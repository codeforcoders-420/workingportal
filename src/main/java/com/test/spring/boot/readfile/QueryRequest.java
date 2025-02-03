package com.test.spring.boot.readfile;

public class QueryRequest {
	private String inputField;
	private String queryText;
	private String selectedEnv;

	// Getters and Setters
	public String getInputField() {
		return inputField;
	}

	public void setInputField(String inputField) {
		this.inputField = inputField;
	}

	public String getQueryText() {
		return queryText;
	}

	public void setQueryText(String queryText) {
		this.queryText = queryText;
	}

	public String getSelectedEnv() {
		return selectedEnv;
	}

	public void setSelectedEnv(String selectedEnv) {
		this.selectedEnv = selectedEnv;
	}

}
