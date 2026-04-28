package com.example.calculadora_avanzada;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculadora_Avanzada extends Application {

    private TextField txtPantalla;
    private double num1 = 0;
    private String operador = "";

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage){

        Label titulo = new Label("Calculadora Avanzada");
        titulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        txtPantalla = new TextField();
        txtPantalla.setEditable(false);
        txtPantalla.setPrefHeight(40);
        txtPantalla.setAlignment(Pos.CENTER_RIGHT);

        GridPane gridBotones = new GridPane();
        gridBotones.setHgap(10);
        gridBotones.setVgap(10);
        gridBotones.setAlignment(Pos.CENTER);

        Button btn7 = new Button("7");
        Button btn8 = new Button("8");
        Button btn9 = new Button("9");
        Button btnDiv = new Button("/");

        Button btn4 = new Button("4");
        Button btn5 = new Button("5");
        Button btn6 = new Button("6");
        Button btnMulti = new Button("*");

        Button btn1 = new Button("1");
        Button btn2 = new Button("2");
        Button btn3 = new Button("3");
        Button btnResta = new Button("-");

        Button btn0 = new Button("0");
        Button btnC = new Button("C");
        Button btnIgual = new Button("=");
        Button btnSuma = new Button("+");

        btn7.setMaxWidth(Double.MAX_VALUE);
        btn8.setMaxWidth(Double.MAX_VALUE);
        btn9.setMaxWidth(Double.MAX_VALUE);
        btnDiv.setMaxWidth(Double.MAX_VALUE);

        btn4.setMaxWidth(Double.MAX_VALUE);
        btn5.setMaxWidth(Double.MAX_VALUE);
        btn6.setMaxWidth(Double.MAX_VALUE);
        btnMulti.setMaxWidth(Double.MAX_VALUE);

        btn1.setMaxWidth(Double.MAX_VALUE);
        btn2.setMaxWidth(Double.MAX_VALUE);
        btn3.setMaxWidth(Double.MAX_VALUE);
        btnResta.setMaxWidth(Double.MAX_VALUE);

        btn0.setMaxWidth(Double.MAX_VALUE);
        btnC.setMaxWidth(Double.MAX_VALUE);
        btnIgual.setMaxWidth(Double.MAX_VALUE);
        btnSuma.setMaxWidth(Double.MAX_VALUE);

        gridBotones.add(btn7,0,0);
        gridBotones.add(btn8,1,0);
        gridBotones.add(btn9,2,0);
        gridBotones.add(btnDiv,3,0);

        gridBotones.add(btn4,0,1);
        gridBotones.add(btn5,1,1);
        gridBotones.add(btn6,2,1);
        gridBotones.add(btnMulti,3,1);

        gridBotones.add(btn1,0,2);
        gridBotones.add(btn2,1,2);
        gridBotones.add(btn3,2,2);
        gridBotones.add(btnResta,3,2);

        gridBotones.add(btn0,0,3);
        gridBotones.add(btnC,1,3);
        gridBotones.add(btnIgual,2,3);
        gridBotones.add(btnSuma,3,3);

        btn0.setOnAction(e->agregarNumero("0"));
        btn1.setOnAction(e->agregarNumero("1"));
        btn2.setOnAction(e->agregarNumero("2"));
        btn3.setOnAction(e->agregarNumero("3"));
        btn4.setOnAction(e->agregarNumero("4"));
        btn5.setOnAction(e->agregarNumero("5"));
        btn6.setOnAction(e->agregarNumero("6"));
        btn7.setOnAction(e->agregarNumero("7"));
        btn8.setOnAction(e->agregarNumero("8"));
        btn9.setOnAction(e->agregarNumero("9"));

        btnSuma.setOnAction(e->seleccionarOperacion("+"));
        btnResta.setOnAction(e->seleccionarOperacion("-"));
        btnMulti.setOnAction(e->seleccionarOperacion("*"));
        btnDiv.setOnAction(e->seleccionarOperacion("/"));

        btnIgual.setOnAction(e->operar());

        btnC.setOnAction(e->limpiar());

        VBox root = new VBox(15,titulo,txtPantalla,gridBotones);
        root.setPadding(new Insets(15));
        root.setAlignment(Pos.TOP_CENTER);

        Scene scene = new Scene(root,300,350);

        stage.setTitle("Calculadora Avanzada JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    private void agregarNumero(String num){
        txtPantalla.setText(txtPantalla.getText() + num);
    }

    private void seleccionarOperacion(String op){
        num1 = Double.parseDouble(txtPantalla.getText());
        operador = op;
        txtPantalla.clear();
    }

    private void operar(){
        double num2 = Double.parseDouble(txtPantalla.getText());
        double resultado = 0;

        switch(operador){

            case "+":
                resultado = num1 + num2;
                break;

            case "-":
                resultado = num1 - num2;
                break;

            case "*":
                resultado = num1 * num2;
                break;

            case "/":
                resultado = num1 / num2;
                break;
        }

        txtPantalla.setText(String.valueOf(resultado));
    }

    private void limpiar(){
        txtPantalla.clear();
        num1 = 0;
        operador = "";
    }
}
