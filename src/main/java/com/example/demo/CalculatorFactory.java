package com.example.demo;

public class CalculatorFactory {
    public static Calculator create(ExpressionContext context) {
        // Проверяем наличие приоритетных операций
        boolean hasPriority = context.getTokens().stream()
                .filter(t -> t.type == TokenType.OPERATOR)
                .anyMatch(t -> t.operator == '*' || t.operator == '/');

        return hasPriority ? new AdvancedCalculator() : new SimpleCalculator();
    }
}