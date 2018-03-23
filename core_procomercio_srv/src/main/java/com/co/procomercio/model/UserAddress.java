package com.co.procomercio.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERADDRESS")
public class UserAddress implements Serializable { 
	
	private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "iduser")
    private String iduser;
    
    @Column(name = "zone")
    private String zone;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "alias")
    private String alias;
    
    @Column(name = "eliminated")
    private boolean eliminated;

    @Column(name = "updated")
    private Date updated;
    
    
    public UserAddress() {
            // TODO Auto-generated constructor stub
    }    

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isEliminated() {
        return eliminated;
    }

    public void setEliminated(boolean eliminated) {
        this.eliminated = eliminated;
    }

     
    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
        
}
	