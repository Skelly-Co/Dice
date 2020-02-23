package com.example.dice.views;

import android.content.Context;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatImageView;

import com.example.dice.R;

public class Dice extends AppCompatImageView {

    public enum DiceValue {
        ONE(1, R.drawable.dice_one),
        TWO(2, R.drawable.dice_two),
        THREE(3, R.drawable.dice_three),
        FOUR(4, R.drawable.dice_four),
        FIVE(5, R.drawable.dice_five),
        SIX(6, R.drawable.dice_six);

        public static final DiceValue MIN = ONE;
        public static final DiceValue MAX = SIX;
        public static final DiceValue DEFAULT = ONE;

        private int value;
        private int image;

        DiceValue(int value, int image)
        {
            this.value = value;
            this.image = image;
        }

        public static DiceValue getDiceValue(int value)
        {
            for(DiceValue dv : values())
            {
                if(dv.getValue() == value)
                {
                    return dv;
                }
            }
            return DEFAULT;
        }

        public int getValue()
        {
            return value;
        }

        public int getImage()
        {
            return image;
        }
    }

    public enum DiceSize {

        SMALL(120), MEDIUM(160), BIG(180);

        public static final DiceSize DEFAULT = BIG;

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
        setImageResource(value.getImage());
    }
}
