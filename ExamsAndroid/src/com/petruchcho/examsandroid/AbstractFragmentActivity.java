package com.petruchcho.examsandroid;

import com.example.examsandroid.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public abstract class AbstractFragmentActivity extends FragmentActivity {
	protected abstract Fragment createFragment();

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.a_fragment);
		FragmentManager fManager = getSupportFragmentManager();
		Fragment fragment = fManager.findFragmentById(R.id.fragmentContainer);
		if (fragment == null) {
			fragment = createFragment();
			fManager.beginTransaction().add(R.id.fragmentContainer, fragment)
					.commit();
		}
	}
}
