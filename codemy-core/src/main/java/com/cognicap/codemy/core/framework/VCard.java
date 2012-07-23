package com.cognicap.codemy.core.framework;

public class VCard implements Document {
	private String card;

	public void setCard(String v) {
		this.card = v;
	}

	public String getCard() {
		return this.card;
	}
	
	public String getDocument() {
		return this.card;
	}
	
	public String toString() {
		return getDocument();
	}
}


