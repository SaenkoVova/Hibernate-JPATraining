package com.taskbot.vs.inheritance.embeddable;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "name", column = @Column(name = "DIMENSIONS_NAME")),
        @AttributeOverride(name = "symbol", column = @Column(name = "DIMENSIONS_SYMBOL")),
})
public class Dimensions extends Measurement {
    @NotNull
    protected BigDecimal depth;
    @NotNull
    protected BigDecimal width;
    @NotNull
    protected BigDecimal height;
}
