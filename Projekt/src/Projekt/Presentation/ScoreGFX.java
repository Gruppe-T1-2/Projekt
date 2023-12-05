package Projekt.Presentation;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Stack;

public class ScoreGFX {
    int score = 5;
    Scene scene;
    Image star;
    Image happySmiley;
    Image mediumSmiley;
    Image sadSmiley;
    Label ScoreTxt;

    String paperPath ="src\\Projekt\\Presentation\\images\\paper.png";
    String imagePath = "src\\Projekt\\Presentation\\images\\star.png";
    String HappySmileyPath ="src\\Projekt\\Presentation\\images\\happysmiley.png";
    String MediumSmileyPath = "src\\Projekt\\Presentation\\images\\mediumSmiley.png";
    String SadSmileyPath = "src\\Projekt\\Presentation\\images\\sadSmiley.png";
    ImageView paperView;
    Image paper;
    public void showScore(Pane root){

        try {
            paper = new Image(new FileInputStream(paperPath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        paperView = new ImageView(paper);
        root.getChildren().add(paperView);

        for (int i = 0; i < score; i++) {
            square(i, root);
        }

    }
    public void square(int y, Pane root){
        star = new Image("file:" + imagePath);
        ImageView imageview = new ImageView(star);
        imageview.setFitHeight(250);
        imageview.setFitWidth(250);
        imageview.setTranslateX(200);
        imageview.setTranslateY(100 - y * 60);
        root.getChildren().add(imageview);
        smiley(score, root);
    }
    public void smiley(int score, Pane root){
        if(score == 1 ){
            sadSmiley = new Image("file:" + SadSmileyPath);
            ImageView sadSmileyView = new ImageView(sadSmiley);
            sadSmileyView.setFitHeight(100);
            sadSmileyView.setFitWidth(100);
            sadSmileyView.setTranslateX(100);
            sadSmileyView.setTranslateY(100);
            root.getChildren().add(sadSmileyView);
        }else if (score == 2){
            mediumSmiley = new Image("file:" + MediumSmileyPath);
            ImageView mediumSmileyView = new ImageView(mediumSmiley);
            mediumSmileyView.setFitHeight(100);
            mediumSmileyView.setFitWidth(100);
            mediumSmileyView.setTranslateX(100);
            mediumSmileyView.setTranslateY(100);
            root.getChildren().add(mediumSmileyView);

        }else if (score == 3){
            happySmiley = new Image("file:" + HappySmileyPath);
            ImageView happySmileyView = new ImageView(happySmiley);

            happySmileyView.setFitHeight(100);
            happySmileyView.setFitWidth(100);
            happySmileyView.setTranslateX(100);
            happySmileyView.setTranslateY(100);
            root.getChildren().add(happySmileyView);
        }

    }

    public void putOnLabel(String Txt, StackPane root){
        double y = -200;
        Label txt = new Label(Txt);
        txt.setTranslateY(y);
        txt.setFont(new Font("Arial", 20));
        y+=50;
        root.getChildren().add(txt);
    }

}
