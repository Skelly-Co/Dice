package com.example.dice;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatImageView;

public class Dice extends AppCompatImageView {

    public enum DiceValue {
        ONE, TWO, THREE, FOUR, FIVE, SIX;

        public static DiceValue getDiceValue(int value)
        {
            return DiceValue.values()[value];
        }
    }

    public enum DiceSize {

        SMALL(100), MEDIUM(140), BIG(180);

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

    private static final DiceValue DEFAULT_DICE_VALUE = DiceValue.ONE;
    private static final DiceSize DEFAULT_DICE_SIZE = DiceSize.BIG;

    public Dice(Context ct)
    {
        this(ct, DEFAULT_DICE_VALUE);
    }

    public Dice(Context ct, DiceValue value)
    {
        this(ct, value, DEFAULT_DICE_SIZE);
    }

    public Dice(Context ct, DiceValue value, DiceSize size)
    {
        super(ct);
        setDiceSize(size);
        setDiceImage(value);
    }

    public void setDiceSize(DiceSize size)
    {
        final float scale = getResources().getDisplayMetrics().density;
        int dpSizeInPx  = (int) (size.getSize() * scale);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(dpSizeInPx, dpSizeInPx,1);
        setLayoutParams(params);
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
