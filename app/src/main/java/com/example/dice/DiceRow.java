package com.example.dice;

import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class DiceRow extends LinearLayout {

    public DiceRow(Context ct)
    {
        super(ct);
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

    public void addDice(Dice dice)
    {
        addView(dice);
    }

}
