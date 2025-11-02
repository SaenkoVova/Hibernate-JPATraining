package com.taskbot.vs.collections.listofstrings;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.OrderColumn;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Item {
    @ElementCollection
    @CollectionTable(name = "IMAGE")
    @OrderColumn // Allows to specify the order of elements in the collection. By default IMAGES_ORDER
    protected List<String> images = new ArrayList<>();
}
