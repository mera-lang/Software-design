package com.example.demo;

public interface OperationFactory {
    Operation createAddition();
    Operation createSubtraction();
    Operation createMultiplication();
    Operation createDivision();
}

class MathOperationFactory implements OperationFactory {
    public Operation createAddition() { return new AdditionOperation(); }
    public Operation createSubtraction() { return new SubtractionOperation(); }
    public Operation createMultiplication() { return new MultiplicationOperation(); }
    public Operation createDivision() { return new DivisionOperation(); }
}