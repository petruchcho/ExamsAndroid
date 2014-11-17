package com.petruchcho.examsandroid;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.examsandroid.R;
import com.petruchcho.examsandroid.ExamSettingsFragment.SettingsType;
import com.petruchcho.examsandroid.exams.Exam;
import com.petruchcho.examsandroid.exams.ExamsLab;

public class ExamsListFragment extends ListFragment {
	private List<Exam> exams;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		exams = ExamsLab.getInstance(getActivity()).getExams();
		getActivity().setTitle(R.string.exams_list_title);
		Collections.sort(exams);
		setHasOptionsMenu(true);
		ExamAdapter adapter = new ExamAdapter(exams);
		setListAdapter(adapter);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.f_exam_list, menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_item_new_exam: {
			Intent intent = new Intent(getActivity(),
					ExamSettingsActivity.class);
			intent.putExtra(ExamSettingsFragment.EXTRA_EXAM_ID,
					UUID.randomUUID());
			intent.putExtra(ExamSettingsFragment.EXTRA_SETTINGS_TYPE,
					SettingsType.ADD);
			startActivity(intent);
			return true;
		}
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private class ExamAdapter extends ArrayAdapter<Exam> {

		public ExamAdapter(List<Exam> exams) {
			super(getActivity(), 0, exams);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = getActivity().getLayoutInflater().inflate(
						R.layout.i_exam, null);
			}
			Exam exam = getItem(position);
			TextView nameLabel = (TextView) convertView
					.findViewById(R.id.nameLabel);
			TextView daysLeftLabel = (TextView) convertView
					.findViewById(R.id.daysLeftLabel);
			TextView countLabel = (TextView) convertView
					.findViewById(R.id.countOfQuestionsLabel);

			if (exam.hasDate())
				daysLeftLabel.setText(exam.getDate().toString());
			else
				daysLeftLabel.setVisibility(View.GONE);

			nameLabel.setText(exam.getName());
			countLabel.setText("" + exam.getCountOfQuestions());

			return convertView;
		}

	}

}
