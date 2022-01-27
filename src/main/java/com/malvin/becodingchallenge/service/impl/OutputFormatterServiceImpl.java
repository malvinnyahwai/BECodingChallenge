package com.malvin.becodingchallenge.service.impl;

import com.malvin.becodingchallenge.pojo.Team;
import com.malvin.becodingchallenge.service.OutputFormatterService;
import com.malvin.becodingchallenge.service.PointsService;
import com.malvin.becodingchallenge.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class OutputFormatterServiceImpl implements OutputFormatterService {

    private final TeamService teamService;
    private final PointsService pointsService;

    public OutputFormatterServiceImpl(TeamService teamService, PointsService pointsService) {
        this.teamService = teamService;
        this.pointsService = pointsService;
    }

    @Override
    public String createOutputTable() {
        List<Team> teamsList = teamService.getAllTeams();

        if(teamsList.isEmpty()) {
            return "Unable to create output, please check the input";
        }

        StringBuilder table = new StringBuilder();

        Comparator<Team> byPoints = (team1, team2) -> pointsService.calculatePoints(team2) - pointsService.calculatePoints(team1);

        Comparator<Team> byNames = (Team team1, Team team2) -> team2.getName().compareTo(team1.getName());

        teamsList.sort(byPoints.thenComparing(byNames));

        int position = 1;
        int previousPoints = pointsService.calculatePoints(teamsList.get(0));

        for(Team team: teamsList) {
            int points = pointsService.calculatePoints(team);
            if(points != previousPoints) {
                position++;
            }
            table.append(position).append(". ").append(team.getName()).append(", ").append(points).append("pts \n");
            previousPoints = points;
        }
        return table.toString();
    }
}

