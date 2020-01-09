package com.iteco.a.alexandrov.transmitter.model;

import lombok.Data;


public class Message {

	private String msgText;
	
	public String getMsgText() {
		return msgText;
	}

	public void setMsgText(String msgText) {
		this.msgText = msgText;
	}

	@Override
	public String toString() {
		return "Message [msg = " + msgText + " ]";
	}

}
