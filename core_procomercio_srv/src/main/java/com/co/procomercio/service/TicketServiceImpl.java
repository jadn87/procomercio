package com.co.procomercio.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.procomercio.dao.TicketDao;
import com.co.procomercio.model.Item;
import com.co.procomercio.model.Ticket;
import com.co.procomercio.model.UserAddress;

@Service
public class TicketServiceImpl implements TicketService{

	@Autowired
	private TicketDao ticketDao;
	

	@Override
	public Ticket createOrder(List<Item> items, UserAddress useraddress) {
		// TODO Auto-generated method stub
		return ticketDao.createOrder(items, useraddress);
	}
		
}
