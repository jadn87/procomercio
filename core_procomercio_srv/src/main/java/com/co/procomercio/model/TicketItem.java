package com.co.procomercio.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TICKETITEMS")
public class TicketItem implements Serializable {

    @Id    
    @Column(name = "localid")
    private String localId;
    
    @Id
    @Column(name = "ticketnumber")
    private BigInteger ticketnumber;
    
    @Id
    @Column(name = "opendate")
    private Date opendate;
    
    @Id
    @Column(name = "id")
    private int id;
        
    @Column(name = "ean")
    private String ean;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "quantity")
    private int quantity;
    
    @Column(name = "unitamount")
    private double unitamount;
    
    @Column(name = "tax")
    private int tax;
    
    @Column(name = "observation")
    private String observation;

    
    private static final long serialVersionUID = 1L;

    

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

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitamount() {
        return unitamount;
    }

    public void setUnitamount(double unitamount) {
        this.unitamount = unitamount;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
    
}
