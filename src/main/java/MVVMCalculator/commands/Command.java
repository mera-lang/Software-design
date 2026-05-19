package MVVMCalculator.commands;

public interface Command {
    double execute(double firstOperand, double secondOperand);
    String getSymbol();
}