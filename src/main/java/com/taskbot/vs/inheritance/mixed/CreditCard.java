package com.taskbot.vs.inheritance.mixed;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("CC")
@SecondaryTable(
        name = "CREDITCARD",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "CREDITCARD_ID")
)
public class CreditCard extends BillingDetails {
    @NotNull
    @Column(table = "CREDITCARD", nullable = false)
    protected String cardNumber;

    @Column(table = "CREDITCARD", nullable = false)
    protected String expMonth;

    @Column(table = "CREDITCARD", nullable = false)
    protected String expYear;
}
