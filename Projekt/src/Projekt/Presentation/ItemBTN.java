package Projekt.Presentation;

import Projekt.Domain.Domain;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import Projekt.Domain.Item;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ItemBTN {
    private Button newBTN;
    static double x= -500;
    static double y=0;
    ImageView imageView;
    Label label;
    Item item;
    public ItemBTN(Pane root, String ImagePath, String space, String itemName) throws FileNotFoundException {
        if (Domain.checkIfItemExists(space, itemName)) {
            Image newImg = new Image(new FileInputStream(ImagePath));
            imageView = new ImageView(newImg);

            newBTN = new Button();

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
                if (item.price <= Domain.getMoney()) {
                    newBTN.setScaleX(0);
                    newBTN.setScaleX(0);
                    Display.inventory.addItem(item, imageView);
                    Domain.removeItemFromSpace(space, itemName);
                } else {
                    Label label1 = new Label("Du har ikke nok penge til at købe denne vare.");
                    label1.setFont(new Font("Arial", 20));
                    label1.setTextFill(Color.ANTIQUEWHITE);
                    label1.setTranslateX(newBTN.getTranslateX());
                    label1.setTranslateY(newBTN.getTranslateY()+200);
                    root.getChildren().add(label1);
                    new Timer().scheduleAtFixedRate(
                            new TimerTask() {
                                @Override
                                public void run() {
                                    Platform.runLater(() -> {
                                        label1.setText("");
                                    });
                                }
                            },
                            2000, 2000
                    );
                }
            });

            DropShadow shadow = new DropShadow();

            newBTN.setOnMouseEntered(actionEvent -> {
                newBTN.setEffect(shadow);
                label = new Label(item.name + "\n" + item.description + "\n" + "Den koster " + item.price + " DKK" );
                label.setTranslateX(newBTN.getTranslateX());
                label.setTranslateY(newBTN.getTranslateY()-300);
                root.getChildren().add(label);
                label.setFont(new Font("Arial", 20));
                label.setTextFill(Color.ANTIQUEWHITE);
            });


            newBTN.setOnMouseExited(actionEvent ->{
                root.getChildren().remove(label);
                newBTN.setEffect(null);
            });
        }




    }
    public Button getButton() {
        return newBTN;
    }
    public void RemoveBTN(Pane root){
        root.getChildren().remove(newBTN);
    }
    public ImageView getImageView() { return imageView;}
}
