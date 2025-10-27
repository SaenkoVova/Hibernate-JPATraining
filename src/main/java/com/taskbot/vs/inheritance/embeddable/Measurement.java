package com.taskbot.vs.inheritance.embeddable;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;

@MappedSuperclass
public abstract class Measurement {
    @NotNull
    protected String name;
    @NotNull
    protected String symbol;
}
