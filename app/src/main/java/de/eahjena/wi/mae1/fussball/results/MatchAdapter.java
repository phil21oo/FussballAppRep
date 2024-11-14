package de.eahjena.wi.mae1.fussball.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.eahjena.wi.mae1.fussball.R;
import de.eahjena.wi.mae1.fussball.models.Match;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import de.eahjena.wi.mae1.fussball.results.MatchDetailFragment;
import java.util.List;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.MatchViewHolder> {

    private Context context;
    private List<Match> matchList;

    public MatchAdapter(Context context, List<Match> matchList) {
        this.context = context;
        this.matchList = matchList;
    }

    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_match, parent, false);
        return new MatchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder holder, int position) {
        Match match = matchList.get(position);

        // Setze die Teamnamen und das Ergebnis
        holder.homeTeam.setText(match.getHomeTeam());
        holder.awayTeam.setText(match.getAwayTeam());
        holder.score.setText(match.getHomeScore() + ":" + match.getAwayScore());

        // Setze die Logos der Teams
        holder.homeLogo.setImageResource(match.getHomeLogoResId());
        holder.awayLogo.setImageResource(match.getAwayLogoResId());

        // Setze einen OnClickListener für jedes Element, um zur Detailseite zu navigieren
        holder.itemView.setOnClickListener(v -> {
            // Erstelle das Fragment für die Details und übergebe die Spiel-Details
            MatchDetailFragment detailFragment = MatchDetailFragment.newInstance(
                    match.getHomeTeam(),
                    match.getAwayTeam(),
                    match.getHomeScore() + ":" + match.getAwayScore(),
                    match.getStartTime(),
                    match.getStadium(),
                    match.getSpectators(),
                    match.getScorers()
            );

            // Navigiere zu den MatchDetails
            NavController navController = Navigation.findNavController(v);
            navController.navigate(R.id.action_nav_results_to_matchDetailFragment, null);
        });
    }

    @Override
    public int getItemCount() {
        return matchList.size();
    }

    static class MatchViewHolder extends RecyclerView.ViewHolder {
        TextView homeTeam, awayTeam, score;
        ImageView homeLogo, awayLogo;

        public MatchViewHolder(@NonNull View itemView) {
            super(itemView);
            homeTeam = itemView.findViewById(R.id.home_team);
            awayTeam = itemView.findViewById(R.id.away_team);
            score = itemView.findViewById(R.id.score);
            homeLogo = itemView.findViewById(R.id.home_logo);
            awayLogo = itemView.findViewById(R.id.away_logo);
        }
    }
}
