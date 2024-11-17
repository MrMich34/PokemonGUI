package com.org.prueba2;

import org.eclipse.paho.client.mqttv3.*;

public class MqttHandler implements Runnable {
    private final String broker;
    private final String clientId;
    private final String topic;
    private MqttClient client;
    private MqttCallback callback;

    public MqttHandler(String broker, String clientId, String topic) {
        this.broker = broker;
        this.clientId = clientId;
        this.topic = topic;
    }

    @Override
    public void run() {
        try {
            client = new MqttClient(broker, clientId);
            client.setCallback(callback);
            client.connect();
            client.subscribe(topic);
            System.out.println("Conectado al broker MQTT y suscrito al tema " + topic);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void setCallback(MqttCallback callback) {
        this.callback = callback;
    }

    public void disconnect() {
        try {
            if (client != null && client.isConnected()) {
                client.disconnect();
                System.out.println("Desconectado del broker MQTT");
            }
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
