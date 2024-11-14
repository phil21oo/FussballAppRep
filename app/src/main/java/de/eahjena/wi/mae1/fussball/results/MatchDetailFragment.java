package de.eahjena.wi.mae1.fussball.results;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import de.eahjena.wi.mae1.fussball.R;

public class MatchDetailFragment extends Fragment {

    private TextView homeTeamText, awayTeamText, scoreText, startTimeText, stadiumText, spectatorsText, scorersText;

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

        // Erhalte die Argumente (Spielinfo)
        if (getArguments() != null) {
            String homeTeam = getArguments().getString("homeTeam");
            String awayTeam = getArguments().getString("awayTeam");
            String score = getArguments().getString("score");
            String startTime = getArguments().getString("startTime");
            String stadium = getArguments().getString("stadium");
            String spectators = getArguments().getString("spectators");
            String scorers = getArguments().getString("scorers");

            // Setze die Daten in die TextViews
            homeTeamText.setText(homeTeam);
            awayTeamText.setText(awayTeam);
            scoreText.setText(score);
            startTimeText.setText(startTime);
            stadiumText.setText(stadium);
            spectatorsText.setText(spectators);
            scorersText.setText(scorers);
        }

        return rootView;
    }

    // Diese Methode wird verwendet, um die Daten an das Fragment zu übergeben
    public static MatchDetailFragment newInstance(String homeTeam, String awayTeam, String score,
                                                  String startTime, String stadium, String spectators,
                                                  String scorers) {
        MatchDetailFragment fragment = new MatchDetailFragment();
        Bundle args = new Bundle();
        args.putString("homeTeam", homeTeam);
        args.putString("awayTeam", awayTeam);
        args.putString("score", score);
        args.putString("startTime", startTime);
        args.putString("stadium", stadium);
        args.putString("spectators", spectators);
        args.putString("scorers", scorers);
        fragment.setArguments(args);
        return fragment;
    }
}
