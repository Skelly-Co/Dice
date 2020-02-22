package com.example.dice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private DiceContainer diceContainer;
    private Button btnRoll, btnAddDice, btnRemoveDice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
    }

    private void initializeViews()
    {
        diceContainer = findViewById(R.id.diceContainer);
        btnRoll = findViewById(R.id.btnRoll);
        btnAddDice = findViewById(R.id.btnAddDice);
        btnRemoveDice = findViewById(R.id.btnRemoveDice);

        btnAddDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDice();
            }
        });
    }

    private void addDice()
    {
        diceContainer.addDice();
    }

    private void removeDice()
    {
        
    }


}
