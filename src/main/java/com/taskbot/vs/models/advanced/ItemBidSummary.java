package com.taskbot.vs.models.advanced;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@org.hibernate.annotations.Immutable
@org.hibernate.annotations.Subselect(
        value = "select i.ID as ITEMID, i.ITEM_NAME as name, COUNT(b.ID) as NUMBEROFBIDS from ITEM i left outer join BID b on i.ID = b.ITEM_ID group by i.ID, i.ITEM_NAME"
)
public class ItemBidSummary {
    @Id
    protected Long itemId;
}
