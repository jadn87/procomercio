package com.co.procomercio.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(TicketPK.class)
@Table(name = "TICKETITEMS")
public class TicketItem implements Serializable {

    @Id    
    @Column(name = "cityid")
    private String cityId;
    
    @Id
    @Column(name = "ticketnumber")
    private Integer ticketnumber;
    
    @Id
    @Column(name = "opendate")
    private Date opendate;
        
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
    
    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public Integer getTicketnumber() {
        return ticketnumber;
    }

    public void setTicketnumber(Integer ticketnumber) {
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
    
    
}
