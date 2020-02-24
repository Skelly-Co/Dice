package com.example.dice;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.dice.views.Dice;
import com.example.dice.views.DiceContainer;

public class MainActivity extends AppCompatActivity {

    private static final int INITIAL_DICE_COUNT = 1;
    private static final int MIN_DICE_COUNT = 1;
    private static final int MAX_DICE_COUNT = 6;

    private DiceContainer diceContainer;
    private Button btnRoll, btnAddDice, btnRemoveDice;

    private DiceRollManager rollManager = DiceRollManager.getInstance();
    private int diceCount;

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
        if(diceCount < MAX_DICE_COUNT)
        {
            Dice dice = diceContainer.addDice();
            rollManager.addDice(dice);
            diceCount++;
            setAddRemoveButtonsVisibility();
        }
    }

    private void removeDice()
    {
        if(diceCount > MIN_DICE_COUNT)
        {
            Dice dice = diceContainer.removeDice();
            rollManager.removeDice(dice);
            diceCount--;
            setAddRemoveButtonsVisibility();
        }
    }

    private void setAddRemoveButtonsVisibility()
    {
        if(diceCount <= MIN_DICE_COUNT)
        {
            btnRemoveDice.setVisibility(View.INVISIBLE);
        }
        else if(diceCount >= MAX_DICE_COUNT)
        {
            btnAddDice.setVisibility(View.INVISIBLE);
        }
        else
        {
            btnAddDice.setVisibility(View.VISIBLE);
            btnRemoveDice.setVisibility(View.VISIBLE);
        }

    }

    private void roll()
    {
        rollManager.roll();
        playShakeAnimation();
        playRollingSound();
    }

    private void playShakeAnimation()
    {
//        YoYo.with(Techniques.Shake).duration(700).repeat(0).playOn(diceContainer);
    }

    private void playRollingSound()
    {
        MediaPlayer rollDiceSound  = MediaPlayer.create(this, R.raw.dice_roll);
        rollDiceSound.start();
    }


}
