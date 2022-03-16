package com.example.demo.dto;

public class SimpleResponse {
    private boolean statusOk;
    private String message;

    public SimpleResponse() {
        statusOk = false;
        message = "Ocorreu um erro";
    }

    public void setSucess(String message){
        statusOk = true;
        this.message = message;
    }

    public boolean isStatusOk() {
        return statusOk;
    }

    public void setStatusOk(boolean statusOk) {
        this.statusOk = statusOk;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
