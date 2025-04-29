package org.kakaoTechCampus.calculatorProject;

public enum OperatorType {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String symbol;

    OperatorType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static OperatorType getOperatorType(String symbol) {
        return switch (symbol) {
            case "+" -> PLUS;
            case "-" -> MINUS;
            case "*" -> MULTIPLY;
            case "/" -> DIVIDE;
            default -> throw new IllegalArgumentException("지원하지 않는 연산자입니다: " + symbol);
        };
    }
}
