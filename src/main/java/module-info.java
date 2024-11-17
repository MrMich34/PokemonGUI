module com.org.prueba2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.eclipse.paho.client.mqttv3;


    opens com.org.prueba2 to javafx.fxml;
    exports com.org.prueba2;
}