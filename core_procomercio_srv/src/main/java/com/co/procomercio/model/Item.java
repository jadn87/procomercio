package com.co.procomercio.model;

public class Item extends Product{

	private static final long serialVersionUID = 1L;

	private int quantity;
	private String note;
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
