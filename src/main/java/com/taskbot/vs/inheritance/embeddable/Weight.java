package com.taskbot.vs.inheritance.embeddable;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "name", column = @Column(name = "WEIGHT_NAME")),
        @AttributeOverride(name = "symbol", column = @Column(name = "WEIGHT_SYMBOL")),
})
public class Weight extends Measurement {
    @NotNull
    @Column(name = "WEIGHT")
    protected BigDecimal value;

}
