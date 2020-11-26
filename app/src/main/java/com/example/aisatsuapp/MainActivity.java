package com.example.aisatsuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        textView = (TextView) findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v) {
        showTimePickerDialog();
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hour, int minute) {
                        Log.d("java_test", String.format("%02d:%02d", hour, minute));
                        if (2 <= hour && hour <= 9) {
                            textView.setText("おはよう");
                        } else if (10 <= hour && hour <= 17) {
                            textView.setText("こんにちは");
                        } else {
                            textView.setText("こんばんは");
                        }
                    }
                },
                13, 0, true
        );
        timePickerDialog.show();
    }
}