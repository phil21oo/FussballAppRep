package de.eahjena.wi.mae1.fussball.models;

import de.eahjena.wi.mae1.fussball.R;  // Importiere R, um auf Ressourcen zuzugreifen

public class Match {
    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;
    private int homeLogoResId;
    private int awayLogoResId;
    private String startTime;  // Spielstart
    private String stadium;    // Stadion
    private String spectators; // Zuschauer
    private String scorers;    // Torschützen

    // Konstruktor für Match
    public Match(String homeTeam, String awayTeam, int homeScore, int awayScore,
                 String startTime, String stadium, String spectators, String scorers) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.startTime = startTime;
        this.stadium = stadium;
        this.spectators = spectators;
        this.scorers = scorers;

        // Setze die Logo-IDs basierend auf den Teamnamen
        this.homeLogoResId = getLogoResId(homeTeam);
        this.awayLogoResId = getLogoResId(awayTeam);
    }

    private int getLogoResId(String teamName) {
        switch (teamName) {
            case "FC Bayern":
                return R.drawable.bayern_munchen; // Logo für Bayern München
            case "Borussia Dortmund":
                return R.drawable.bvb; // Logo für Borussia Dortmund
            case "RB Leipzig":
                return R.drawable.rb_leipzig; // Logo für RB Leipzig
            case "Eintracht Frankfurt":
                return R.drawable.eintracht_frankfurt; // Logo für Eintracht Frankfurt
            case "Bayer Leverkusen":
                return R.drawable.bayer_leverkusen; // Logo für Bayer Leverkusen
            case "SC Freiburg":
                return R.drawable.sc_freiburg; // Logo für SC Freiburg
            case "Union Berlin":
                return R.drawable.union_berlin; // Logo für Union Berlin
            case "Werder Bremen":
                return R.drawable.werder_bremen; // Logo für Werder Bremen
            case "Borussia Mönchengladbach":
                return R.drawable.gladbach; // Logo für Borussia Mönchengladbach
            case "FSV Mainz 05":
                return R.drawable.mainz05; // Logo für 1. FSV Mainz 05
            case "VfB Stuttgart":
                return R.drawable.vfb_stuttgart; // Logo für VfB Stuttgart
            case "VfL Wolfsburg":
                return R.drawable.vfl_wolfsburg; // Logo für VfL Wolfsburg
            case "FC Augsburg":
                return R.drawable.fc_augsburg; // Logo für FC Augsburg
            case "1. FC Heidenheim":
                return R.drawable.heidenheim; // Logo für 1. FC Heidenheim
            case "TSG Hoffenheim":
                return R.drawable.tsg_1899_hoffenheim; // Logo für TSG Hoffenheim
            case "FC St. Pauli":
                return R.drawable.st_pauli; // Logo für FC St. Pauli
            case "Holstein Kiel":
                return R.drawable.holstein_kiel; // Logo für Holstein Kiel
            case "VfL Bochum":
                return R.drawable.vfl_bochum; // Logo für VfL Bochum
            default:
                return R.drawable.bayern_munchen; // Standardlogo, falls das Team nicht gefunden wird
        }
    }

    // Getter für Teamnamen
    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    // Getter für Scores
    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    // Getter für Logo-Ressourcen-IDs
    public int getHomeLogoResId() {
        return homeLogoResId;
    }

    public int getAwayLogoResId() {
        return awayLogoResId;
    }

    // Getter für Spielstart, Stadion, Zuschauer und Torschützen
    public String getStartTime() {
        return startTime;
    }

    public String getStadium() {
        return stadium;
    }

    public String getSpectators() {
        return spectators;
    }

    public String getScorers() {
        return scorers;
    }
}
