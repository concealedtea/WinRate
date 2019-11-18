package com.ucsc.winrate.ui.inputForm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ucsc.winrate.GameLogAdapter;
import com.ucsc.winrate.R;
import com.ucsc.winrate.WinRateRepository;
import com.ucsc.winrate.table_entities.GameLogEntry;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class GameLogTableFragment extends Fragment {

    private GameLogTableViewModel gameLogTableViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final GameLogAdapter adapter = new GameLogAdapter(getActivity());

        gameLogTableViewModel = new ViewModelProvider(this).get(GameLogTableViewModel.class);

        gameLogTableViewModel.getAllGameLogEntries().observe(this, new Observer<List<GameLogEntry>>() {
            @Override
            public void onChanged(List<GameLogEntry> gameLogEntries) {
                adapter.setGameLogEntries(gameLogEntries);
                //Toast.makeText(getActivity(), "onChanged called", Toast.LENGTH_SHORT).show();
            }
        });

        View root = inflater.inflate(R.layout.fragment_game_log_table, container, false);

        return root;
    }


}