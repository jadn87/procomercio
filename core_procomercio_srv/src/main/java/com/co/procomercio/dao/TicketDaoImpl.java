package com.co.procomercio.dao;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.co.procomercio.model.Item;
import com.co.procomercio.model.Ticket;
import com.co.procomercio.model.TicketItem;
import com.co.procomercio.model.UserAddress;
import com.co.procomercio.utilities.Constants;


@Transactional
@Repository
public class TicketDaoImpl implements TicketDao{

	@PersistenceContext	
	private EntityManager entityManager;

	@Override
	public Ticket createOrder(List<Item> items, UserAddress useraddress) {
		
		if(items.isEmpty())
			return null;
		if(useraddress==null)
			return null;
		
		//obtener consecutivo del ticketnumber		
		Query seq = (Query) entityManager.createQuery("select nextval('seq_ticketnum')");
		Integer tinum = (Integer)seq.getFirstResult();
		
		Date openDate = new Date();
		String priceList = items.get(0).getPricelist();
		double totalAmount=0;
		
		Ticket tk = new Ticket();
        tk.setCityId(priceList);
        tk.setTicketnumber(tinum);
        tk.setOpendate(openDate);
        tk.setDocumenttype(Constants.DOCUMENTTYPE_SALE);
        tk.setNote("");
        tk.setOrderState(Constants.STATE_ORDER_PENDING);
        tk.setDispAddress(useraddress.getAddress());
        tk.setDispPhone(useraddress.getPhone());
        tk.setDispZone(useraddress.getZone());
        tk.setUserId(useraddress.getIduser());
        tk.setPaymentmodeId(1);
        
        
        
        for (Iterator<Item> iterator = items.iterator(); iterator.hasNext();) {
        	Item next = iterator.next();
            
            TicketItem item = new TicketItem();
            
            item.setCityId(priceList);
            item.setTicketnumber(tinum);
            item.setOpendate(openDate);
            item.setEan(next.getEan());
            item.setDescription(next.getName());
            item.setTax(next.getTax());
            item.setUnitamount(next.getAmount());
            item.setQuantity(next.getQuantity());
            item.setObservation(next.getNote());
            totalAmount = totalAmount+next.getAmount();
                        
            entityManager.persist(item);            

        }
        
        tk.setTotal(totalAmount);
        entityManager.persist(tk);
		
		return tk;
	}
	

}
