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
    private static final int MIN_DICE_COUNT = 0;
    private static final int MAX_DICE_COUNT = 6;

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
        if(diceCount < MAX_DICE_COUNT)
        {
            if(diceCount == 0)
            {
                DiceRow diceRow = new DiceRow(this);
                diceRow.addDice();
                linDiceContainer.addView(diceRow);
            }
            else if(diceCount == 1)
            {
                DiceRow diceRow = (DiceRow) linDiceContainer.getChildAt(0);
                diceRow.addDice();
                btnRemoveDice.setEnabled(true);
            }
            else if(diceCount == 2)
            {
                DiceRow diceRow = new DiceRow(this);
                diceRow.addDice();
                linDiceContainer.addView(diceRow);
            }
            else if(diceCount%2 == 0)
            {
                DiceRow diceRow = (DiceRow) linDiceContainer.getChildAt(0);
                diceRow.addDice();
            }
            else
            {
                DiceRow diceRow = (DiceRow) linDiceContainer.getChildAt(1);
                diceRow.addDice();
            }
            diceCount++;
            adjustDiceSizes();
            
        }
        
    }
    
    private void adjustDiceSizes()
    {
        Dice.DiceSize size;
        if(diceCount < 3)
        {
            size = Dice.DiceSize.BIG;
        }
        else if(diceCount < 5)
        {
            size = Dice.DiceSize.MEDIUM;
        }
        else
        {
            size = Dice.DiceSize.SMALL;
        }
        for(int i = 0; i < linDiceContainer.getChildCount(); i++)
        {
            DiceRow diceRow = (DiceRow) linDiceContainer.getChildAt(i);
            diceRow.setDiceSizes(size);
        }
    }

    private void removeDice()
    {
        
    }


}
