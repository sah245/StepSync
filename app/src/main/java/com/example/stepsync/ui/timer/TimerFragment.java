package com.example.stepsync.ui.timer;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.stepsync.R;
import com.example.stepsync.databinding.FragmentTimerBinding;

public class TimerFragment extends Fragment {


    private FragmentTimerBinding binding;
    private TimerViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        TimerViewModel notificationsViewModel =
                new ViewModelProvider(this).get(TimerViewModel.class);

        binding = FragmentTimerBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(TimerViewModel.class);

        final TextView textView = binding.textNotifications;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        viewModel.getElapsedSeconds().observe(getViewLifecycleOwner(), seconds -> {
            binding.textTimer.setText(formatTime(seconds));
        });

        binding.startStopTimer.setOnClickListener(v -> {
            if (viewModel.isRunning) {
                viewModel.pauseTimer();
                binding.startStopTimer.setText("Start");
            } else {
                viewModel.startTimer();
                binding.startStopTimer.setText("Pause");
            }
        });

        binding.reset.setOnClickListener(v -> {
            viewModel.resetTimer();
            binding.startStopTimer.setText("Start");
        });


        return binding.getRoot();
    }

    private String formatTime(long seconds) {
        long mins = seconds / 60;
        long secs = seconds % 60;
        return String.format("%02d:%02d", mins, secs);
    }


}