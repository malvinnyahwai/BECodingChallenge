package com.malvin.becodingchallenge.service.impl;

import com.malvin.becodingchallenge.pojo.Team;
import com.malvin.becodingchallenge.pojo.TeamAndScore;
import com.malvin.becodingchallenge.service.ResultsInterpreterService;
import com.malvin.becodingchallenge.service.TeamAndScoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultsInterpreterServiceImpl implements ResultsInterpreterService {
    private final TeamAndScoreService teamAndScoreService;

    public ResultsInterpreterServiceImpl(TeamAndScoreService teamAndScoreService) {
        this.teamAndScoreService = teamAndScoreService;
    }

    public void allocateWinLossOrDrawToTeams(String result) {
        List<TeamAndScore> teamAndScoresList = teamAndScoreService.createTeamAndScoreList(result);

        Long teamAScore = teamAndScoresList.get(0).getScore();
        Long teamBScore = teamAndScoresList.get(1).getScore();

        if (teamAScore > teamBScore) {
            firstTeamWonToSecond(teamAndScoresList.get(0).getTeam(), teamAndScoresList.get(1).getTeam());
        } else if (teamAScore < teamBScore) {
            firstTeamWonToSecond(teamAndScoresList.get(1).getTeam(), teamAndScoresList.get(0).getTeam());
        } else {
            drew(teamAndScoresList.get(0).getTeam(), teamAndScoresList.get(1).getTeam());
        }
    }

    private void firstTeamWonToSecond(Team team1, Team team2) {
        team1.setNumberOfGamesWon(team1.getNumberOfGamesWon() + 1);
        team2.setNumberOfGamesLost(team2.getNumberOfGamesLost() + 1);
    }

    private void drew(Team team1, Team team2) {
        team1.setNumberOfGamesDrawn(team1.getNumberOfGamesDrawn() + 1);
        team2.setNumberOfGamesDrawn(team2.getNumberOfGamesDrawn() + 1);
    }
}
