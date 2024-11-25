package de.eahjena.wi.mae1.fussball.results;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.eahjena.wi.mae1.fussball.R;
import de.eahjena.wi.mae1.fussball.results.Match;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import android.os.Bundle;  // Importiere die Bundle-Klasse
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
            Bundle args = new Bundle();
            args.putString("homeTeam", match.getHomeTeam());
            args.putString("awayTeam", match.getAwayTeam());
            args.putString("score", match.getHomeScore() + ":" + match.getAwayScore());
            args.putString("startTime", match.getStartTime());    // Spielstart
            args.putString("stadium", match.getStadium());     // Stadion
            args.putString("spectators", match.getSpectators());  // Zuschauer
            args.putString("scorers", match.getScorers());      // Torschützen
            args.putInt("homeLogo", match.getHomeLogoResId());  // Übergabe der Home-Logo-Ressource
            args.putInt("awayLogo", match.getAwayLogoResId());  // Übergabe der Away-Logo-Ressource
            args.putString("halftimeScore", match.getHalftimeScore());  // Übergabe des Halbzeitergebnisses

            // Navigiere zu den MatchDetails und übergebe die Argumente
            NavController navController = Navigation.findNavController(v);
            navController.navigate(R.id.action_nav_results_to_matchDetailFragment, args);
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
