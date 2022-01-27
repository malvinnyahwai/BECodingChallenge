package com.malvin.becodingchallenge.service.impl;

import com.malvin.becodingchallenge.pojo.Team;
import com.malvin.becodingchallenge.service.PointsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PointsServiceImpl implements PointsService {

    @Value("${WIN_POINTS}")
    private Integer WIN_POINTS;
    @Value("${DRAW_POINTS}")
    private Integer DRAW_POINTS;
    @Value("${LOSE_POINTS}")
    private Integer LOSE_POINTS;

    public Integer calculatePoints(Team team) {
        return team.getNumberOfGamesWon() * WIN_POINTS + team.getNumberOfGamesDrawn() * DRAW_POINTS
                + team.getNumberOfGamesLost() * LOSE_POINTS;
    }
}
