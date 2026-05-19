package MVVMCalculator.commands;


public class AddCommand implements Command {
    @Override
    public double execute(double firstOperand, double secondOperand) {
        return firstOperand + secondOperand;
    }

    @Override
    public String getSymbol() {
        return "+";
    }
}