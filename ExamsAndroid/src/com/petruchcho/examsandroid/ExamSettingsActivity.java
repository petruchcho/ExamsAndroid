package com.petruchcho.examsandroid;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

public class ExamSettingsActivity extends AbstractFragmentActivity{

	@Override
	protected Fragment createFragment() {
		return new ExamSettingsFragment();
	}

}
