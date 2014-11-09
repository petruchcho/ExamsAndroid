package com.petruchcho.examsandroid;

import java.util.UUID;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.examsandroid.R;
import com.petruchcho.examsandroid.exams.Exam;
import com.petruchcho.examsandroid.exams.ExamsLab;

public class ExamSettingsFragment extends Fragment {

	public enum SettingsType {
		ADD, EDIT
	}

	private Exam exam;
	private SettingsType settingsType;

	protected final static String EXTRA_EXAM_ID = "com.petruchcho.examsandroid.examsettingsfragment.id";
	protected final static String EXTRA_SETTINGS_TYPE = "com.petruchcho.examsandroid.examsettingsfragment.type";

	public static ExamSettingsFragment newInstance(UUID examId,
			SettingsType type) {
		Bundle args = new Bundle();
		args.putSerializable(EXTRA_EXAM_ID, examId);
		args.putSerializable(EXTRA_SETTINGS_TYPE, type);

		ExamSettingsFragment fragment = new ExamSettingsFragment();
		fragment.setArguments(args);

		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		UUID examId = (UUID) getArguments().getSerializable(EXTRA_EXAM_ID);
		this.exam = ExamsLab.getInstance(getActivity()).getExam(examId);
		this.settingsType = (SettingsType) getArguments().getSerializable(
				EXTRA_SETTINGS_TYPE);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater
				.inflate(R.layout.f_exam_settings, container, false);
		return view;
	}
}
