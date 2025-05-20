package com.example.stepsync.ui.workouts;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WorkoutsViewModel extends ViewModel {

    private final MutableLiveData<Integer> walkcounter = new MutableLiveData<>(0);
    private final MutableLiveData<Integer> runcounter = new MutableLiveData<>(0);
    private final MutableLiveData<Integer> cyclecounter = new MutableLiveData<>(0);
    private final MutableLiveData<Integer> liftcounter = new MutableLiveData<>(0);
    public LiveData<Integer> getWalkCounter() {
        return walkcounter;
    }

    public LiveData<Integer> getRunCounter() {
        return runcounter;
    }

    public LiveData<Integer> getCycleCounter() {
        return cyclecounter;
    }

    public LiveData<Integer> getLiftCounter() {
        return liftcounter;
    }

    public void walkincrement() {
        walkcounter.setValue(walkcounter.getValue() + 1);
    }
    public void walkdecrement() {
        if (walkcounter.getValue() > 0) {
            walkcounter.setValue(walkcounter.getValue() - 1);
        }
    }

    public void runincrement() {
        runcounter.setValue(runcounter.getValue() + 1);
    }
    public void rundecrement() {
        if (runcounter.getValue() > 0) {
            runcounter.setValue(runcounter.getValue() - 1);
        }
    }

    public void cycleincrement() {
        cyclecounter.setValue(cyclecounter.getValue() + 1);
    }
    public void cycledecrement() {
        if (cyclecounter.getValue() > 0) {
            cyclecounter.setValue(cyclecounter.getValue() - 1);
        }
    }

    public void liftincrement() {
        liftcounter.setValue(liftcounter.getValue() + 1);
    }
    public void liftdecrement() {
        if (liftcounter.getValue() > 0) {
            liftcounter.setValue(liftcounter.getValue() - 1);
        }
    }

}