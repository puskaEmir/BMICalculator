package com.academy.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.academy.bmi.calculator.Health;

public class MainActivity extends AppCompatActivity {
    private NumberPicker heightNumberPicker;
    private NumberPicker weightNumberPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        heightNumberPicker = findViewById(R.id.heightNumberPicker);
        weightNumberPicker = findViewById(R.id.weightNumberPicker);
        heightNumberPicker.setMinValue(100);
        heightNumberPicker.setMaxValue(289);
        heightNumberPicker.setValue(175);
        heightNumberPicker.setWrapSelectorWheel(false);
        weightNumberPicker.setMinValue(20);
        weightNumberPicker.setMaxValue(400);
        weightNumberPicker.setValue(70);
        weightNumberPicker.setWrapSelectorWheel(false);

    }

    public void calculateBtnClick(View view){
        double height = 0;
        double weight = 0;
        if(heightNumberPicker!=null){
            height = heightNumberPicker.getValue();
        }
        if(weightNumberPicker != null){
            weight = weightNumberPicker.getValue();
        }
        Health health = new Health();
        double bmiResult = health.calculateBMI(height, weight);
        TextView resultTextView = findViewById(R.id.resultTextView);
        if(bmiResult == -1){
            resultTextView.setText(health.getErrorMessage());
        }else{
           String bmiCategory = health.determineBMICategory(bmiResult);
           String message = "Your BMI index is: " + String.format("%.2f", bmiResult);
           message += System.lineSeparator();
           message += "BMI category: " + bmiCategory;
           resultTextView.setText(message);
        }
    }
}