package com.taskbot.vs.models.simple;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "TITLE", length = 100, columnDefinition = "Text default '100'")
    private String title;

    @Column(nullable = false, insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date created;

    protected Set<Bid> bids = new HashSet<>();

    public Set<Bid> getBids() {
        return bids;
    }

    public void setBids(Set<Bid> bids) {
        this.bids = bids;
    }

    public void addBid(Bid bid) {
        if (bid == null) {
            throw new NullPointerException("bid cannot be null");
        }
        if (bid.getItem() != null) {
            throw new IllegalArgumentException("Bid is already assigned to an Item");
        }

        getBids().add(bid);
        bid.setItem(this);
    }
}
