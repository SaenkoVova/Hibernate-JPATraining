package com.taskbot.vs.associations.onetomany.bidirectional;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Bid {
    @ManyToOne(fetch = FetchType.LAZY) //this annotation creates ITEM_ID foreign key by default
    @JoinColumn(name = "ITEM_ID", nullable = false)
    protected Item item;
}
