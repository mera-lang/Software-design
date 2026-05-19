package MVVMCalculator;

import MVVMCalculator.commands.*;

public class CalculatorModel {
    private double firstOperand = 0;      // первое введённое число
    private double secondOperand = 0;     // второе введённое число
    private String pendingOperation = "";  // операция, которую нужно выполнить
    private boolean waitingForSecondOperand = false;  // ждём второе число?
    private Command pendingCommand = null;


    public static Command getCommand(String symbol){
        switch (symbol) {
            case "+": return new AddCommand();
            case "-": return new SubtractCommand();
            case "*": return new MultiplyCommand();
            case "/": return new DivideCommand();
            case "=": return new EqualsCommand();
            case "C": return new ClearCommand();
            default: return null;
        }
    }
    public void setCommand(Command command){
        if(pendingCommand != null && waitingForSecondOperand){
            calculate();
        }
    }

    // Установить текущее вводимое число
    public void setCurrentNumber(double number) {
        if (waitingForSecondOperand) {
            secondOperand = number;
        } else {
            firstOperand = number;
        }
    }

    // Получить текущее отображаемое число
    public double getCurrentNumber(double number) {
        if (waitingForSecondOperand) {
            return secondOperand;
        } else {
            return firstOperand;
        }
    }

    // Выбрать операцию (+, -, *, /)


    // Выполнить вычисление
    public double calculate() {
        if (pendingCommand == null) return firstOperand;

        double result = pendingCommand.execute(firstOperand, secondOperand);

        // Если это не операция очистки, обновляем операнды
        if (!(pendingCommand instanceof ClearCommand)) {
            firstOperand = result;
            secondOperand = 0;
        } else {
            firstOperand = 0;
            secondOperand = 0;
        }

        waitingForSecondOperand = false;
        pendingCommand = null;

        return result;

    }

    // Очистить всё
    public void clear() {
        firstOperand = 0;
        secondOperand = 0;
        pendingOperation = "";
        waitingForSecondOperand = false;
    }

    // Нужно ли ожидать второе число
    public boolean isWaitingForSecondOperand() {
        return waitingForSecondOperand;
    }
}