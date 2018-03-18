package com.co.procomercio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTCATEGORIES")
public class ProductCategories implements Serializable {
    
    
    @Column(name = "root")
    private String root; 
    
    @Id
    @Column(name = "product")
    private String product;
    
    @Column(name = "updated")
    private String updated;
    
    @Column(name = "eliminated")
    private boolean eliminated;

    private static final long serialVersionUID = 1L;
    //private static final long serialVersionUID = 1L;
    
    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public boolean getEliminated() {
        return eliminated;
    }

    public void setEliminated(boolean eliminated) {
        this.eliminated = eliminated;
    }
       
    
}

