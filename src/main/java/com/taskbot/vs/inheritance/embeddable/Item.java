package com.taskbot.vs.inheritance.embeddable;

import jakarta.persistence.Entity;

@Entity
public class Item {
    protected Dimensions dimensions;

    protected Weight weight;
}
