package MVVMCalculator.commands;

public class SubtractCommand implements Command {
    @Override
    public double execute(double firstOperand, double secondOperand) {
        return firstOperand - secondOperand;
    }

    @Override
    public String getSymbol() {
        return "-";
    }
}