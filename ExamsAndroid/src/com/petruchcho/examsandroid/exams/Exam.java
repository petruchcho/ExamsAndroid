package com.petruchcho.examsandroid.exams;

import java.util.Date;
import java.util.UUID;

import org.json.JSONException;
import org.json.JSONObject;

public class Exam implements Comparable<Exam> {

	private Date date;
	private String name;
	private int countOfQuestions;
	private boolean isFinished;
	private UUID id;

	private final static String JSON_DATE = "date";
	private final static String JSON_NAME = "name";
	private final static String JSON_COUNT_OF_QUESTIONS = "count";
	private final static String JSON_IS_FINISHED = "is_finished";
	private final static String JSON_ID = "id";

	public Exam(String name, int countOfQuestions) {
		super();
		this.name = name;
		this.countOfQuestions = countOfQuestions;
		this.date = null;
		isFinished = false;
		id = UUID.randomUUID();
	}

	public Exam(JSONObject json) throws JSONException {
		super();
		this.countOfQuestions = json.getInt(JSON_COUNT_OF_QUESTIONS);
		this.date = json.has(JSON_DATE) ? new Date(json.getLong(JSON_DATE))
				: null;
		this.name = json.getString(JSON_NAME);
		this.isFinished = json.getBoolean(JSON_IS_FINISHED);
		id = UUID.fromString(JSON_ID);
	}

	public JSONObject toJSON() throws JSONException {
		JSONObject json = new JSONObject();
		json.put(JSON_NAME, getName());
		json.put(JSON_COUNT_OF_QUESTIONS, countOfQuestions);
		if (hasDate())
			json.put(JSON_DATE, getDate().getTime());
		json.put(JSON_IS_FINISHED, isFinished);
		json.put(JSON_ID, id.toString());
		return json;
	}

	public Exam(Date date, String name, int countOfQuestions) {
		super();
		this.date = date;
		this.name = name;
		this.countOfQuestions = countOfQuestions;
		isFinished = new Date().getTime() < date.getTime();
	}

	public Date getDate() {
		return date;
	}

	public String getName() {
		return name;
	}

	public int getCountOfQuestions() {
		return countOfQuestions;
	}

	public boolean hasDate() {
		return getDate() != null;
	}

	@Override
	public int compareTo(Exam another) {
		return this.date.compareTo(another.date);
	}

	public boolean isFinished() {
		return isFinished;
	}

	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

	public UUID getId() {
		return id;
	}
	
	
}
