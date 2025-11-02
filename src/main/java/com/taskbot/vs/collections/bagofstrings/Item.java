package com.taskbot.vs.collections.bagofstrings;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Type;

import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Item {
    @ElementCollection
    @CollectionTable(name = "IMAGE")
    @Column(name = "FILENAME")
    @CollectionId(
            columns = @Column(name = "IMAGE_ID"),
            generator = "ID_GENERATOR",
            type = @Type(type = "long")
    )
    protected Collection<String> images = new ArrayList<>();
}
