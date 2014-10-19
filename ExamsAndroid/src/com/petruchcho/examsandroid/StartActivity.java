package com.petruchcho.examsandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.examsandroid.R;

public class StartActivity extends ActionBarActivity {

	Button addFirstExamBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_start);
		addFirstExamBtn = (Button) findViewById(R.id.addFirstExamBtn);
		
		addFirstExamBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(StartActivity.this, ExamSettingsActivity.class);
				startActivity(intent);
			}
		});
	}
}
