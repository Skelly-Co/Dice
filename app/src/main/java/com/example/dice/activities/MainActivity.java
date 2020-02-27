package com.example.dice.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.dice.DiceRollManager;
import com.example.dice.R;
import com.example.dice.views.Dice;
import com.example.dice.views.DiceContainer;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int SHAKE_ANIMATION_DELAY = 75;

    private static final int INITIAL_DICE_COUNT = 1;
    private static final int MIN_DICE_COUNT = 1;
    private static final int MAX_DICE_COUNT = 6;

    private DiceContainer diceContainer;
    private Button btnRoll, btnAddDice, btnRemoveDice;

    private MediaPlayer mediaPlayer;
    private DiceRollManager rollManager = DiceRollManager.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();

        if(savedInstanceState != null)
        {
            int[] lastRoll = savedInstanceState.getIntArray("lastRoll");
            restoreDice(lastRoll);
        }
        else
        {
            initializeDice();
        }
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
        if(diceContainer.getDiceCount() < MAX_DICE_COUNT)
        {
            diceContainer.addDice();
            rollManager.addDice();
            setAddRemoveButtonsVisibility();
        }
    }

    private void removeDice()
    {
        if(diceContainer.getDiceCount() > MIN_DICE_COUNT)
        {
            diceContainer.removeDice();
            rollManager.removeDice();
            setAddRemoveButtonsVisibility();
        }
    }

    private void restoreDice(int[] lastRoll)
    {
        for(int i = 0; i < lastRoll.length; i++)
        {
            diceContainer.addDice();
            setAddRemoveButtonsVisibility();
        }
        diceContainer.updateDiceValues(lastRoll);
    }

    private void setAddRemoveButtonsVisibility()
    {
        if(diceContainer.getDiceCount() <= MIN_DICE_COUNT)
        {
            btnRemoveDice.setVisibility(View.INVISIBLE);
        }
        else if(diceContainer.getDiceCount() >= MAX_DICE_COUNT)
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
        btnRoll.setEnabled(false);
        final int[] rollResult = rollManager.roll();
        final List<Dice> diceList = diceContainer.getDiceList();
        for(int i = 0; i < diceList.size(); i++)
        {
            YoYo.AnimationComposer animation = createShakeAnimation().delay(i * SHAKE_ANIMATION_DELAY);
            if(i == diceList.size()-1)
            {
                animation.withListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        playRollingSound();
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        diceContainer.updateDiceValues(rollResult);
                        btnRoll.setEnabled(true);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) { }

                    @Override
                    public void onAnimationRepeat(Animator animation) { }
                });
            }
            animation.playOn(diceList.get(i));
        }
    }

    private YoYo.AnimationComposer createShakeAnimation()
    {
        YoYo.AnimationComposer animation = YoYo.with(Techniques.Shake).duration(600);
        return animation;
    }

    private void playRollingSound()
    {
        if(mediaPlayer == null)
        {
            mediaPlayer  = MediaPlayer.create(this, R.raw.dice_roll);
        }
        else if(mediaPlayer.isPlaying())
        {
            mediaPlayer.stop();
            mediaPlayer  = MediaPlayer.create(this, R.raw.dice_roll);
        }
        mediaPlayer.start();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putIntArray("lastRoll", rollManager.getLastRollResult());
        super.onSaveInstanceState(outState);
    }
}
