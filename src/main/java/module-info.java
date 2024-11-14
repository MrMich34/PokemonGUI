module com.org.prueba2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.org.prueba2 to javafx.fxml;
    exports com.org.prueba2;
}