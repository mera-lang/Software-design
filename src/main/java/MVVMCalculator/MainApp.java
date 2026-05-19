package MVVMCalculator;

import MVVMCalculator.CalculatorViewModel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        CalculatorViewModel viewModel = new CalculatorViewModel();
        TextField display = new TextField();
        display.setEditable(false);
        display.textProperty().bind(viewModel.displayProperty());

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        GridPane grid = new GridPane();
        grid.add(display, 0, 0, 4, 1);

        int row = 1, col = 0;
        for (String btn : buttons) {
            Button button = new Button(btn);
            button.setPrefSize(80, 80);
            button.setOnAction(e -> {
                switch (btn) {
                    case "C": viewModel.onClear(); break;
                    case "=": viewModel.onOperationClick("="); break;
                    case "+": case "-": case "*": case "/":
                        viewModel.onOperationClick(btn); break;
                    default:
                        viewModel.onNumberClick(btn); break;
                }
            });
            grid.add(button, col, row);
            col++;
            if (col > 3) { col = 0; row++; }
        }

        Scene scene = new Scene(grid, 320, 420);
        primaryStage.setTitle("Simple Calculator MVVM");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}