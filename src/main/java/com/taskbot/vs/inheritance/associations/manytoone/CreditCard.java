package com.taskbot.vs.inheritance.associations.manytoone;

import jakarta.persistence.Entity;

@Entity
public class CreditCard extends BillingDetails {

    private String cardNumber;

    private String expMonth;

    private String expYear;

    public CreditCard() {
    }

    public CreditCard(String cardNumber, String expMonth, String expYear) {
        this.cardNumber = cardNumber;
        this.expMonth = expMonth;
        this.expYear = expYear;
    }
}
