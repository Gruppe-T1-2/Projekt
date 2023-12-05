package com.example.scoregui.BTNS;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;

public class redBtnEvent4 extends Button {
    public redBtnEvent4(String ImagePath){
        Image BTN = new Image(ImagePath);
        ImageView BTNView = new ImageView(BTN);
        BTNView.setFitHeight(150);
        BTNView.setFitWidth(150);
        BTNView.setTranslateX(-250);
        BTNView.setTranslateY(0);

        setGraphic(BTNView);
        setBorder(Border.EMPTY);
        setBackground(Background.EMPTY);
    }
}
