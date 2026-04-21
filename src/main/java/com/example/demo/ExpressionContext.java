package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class ExpressionContext implements Cloneable {
    private List<Token> tokens = new ArrayList<>();
    private double result;

    public void addToken(Token token) {
        tokens.add(token);
    }

    public List<Token> getTokens() {
        return new ArrayList<>(tokens);
    }

    public void setResult(double result) {
        this.result = result;
    }

    public double getResult() {
        return result;
    }

    @Override
    protected ExpressionContext clone() {
        try {
            ExpressionContext clone = (ExpressionContext) super.clone();
            clone.tokens = new ArrayList<>(this.tokens);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}