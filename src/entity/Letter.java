package entity;

import constant.LetterStatus;

public class Letter {

    private String status;
    private String senderLogin;
    private String text;

    public Letter() {
    }

    public Letter(String status, String senderLogin, String text) {
        this.status = status;
        this.senderLogin = senderLogin;
        this.text = text;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSenderLogin() {
        return senderLogin;
    }

    public void setSenderLogin(String senderLogin) {
        this.senderLogin = senderLogin;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}