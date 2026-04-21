package com.example.demo;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Calculate {
    private static final String str = new String(); // Singleton (ваш)

    @FXML private TextArea area;
    @FXML private Button reset, addition, division, eight, five, foure,
            multiplication, nine, one, point, seven, six,
            subtraction, three, two, result;
    @FXML
    private Button Exit;
    private final ExpressionBuilder builder = new ExpressionBuilder();
    private final CalculatorFactory factory = new CalculatorFactory();

    @FXML
    void result_enter(ActionEvent event) {
        try {
            String input = area.getText().trim();
            if (input.isEmpty()) {
                showAlert("Ошибка", "Введите выражение");
                return;
            }

            ExpressionContext context = builder.build(input);
            Calculator calculator = factory.create(context);
            double resultValue = calculator.calculate(context);

            area.clear();
            area.appendText(String.format("%.2f", resultValue));

        } catch (Exception e) {
            showAlert("Ошибка", e.getMessage());
        }
    }

    @FXML
    void reset_enter(ActionEvent e) { area.clear(); }
    @FXML
    void exit_programm() { Platform.exit(); }

    // Кнопки цифр и операций
    @FXML
    void addition_button(ActionEvent e) { area.appendText("+"); }
    @FXML
    void division_button(ActionEvent e) { area.appendText("/"); }
    @FXML
    void multiplication_button(ActionEvent e) { area.appendText("*"); }
    @FXML
    void subtraction_button(ActionEvent e) { area.appendText("-"); }
    @FXML
    void one_button(ActionEvent e) { area.appendText("1"); }
    @FXML
    void two_button(ActionEvent e) { area.appendText("2"); }
    @FXML
    void three_button(ActionEvent e) { area.appendText("3"); }
    @FXML
    void foure_button(ActionEvent e) { area.appendText("4"); }
    @FXML
    void five_button(ActionEvent e) { area.appendText("5"); }
    @FXML
    void six_button(ActionEvent e) { area.appendText("6"); }
    @FXML
    void seven_button(ActionEvent e) { area.appendText("7"); }
    @FXML
    void eight_button(ActionEvent e) { area.appendText("8"); }
    @FXML
    void nine_button(ActionEvent e) { area.appendText("9"); }
    @FXML
    void point_button(ActionEvent e) { area.appendText("."); }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.show();
    }

    @FXML void initialize() {
        // FXML проверки
    }
}