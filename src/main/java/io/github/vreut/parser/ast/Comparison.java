package io.github.vreut.parser.ast;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public enum Comparison {
    EQUAL(new ComparisonOperator("==")),
    NOT_EQUAL(new ComparisonOperator("!=")),
    GREATER_THAN(new ComparisonOperator("=gt=", ">")),
    GREATER_THAN_OR_EQUAL(new ComparisonOperator("=ge=", ">=")),
    LESS_THAN(new ComparisonOperator("=lt=", "<")),
    LESS_THAN_OR_EQUAL(new ComparisonOperator("=le=", "<=")),
    IN(new ComparisonOperator("=in=", true)),
    NOT_IN(new ComparisonOperator("=out=", true)),
    RANGE(new ComparisonOperator("=range=", "=RANGE=", true)),
    STARTS(new ComparisonOperator("=starts=", "=STARTS=", false)),
    ENDS(new ComparisonOperator("=ends=", "=ENDS=", false)),
    CONTAINS(new ComparisonOperator("=contains=", "=CONTAINS=", false)),
    NOT_CONTAINS(new ComparisonOperator("=notcontains=", "=notcontains=", false));


    private final ComparisonOperator operator;

    Comparison(ComparisonOperator operator) {
        this.operator = operator;
    }

    public static Set<ComparisonOperator> getValuesSet() {
        return Arrays
            .stream(Comparison.values())
            .map(Comparison::getOperator)
            .collect(Collectors.toSet());
    }

    public ComparisonOperator getOperator() {
        return operator;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.getOperator().getSymbols());
    }
}
