package com.kata312.exception;

public class UserErrorResponse {
    private String massage;
    public UserErrorResponse(String massage) {
        this.massage = massage;
    }
    public String getMassage() {
        return massage;
    }
    public void setMassage(String massage) {
        this.massage = massage;
    }
}
