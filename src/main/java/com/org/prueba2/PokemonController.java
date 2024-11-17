package com.org.prueba2;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import org.eclipse.paho.client.mqttv3.*;

public class PokemonController {

    private MqttHandler mqttHandler;
    private String imgs;
    private String uno;
    private String dos;

    @FXML
    public Text tPokemon1;

    @FXML
    public Text tPokemon2;

    @FXML
    public Text tGanador;

    @FXML
    private ImageView imgPokemon1;

    @FXML
    private ImageView imgPokemon2;

    public void initialize() {

        String gifUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3b/MissingNo.svg/877px-MissingNo.svg.png";
        Image gifImage = new Image(gifUrl);
        imgPokemon1.setImage(gifImage);

        String gifUrl2 = "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3b/MissingNo.svg/877px-MissingNo.svg.png";
        Image gifImage2 = new Image(gifUrl2);
        imgPokemon2.setImage(gifImage2);

        mqttHandler = new MqttHandler("tcp://localhost:1883", "JavaFXClient", "pokemon/imagenes");
        MqttConnectOptions options = new MqttConnectOptions();
        mqttHandler.setCallback(new MqttCallback() {
            @Override
            public void connectionLost(Throwable cause) {
                options.setKeepAliveInterval(60);
            }

            @Override
            public void messageArrived(String topic, MqttMessage message) throws Exception {
                System.out.println("Mensaje recibido: " + topic);
                String payload = new String(message.getPayload());
                System.out.println("Payload: " + payload);

                String[] parts = payload.split(" @@@ ");
                if (parts.length == 5) {
                    setTextoPokemon1(parts[0]);
                    setTextoPokemon2(parts[1]);
                    startImage1(parts[2]);
                    startImage2(parts[3]);
                    setTextoGanador(parts[4]);
                } else {
                    System.out.println("Error: El formato del mensaje no es válido.");
                }
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken token) {
                // No utilizado para el cliente suscriptor
            }
        });

        // Iniciar el hilo del MQTT
        new Thread(mqttHandler).start();
    }

    public void stop() {
        if (mqttHandler != null) {
            mqttHandler.disconnect();
        }
    }

    public void setTextoPokemon1(String poke1) {
        tPokemon1.setText(poke1);
    }

    public void setTextoPokemon2(String poke2) {
        tPokemon2.setText(poke2);
    }

    public void setTextoGanador(String ganador) {
        tGanador.setText("El ganador es: " + ganador);
    }

    public void startImage1(String s){
        Image gifImage = new Image(s);
        imgPokemon1.setImage(gifImage);
    }

    public void startImage2(String s){
        Image gifImage = new Image(s);
        imgPokemon2.setImage(gifImage);
    }
}
