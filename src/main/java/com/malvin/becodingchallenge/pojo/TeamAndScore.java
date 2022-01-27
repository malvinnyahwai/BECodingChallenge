package com.malvin.becodingchallenge.pojo;

import java.util.Objects;

public class TeamAndScore {
    private Team team;
    private Long score;

    public TeamAndScore(Team team, Long score) {
        this.team = team;
        this.score = score;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TeamAndScore))
            return false;
        TeamAndScore teamAndScore = (TeamAndScore) object;
        return Objects.equals(this.team.getName(), teamAndScore.getTeam().getName())
                && Objects.equals(this.score, teamAndScore.getScore());
    }

    @Override
    public String toString() {
        return "TeamAndScore{" +
                "team=" + team +
                ", score=" + score +
                '}';
    }
}
