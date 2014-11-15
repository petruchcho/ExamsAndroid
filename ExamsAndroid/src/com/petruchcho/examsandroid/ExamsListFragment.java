package com.petruchcho.examsandroid;

import java.util.Collections;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.examsandroid.R;
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

		ExamAdapter adapter = new ExamAdapter(exams); 
		setListAdapter(adapter);
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
			countLabel.setText(""+exam.getCountOfQuestions());

			return convertView;
		}

	}

}
