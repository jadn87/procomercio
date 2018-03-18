package com.co.procomercio.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class ProductPK implements Serializable{
    
    protected String ean;
    protected String pricelist;
    

    public ProductPK() {
    }
    
    public ProductPK(String ean, String priceList) {
        this.ean=ean;
        this.pricelist=priceList;
    }   

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getPricelist() {
        return pricelist;
    }

    public void setPricelist(String pricelist) {
        this.pricelist = pricelist;
    }
    
    
}
