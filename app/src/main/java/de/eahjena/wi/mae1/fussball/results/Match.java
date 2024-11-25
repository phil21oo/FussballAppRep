package de.eahjena.wi.mae1.fussball.results;
import de.eahjena.wi.mae1.fussball.R;
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
    private String halftimeScore; // Halbzeitergebnis

    // Kombinierter Konstruktor für Match
    public Match(String homeTeam, String awayTeam, int homeScore, int awayScore,
                 String startTime, String stadium, String spectators, String scorers,
                 String halftimeScore) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.startTime = startTime;
        this.stadium = stadium;
        this.spectators = spectators;
        this.scorers = scorers;
        this.halftimeScore = halftimeScore;

        // Setze die Logo-IDs basierend auf den Teamnamen
        this.homeLogoResId = getLogoResId(homeTeam);
        this.awayLogoResId = getLogoResId(awayTeam);
    }

    private int getLogoResId(String teamName) {
        switch (teamName) {
            case "FC Bayern":
                return R.drawable.bayern_munchen;
            case "Borussia Dortmund":
                return R.drawable.bvb;
            case "RB Leipzig":
                return R.drawable.rb_leipzig;
            case "Eintracht Frankfurt":
                return R.drawable.eintracht_frankfurt;
            case "Bayer Leverkusen":
                return R.drawable.bayer_leverkusen;
            case "SC Freiburg":
                return R.drawable.sc_freiburg;
            case "Union Berlin":
                return R.drawable.union_berlin;
            case "Werder Bremen":
                return R.drawable.werder_bremen;
            case "Borussia Mönchengladbach":
                return R.drawable.gladbach;
            case "FSV Mainz 05":
                return R.drawable.mainz05;
            case "VfB Stuttgart":
                return R.drawable.vfb_stuttgart;
            case "VfL Wolfsburg":
                return R.drawable.vfl_wolfsburg;
            case "FC Augsburg":
                return R.drawable.fc_augsburg;
            case "1. FC Heidenheim":
                return R.drawable.heidenheim;
            case "TSG Hoffenheim":
                return R.drawable.tsg_1899_hoffenheim;
            case "FC St. Pauli":
                return R.drawable.st_pauli;
            case "Holstein Kiel":
                return R.drawable.holstein_kiel;
            case "VfL Bochum":
                return R.drawable.vfl_bochum;
            default:
                return R.drawable.bayern_munchen; // Standardlogo, falls das Team nicht gefunden wird
        }
    }

    // Getter und Setter für Teamnamen, Scores, Startzeit, Stadion etc.
    public String getHomeTeam() { return homeTeam; }
    public String getAwayTeam() { return awayTeam; }
    public int getHomeScore() { return homeScore; }
    public int getAwayScore() { return awayScore; }
    public int getHomeLogoResId() { return homeLogoResId; }
    public int getAwayLogoResId() { return awayLogoResId; }
    public String getStartTime() { return startTime; }
    public String getStadium() { return stadium; }
    public String getSpectators() { return spectators; }
    public String getScorers() { return scorers; }
    public String getHalftimeScore() { return halftimeScore; }
}
