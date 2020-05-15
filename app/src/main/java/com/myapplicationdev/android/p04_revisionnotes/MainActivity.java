package com.myapplicationdev.android.p04_revisionnotes;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvNotes, tvStart;
    EditText etNotes;
    RadioGroup rg;
    RadioButton rb;
    Button btnInsert, btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNotes = findViewById(R.id.textViewNote);
        tvStart = findViewById(R.id.textView2);
        etNotes = findViewById(R.id.editTextNote);
        rg = findViewById(R.id.radioGroupStars);
        btnInsert = findViewById(R.id.buttonInsertNote);
        btnShow = findViewById(R.id.buttonShowList);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedButtonId = rg.getCheckedRadioButtonId();
                rb = findViewById(selectedButtonId);
                int buttonId = Integer.parseInt(rb.getText().toString());

                DBHelper db = new DBHelper(MainActivity.this);

                db.insertNote(etNotes.getText().toString(), buttonId);
                db.close();
                Toast.makeText(MainActivity.this, "Inserted" , Toast.LENGTH_SHORT).show();
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
