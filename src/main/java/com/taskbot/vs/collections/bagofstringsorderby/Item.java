package com.taskbot.vs.collections.bagofstringsorderby;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.OrderBy;
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
            type = Type(type = "long"),
            generator = "ID_GENERATOR"
    )
    @OrderBy(clause = "FILENAME desc")
    protected Collection<String> image = new ArrayList<>();
}
