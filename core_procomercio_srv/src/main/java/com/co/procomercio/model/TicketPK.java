package com.co.procomercio.model;

import java.io.Serializable;
import java.util.Date;

public class TicketPK implements Serializable { 
	
	private static final long serialVersionUID = 1L;

	protected String cityId;
    protected Integer ticketnumber;
    protected Date opendate;

    public TicketPK() {
    }
    
    public TicketPK(String cityId, Integer ticketnumber, Date opendate) {
        this.cityId=cityId;
        this.opendate=opendate;
        this.ticketnumber=ticketnumber;
    }
}
