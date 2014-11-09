package com.petruchcho.examsandroid;

import java.util.UUID;

import android.support.v4.app.Fragment;

import com.petruchcho.examsandroid.ExamSettingsFragment.SettingsType;

public class ExamSettingsActivity extends AbstractFragmentActivity{

	@Override
	protected Fragment createFragment() {
		UUID examId = (UUID)getIntent().getSerializableExtra(ExamSettingsFragment.EXTRA_EXAM_ID);
		SettingsType type = (SettingsType)getIntent().getSerializableExtra(ExamSettingsFragment.EXTRA_SETTINGS_TYPE);
		return ExamSettingsFragment.newInstance(examId, type);
	}

}
