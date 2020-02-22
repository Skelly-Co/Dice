package com.example.dice.views;

import android.content.Context;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatImageView;

import com.example.dice.R;

public class Dice extends AppCompatImageView {

    public enum DiceValue {
        DEFAULT, ONE, TWO, THREE, FOUR, FIVE, SIX;

        public static DiceValue getDiceValue(int value)
        {
            return DiceValue.values()[value+1];
        }
    }

    public enum DiceSize {

        DEFAULT(180), SMALL(120), MEDIUM(160), BIG(180);

        private int value;

        DiceSize(int value)
        {
            this.value = value;
        }

        public int getSize()
        {
            return value;
        }
    }

    public Dice(Context ct)
    {
        this(ct, DiceValue.DEFAULT);
    }

    public Dice(Context ct, DiceValue value)
    {
        this(ct, value, DiceSize.DEFAULT);
    }

    public Dice(Context ct, DiceValue value, DiceSize size)
    {
        super(ct);
        setDiceSize(size);
        setDiceValue(value);
    }

    public void setDiceSize(DiceSize size)
    {
        final float scale = getResources().getDisplayMetrics().density;
        int dpSizeInPx  = (int) (size.getSize() * scale);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(dpSizeInPx, dpSizeInPx,1);
        setLayoutParams(params);
    }

    public void setDiceValue(DiceValue value)
    {
        int imageResource;
        switch(value)
        {
            case ONE:
                imageResource = R.drawable.dice_one;
                break;
            case TWO:
                imageResource = R.drawable.dice_two;
                break;
            case THREE:
                imageResource = R.drawable.dice_three;
                break;
            case FOUR:
                imageResource = R.drawable.dice_four;
                break;
            case FIVE:
                imageResource = R.drawable.dice_five;
                break;
            case SIX:
                imageResource = R.drawable.dice_six;
                break;
            default:
                imageResource = R.drawable.dice_one;
        }
        setImageResource(imageResource);
    }
}
