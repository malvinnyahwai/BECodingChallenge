package com.malvin.becodingchallenge.service;

import com.malvin.becodingchallenge.pojo.Team;
import com.malvin.becodingchallenge.pojo.TeamAndScore;
import com.malvin.becodingchallenge.service.impl.ResultsInterpreterServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ResultsInterpreterServiceTest {

    @Mock
    TeamAndScoreService teamAndScoreService;
    @Mock
    TeamService teamService;

    @DisplayName("Allocating a win to a team test")
    @Test
    void allocateWinLossOrDrawToTeams_WinTest() {
        ResultsInterpreterService resultsInterpreterService = new ResultsInterpreterServiceImpl(teamAndScoreService);
        Team team1 = new Team("Lions", 0, 0, 0);
        Team team2 = new Team("Snakes", 0, 0, 0);

        lenient().when(teamService.findByName("Lions")).thenReturn(team1);
        lenient().when(teamService.findByName("Snakes")).thenReturn(team2);

        String result = "Lions 4, Snakes 3";

        when(teamAndScoreService.createTeamAndScoreList(result)).thenReturn(new ArrayList<>(Arrays.asList(
                new TeamAndScore(team1, 4L),
                new TeamAndScore(team2, 3L)
        )));
        resultsInterpreterService.allocateWinLossOrDrawToTeams(result);
        assertEquals(Integer.valueOf(1), team1.getNumberOfGamesWon(), "Expecting 1 but returned "+team1.getNumberOfGamesWon());
    }

}