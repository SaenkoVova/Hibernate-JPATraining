package com.taskbot.vs.collections.mapofstringsorderby;

import jakarta.persistence.*;
import org.hibernate.annotations.OrderBy;

import java.util.LinkedHashMap;
import java.util.Map;

@Entity
public class Item {
    @ElementCollection
    @CollectionTable(name = "IMAGE")
    @MapKeyColumn(name = "FILENAME")
    @Column(name = "IMAGENAME")
    @OrderBy(clause = "FILENAME desc")
    protected Map<String, String> images = new LinkedHashMap<>();
}
