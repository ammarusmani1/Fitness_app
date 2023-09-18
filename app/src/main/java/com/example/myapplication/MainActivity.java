package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.btnCalculate.setOnClickListener(view -> {
            if (!binding.edtweight.getText().toString().isEmpty() && !binding.edtheightft.getText().toString().isEmpty() && !binding.edtheightinch.getText().toString().isEmpty()) {
                int edtweight = Integer.parseInt(binding.edtweight.getText().toString());
                int edtfeet = Integer.parseInt(binding.edtheightft.getText().toString());
                int edtinch = Integer.parseInt(binding.edtheightinch.getText().toString());

                int inch = edtfeet * 12 + edtinch;
                double cm = inch * 2.53;
                double Mm = cm / 100;
                double bmi = edtweight / (Mm * Mm);
                if (bmi > 25) {
                    binding.textView.setText("opps you are overweight!");
                    binding.constraint.setBackgroundColor(getResources().getColor(R.color.over));
                } else if (bmi < 18) {
                    binding.textView.setText("Eat something you are underweight");
                    binding.constraint.setBackgroundColor(getResources().getColor(R.color.under));
                } else {
                    binding.textView.setText("Congrats you are healthy!");
                    binding.constraint.setBackgroundColor(getResources().getColor(R.color.healthy));
                }
            } else {
                binding.textView.setText("Please fill all the fields");
            }
        });
    }
}