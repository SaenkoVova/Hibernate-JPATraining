package com.taskbot.vs.collections.mapofstrings;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Map;

@Entity
public class Item {
    @ElementCollection
    @CollectionTable(name = "IMAGE")
    @MapKeyColumn(name = "FILENAME")
    @Column(name = "IMAGENAME")
    protected Map<String, String> images = new HashMap<>();
}
