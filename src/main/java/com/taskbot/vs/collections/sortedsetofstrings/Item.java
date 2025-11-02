package com.taskbot.vs.collections.sortedsetofstrings;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import org.hibernate.annotations.SortNatural;

import java.util.SortedSet;
import java.util.TreeSet;

@Entity
public class Item {
    @ElementCollection
    @CollectionTable(name = "IMAGE")
    @Column(name = "FILENAME")
    @SortNatural
    protected SortedSet<String> images = new TreeSet<>();
}
