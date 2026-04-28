module com.example.calculadora_avanzada {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;

    opens com.example.calculadora_avanzada to javafx.fxml;
    exports com.example.calculadora_avanzada;
}