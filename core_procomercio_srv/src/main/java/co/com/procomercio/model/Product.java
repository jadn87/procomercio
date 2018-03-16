package co.com.procomercio.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(ProductPK.class)
@Table(name = "PRODUCT")
public class Product implements Serializable {

    @Id
    @Column(name = "ean")
    private String ean;
    
    @Id
    @Column(name = "pricelist")
    private String pricelist;

    @Column(name = "name")
    private String name;

    @Column(name = "supplier")
    private String supplier;

    @Column(name = "amount")
    private double amount;

    @Column(name = "tax")
    private int tax;

    @Column(name = "updated")
    private Date updated;

    @Column(name = "eliminated")
    private boolean eliminated;
    
    @Column(name = "promodatefrom")
    private Date promodatefrom;
    
    @Column(name = "promodatevto")
    private Date promodatevto;
    
    @Column(name = "amountpromo")
    private Double amountpromo;
    
    private static final long serialVersionUID = 1L;
    

    public String getName() {
            return name;
    }

    public void setName(String name) {
            this.name = name;
    }
    
    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public boolean isEliminated() {
        return eliminated;
    }

    public void setEliminated(boolean eliminated) {
        this.eliminated = eliminated;
    }

    public String getPricelist() {
        return pricelist;
    }

    public void setPricelist(String pricelist) {
        this.pricelist = pricelist;
    }

    public Date getPromodatefrom() {
        return promodatefrom;
    }

    public void setPromodatefrom(Date promodatefrom) {
        this.promodatefrom = promodatefrom;
    }

    public Date getPromodatevto() {
        return promodatevto;
    }

    public void setPromodatevto(Date promodatevto) {
        this.promodatevto = promodatevto;
    }

    public Double getAmountpromo() {
        return amountpromo;
    }

    public void setAmountpromo(Double amountpromo) {
        this.amountpromo = amountpromo;
    }

}
