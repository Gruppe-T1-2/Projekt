package Projekt.Presentation;

import Projekt.Domain.Domain;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import Projekt.Domain.Item;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ItemBTN {
    private Button newBTN;
    static double x= -500;
    static double y=0;
    ImageView imageView;
    Item item;
    public ItemBTN(String ItemNameBTN, Pane root, String ImagePath, String space, String itemName) throws FileNotFoundException {
        IntroSceneGUI ISG = new IntroSceneGUI();

        Image newImg = new Image(new FileInputStream(ImagePath));
        imageView = new ImageView(newImg);

        newBTN = new Button(ItemNameBTN);

        newBTN.setGraphic(imageView);
        root.getChildren().add(newBTN);

        newBTN.setBorder(Border.EMPTY);
        newBTN.setBackground(Background.EMPTY);
        newBTN.setScaleX(0.7);
        newBTN.setScaleY(0.7);
        newBTN.setTranslateX(x);
        if(newBTN.getText().equals("Ost"))        {
            newBTN.setTranslateY(350);
        }
        x+=350;
        if (x>=900){
            x=-500;
        }

        item = Domain.getItemFromSpace(space, itemName);

        newBTN.setOnAction(actionEvent -> {
            Lighting light = new Lighting();
            newBTN.setEffect(light);
            Display.inventory.addItem(item, imageView);
        });

        DropShadow shadow = new DropShadow();
        newBTN.setOnMouseEntered(actionEvent -> newBTN.setEffect(shadow));
        newBTN.setOnMouseExited(actionEvent -> newBTN.setEffect(null));




    }
    public Button getButton() {
        return newBTN;
    }
    public void RemoveBTN(Pane root){
        root.getChildren().remove(newBTN);
    }
    public ImageView getImageView() { return imageView;}
}
