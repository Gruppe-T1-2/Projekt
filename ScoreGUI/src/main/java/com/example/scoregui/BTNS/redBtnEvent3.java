package com.example.scoregui.BTNS;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;

public class redBtnEvent3 extends Button {
    public redBtnEvent3(String ImagePath){
        Image BTN = new Image(ImagePath);
        ImageView BTNView = new ImageView(BTN);
        BTNView.setFitHeight(150);
        BTNView.setFitWidth(150);
        BTNView.setTranslateX(-450);
        BTNView.setTranslateY(-250);

        setGraphic(BTNView);
        setBorder(Border.EMPTY);
        setBackground(Background.EMPTY);
    }
}
