package com.test.spring.boot.model;

public class ValidationResult {
    private int progressPercentage;
    private String message;
    private String outputFolderLocation;

    // Getters and Setters
    public int getProgressPercentage() {
        return progressPercentage;
    }

    public void setProgressPercentage(int progressPercentage) {
        this.progressPercentage = progressPercentage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOutputFolderLocation() {
        return outputFolderLocation;
    }

    public void setOutputFolderLocation(String outputFolderLocation) {
        this.outputFolderLocation = outputFolderLocation;
    }
}
