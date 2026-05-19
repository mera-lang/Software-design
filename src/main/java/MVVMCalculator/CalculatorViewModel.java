package MVVMCalculator;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import MVVMCalculator.commands.Command;
import MVVMCalculator.CalculatorModel;

public class CalculatorViewModel {
    private final CalculatorModel model;
    private final StringProperty display = new SimpleStringProperty("0");
    private boolean startNewNumber = true;  // начинаем ввод нового числа
    private String lastCommand = "";

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

    public void onCommandClick(String commandSymbol) {
        // Обработка очистки
        if (commandSymbol.equals("C")) {
            model.clear();
            display.set("0");
            startNewNumber = true;
            lastCommand = "";
            return;
        }

        // Получаем команду через фабричный метод модели
        Command command = CalculatorModel.getCommand(commandSymbol);

        if (command != null) {
            if (!startNewNumber) {
                model.setCommand(command);
                lastCommand = commandSymbol;
                startNewNumber = true;
            }
        }
    }



    // Нажат "="
    public void onEquals() {
        if (!startNewNumber) {
            model.setCurrentNumber(Double.parseDouble(display.get()));
        }

        double result = model.calculate();

        // Форматируем результат (без .0 для целых чисел)
        if (result == (long) result) {
            display.set(String.valueOf((long) result));
        } else {
            display.set(String.valueOf(result));
        }

        startNewNumber = true;
        lastCommand = "";

        // Обновляем модель текущим результатом
        model.setCurrentNumber(result);

    }

    public String getLastCommand() {
        return lastCommand;
    }
}