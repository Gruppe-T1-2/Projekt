package com.example.scoregui;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.StackPane;

public class ItemBTN {
    private Button newBTN;
    static double x= -500;
    static double y=0;
    public ItemBTN(String ItemNameBTN, StackPane root, String ImagePath){
        IntroSceneGUI ISG = new IntroSceneGUI();

        Image newImg = new Image(ImagePath);
        ImageView imageView = new ImageView(newImg);

        newBTN = new Button(ItemNameBTN);

        newBTN.setGraphic(imageView);
        root.getChildren().add(newBTN);

        newBTN.setBorder(Border.EMPTY);
        newBTN.setBackground(Background.EMPTY);
        ISG.ReSize(imageView);
        newBTN.setTranslateX(x);
        if(newBTN.getText().equals("Ost"))        {
            newBTN.setTranslateY(350);
        }
        x+=350;
        if (x>=900){
            x=-500;
        }

        newBTN.setOnAction(actionEvent -> {
            //add to inv
            System.out.println("Item added to inventory");
        });



    }
    public Button getButton() {
        return newBTN;
    }
    public void RemoveBTN(StackPane root){
        root.getChildren().remove(newBTN);
    }


}
