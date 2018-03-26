package com.co.procomercio.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class TicketPK implements Serializable { 
	
	private static final long serialVersionUID = 1L;

	protected String localId;
    protected BigInteger ticketnumber;
    protected Date opendate;

    public TicketPK() {
    }
    
    public TicketPK(String localId, BigInteger ticketnumber, Date opendate) {
        this.localId=localId;
        this.opendate=opendate;
        this.ticketnumber=ticketnumber;
    }


	public String getLocalId() {
		return localId;
	}

	public void setLocalId(String localId) {
		this.localId = localId;
	}

	public BigInteger getTicketnumber() {
		return ticketnumber;
	}

	public void setTicketnumber(BigInteger ticketnumber) {
		this.ticketnumber = ticketnumber;
	}

	public Date getOpendate() {
		return opendate;
	}

	public void setOpendate(Date opendate) {
		this.opendate = opendate;
	}
}
