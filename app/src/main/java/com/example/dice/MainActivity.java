package com.example.dice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dice.views.Dice;
import com.example.dice.views.DiceContainer;

public class MainActivity extends AppCompatActivity {

    private DiceContainer diceContainer;
    private DiceRollManager rollManager;
    private Button btnRoll, btnAddDice, btnRemoveDice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
    }

    private void initializeViews()
    {
        diceContainer = findViewById(R.id.diceContainer);
        btnRoll = findViewById(R.id.btnRoll);
        btnAddDice = findViewById(R.id.btnAddDice);
        btnRemoveDice = findViewById(R.id.btnRemoveDice);
        btnRoll = findViewById(R.id.btnRoll);

        btnAddDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDice();
            }
        });
        btnRemoveDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeDice();
            }
        });
        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roll();
            }
        });
    }

    private void addDice()
    {
        Dice dice = diceContainer.addDice();
    }

    private void removeDice()
    {
        Dice dice = diceContainer.removeDice();
    }

    private void roll()
    {

    }

}
