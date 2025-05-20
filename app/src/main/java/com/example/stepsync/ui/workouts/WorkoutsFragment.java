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

        workoutsViewModel.getWalkCounter().observe(getViewLifecycleOwner(), value ->
                binding.walkCountText.setText(String.valueOf(value)));

        workoutsViewModel.getRunCounter().observe(getViewLifecycleOwner(), value ->
                binding.runCountText.setText(String.valueOf(value)));

        workoutsViewModel.getCycleCounter().observe(getViewLifecycleOwner(), value ->
                binding.cyclingCountText.setText(String.valueOf(value)));

        workoutsViewModel.getLiftCounter().observe(getViewLifecycleOwner(), value ->
                binding.liftCountText.setText(String.valueOf(value)));

        binding.walkIncrement.setOnClickListener(v -> workoutsViewModel.walkincrement());
        binding.walkDecrement.setOnClickListener(v -> workoutsViewModel.walkdecrement());


        binding.runIncrement.setOnClickListener(v -> workoutsViewModel.runincrement());
        binding.runDecrement.setOnClickListener(v -> workoutsViewModel.rundecrement());


        binding.cycleIncrement.setOnClickListener(v -> workoutsViewModel.cycleincrement());
        binding.cycleDecrement.setOnClickListener(v -> workoutsViewModel.cycledecrement());


        binding.liftingIncrement.setOnClickListener(v -> workoutsViewModel.liftincrement());
        binding.liftingDecrement.setOnClickListener(v -> workoutsViewModel.liftdecrement());

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}