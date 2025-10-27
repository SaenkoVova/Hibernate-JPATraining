package com.taskbot.vs.inheritance.mixed;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class BillingDetails {
    @Id
    private Long id;

    private String owner;
}
