package com.taskbot.vs.associations.onetomany.bidirectional;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Item {
    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
    protected Set<Bid> bids = new HashSet<>();
}
