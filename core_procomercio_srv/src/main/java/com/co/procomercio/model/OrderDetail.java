package com.co.procomercio.model;

import java.util.List;

public class OrderDetail{

	private List<Item> items;
	private UserAddress useraddress;
	
	
	public UserAddress getUseraddress() {
		return useraddress;
	}
	public void setUseraddress(UserAddress useraddress) {
		this.useraddress = useraddress;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
}
