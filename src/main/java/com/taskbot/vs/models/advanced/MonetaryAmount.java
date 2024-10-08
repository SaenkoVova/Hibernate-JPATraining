package com.taskbot.vs.models.advanced;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

public class MonetaryAmount implements Serializable {

    private final BigDecimal value;

    private final Currency currency;

    public MonetaryAmount(BigDecimal value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Currency getCurrency() {
        return currency;
    }

    public static MonetaryAmount fromString(String s) {
        String[] split = s.split(" ");
        return new MonetaryAmount(
                new BigDecimal(split[0]),
                Currency.getInstance(split[1]));
    }

    @Override
    public String toString() {
        return getValue() + " " + getCurrency();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MonetaryAmount that)) return false;
        return Objects.equals(value, that.value) && Objects.equals(currency, that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, currency);
    }
}
