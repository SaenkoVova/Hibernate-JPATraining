package com.taskbot.vs.models.simple;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.usertype.UserType;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.Types;
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

    @Lob
    protected Blob image; // The disadvantage is that the object model will be related to jdbc

    @Lob
    protected String description;

//    @Lob
//    protected Clob description; //character large object, if type specified to Clob and not to String Hibernate will use lazy loading for this prop

    public Set<Bid> getBids() {
        return bids;
    }

    public void setBids(Set<Bid> bids) {
        this.bids = bids;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
