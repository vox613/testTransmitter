package com.iteco.a.alexandrov.transmitter.model;


public class Message {

    private String msgText;

    public Message(String msgText) {
        this.msgText = msgText;
    }

    public Message() {
    }

    public String getMsgText() {
        return msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }

    @Override
    public String toString() {
        return "{\"msgText\":\"" + msgText + "\"}";
    }
}
