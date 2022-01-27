package com.malvin.becodingchallenge.pojo;

public class Team {
    private String name;
    private Integer numberOfGamesWon;
    private Integer numberOfGamesDrawn;
    private Integer numberOfGamesLost;

    public Team(String name, Integer numberOfGamesWon, Integer numberOfGamesDrawn, Integer numberOfGamesLost) {
        this.name = name;
        this.numberOfGamesWon = numberOfGamesWon;
        this.numberOfGamesDrawn = numberOfGamesDrawn;
        this.numberOfGamesLost = numberOfGamesLost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfGamesWon() {
        return numberOfGamesWon;
    }

    public void setNumberOfGamesWon(Integer numberOfGamesWon) {
        this.numberOfGamesWon = numberOfGamesWon;
    }

    public Integer getNumberOfGamesDrawn() {
        return numberOfGamesDrawn;
    }

    public void setNumberOfGamesDrawn(Integer numberOfGamesDrawn) {
        this.numberOfGamesDrawn = numberOfGamesDrawn;
    }

    public Integer getNumberOfGamesLost() {
        return numberOfGamesLost;
    }

    public void setNumberOfGamesLost(Integer numberOfGamesLost) {
        this.numberOfGamesLost = numberOfGamesLost;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Team))
            return false;
        Team team = (Team) object;
        return this.name == team.getName();
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", numberOfGamesWon=" + numberOfGamesWon +
                ", numberOfGamesDrawn=" + numberOfGamesDrawn +
                ", numberOfGamesLost=" + numberOfGamesLost +
                '}';
    }
}
