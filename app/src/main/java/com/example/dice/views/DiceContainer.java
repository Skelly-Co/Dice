package com.example.dice.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.example.dice.R;

import java.util.ArrayList;
import java.util.List;

public class DiceContainer extends LinearLayout {

    private List<Dice> diceList = new ArrayList<>();
    private Context ct;

    private int MAX_DICE_PER_ROW = Integer.MAX_VALUE;

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

    public void addDice()
    {
        if(diceList.size() % MAX_DICE_PER_ROW == 0)
        {
            DiceRow diceRow = new DiceRow(ct);
            diceList.add(diceRow.addDice());
            addView(diceRow);
        }
        else
        {
            DiceRow diceRow = (DiceRow) getChildAt(getChildCount()-1);
            diceList.add(diceRow.addDice());
        }
        resetDice();
        adjustDiceSizes();
    }

    public void removeDice()
    {
        if((diceList.size() + 1 ) % MAX_DICE_PER_ROW == 0)
        {
            DiceRow diceRow = (DiceRow) getChildAt(getChildCount()-1);
            diceList.remove(diceRow.removeDice());
            removeView(diceRow);
        }
        else
        {
            DiceRow diceRow = (DiceRow) getChildAt(getChildCount()-1);
            diceList.remove(diceRow.removeDice());
        }
        resetDice();
        adjustDiceSizes();
    }

    public void resetDice()
    {
        for(int i = 0; i < getChildCount(); i++)
        {
            ((DiceRow)getChildAt(i)).resetDice();
        }
    }

    private void adjustDiceSizes()
    {
        Dice.DiceSize size;
        if(diceList.size() <= MAX_DICE_PER_ROW)
        {
            size = Dice.DiceSize.BIG;
        }
        else if(diceList.size() <= MAX_DICE_PER_ROW * 2)
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

    public void updateDiceValues(List<Integer> diceValues)
    {
        for(int i = 0; i < diceList.size(); i++)
        {
            Dice.DiceValue diceValue = Dice.DiceValue.getDiceValue(diceValues.get(i));
            diceList.get(i).setDiceValue(diceValue);
        }
    }

    public List<Dice> getDiceList()
    {
        return diceList;
    }

    public int getDiceCount()
    {
        return diceList.size();
    }
}
