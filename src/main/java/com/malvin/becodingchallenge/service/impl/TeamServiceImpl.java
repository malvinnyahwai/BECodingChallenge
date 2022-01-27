package com.malvin.becodingchallenge.service.impl;

import com.malvin.becodingchallenge.pojo.Team;
import com.malvin.becodingchallenge.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {
    private final List<Team> teamList = new ArrayList<>();
    @Override
    public Team findByName(String name) {
        Optional<Team> teamOptional = teamList.stream()
                .filter(team -> name.equalsIgnoreCase(team.getName()))
                .findFirst();

        if(teamOptional.isPresent())
            return teamOptional.get();

        Team team = new Team(name, 0, 0, 0);
        teamList.add(team);

        return team;
    }

    @Override
    public List<Team> getAllTeams() {
        return teamList;
    }
}
