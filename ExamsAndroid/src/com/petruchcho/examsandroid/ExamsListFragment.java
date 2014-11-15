package com.petruchcho.examsandroid;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.ListFragment;

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
	}

}
