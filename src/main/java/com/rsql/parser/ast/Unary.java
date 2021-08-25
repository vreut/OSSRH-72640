package com.rsql.parser.ast;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public enum Unary {
    IS_NULL(new UnaryComparisonOperator("=isnull=")),
    NOT_NULL(new UnaryComparisonOperator("=notnull=")),
    CONTAINS_FALSE(new UnaryComparisonOperator("=false=")),
    CONTAINS_TRUE(new UnaryComparisonOperator("=true="));

    private final UnaryComparisonOperator operator;

    Unary(UnaryComparisonOperator operator) {
        this.operator = operator;
    }

    public static Set<UnaryComparisonOperator> getValuesSet() {
        return Arrays
                .stream(Unary.values())
                .map(Unary::getOperator)
                .collect(Collectors.toSet());
    }

    public UnaryComparisonOperator getOperator() {
        return operator;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.getOperator().getSymbols());
    }
}
