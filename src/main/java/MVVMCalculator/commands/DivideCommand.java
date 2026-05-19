package MVVMCalculator.commands;

public class DivideCommand implements Command {
    @Override
    public double execute(double firstOperand, double secondOperand) {
        if (secondOperand == 0) {
            throw new ArithmeticException("Деление на ноль");
        }
        return firstOperand / secondOperand;
    }

    @Override
    public String getSymbol() {
        return "/";
    }
}