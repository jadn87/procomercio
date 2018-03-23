package com.co.procomercio.service;

import java.util.List;

import com.co.procomercio.model.Item;
import com.co.procomercio.model.Ticket;
import com.co.procomercio.model.UserAddress;

public interface TicketService {

	Ticket createOrder(List<Item> items, UserAddress useraddress);
	
}
