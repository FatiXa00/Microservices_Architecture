package org.sid.billingservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.billingservice.model.Customer;


import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billDate;
    private Long customerId;
    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems;
    @Transient //ignorer l'attribut c pas une table de bd
    private Customer customer;

    public Long getId() {
        return id;
    }

    public Date getBillDate() {
        return billDate;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public List<ProductItem> getProductItems() {
        return productItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setProductItems(List<ProductItem> productItems) {
        this.productItems = productItems;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}