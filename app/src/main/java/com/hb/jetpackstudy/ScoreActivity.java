package com.hb.jetpackstudy;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.hb.jetpackstudy.databinding.ActivityScoreBinding;

public class ScoreActivity extends AppCompatActivity {
    public static final String RED_SCORE ="red_score";
    public static final String BLUE_SCORE ="blue_score";
    private ViewModelScore viewModelScore;
    private ActivityScoreBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_score);

        viewModelScore = new ViewModelProvider(this).get(ViewModelScore.class);
        binding.setData(this.viewModelScore);
        binding.setLifecycleOwner(this);

    }
}
