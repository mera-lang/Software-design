package MVVMCalculator;

public class CalculatorModel {
    private double firstOperand = 0;      // первое введённое число
    private double secondOperand = 0;     // второе введённое число
    private String pendingOperation = "";  // операция, которую нужно выполнить
    private boolean waitingForSecondOperand = false;  // ждём второе число?

    // Установить текущее вводимое число
    public void setCurrentNumber(double number) {
        if (waitingForSecondOperand) {
            secondOperand = number;
        } else {
            firstOperand = number;
        }
    }

    // Получить текущее отображаемое число
    public double getCurrentNumber() {
        if (waitingForSecondOperand) {
            return secondOperand;
        } else {
            return firstOperand;
        }
    }

    // Выбрать операцию (+, -, *, /)
    public void setOperation(String operation) {
        // Если уже есть ожидающая операция и мы вводили второе число — выполняем её
        if (!pendingOperation.isEmpty() && waitingForSecondOperand) {
            calculate();
        }
        pendingOperation = operation;
        waitingForSecondOperand = true;
    }

    // Выполнить вычисление
    public double calculate() {
        double result = 0;

        switch (pendingOperation) {
            case "+":
                result = firstOperand + secondOperand;
                break;
            case "-":
                result = firstOperand - secondOperand;
                break;
            case "*":
                result = firstOperand * secondOperand;
                break;
            case "/":
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                } else {
                    throw new ArithmeticException("Деление на ноль");
                }
                break;
            case "=":
                result = secondOperand;
                break;
            default:
                result = firstOperand;
                break;
        }

        // Результат становится первым операндом для следующих вычислений
        firstOperand = result;
        secondOperand = 0;
        waitingForSecondOperand = false;
        pendingOperation = "";

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