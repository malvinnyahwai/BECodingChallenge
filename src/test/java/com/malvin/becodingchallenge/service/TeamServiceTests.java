package com.malvin.becodingchallenge.service;

import com.malvin.becodingchallenge.pojo.Team;
import com.malvin.becodingchallenge.service.impl.TeamServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TeamServiceTests {
    @Test
    void findByNameTest() {
        TeamService teamService = new TeamServiceImpl();
        Team team = new Team("Lions", 0, 0, 0);
        Assertions.assertEquals(team, teamService.findByName("Lions"));
    }
}