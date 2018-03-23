package com.co.procomercio.dao;

import java.util.List;

import com.co.procomercio.model.Item;
import com.co.procomercio.model.Ticket;
import com.co.procomercio.model.UserAddress;

public interface TicketDao {

	Ticket createOrder(List<Item> items, UserAddress useraddress);


}
