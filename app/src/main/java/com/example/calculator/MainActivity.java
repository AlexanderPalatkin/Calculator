package com.example.calculator;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private Calculator calculator = new Calculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initFields();
        onNumberButtonsOnClick();
        onOperationButtonsOnClick();

    }

    private void initFields() {
        binding.firstInputTextView.setText(calculator.getFirstValue());
        binding.secondInputTextView.setText(calculator.getSecondValue());
        binding.operationInputTextView.setText(calculator.getOperand());
        binding.resultInputTextView.setText(calculator.getResult());
    }

    private void onOperationButtonsOnClick() {
        binding.plusButton.setOnClickListener(view -> {
            calculator.setField(String.valueOf(binding.plusButton.getText()));
            initFields();
        });
        binding.minusButton.setOnClickListener(view -> {
            calculator.setField(String.valueOf(binding.minusButton.getText()));
            initFields();
        });
        binding.multiplyButton.setOnClickListener(view -> {
            calculator.setField(String.valueOf(binding.multiplyButton.getText()));
            initFields();
        });
        binding.divideButton.setOnClickListener(view -> {
            calculator.setField(String.valueOf(binding.divideButton.getText()));
            initFields();
        });
        binding.resetButton.setOnClickListener(view -> {
            calculator.getReset();
            initFields();
        });
        binding.resultButton.setOnClickListener(view -> {
            calculator.setResult();
            initFields();
        });
        binding.plusMinusButton.setOnClickListener(view -> {
            calculator.getPlusMinus();
            initFields();
        });
        binding.backspaceButton.setOnClickListener(view -> {
            calculator.backspace();
            initFields();
        });
        binding.pointButton.setOnClickListener(view -> {
            calculator.setField(String.valueOf(binding.pointButton.getText()));
            initFields();
        });
    }

    private void onNumberButtonsOnClick() {
        binding.button0.setOnClickListener(view -> {
            calculator.setField(String.valueOf(binding.button0.getText()));
            initFields();
        });
        binding.button1.setOnClickListener(view -> {
            calculator.setField(String.valueOf(binding.button1.getText()));
            initFields();
        });
        binding.button2.setOnClickListener(view -> {
            calculator.setField(String.valueOf(binding.button2.getText()));
            initFields();
        });
        binding.button3.setOnClickListener(view -> {
            calculator.setField(String.valueOf(binding.button3.getText()));
            initFields();
        });
        binding.button4.setOnClickListener(view -> {
            calculator.setField(String.valueOf(binding.button4.getText()));
            initFields();
        });
        binding.button5.setOnClickListener(view -> {
            calculator.setField(String.valueOf(binding.button5.getText()));
            initFields();
        });
        binding.button6.setOnClickListener(view -> {
            calculator.setField(String.valueOf(binding.button6.getText()));
            initFields();
        });
        binding.button7.setOnClickListener(view -> {
            calculator.setField(String.valueOf(binding.button7.getText()));
            initFields();
        });
        binding.button8.setOnClickListener(view -> {
            calculator.setField(String.valueOf(binding.button8.getText()));
            initFields();
        });
        binding.button9.setOnClickListener(view -> {
            calculator.setField(String.valueOf(binding.button9.getText()));
            initFields();
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}