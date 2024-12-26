package net.csibio.labic.enums;

public enum Operator {

    POSITIVE("+"),  //正
    NEGATIVE("-"),  //负

    ;

    String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
