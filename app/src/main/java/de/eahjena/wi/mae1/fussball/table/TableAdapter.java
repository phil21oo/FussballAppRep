package de.eahjena.wi.mae1.fussball.table;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.eahjena.wi.mae1.fussball.R;
import de.eahjena.wi.mae1.fussball.models.Team;
import java.util.List;

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.TableViewHolder> {

    private Context context;
    private List<Team> teamList;

    public TableAdapter(Context context, List<Team> teamList) {
        this.context = context;
        this.teamList = teamList;
    }

    @NonNull
    @Override
    public TableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Hier wird die View mit der Layout-Resource aufgeblasen
        View view = LayoutInflater.from(context).inflate(R.layout.item_team, parent, false);
        return new TableViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TableViewHolder holder, int position) {
        Team team = teamList.get(position);
        // Setze die Daten aus der Team-Klasse in die Views ein
        holder.rank.setText(String.valueOf(team.getRank()));  // Setzt den Rang
        holder.teamName.setText(team.getTeamName());  // Setzt den Teamnamen
        holder.points.setText(String.valueOf(team.getPoints()));  // Setzt die Punkte
        holder.goalDifference.setText(String.valueOf(team.getGoalDifference()));  // Setzt die Tordifferenz
        // Setze das Logo für das Team
        holder.teamLogo.setImageResource(team.getLogoResId());  // Setzt das Team-Logo
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    static class TableViewHolder extends RecyclerView.ViewHolder {
        TextView rank, teamName, points, goalDifference;
        ImageView teamLogo;  // Füge ImageView für das Logo hinzu

        public TableViewHolder(@NonNull View itemView) {
            super(itemView);
            // Referenziere die Views aus der item_team.xml
            rank = itemView.findViewById(R.id.position);
            teamName = itemView.findViewById(R.id.name);
            points = itemView.findViewById(R.id.points);
            goalDifference = itemView.findViewById(R.id.goal_difference);
            teamLogo = itemView.findViewById(R.id.team_logo);  // Referenz für das ImageView
        }
    }
}
