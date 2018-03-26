package com.co.procomercio.dao;

import java.math.BigInteger;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.co.procomercio.model.Item;
import com.co.procomercio.model.Ticket;
import com.co.procomercio.model.TicketItem;
import com.co.procomercio.model.TicketPK;
import com.co.procomercio.model.UserAddress;
import com.co.procomercio.utilities.Constants;


@Transactional
@Repository
public class TicketDaoImpl implements TicketDao{

	@PersistenceContext	
	private EntityManager entityManager;

	@SuppressWarnings("rawtypes")
	@Override
	public Ticket createOrder(List<Item> items, UserAddress useraddress) {
		
		if(items.isEmpty())
			return null;
		if(useraddress==null)
			return null;
		
		//obtener consecutivo del ticketnumber		
		Query seq = (Query) entityManager.createNativeQuery("select nextval('seq_ticketnum')");
		BigInteger tinum = (BigInteger)seq.uniqueResult();
		
		Date openDate = new Date();
		String priceList = items.get(0).getPricelist();
		double totalAmount=0;
		
		TicketPK pk = new TicketPK(priceList, tinum, openDate);
		
		Ticket tk = new Ticket();
        tk.setLocalId(pk.getLocalId());
        tk.setTicketnumber(pk.getTicketnumber());
        tk.setOpendate(pk.getOpendate());
        tk.setDocumenttype(Constants.DOCUMENTTYPE_SALE);
        tk.setNote("");
        tk.setOrderState(Constants.STATE_ORDER_PENDING);
        tk.setDispAddress(useraddress.getAddress());
        tk.setDispPhone(useraddress.getPhone());
        tk.setDispZone(useraddress.getZone());
        tk.setUserId(useraddress.getIduser());
        tk.setPaymentmodeId(1);
        
        
        int idItem=0;
        for (Iterator<Item> iterator = items.iterator(); iterator.hasNext();) {
        	Item next = iterator.next();
            
            TicketItem item = new TicketItem();
            
            item.setLocalId(pk.getLocalId());
            item.setTicketnumber(pk.getTicketnumber());
            item.setOpendate(pk.getOpendate());
            item.setId(idItem);
            item.setEan(next.getEan());
            item.setDescription(next.getName());
            item.setTax(next.getTax());
            item.setUnitamount(next.getAmount());
            item.setQuantity(next.getQuantity());
            item.setObservation(next.getNote());
            totalAmount = totalAmount+next.getAmount();

            entityManager.persist(item);        
            idItem++;

        }
        
        tk.setTotal(totalAmount);
        entityManager.persist(tk);
		
		return tk;
	}
	

}
