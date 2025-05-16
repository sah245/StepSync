package com.example.stepsync.ui.timer;

import android.os.Handler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TimerViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private final MutableLiveData<Long> elapsedSeconds = new MutableLiveData<>(0L);
    boolean isRunning = false;
    private Handler handler = new Handler();
    private Runnable runnable;

    public TimerViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Timer fragment");

        runnable = new Runnable() {
            @Override
            public void run() {
                if (isRunning) {
                    Long current = elapsedSeconds.getValue();
                    if (current == null) current = 0L;
                    elapsedSeconds.setValue(current + 1);
                    handler.postDelayed(this, 1000);
                }
            }
        };
    }

    public LiveData<Long> getElapsedSeconds() {
        return elapsedSeconds;
    }

    public void startTimer() {
        if (!isRunning) {
            isRunning = true;
            handler.post(runnable);
        }
    }

    public void pauseTimer() {
        isRunning = false;
    }

    public void resetTimer() {
        isRunning = false;
        elapsedSeconds.setValue(0L);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        handler.removeCallbacks(runnable);
    }
    public LiveData<String> getText() {
        return mText;
    }
}