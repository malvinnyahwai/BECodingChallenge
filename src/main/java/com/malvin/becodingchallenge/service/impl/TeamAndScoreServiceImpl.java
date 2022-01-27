package com.malvin.becodingchallenge.service.impl;

import com.malvin.becodingchallenge.pojo.Team;
import com.malvin.becodingchallenge.pojo.TeamAndScore;
import com.malvin.becodingchallenge.service.TeamAndScoreService;
import com.malvin.becodingchallenge.service.TeamService;
import com.malvin.becodingchallenge.utils.Regex;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamAndScoreServiceImpl implements TeamAndScoreService {
    private final TeamService teamService;

    public TeamAndScoreServiceImpl(TeamService teamService) {
        this.teamService = teamService;
    }

    @Override
    public List<TeamAndScore> createTeamAndScoreList(String result) {
        String[] teamAndScoreCardArray = result.split(",");
        List<TeamAndScore> teamAndScoreList = new ArrayList<>();
        if(teamAndScoreCardArray.length == 2) {
            String teamAAndScore = teamAndScoreCardArray[0].trim();
            String teamBAndScore = teamAndScoreCardArray[1].trim();

            Long teamAScore = Regex.getScore(teamAAndScore);
            Long teamBScore = Regex.getScore(teamBAndScore);

            String teamAName = teamAAndScore.replaceAll(teamAScore.toString(), "");
            String teamBName = teamBAndScore.replaceAll(teamBScore.toString(), "");

            TeamAndScore teamAndScore1 = creatTeamAndScore(teamAName, teamAScore);
            TeamAndScore teamAndScore2 = creatTeamAndScore(teamBName, teamBScore);

            teamAndScoreList.add(teamAndScore1);
            teamAndScoreList.add(teamAndScore2);
        }
        return teamAndScoreList;
    }

    private TeamAndScore creatTeamAndScore(String teamName, Long teamScore) {
        Team team = teamService.findByName(teamName.trim());
        return new TeamAndScore(team, teamScore);
    }
}
