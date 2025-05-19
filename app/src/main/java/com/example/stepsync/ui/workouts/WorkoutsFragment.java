package com.example.stepsync.ui.workouts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.stepsync.databinding.FragmentWorkoutsBinding;

public class WorkoutsFragment extends Fragment {

    private FragmentWorkoutsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        WorkoutsViewModel workoutsViewModel =
                new ViewModelProvider(this).get(WorkoutsViewModel.class);

        binding = FragmentWorkoutsBinding.inflate(inflater, container, false);

        workoutsViewModel.getCounter().observe(getViewLifecycleOwner(), value ->
                binding.walkCountText.setText(String.valueOf(value)));
        workoutsViewModel.getCounter().observe(getViewLifecycleOwner(), value ->
                binding.runCountText.setText(String.valueOf(value)));
        workoutsViewModel.getCounter().observe(getViewLifecycleOwner(), value ->
                binding.cyclingCountText.setText(String.valueOf(value)));
        workoutsViewModel.getCounter().observe(getViewLifecycleOwner(), value ->
                binding.liftCountText.setText(String.valueOf(value)));

        binding.walkIncrement.setOnClickListener(v -> workoutsViewModel.increment());
        binding.walkDecrement.setOnClickListener(v -> workoutsViewModel.decrement());
        binding.runIncrement.setOnClickListener(v -> workoutsViewModel.increment());
        binding.runDecrement.setOnClickListener(v -> workoutsViewModel.decrement());
        binding.cycleIncrement.setOnClickListener(v -> workoutsViewModel.increment());
        binding.cycleDecrement.setOnClickListener(v -> workoutsViewModel.decrement());
        binding.liftingIncrement.setOnClickListener(v -> workoutsViewModel.increment());
        binding.liftingDecrement.setOnClickListener(v -> workoutsViewModel.decrement());

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}