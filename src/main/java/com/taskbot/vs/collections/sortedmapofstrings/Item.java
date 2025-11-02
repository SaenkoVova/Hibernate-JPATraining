package com.taskbot.vs.collections.sortedmapofstrings;

import jakarta.persistence.*;
import org.hibernate.annotations.SortComparator;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

@Entity
public class Item {
    @ElementCollection
    @CollectionTable(name = "IMAGE")
    @MapKeyColumn(name = "FILENAME")
    @Column(name = "IMAGENAME")
    @SortComparator(ReverseStringComparator.class)
    protected SortedMap<String, String> images = new TreeMap<>();
}

class ReverseStringComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);
    }
}