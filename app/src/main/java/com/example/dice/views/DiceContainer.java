package com.example.dice.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.example.dice.R;

public class DiceContainer extends LinearLayout {

    private Context ct;

    private int MAX_DICE_COUNT = 2;
    private int DICE_PER_ROW = 2;

    private int diceCount;

    public DiceContainer(Context ct, AttributeSet attrs)
    {
        super(ct, attrs);
        this.ct = ct;
        setProperties(ct, attrs);
    }

    private void setProperties(Context ct, AttributeSet attrs)
    {
        TypedArray a = ct.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.DiceContainer,
                0, 0);
        if(a.hasValue(R.styleable.DiceContainer_maxDiceCount))
        {
            MAX_DICE_COUNT = a.getInt(R.styleable.DiceContainer_maxDiceCount, MAX_DICE_COUNT);
        }
        if(a.hasValue(R.styleable.DiceContainer_dicePerRow))
        {
            DICE_PER_ROW = a.getInt(R.styleable.DiceContainer_dicePerRow, DICE_PER_ROW);
        }
        a.recycle();
    }

    public Dice addDice()
    {
        Dice dice = null;
        if(diceCount%2 == 0)
        {
            DiceRow diceRow = new DiceRow(ct);
            dice = diceRow.addDice();
            addView(diceRow);
        }
        else
        {
            DiceRow diceRow = (DiceRow) getChildAt(getChildCount()-1);
            diceRow.addDice();
        }
        diceCount++;
        adjustDiceSizes();
        return dice;

    }

    public Dice removeDice()
    {
        return null;
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
        for(int i = 0; i < getChildCount(); i++)
        {
            DiceRow diceRow = (DiceRow) getChildAt(i);
            diceRow.setDiceSizes(size);
        }
    }

}
