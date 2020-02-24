package com.example.dice;

import android.content.Context;
import android.media.MediaPlayer;

import com.example.dice.views.Dice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DiceRollManager {

    private List<Dice> diceList = new ArrayList<>();
    private static DiceRollManager instance;

    private DiceRollManager()
    {

    }

    public static DiceRollManager getInstance()
    {
        if(instance == null)
        {
            instance = new DiceRollManager();
        }
        return instance;
    }

    public void addDice(Dice dice)
    {
        diceList.add(dice);
        resetDice();
    }

    public void removeDice(Dice dice)
    {
        diceList.remove(dice);
        resetDice();
    }

    public void roll()
    {
        rollDice();
    }


    private void rollDice()
    {
        Random random = new Random();
        for(Dice dice : diceList)
        {
            int rollResult = random.nextInt(
                    ((Dice.DiceValue.MAX.getValue() - Dice.DiceValue.MIN.getValue())
                            + 1) + Dice.DiceValue.MIN.getValue());
            dice.setDiceValue(Dice.DiceValue.getDiceValue(rollResult));
        }
    }

    private void resetDice()
    {
        for(Dice dice : diceList)
        {
            dice.setDiceValue(Dice.DiceValue.DEFAULT);
        }
    }
}
