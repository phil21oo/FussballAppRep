package de.eahjena.wi.mae1.fussball.table;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import de.eahjena.wi.mae1.fussball.R;
import de.eahjena.wi.mae1.fussball.table.TableAdapter;
import de.eahjena.wi.mae1.fussball.models.Team;
import java.util.ArrayList;
import java.util.List;

public class TableFragment extends Fragment {

    private RecyclerView recyclerViewTable;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_table, container, false);

        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Bundesliga Tabelle");
        }

        // RecyclerView initialisieren
        recyclerViewTable = view.findViewById(R.id.recycler_view_table);

        // Liste der Bundesliga-Teams mit den Punkten und Tordifferenz (Stand 13.11.2024)
        List<Team> teamList = new ArrayList<>();
        teamList.add(new Team(1, R.drawable.bayern_munchen, "Bayern München", 26, 26));  // Bayern München
        teamList.add(new Team(2, R.drawable.rb_leipzig, "RB Leipzig", 10, 21));  // RB Leipzig
        teamList.add(new Team(3, R.drawable.rb_leipzig,"Eintracht Frankfurt", 10, 20));  // Eintracht Frankfurt
        teamList.add(new Team(4, R.drawable.rb_leipzig,"Bayer Leverkusen", 5, 17));  // Bayer Leverkusen
        teamList.add(new Team(5, R.drawable.rb_leipzig,"SC Freiburg", 2, 17));  // SC Freiburg
        teamList.add(new Team(6, R.drawable.rb_leipzig,"Union Berlin", 1, 16));  // Union Berlin
        teamList.add(new Team(7, R.drawable.rb_leipzig,"Borussia Dortmund", 0, 16));  // Borussia Dortmund
        teamList.add(new Team(8, R.drawable.rb_leipzig,"Werder Bremen", -4, 15));  // Werder Bremen
        teamList.add(new Team(9, R.drawable.rb_leipzig,"Borussia Mönchengladbach", 1, 14));  // Borussia Mönchengladbach
        teamList.add(new Team(10, R.drawable.rb_leipzig,"1. FSV Mainz 05", 1, 13));  // 1. FSV Mainz 05
        teamList.add(new Team(11, R.drawable.rb_leipzig,"VfB Stuttgart", 0, 13));  // VfB Stuttgart
        teamList.add(new Team(12, R.drawable.rb_leipzig,"VfL Wolfsburg", 1, 12));  // VfL Wolfsburg
        teamList.add(new Team(13, R.drawable.rb_leipzig,"FC Augsburg", -7, 12));  // FC Augsburg
        teamList.add(new Team(14, R.drawable.rb_leipzig,"1. FC Heidenheim", -2, 10));  // 1. FC Heidenheim
        teamList.add(new Team(15, R.drawable.rb_leipzig,"TSG Hoffenheim", -6, 9));  // TSG Hoffenheim
        teamList.add(new Team(16, R.drawable.rb_leipzig,"FC St. Pauli", -5, 8));  // FC St. Pauli
        teamList.add(new Team(17, R.drawable.rb_leipzig,"Holstein Kiel", -13, 5));  // Holstein Kiel
        teamList.add(new Team(18, R.drawable.rb_leipzig,"VfL Bochum", -20, 0));  // VfL Bochum

        // Adapter initialisieren und an RecyclerView binden
        TableAdapter adapter = new TableAdapter(getContext(), teamList);  // Adapter-Initialisierung
        recyclerViewTable.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewTable.setAdapter(adapter);

        return view;
    }
}
