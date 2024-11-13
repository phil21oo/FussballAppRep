package de.eahjena.wi.mae1.fussball;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class QuizFragment extends Fragment {

    private RadioGroup answerGroup1, answerGroup2, answerGroup3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);

        // RadioGroups verknüpfen
        answerGroup1 = view.findViewById(R.id.answerGroup1);
        answerGroup2 = view.findViewById(R.id.answerGroup2);
        answerGroup3 = view.findViewById(R.id.answerGroup3);

        // Button für Quiz-Auswertung verknüpfen und Listener hinzufügen
        Button submitButton = view.findViewById(R.id.submit_button);
        submitButton.setOnClickListener(v -> evaluateQuiz());

        return view;
    }

    private void evaluateQuiz() {
        int score = 0;

        if (answerGroup1.getCheckedRadioButtonId() == R.id.answer1_a) score++;
        if (answerGroup2.getCheckedRadioButtonId() == R.id.answer2_b) score++;
        if (answerGroup3.getCheckedRadioButtonId() == R.id.answer3_b) score++;

        Toast.makeText(getActivity(), "Du hast " + score + " von 3 Fragen richtig beantwortet!", Toast.LENGTH_LONG).show();
    }
}
