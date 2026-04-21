package com.example.demo;

public class ExpressionBuilder {
    public ExpressionContext build(String input) {
        ExpressionContext context = new ExpressionContext();
        String cleanInput = input.replaceAll("\\s+", ""); // убираем пробелы

        int i = 0;
        while (i < cleanInput.length()) {
            char c = cleanInput.charAt(i);

            if (Character.isDigit(c) || c == '.') {
                // Парсим число
                StringBuilder num = new StringBuilder();
                while (i < cleanInput.length() &&
                        (Character.isDigit(cleanInput.charAt(i)) || cleanInput.charAt(i) == '.')) {
                    num.append(cleanInput.charAt(i++));
                }
                context.addToken(new Token(TokenType.NUMBER, Double.parseDouble(num.toString())));
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                context.addToken(new Token(TokenType.OPERATOR, c));
                i++;
            } else {
                i++; // пропускаем неизвестные символы
            }
        }

        if (context.getTokens().isEmpty()) {
            throw new IllegalArgumentException("Некорректное выражение");
        }
        return context;
    }
}