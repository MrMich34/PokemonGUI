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

        Image gifImage = new Image(getClass().getResource("com/org/prueba2/ghost.png").toString());
        imgPokemon1.setImage(gifImage);

        //String gifUrl2 = "https://static.wikia.nocookie.net/pokemonreloaded/images/a/ab/Ghost.png/revision/latest?cb=20181015230129&path-prefix=es";
        //Image gifImage2 = new Image(gifUrl2);
        //imgPokemon2.setImage(gifImage2);
    }
}
