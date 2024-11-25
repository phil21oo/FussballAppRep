package de.eahjena.wi.mae1.fussball.results;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import de.eahjena.wi.mae1.fussball.R;

public class MatchDetailFragment extends Fragment {

    private TextView homeTeamText, awayTeamText, scoreText, startTimeText, stadiumText, spectatorsText, scorersText, halftimeScoreText;
    private ImageView homeLogoImageView, awayLogoImageView;

    public MatchDetailFragment() {
        // Leerer Konstruktor erforderlich
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_match_detail, container, false);

        // Initialisiere TextViews
        homeTeamText = rootView.findViewById(R.id.home_team);
        awayTeamText = rootView.findViewById(R.id.away_team);
        scoreText = rootView.findViewById(R.id.score);
        startTimeText = rootView.findViewById(R.id.start_time);
        stadiumText = rootView.findViewById(R.id.stadium);
        spectatorsText = rootView.findViewById(R.id.spectators);
        scorersText = rootView.findViewById(R.id.scorers);
        halftimeScoreText = rootView.findViewById(R.id.halftime_score); // Halbzeitergebnis TextView

        // Initialisiere ImageViews
        homeLogoImageView = rootView.findViewById(R.id.home_logo);
        awayLogoImageView = rootView.findViewById(R.id.away_logo);

        // Erhalte die Argumente (Spielinfo)
        if (getArguments() != null) {
            String homeTeam = getArguments().getString("homeTeam", "N/A");
            String awayTeam = getArguments().getString("awayTeam", "N/A");
            String score = getArguments().getString("score", "0:0");
            String startTime = getArguments().getString("startTime", "Unbekannt");
            String stadium = getArguments().getString("stadium", "Unbekannt");
            String spectators = getArguments().getString("spectators", "Unbekannt");
            String scorers = getArguments().getString("scorers", "Keine");
            String halftimeScore = getArguments().getString("halftimeScore", "Unbekannt");

            // Setze die Daten in die TextViews
            homeTeamText.setText(homeTeam);
            awayTeamText.setText(awayTeam);
            scoreText.setText(score);
            startTimeText.setText(startTime);
            stadiumText.setText(stadium);
            spectatorsText.setText(spectators);
            scorersText.setText(scorers);
            halftimeScoreText.setText("(" + halftimeScore + ")");

            // Erhalte die Logo-Ressourcen-IDs
            int homeLogoResId = getArguments().getInt("homeLogo", -1);
            int awayLogoResId = getArguments().getInt("awayLogo", -1);

            // Setze die Logos, falls vorhanden, andernfalls Logo unsichtbar lassen
            if (homeLogoResId != -1) {
                homeLogoImageView.setImageResource(homeLogoResId);
            } else {
                homeLogoImageView.setVisibility(View.INVISIBLE);  // Logo unsichtbar machen, wenn nicht vorhanden
            }

            if (awayLogoResId != -1) {
                awayLogoImageView.setImageResource(awayLogoResId);
            } else {
                awayLogoImageView.setVisibility(View.INVISIBLE);  // Logo unsichtbar machen, wenn nicht vorhanden
            }
        }

        return rootView;
    }

    // Diese Methode wird verwendet, um die Daten an das Fragment zu übergeben
    public static MatchDetailFragment newInstance(String homeTeam, String awayTeam, String score,
                                                  String startTime, String stadium, String spectators,
                                                  String scorers, String halftimeScore, int homeLogoResId, int awayLogoResId) {
        MatchDetailFragment fragment = new MatchDetailFragment();
        Bundle args = new Bundle();
        args.putString("homeTeam", homeTeam);
        args.putString("awayTeam", awayTeam);
        args.putString("score", score);
        args.putString("startTime", startTime);
        args.putString("stadium", stadium);
        args.putString("spectators", spectators);
        args.putString("scorers", scorers);
        args.putString("halftimeScore", halftimeScore);  // Halbzeitergebnis
        args.putInt("homeLogo", homeLogoResId);
        args.putInt("awayLogo", awayLogoResId);
        fragment.setArguments(args);
        return fragment;
    }
}

