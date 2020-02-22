package com.example.dice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linDiceContainer;
    private Button btnRoll, btnAddDice, btnRemoveDice;

    private static final int INITIAL_DICE_NUMBER = 1;

    private int currentDiceNumber;

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
        for(int i = 0; i < INITIAL_DICE_NUMBER; i++)
        {
            addDice();
        }
    }

    private void addDice()
    {
        if(currentDiceNumber == 0)
        {
            DiceRow diceRow = new DiceRow(this);
            diceRow.addDice(new Dice(this));
            linDiceContainer.addView(diceRow);
        }
        currentDiceNumber++;
    }

    private void removeDice()
    {

    }


}
