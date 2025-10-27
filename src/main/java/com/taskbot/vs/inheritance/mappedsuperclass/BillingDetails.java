package com.taskbot.vs.inheritance.mappedsuperclass;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;

@MappedSuperclass
public abstract class BillingDetails {
    @NotNull
    protected String owner;
}
