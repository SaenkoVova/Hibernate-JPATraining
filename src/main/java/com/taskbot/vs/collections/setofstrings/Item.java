package com.taskbot.vs.collections.setofstrings;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Item {
    @ElementCollection
    @CollectionTable(
            name = "IMAGE",
            joinColumns = @JoinColumn(name = "ITEM_ID")
    )
    @Column(name = "FILENAME")
    protected Set<String> images = new HashSet<>();
}
