package MVVMCalculator.commands;

public class ClearCommand implements Command {
    @Override
    public double execute(double firstOperand, double secondOperand) {
        return 0; // очистка возвращает 0
    }

    @Override
    public String getSymbol() {
        return "C";
    }
}