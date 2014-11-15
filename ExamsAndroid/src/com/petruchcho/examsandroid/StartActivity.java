package com.petruchcho.examsandroid;

import java.util.UUID;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.examsandroid.R;
import com.petruchcho.examsandroid.ExamSettingsFragment.SettingsType;

public class StartActivity extends ActionBarActivity {

	Button addFirstExamBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_start);

		// TODO Should start list logic if there is at least one exam

		addFirstExamBtn = (Button) findViewById(R.id.addFirstExamBtn);
		addFirstExamBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(StartActivity.this,
						ExamSettingsActivity.class);
				intent.putExtra(ExamSettingsFragment.EXTRA_EXAM_ID, UUID.randomUUID());
				intent.putExtra(ExamSettingsFragment.EXTRA_SETTINGS_TYPE,
						SettingsType.ADD);
				startActivity(intent);
			}
		});
	}
}
