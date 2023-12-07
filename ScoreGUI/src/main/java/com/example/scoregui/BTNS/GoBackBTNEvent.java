package com.example.scoregui.BTNS;

import com.example.scoregui.IntroSceneGUI;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;

public class GoBackBTNEvent extends Button {
    public GoBackBTNEvent(String ImagePath){
        Image Arrow = new Image(ImagePath);
        ImageView ArrowView = new ImageView(Arrow);

        ArrowView.setFitHeight(100);
        ArrowView.setFitWidth(100);
        ArrowView.setTranslateX(-700);
        ArrowView.setTranslateY(400);

        setGraphic(ArrowView);
        setBorder(Border.EMPTY);
        setBackground(Background.EMPTY);
    }
}
