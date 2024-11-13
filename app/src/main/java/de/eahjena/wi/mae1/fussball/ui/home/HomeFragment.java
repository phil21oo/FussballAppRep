package de.eahjena.wi.mae1.fussball.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import de.eahjena.wi.mae1.fussball.R;
import de.eahjena.wi.mae1.fussball.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Button für die Navigation zur Tabelle einrichten
        binding.buttonTabelle.setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_nav_home_to_nav_table)
        );

        // Button für die Navigation zu Spielergebnisse einrichten
        binding.buttonSpielergebnisse.setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_nav_home_to_nav_results)
        );

        // Button für die Navigation zum Quiz einrichten
        binding.buttonQuiz.setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_nav_home_to_nav_quiz)
        );

        // Beispiel-Text setzen
        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
