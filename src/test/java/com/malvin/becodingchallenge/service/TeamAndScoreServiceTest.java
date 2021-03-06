package com.malvin.becodingchallenge.service;

import com.malvin.becodingchallenge.pojo.Team;
import com.malvin.becodingchallenge.pojo.TeamAndScore;
import com.malvin.becodingchallenge.service.impl.TeamAndScoreServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
class TeamAndScoreServiceTest {
    @Mock
    private TeamService teamService;

    @DisplayName("Creating Team and Score Pair test")
    @Test
    void createTeamAndScoreListTest() {
        TeamAndScoreService teamAndScoreService = new TeamAndScoreServiceImpl(teamService);
        Team team1 = new Team("Lions", 0, 0, 0);
        Team team2 = new Team("Snakes", 0, 0, 0);

        lenient().when(teamService.findByName("Lions")).thenReturn(team1);
        lenient().when(teamService.findByName("Snakes")).thenReturn(team2);

        String result = "Lions 4, Snakes 3";

        List<TeamAndScore> teamAndScoreList = new ArrayList<>(Arrays.asList(
                new TeamAndScore(team1, 4L),
                new TeamAndScore(team2, 3L)
        ));
        assertEquals(teamAndScoreList.get(0), teamAndScoreService.createTeamAndScoreList(result).get(0));
    }

}