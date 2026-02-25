package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculate {


    @FXML
    private Button reset;

    @FXML
    private Button addition;

    @FXML
    private TextArea area;

    @FXML
    private Button division;

    @FXML
    private Button eight;

    @FXML
    private Button five;

    @FXML
    private Button foure;

    @FXML
    private Button multiplication;

    @FXML
    private Button nine;

    @FXML
    private Button one;

    @FXML
    private Button point;

    @FXML
    private Button seven;

    @FXML
    private Button six;

    @FXML
    private Button subtraction;

    @FXML
    private Button three;

    @FXML
    private Button two;

    @FXML
    private Button result;

    @FXML
    void addition_button(ActionEvent event) {
        area.appendText("+");
    }

    @FXML
    void result_enter(ActionEvent event) {

        String text = area.getText();

        int a = 0;
        double b = 0.0;
        char[] ch = new char[10];
        char[] arr = text.toCharArray();
//        for(int i = 0 ; i < arr.length; i++){
//            if(arr[i] == '*'){
//                String [] array = area.getText().split("\\*");
//                System.out.println(Arrays.toString(array));
//                a = Integer.parseInt(array[0]) * Integer.parseInt(array[1]);
//                area.appendText("= " + a);
//                break;
//            }
//            else if(arr[i] == '+'){
//                String [] array = area.getText().split("\\+");
//            }
//            else if(arr[i] == '-'){
//                String [] array = area.getText().split("-");
//            }
//            else if(arr[i] == '/'){
//                String [] array = area.getText().split("/");
//            }
//        }
        StringBuilder[][] mas = new StringBuilder[10][10];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '+') {
                String[] array = area.getText().split("[/*-+]");
                //System.out.println(rez(array));
                //System.out.println(Arrays.toString(array));
                area.appendText(" = " + baseOperation(array).toString());

            }

        }

    }

    private Double rez(String[] mas) {
        double result = 1.0;
        double sum = 0;

        ArrayList<Double> str = new ArrayList<Double>();
        for (int i = 0; i < mas.length; i++) {
            result = 1.0;
            char[] ch = mas[i].toCharArray();
            String[] strings = mas[i].split("\\*");
            for (int ine = 0; ine < ch.length; ine++) {
                if (ch[ine] == '*') {
                    for (int b = 0; b < strings.length; b++) {
                        result *= Double.parseDouble(strings[b]);
                    }
                    str.add(result);
                    System.out.println(str.size());
                    if (str.size() != 2) {
                        break;
                    }
                } else if (ch[ine] == '/') { // если в строке есть  / проводится деление всех его элементов
                    for (int b = 0; b < strings.length; b++) {
                        result /= Double.parseDouble(strings[b]);
                        str.add(result);
                    }
                    str.add(result);
                } else if (!mas[i].contains("*")) {// если в строке есть  * проводится умножение всех его элементов
                    sum += Double.parseDouble(mas[i]);
                    break;
                }
                if (str.size() >= 2) { // условие,которое работает с 2 или более элементами
                    // в Коллекции(если более одного , значит операций умножение или деление больше чем 1)

                    for (int len = 0; len < str.size(); len++) {
                        sum += str.get(len);
                    }

                    System.out.println(str.size());
                    return sum;
                }
            }
        }
        Double in = str.getFirst() + sum;
        System.out.println(str);
        return in;

    }

    //Написать метод , который будет считывать строку с TextArea , при нахождении числа использовать StringBuilder и добавлять туда число
    // до тех пора пока не встретится символ.После символы можно будет хранить как в String Builder , так и в массиве символов
    // после уже можно будет написать приоритет операций
    private Double baseOperation(String[] mas) {
        String element = area.getText();
        int count = 0;
        char operation = ' ';

        for (int i = 0; i < area.getText().length(); i++) {
            if (element.charAt(i) == '+') {
                count++;
                operation = '+';
            } else if (element.charAt(i) == '*') {
                count++;
                operation = '*';
            } else if (element.charAt(i) == '/') {
                count++;
                operation = '/';
            } else if (element.charAt(i) == '-') {
                count++;
                operation = '-';
            } else if(operation == ' ' && i == area.getText().length() - 1){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setContentText("Введите оператор");
                alert.show();
            }
        }
        if (count >= 2) {
            return 0.0;
        } else if (count == 1) {
            switch (operation) {
                case '+':
                    return Double.parseDouble(mas[0]) + Double.parseDouble(mas[1]);
                case '-':
                    return Double.parseDouble(mas[0]) - Double.parseDouble(mas[1]);
                case '*':
                    return Double.parseDouble(mas[0]) * Double.parseDouble(mas[1]);
                case '/':
                    return Double.parseDouble(mas[0]) / Double.parseDouble(mas[1]);
                default:
                    System.out.println("Ну ошибка");
            }
        }
        return 0.0;
    }




    @FXML
    void division_button(ActionEvent event) {
        area.appendText("/");
    }

    @FXML
    void eight_button(ActionEvent event) {
        area.appendText("8");
    }

    @FXML
    void five_button(ActionEvent event) {
        area.appendText("5");
    }

    @FXML
    void reset_enter(ActionEvent event){
        area.clear();
    }
    @FXML
    void foure_button(ActionEvent event) {
        area.appendText("4");
    }

    @FXML
    void multiplication_button(ActionEvent event) {
        area.appendText("*");
    }

    @FXML
    void nine_button(ActionEvent event) {
        area.appendText("9");
    }

    @FXML
    void one_button(ActionEvent event) {
        area.appendText("1");
    }

    @FXML
    void point_button(ActionEvent event) {
        area.appendText(".");
    }

    @FXML
    void seven_button(ActionEvent event) {
        area.appendText("7");
    }

    @FXML
    void six_button(ActionEvent event) {
        area.appendText("6");

    }

    @FXML
    void subtraction_button(ActionEvent event) {
        area.appendText("-");

    }

    @FXML
    void three_button(ActionEvent event) {
        area.appendText("3");

    }

    @FXML
    void two_button(ActionEvent event) {
        area.appendText("2");
    }
    @FXML
    void initialize() {
        assert addition != null : "fx:id=\"addition\" was not injected: check your FXML file ' Calculate.fxml'.";
        assert area != null : "fx:id=\"area\" was not injected: check your FXML file ' Calculate.fxml'.";
        assert division != null : "fx:id=\"division\" was not injected: check your FXML file ' Calculate.fxml'.";
        assert eight != null : "fx:id=\"eight\" was not injected: check your FXML file ' Calculate.fxml'.";
        assert five != null : "fx:id=\"five\" was not injected: check your FXML file ' Calculate.fxml'.";
        assert foure != null : "fx:id=\"foure\" was not injected: check your FXML file ' Calculate.fxml'.";
        assert multiplication != null : "fx:id=\"multiplication\" was not injected: check your FXML file ' Calculate.fxml'.";
        assert nine != null : "fx:id=\"nine\" was not injected: check your FXML file ' Calculate.fxml'.";
        assert one != null : "fx:id=\"one\" was not injected: check your FXML file ' Calculate.fxml'.";
        assert point != null : "fx:id=\"point\" was not injected: check your FXML file ' Calculate.fxml'.";
        assert reset != null : "fx:id=\"reset\" was not injected: check your FXML file ' Calculate.fxml'.";
        assert result != null : "fx:id=\"result\" was not injected: check your FXML file ' Calculate.fxml'.";
        assert seven != null : "fx:id=\"seven\" was not injected: check your FXML file ' Calculate.fxml'.";
        assert six != null : "fx:id=\"six\" was not injected: check your FXML file ' Calculate.fxml'.";
        assert subtraction != null : "fx:id=\"subtraction\" was not injected: check your FXML file ' Calculate.fxml'.";
        assert three != null : "fx:id=\"three\" was not injected: check your FXML file ' Calculate.fxml'.";
        assert two != null : "fx:id=\"two\" was not injected: check your FXML file ' Calculate.fxml'.";

    }

}
