package com.example.stepsync.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<Integer> waterAmount = new MutableLiveData<>(0);

    public LiveData<Integer> getWaterAmount() {
        return waterAmount;
    }

    public void addWater(int amount) {
        waterAmount.setValue(waterAmount.getValue() + amount);
    }


}