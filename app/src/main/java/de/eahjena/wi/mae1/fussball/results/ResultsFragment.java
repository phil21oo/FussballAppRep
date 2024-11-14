package de.eahjena.wi.mae1.fussball.results;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import de.eahjena.wi.mae1.fussball.R;
import de.eahjena.wi.mae1.fussball.adapters.MatchAdapter;
import de.eahjena.wi.mae1.fussball.models.Match;
import java.util.ArrayList;
import java.util.List;

public class ResultsFragment extends Fragment {

    private RecyclerView recyclerViewMatches;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_results, container, false);

        recyclerViewMatches = view.findViewById(R.id.recycler_view_matches);

        // Beispiel-Daten für die Matches (Spielergebnisse)
        List<Match> matchList = new ArrayList<>();

        // Beispiel-Spiele mit allen Details
        matchList.add(new Match("Union Berlin", "SC Freiburg", 0, 0,
                "08.11.2024 20:30", "Stadion XYZ", "25.000", "Torschütze: Keiner"));

        matchList.add(new Match("FSV Mainz 05", "Borussia Dortmund", 3, 1,
                "09.11.2024 15:30", "Stadion Mainz", "30.000", "Torschützen: Müller (25')"));

        matchList.add(new Match("FC St. Pauli", "FC Bayern", 0, 1,
                "09.11.2024 15:30", "Millerntor-Stadion", "20.000", "Torschütze: Lewandowski (50')"));

        matchList.add(new Match("VfL Bochum", "Bayer Leverkusen", 1, 1,
                "09.11.2024 15:30", "Vonovia Ruhrstadion", "15.000", "Torschützen: Pizarro (60')"));

        matchList.add(new Match("Werder Bremen", "Holstein Kiel", 2, 1,
                "09.11.2024 15:30", "Weserstadion", "25.000", "Torschützen: Osako (30'), Sargent (75')"));

        matchList.add(new Match("RB Leipzig", "Borussia Mönchengladbach", 0, 0,
                "09.11.2024 18:30", "Red Bull Arena", "42.000", "Torschütze: Keiner"));

        matchList.add(new Match("FC Augsburg", "TSG Hoffenheim", 0, 0,
                "10.11.2024 15:30", "WWK Arena", "20.000", "Torschütze: Keiner"));

        matchList.add(new Match("VfB Stuttgart", "Eintracht Frankfurt", 2, 3,
                "10.11.2024 17:30", "Mercedes-Benz Arena", "35.000", "Torschützen: Gonzalo (10')"));

        matchList.add(new Match("1. FC Heidenheim", "VfL Wolfsburg", 1, 3,
                "10.11.2024 17:30", "Voith-Arena", "18.000", "Torschütze: Bülter (55')"));

        // Adapter initialisieren und an RecyclerView binden
        MatchAdapter adapter = new MatchAdapter(getContext(), matchList);
        recyclerViewMatches.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewMatches.setAdapter(adapter);

        return view;
    }
}