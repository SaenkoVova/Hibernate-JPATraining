package com.taskbot.vs.collections.setofstringsorderby;

import jakarta.persistence.*;
import org.hibernate.annotations.OrderBy;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Item {
    @ElementCollection
    @CollectionTable(name = "IMAGE")
    @Column(name = "FILENAME")
    //    @OrderBy(value = "FILENAME desc") -> analog from JPA. Sorts only by primary key but not by value.
    @OrderBy(clause = "FILENAME desc")
    protected Set<String> images = new LinkedHashSet<>();
}
