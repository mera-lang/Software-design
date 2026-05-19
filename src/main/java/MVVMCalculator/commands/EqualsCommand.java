package MVVMCalculator.commands;

public class EqualsCommand implements Command {
    @Override
    public double execute(double firstOperand, double secondOperand) {
        return secondOperand; // просто возвращаем второй операнд
    }

    @Override
    public String getSymbol() {
        return "=";
    }
}