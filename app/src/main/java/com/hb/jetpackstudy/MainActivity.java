package com.hb.jetpackstudy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button textView2;
    private Button button;
    private ViewModelData viewModelData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        button = findViewById(R.id.button);
        viewModelData = ViewModelProviders.of(this).get(ViewModelData.class);
        textView.setText(String.valueOf(viewModelData.value));

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModelData.value++;
                textView.setText(String.valueOf(viewModelData.value));
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModelData.value += 2;
                textView.setText(String.valueOf(viewModelData.value));

            }
        });
    }
}
