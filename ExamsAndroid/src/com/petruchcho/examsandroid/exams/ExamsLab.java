package com.petruchcho.examsandroid.exams;

import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

import android.content.Context;

public class ExamsLab {

	private static final String fileName = "exams.json";

	private Set<Exam> exams;
	private Context context;

	private ExamsJSONSerializer serializer;

	private static ExamsLab instance;

	public static ExamsLab getInstance(Context context) {
		if (instance == null)
			instance = new ExamsLab(context);
		return instance;
	}

	private ExamsLab(Context context) {
		this.context = context;
		serializer = new ExamsJSONSerializer(context, fileName);
		try {
			exams = serializer.loadExams();
		} catch (Exception e) {
			exams = new TreeSet<Exam>();
		}
	}

	public Set<Exam> getExams() {
		return exams;
	}

	public Exam getExam(UUID id) {
		for (Exam exam : exams) {
			if (exam.getId().equals(id))
				return exam;
		}
		return null;
	}
	
	public void addExam(Exam exam) {
		exams.add(exam);
		
	}
	
	public boolean SaveExams() {
		try {
			serializer.saveExams(exams);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
