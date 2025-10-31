package com.taskbot.vs.inheritance.associations.onetomany;

import com.taskbot.vs.inheritance.associations.manytoone.BillingDetails;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class User {
    @OneToMany(mappedBy = "user")
    protected Set<BillingDetails> billingDetails = new HashSet<>();
}
