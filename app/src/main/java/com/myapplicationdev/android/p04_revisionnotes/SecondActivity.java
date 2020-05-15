package com.myapplicationdev.android.p04_revisionnotes;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

	ListView lv;
	ArrayAdapter aa;
	ArrayList<Note> notes = new ArrayList<Note>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//TODO implement the Custom ListView

		setContentView(R.layout.activity_second);
		lv = (ListView)findViewById(R.id.lv);

		aa = new RevisionNotesArrayAdapter(getApplicationContext(), R.layout.row, notes);
		lv.setAdapter(aa);

		DBHelper db = new DBHelper(SecondActivity.this);

		ArrayList<Note> data = db.getAllNotes();
		db.close();
		for(int i=0; i<data.size(); i++){
			notes.add(new Note(data.get(i).getId(), data.get(i).getNoteContent(), data.get(i).getStars()));
		}

	}


}
