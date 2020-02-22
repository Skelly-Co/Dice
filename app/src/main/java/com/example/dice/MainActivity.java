package com.example.dice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linDiceContainer;
    private Button btnRoll, btnAddDice, btnRemoveDice;

    private static final int INITIAL_DICE_COUNT = 1;

    private int diceCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        initializeDices();
    }

    private void initializeViews()
    {
        linDiceContainer = findViewById(R.id.linDiceContainer);
        btnRoll = findViewById(R.id.btnRoll);
        btnAddDice = findViewById(R.id.btnAddDice);
        btnRemoveDice = findViewById(R.id.btnRemoveDice);

        btnAddDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDice();
            }
        });
    }

    private void initializeDices()
    {
        for(int i = 0; i < INITIAL_DICE_COUNT; i++)
        {
            addDice();
        }
    }

    private void addDice()
    {
        if(diceCount == 0)
        {
            DiceRow diceRow = new DiceRow(this);
            diceRow.addDice(new Dice(this));
            linDiceContainer.addView(diceRow);
        }
        diceCount++;
    }

    private void removeDice()
    {

    }


}
