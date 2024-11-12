package de.eahjena.wi.mae1.fussball.table;

public class Team {
    private int position;
    private String name;
    private int points;

    public Team(int position, String name, int points) {
        this.position = position;
        this.name = name;
        this.points = points;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }
}