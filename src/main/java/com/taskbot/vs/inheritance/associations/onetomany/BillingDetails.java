package com.taskbot.vs.inheritance.associations.onetomany;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BillingDetails {
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    protected User user;

    @NotNull
    protected String owner;

    public Long getId() {
        return id;
    }
}
