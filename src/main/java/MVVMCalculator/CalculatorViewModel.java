package MVVMCalculator;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CalculatorViewModel {
    private final CalculatorModel model;
    private final StringProperty display = new SimpleStringProperty("0");
    private boolean startNewNumber = true;  // начинаем ввод нового числа

    public CalculatorViewModel() {
        this.model = new CalculatorModel();
    }

    public StringProperty displayProperty() {
        return display;
    }

    // Нажата цифра
    public void onNumberClick(String number) {
        String currentDisplay = display.get();

        if (startNewNumber) {
            // Начинаем новое число
            display.set(number);
            startNewNumber = false;
        } else {
            // Добавляем цифру к текущему числу
            display.set(currentDisplay + number);
        }

        // Сохраняем число в модель
        model.setCurrentNumber(Double.parseDouble(display.get()));
    }

    // Нажата операция (+, -, *, /)
    public void onOperationClick(String operation) {
        if (!startNewNumber) {
            // Если мы вводили число, запоминаем его и ждём второе
            model.setOperation(operation);
            startNewNumber = true;
        }
    }

    // Нажат "="
    public void onEquals() {
        if (!startNewNumber) {
            // Сохраняем второе число
            model.setCurrentNumber(Double.parseDouble(display.get()));
        }

        // Вычисляем результат
        double result = model.calculate();

        // Показываем результат
        if (result == (long) result) {
            display.set(String.valueOf((long) result));
        } else {
            display.set(String.valueOf(result));
        }

        startNewNumber = true;
    }

    // Нажата "C" (очистка)
    public void onClear() {
        model.clear();
        display.set("0");
        startNewNumber = true;
    }
}