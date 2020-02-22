package com.example.dice;

import com.example.dice.views.Dice;

import java.util.ArrayList;
import java.util.List;

public class DiceRollManager {

    private List<Dice> diceList = new ArrayList<>();

    public void addDice(Dice dice)
    {
        diceList.add(dice);
    }

    public void removeDice(Dice dice)
    {

    }

    public void resetDice()
    {
        
    }
}
