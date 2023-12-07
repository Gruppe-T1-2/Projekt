package com.example.scoregui.BTNS;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;

public class EndGameBTN extends Button {
    public EndGameBTN(String ImagePath){
        Image endGameBTN = new Image(ImagePath);
        ImageView EndGameBTNView = new ImageView(endGameBTN);

        EndGameBTNView.setFitHeight(150);
        EndGameBTNView.setFitWidth(150);

        EndGameBTNView.setTranslateX(-450);
        EndGameBTNView.setTranslateY(-250);

        setGraphic(EndGameBTNView);
        setBorder(Border.EMPTY);
        setBackground(Background.EMPTY);
    }
}
