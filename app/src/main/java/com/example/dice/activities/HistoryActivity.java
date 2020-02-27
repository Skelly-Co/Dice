package com.example.dice.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.dice.DiceRollManager;
import com.example.dice.R;

public class HistoryActivity extends AppCompatActivity {

    private DiceRollManager rollManager = DiceRollManager.getInstance();
    private ListView lstHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        initializeViews();
        initializeHistory();
    }

    private void initializeViews()
    {
        lstHistory = findViewById(R.id.lstHistory);
        Button btnBack = findViewById(R.id.btnBack);
        Button btnClear = findViewById(R.id.btnClear);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearHistory();
            }
        });
    }

    private void initializeHistory()
    {
        ListAdapter adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, rollManager.getRollResultsAsStrings());
        lstHistory.setAdapter(adapter);
    }

    private void clearHistory()
    {
        rollManager.clearHistory();
        initializeHistory();
    }

    private void goBack()
    {
        finish();
    }

}
