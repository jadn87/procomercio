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
@Table(name = "TICKETS")
public class Ticket implements Serializable { 
	
	private static final long serialVersionUID = 1L;

    @Id    
    @Column(name = "cityid")
    private String cityId;
    @Id
    @Column(name = "ticketnumber")
    private Integer ticketnumber;
    @Id
    @Column(name = "opendate")
    private Date opendate;
    @Column(name = "documenttype")
    private String documenttype;
    @Column(name = "total")
    private double total;
    @Column(name = "note")
    private String note;
    @Column(name = "orderstate")
    private String orderState;
    @Column(name = "userid")
    private String userId;
    @Column(name = "dispzone")
    private String dispZone;
    @Column(name = "dispaddress")
    private String dispAddress;
    @Column(name = "dispphone")
    private String dispPhone;
    @Column(name = "paymentmodeid")
    private int paymentmodeId;

    
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

    public String getDocumenttype() {
        return documenttype;
    }

    public void setDocumenttype(String documenttype) {
        this.documenttype = documenttype;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDispAddress() {
        return dispAddress;
    }

    public void setDispAddress(String dispAddress) {
        this.dispAddress = dispAddress;
    }

    public String getDispPhone() {
        return dispPhone;
    }

    public void setDispPhone(String dispPhone) {
        this.dispPhone = dispPhone;
    }

    public int getPaymentmodeId() {
        return paymentmodeId;
    }

    public void setPaymentmodeId(int paymentmodeId) {
        this.paymentmodeId = paymentmodeId;
    }

    public String getDispZone() {
        return dispZone;
    }

    public void setDispZone(String dispZone) {
        this.dispZone = dispZone;
    }
        
    
}
