package Projekt.Presentation;

import Projekt.Domain.Domain;
import Projekt.Domain.Item;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Stack;

import static javafx.scene.input.DataFormat.URL;

public class ScoreGFX {
    int score = 5;
    Scene scene;
    Image star;
    Image happySmiley;
    Image mediumSmiley;
    Image sadSmiley;
    Label ScoreTxt;
    String URL = "https://forms.gle/gwMDuvA9RkN285jt9";

    String paperPath ="src\\Projekt\\Presentation\\images\\paper.png";
    String imagePath = "src\\Projekt\\Presentation\\images\\star.png";
    String HappySmileyPath ="src\\Projekt\\Presentation\\images\\happysmiley.png";
    String MediumSmileyPath = "src\\Projekt\\Presentation\\images\\mediumSmiley.png";
    String SadSmileyPath = "src\\Projekt\\Presentation\\images\\sadSmiley.png";
    ImageView paperView;
    Image paper;
    public void showScore(Pane root){
        score = Domain.getScore();
        try {
            paper = new Image(new FileInputStream(paperPath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        paperView = new ImageView(paper);
        root.getChildren().add(paperView);
        putOnLabel(Domain.getScoreTXT(), root);

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

    public void putOnLabel(String[] Txt, Pane root){
        double y = -200;
        String text = "";

        for (int i = 0; i < Txt.length; i++) {
            text += Txt[i];
            text += "\n";
            text += "\n";
        }
        System.out.println(text);
        Label txt = new Label(text);
        txt.setTranslateY(-150);
        txt.setTranslateX(50);
        txt.setTextFill(Color.BLACK);
        txt.setFont(new Font("Arial", 20));
        List<Item> itemList = Domain.getTop3();
        if (itemList.size() >= 3) {
            Label label1 = new Label("De genstande der bidragede mest til din score var:");
            label1.setTranslateY(50);
            label1.setTranslateX(-200);
            label1.setTextFill(Color.BLACK);
            label1.setFont(new Font("Arial", 20));
            Label label2 = new Label(itemList.get(0).name + "\n" + itemList.get(1).name + "\n" + itemList.get(2).name + "\n");
            label2.setTranslateY(150);
            label2.setTranslateX(-200);
            label2.setTextFill(Color.BLACK);
            label2.setFont(new Font("Arial", 20));
            root.getChildren().add(label1);
            root.getChildren().add(label2);
        }
        root.getChildren().add(txt);
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        Hyperlink link = new Hyperlink();
        link.setTranslateX(0);
        link.setTranslateY(0);
        link.setText(URL);
        link.setOnAction(actionEvent -> {
            content.putString(URL);
            clipboard.setContent(content);

        });

        root.getChildren().add(link);
    }

}
