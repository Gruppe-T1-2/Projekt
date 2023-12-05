package com.example.scoregui.BTNS;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;

public class RightArrowBTNEvent extends Button {
    public RightArrowBTNEvent(String ImagePath){
        Image RightArrow = new Image(ImagePath);
        ImageView RightArrowView = new ImageView(RightArrow);

        RightArrowView.setFitHeight(100);
        RightArrowView.setFitWidth(100);
        RightArrowView.setTranslateX(700);
        RightArrowView.setTranslateY(0);
        RightArrowView.setRotate(180);

        setGraphic(RightArrowView);
        setBorder(Border.EMPTY);
        setBackground(Background.EMPTY);
    }
}
