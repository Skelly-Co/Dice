package com.example.dice;

import android.content.Context;

import androidx.appcompat.widget.AppCompatImageButton;

public class Dice extends AppCompatImageButton {

    public enum DiceValue {
        ONE, TWO, THREE, FOUR, FIVE, SIX;

        public static DiceValue getDiceValue(int value)
        {
            return DiceValue.values()[value];
        }
    }

    public static final DiceValue DEFAULT_DICE_VALUE = DiceValue.ONE;

    public Dice(Context ct)
    {
        this(ct, DEFAULT_DICE_VALUE);
    }

    public Dice(Context ct, DiceValue value)
    {
        super(ct);
        setDiceImage(value);
    }

    private void setDiceImage(DiceValue value)
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
