package com.taskbot.vs.models.simple;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private Address address;

    @Embedded //not required but useful when class source code is not available
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "BILLING_STREET")), //this is terminal annotation, so all JPA and Hibernate annotations from Address class will ignore
            //but Hibernate Validation Annotations will work
            @AttributeOverride(name = "zipcode", column = @Column(name = "BILLING_ZIPCODE")),
            @AttributeOverride(name = "city", column = @Column(name = "BILLING_CITY")),
    })
    private Address billingAddress;

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }
}
