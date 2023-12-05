package com.example.scoregui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Stack;

public class ScoreGFX {
    int score = 5;
    Scene scene;
    Image star;
    Image happySmiley;
    Image mediumSmiley;
    Image sadSmiley;

    String imagePath = "C:/Users/Berti/IdeaProjects/ScoreGUI/src/main/resources/star.png";
    String HappySmileyPath ="C:/Users/Berti/IdeaProjects/ScoreGUI/src/main/resources/happysmiley.png";
    String MediumSmileyPath = "C:/Users/Berti/IdeaProjects/ScoreGUI/src/main/resources/mediumSmiley.png";
    String SadSmileyPath = "C:/Users/Berti/IdeaProjects/ScoreGUI/src/main/resources/sadSmiley.png";
    public void showScore(StackPane root){
        for (int i = 0; i < score; i++) {
            square(i, root);
        }

    }
    public void square(int y, StackPane root){
        star = new Image("file:" + imagePath);
        ImageView imageview = new ImageView(star);
        imageview.setFitHeight(250);
        imageview.setFitWidth(250);
        imageview.setTranslateX(200);
        imageview.setTranslateY(100 - y * 60);
        root.getChildren().add(imageview);
        smiley(score, root);
    }
    public void smiley(int score, StackPane root){
        if(score < 5 ){
            sadSmiley = new Image("file:" + SadSmileyPath);
            ImageView sadSmileyView = new ImageView(sadSmiley);
            sadSmileyView.setFitHeight(100);
            sadSmileyView.setFitWidth(100);
            sadSmileyView.setTranslateX(100);
            sadSmileyView.setTranslateY(100);
            root.getChildren().add(sadSmileyView);
        }else if (score >= 5 && score < 8){
            mediumSmiley = new Image("file:" + MediumSmileyPath);
            ImageView mediumSmileyView = new ImageView(mediumSmiley);
            mediumSmileyView.setFitHeight(100);
            mediumSmileyView.setFitWidth(100);
            mediumSmileyView.setTranslateX(100);
            mediumSmileyView.setTranslateY(100);
            root.getChildren().add(mediumSmileyView);

        }else if (score >= 8){
            happySmiley = new Image("file:" + HappySmileyPath);
            ImageView happySmileyView = new ImageView(happySmiley);

            happySmileyView.setFitHeight(100);
            happySmileyView.setFitWidth(100);
            happySmileyView.setTranslateX(100);
            happySmileyView.setTranslateY(100);
            root.getChildren().add(happySmileyView);
        }

    }

}
