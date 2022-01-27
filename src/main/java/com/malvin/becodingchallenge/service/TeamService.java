package com.malvin.becodingchallenge.service;

import com.malvin.becodingchallenge.pojo.Team;

import java.util.List;

public interface TeamService {
    Team findByName(String name);
    List<Team> getAllTeams();
}
