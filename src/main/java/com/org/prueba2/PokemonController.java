package com.org.prueba2;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class PokemonController {

    @FXML
    private ImageView imgPokemon1;


    @FXML
    private ImageView imgPokemon2;

    public void initialize() {
        String gifUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/showdown/back/245.gif";
        Image gifImage = new Image(gifUrl);
        imgPokemon1.setImage(gifImage);

        String gifUrl2 = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/showdown/858.gif";
        Image gifImage2 = new Image(gifUrl2);
        imgPokemon2.setImage(gifImage2);
    }
}
