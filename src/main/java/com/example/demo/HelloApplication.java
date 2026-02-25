package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Path path =  Paths.get("src/main/java/com/example/demo/Calculate.fxml");
        System.out.println("Загружаем: " + path.toAbsolutePath());

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/demo/Calculate.fxml"));

        Parent parent = fxmlLoader.load();

        Scene scene = new Scene(parent);

        stage.setTitle("Лабораторная №1 КПО");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}