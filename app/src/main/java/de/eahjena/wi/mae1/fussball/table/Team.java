package de.eahjena.wi.mae1.fussball.models;

public class Team {
    private int rank;
    private int logoResId;  // Verwende hier den int-Typ für das Logo-ResId
    private String teamName;
    private int goalDifference;
    private int points;

    // Korrigiere den Konstruktor, um das Logo korrekt zuzuweisen
    public Team(int rank, int logoResId, String teamName, int goalDifference, int points) {
        this.rank = rank;
        this.logoResId = logoResId;  // Weise das logoResId zu
        this.teamName = teamName;
        this.goalDifference = goalDifference;
        this.points = points;
    }

    public int getRank() { return rank; }
    public int getLogoResId() { return logoResId; }  // Ändere die Methode von getLogoUrl zu getLogoResId
    public String getTeamName() { return teamName; }
    public int getGoalDifference() { return goalDifference; }
    public int getPoints() { return points; }
}
