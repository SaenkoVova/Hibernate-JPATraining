package com.taskbot.vs.models.simple;

import jakarta.persistence.Entity;

@Entity
public class Bid {
    protected Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
