package com.example.dice;

import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class DiceRow extends LinearLayout {

    private Context ct;
    private static final int DEFAULT_LEFT_MARGIN = 10;
    private static final int DEFAULT_TOP_MARGIN = 50;
    private static final int DEFAULT_RIGHT_MARGIN = 10;
    private static final int DEFAULT_BOTTOM_MARGIN = 0;


    public DiceRow(Context ct)
    {
        super(ct);
        this.ct = ct;
        setMargins(DEFAULT_LEFT_MARGIN, DEFAULT_TOP_MARGIN, DEFAULT_RIGHT_MARGIN, DEFAULT_BOTTOM_MARGIN);
        setGravity(Gravity.CENTER);
    }

    private void setMargins(int leftMargin, int topMargin, int rightMargin, int bottomMargin)
    {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT,
                1);
        params.setMargins(leftMargin, topMargin, rightMargin, bottomMargin);
        setLayoutParams(params);
    }

    public void addDice()
    {
        Dice dice = new Dice(ct);
        addView(dice);
    }


    public void setDiceSizes(Dice.DiceSize size)
    {
        for(int i = 0; i < getChildCount(); i++)
        {
            Dice dice = (Dice) getChildAt(i);
            dice.setDiceSize(size);
        }
    }

    public void removeDice()
    {

    }

}
