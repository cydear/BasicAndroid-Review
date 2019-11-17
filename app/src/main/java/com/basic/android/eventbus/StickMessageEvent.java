package com.basic.android.eventbus;

public class StickMessageEvent {
    private String message;

    public StickMessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
