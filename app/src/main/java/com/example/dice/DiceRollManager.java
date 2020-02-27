package com.example.dice;

import com.example.dice.views.Dice;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DiceRollManager {

    private static final int MAX_DICE_VALUE = Dice.DiceValue.MAX.getValue();
    private static final int MIN_DICE_VALUE = Dice.DiceValue.MIN.getValue();
    private static DiceRollManager instance;
    private static int diceCount = 0;
    private static List<int[]> rollHistory = new ArrayList<>();

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

    public void addDice()
    {
        diceCount++;
    }

    public void removeDice()
    {
        diceCount--;
    }

    public int[] roll()
    {
        int[] results = new int[diceCount];
        Random random = new Random();
        for(int i = 0; i < diceCount; i++)
        {
            int rollResult = random.nextInt(
                    ((MAX_DICE_VALUE - MIN_DICE_VALUE)) + 1) + MIN_DICE_VALUE;
            results[i] = rollResult;
        }
        rollHistory.add(results);
        return results;
    }

    public String[] getRollResultsAsStrings()
    {
        String[] results = new String[rollHistory.size()];
        for(int i = 0; i < rollHistory.size(); i++)
        {
            int[] rollResult = rollHistory.get(i);
            String resultAsString = "";
            int rollSum = 0;
            for(int j = 0; j < rollResult.length; j++)
            {
                resultAsString += rollResult[j] + " ";
                rollSum += rollResult[j];
                if(j != rollResult.length-1)
                {
                    resultAsString += "+ ";
                }
                else
                {
                    resultAsString += "= " + rollSum;
                }
            }
            results[i] = resultAsString;
        }
        ArrayUtils.reverse(results);
        return results;
    }

    public int[] getLastRollResult()
    {
        if(!rollHistory.isEmpty())
        {
            return rollHistory.get(rollHistory.size()-1);
        }
        return null;
    }

    public void clearHistory()
    {
        rollHistory = new ArrayList();
    }

    public int getDiceCount() {
        return diceCount;
    }

}
