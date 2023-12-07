package com.example.scoregui.BTNS;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;

public class LeftArrowBTNEvent extends Button {
    public LeftArrowBTNEvent(String ImagePath){
        Image LeftArrow = new Image(ImagePath);
        ImageView LeftArrowView = new ImageView(LeftArrow);

        LeftArrowView.setFitHeight(100);
        LeftArrowView.setFitWidth(100);
        LeftArrowView.setTranslateX(-700);
        LeftArrowView.setTranslateY(0);

        setGraphic(LeftArrowView);
        setBorder(Border.EMPTY);
        setBackground(Background.EMPTY);
    }
}
