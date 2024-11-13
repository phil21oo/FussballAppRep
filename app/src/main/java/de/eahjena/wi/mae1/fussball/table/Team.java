package de.eahjena.wi.mae1.fussball.models;

public class Team {
    private int rank;
    private String logoUrl;
    private String teamName;
    private int goalDifference;
    private int points;

    public Team(int rank, String logoUrl, String teamName, int goalDifference, int points)
    {
        this.rank = rank;
        this.logoUrl = logoUrl;
        this.teamName = teamName;
        this.goalDifference = goalDifference;
        this.points = points;
    }

    public int getRank() { return rank; }
    public String getLogoUrl() { return logoUrl; }
    public String getTeamName() { return teamName; }
    public int getGoalDifference() { return goalDifference; }
    public int getPoints() { return points; }
}
