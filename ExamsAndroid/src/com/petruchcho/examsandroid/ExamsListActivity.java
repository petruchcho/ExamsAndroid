package com.petruchcho.examsandroid;

import android.support.v4.app.Fragment;

public class ExamsListActivity extends AbstractFragmentActivity {

	@Override
	protected Fragment createFragment() {
		return new ExamsListFragment();
	}

}
