package MVVMCalculator;

import MVVMCalculator.CalculatorViewModel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalculatorView extends Application {

    @Override
    public void start(Stage primaryStage) {
        CalculatorViewModel viewModel = new CalculatorViewModel();

        TextField display = new TextField();
        display.setEditable(false);
        display.setStyle("-fx-font-size: 28px; -fx-alignment: center-right; -fx-padding: 10px;");
        display.textProperty().bind(viewModel.displayProperty());

        String[][] buttons = {
                {"7", "8", "9", "/"},
                {"4", "5", "6", "*"},
                {"1", "2", "3", "-"},
                {"0", "C", "=", "+"}
        };

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setStyle("-fx-padding: 20px; -fx-background-color: #2b2b2b;");
        grid.add(display, 0, 0, 4, 1);

        for (int row = 0; row < buttons.length; row++) {
            for (int col = 0; col < buttons[row].length; col++) {
                String text = buttons[row][col];
                Button button = new Button(text);
                button.setPrefSize(90, 90);
                button.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

                // Стили для разных типов кнопок
                if (text.matches("[0-9]")) {
                    button.setStyle("-fx-font-size: 20px; -fx-background-color: #555; -fx-text-fill: white;");
                } else if (text.equals("C")) {
                    button.setStyle("-fx-font-size: 20px; -fx-background-color: #d32f2f; -fx-text-fill: white;");
                } else if (text.equals("=")) {
                    button.setStyle("-fx-font-size: 20px; -fx-background-color: #388e3c; -fx-text-fill: white;");
                } else {
                    button.setStyle("-fx-font-size: 20px; -fx-background-color: #ff9800; -fx-text-fill: white;");
                }

                if (text.equals("=")) {
                    button.setOnAction(e -> viewModel.onEquals());
                } else if (text.matches("[0-9]")) {
                    button.setOnAction(e -> viewModel.onNumberClick(text));
                } else {
                    button.setOnAction(e -> viewModel.onCommandClick(text));
                }

                grid.add(button, col, row + 1);
            }
        }

        Scene scene = new Scene(grid, 420, 520);
        primaryStage.setTitle("Калькулятор (Command Pattern)");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}