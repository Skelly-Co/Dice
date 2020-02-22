package com.example.dice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dice.views.Dice;
import com.example.dice.views.DiceContainer;

public class MainActivity extends AppCompatActivity {

    private static final int INITIAL_DICE_COUNT = 1;
    private static final int MIN_DICE_COUNT = 0;
    private static final int MAX_DICE_COUNT = 6;

    private DiceContainer diceContainer;
    private Button btnRoll, btnAddDice, btnRemoveDice;

    private DiceRollManager rollManager = new DiceRollManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        initializeDice();
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

    private void initializeDice()
    {
        for(int i = 0; i < INITIAL_DICE_COUNT; i++)
        {
            addDice();
        }
    }

    private void addDice()
    {
        Dice dice = diceContainer.addDice();
        rollManager.addDice(dice);
    }

    private void removeDice()
    {
        Dice dice = diceContainer.removeDice();
        rollManager.addDice(dice);
    }

    private void roll()
    {

    }

}
