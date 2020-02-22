package com.example.dice.views;

import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class DiceRow extends LinearLayout {

    private Context ct;

    public DiceRow(Context ct)
    {
        super(ct);
        this.ct = ct;
        setVisualProperties();
    }

    private void setVisualProperties()
    {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT,
                1);
        setLayoutParams(params);
        setGravity(Gravity.CENTER);
    }

    public Dice addDice()
    {
        Dice dice = new Dice(ct);
        addView(dice);
        return dice;
    }


    public void setDiceSizes(Dice.DiceSize size)
    {
        for(int i = 0; i < getChildCount(); i++)
        {
            Dice dice = (Dice) getChildAt(i);
            dice.setDiceSize(size);
        }
    }

    public Dice removeDice()
    {
        Dice dice = (Dice) getChildAt(getChildCount()-1);
        removeView(dice);
        return dice;
    }

}
