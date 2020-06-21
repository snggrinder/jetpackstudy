package com.hb.jetpackstudy;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class ViewModelScore extends ViewModel {
    private SavedStateHandle handle;

    public ViewModelScore(SavedStateHandle redHandle) {
        this.handle = redHandle;
    }

    private int redTemp , blueTemp;



    public MutableLiveData<Integer> getRedScore() {
       if (!handle.contains(ScoreActivity.RED_SCORE)){
           handle.set(ScoreActivity.RED_SCORE,0);
       }
       return handle.getLiveData(ScoreActivity.RED_SCORE);
    }

    public MutableLiveData<Integer> getBlueScore() {

       if (!handle.contains(ScoreActivity.BLUE_SCORE)){
           handle.set(ScoreActivity.BLUE_SCORE,0);
       }
       return handle.getLiveData(ScoreActivity.BLUE_SCORE);
    }

    public void addRedScore(int p){
        MutableLiveData<Integer> redScore = getRedScore();
        if (redScore.getValue()!=null){
            redTemp = redScore.getValue();
        }else {
            redTemp = 0;
        }

        MutableLiveData<Integer> blueScore = getBlueScore();
        if (blueScore.getValue()!=null){
            blueTemp = blueScore.getValue();
        }else {
            blueTemp = 0;
        }

        handle.set(ScoreActivity.RED_SCORE,redScore.getValue()+p);
    }

    public void addBlueScore(int p){
        MutableLiveData<Integer> redScore = getRedScore();
        if (redScore.getValue()!=null){
            redTemp = redScore.getValue();
        }else {
            redTemp = 0;
        }

        MutableLiveData<Integer> blueScore = getBlueScore();
        if (blueScore.getValue()!=null){
            blueTemp = blueScore.getValue();
            handle.set(ScoreActivity.BLUE_SCORE,blueScore.getValue()+p);
        }else {
            blueTemp = 0;
            handle.set(ScoreActivity.BLUE_SCORE,p);
        }


    }

    public void reSet(){
        redTemp = (int)handle.getLiveData(ScoreActivity.RED_SCORE).getValue();
        blueTemp = (int)handle.getLiveData(ScoreActivity.BLUE_SCORE).getValue();
        handle.set(ScoreActivity.RED_SCORE,0);
        handle.set(ScoreActivity.BLUE_SCORE,0);
    }


    public void unDo(){
        handle.set(ScoreActivity.RED_SCORE,redTemp);
        handle.set(ScoreActivity.BLUE_SCORE,blueTemp);
    }
}
