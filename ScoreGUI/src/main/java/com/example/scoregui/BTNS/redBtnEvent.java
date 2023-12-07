package com.example.scoregui.BTNS;


import com.example.scoregui.IntroSceneGUI;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;


public class redBtnEvent extends Button {

    public redBtnEvent(String ImagePath){
        Image BTN = new Image(ImagePath);
        ImageView BTNView = new ImageView(BTN);
        BTNView.setFitHeight(150);
        BTNView.setFitWidth(150);
        BTNView.setTranslateX(-120);
        BTNView.setTranslateY(320);

        setGraphic(BTNView);
        setBorder(Border.EMPTY);
        setBackground(Background.EMPTY);

    }


}
