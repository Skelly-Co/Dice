package com.example.dice.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.example.dice.R;

public class DiceContainer extends LinearLayout {

    private Context ct;

    private int MAX_DICE_PER_ROW = Integer.MAX_VALUE;

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
        if(a.hasValue(R.styleable.DiceContainer_maxDicePerRow))
        {
            MAX_DICE_PER_ROW = a.getInt(R.styleable.DiceContainer_maxDicePerRow, MAX_DICE_PER_ROW);
        }
        a.recycle();
    }

    public Dice addDice()
    {
        Dice dice;
        if(diceCount%MAX_DICE_PER_ROW == 0)
        {
            DiceRow diceRow = new DiceRow(ct);
            dice = diceRow.addDice();
            addView(diceRow);
        }
        else
        {
            DiceRow diceRow = (DiceRow) getChildAt(getChildCount()-1);
            dice = diceRow.addDice();
        }
        diceCount++;
        adjustDiceSizes();
        return dice;

    }

    public Dice removeDice()
    {
        DiceRow diceRow = (DiceRow) getChildAt(getChildCount()-1);
        Dice dice = diceRow.removeDice();
        diceCount--;
        adjustDiceSizes();
        return dice;
    }

    private void adjustDiceSizes()
    {
        Dice.DiceSize size;
        if(diceCount <= MAX_DICE_PER_ROW)
        {
            size = Dice.DiceSize.BIG;
        }
        else if(diceCount <= MAX_DICE_PER_ROW * 2)
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
