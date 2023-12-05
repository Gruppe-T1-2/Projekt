package Projekt.Presentation;

import Domain.Domain;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.event.*;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.*;


import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;

public class InventoryManagerGFX {
    ArrayList<ImageView> itemViewlist = new ArrayList<ImageView>();


    Pane root = new Pane();
    Scene scene = new Scene(root,800,800);
    Scene previousScene;
    Image slotImage;
    ImageView background;
    ImageView[] slots = new ImageView[15];
    int itemCount = 0;

    public void initInventoryManagerGFX(Stage primaryStage) {
        File file = new File("src\\Projekt\\Presentation\\images\\InventoryBackground.png");
        File slotFile = new File("src\\Projekt\\Presentation\\images\\InventorySlot.png");
        try {
            Image image = new Image(new FileInputStream(file.getPath()));
            slotImage = new Image(new FileInputStream(slotFile.getPath()));
            background = new ImageView(image);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        background.setFitHeight(800);
        background.setFitWidth(800);
        background.setPreserveRatio(true);
        Button openBtn = new Button();
        openBtn.setText("Open Inventory");
        openBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                showInventory();
            }
        });
        Button closeBtn = new Button();

        closeBtn.setText("Close Inventory");
        closeBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                hideInventory();
            }
        });

        root.getChildren().add(background);
        root.getChildren().add(closeBtn);
        for (int i = 0; i < slots.length/2; i++) {
            slots[i] = new ImageView(slotImage);
            slots[i].setX(100*i);
            slots[i].setY(100);
            root.getChildren().add(slots[i]);

        }
        for (int i = 0; i < slots.length/2; i++) {
            slots[i] = new ImageView(slotImage);
            slots[i].setX(100*i);
            slots[i].setY(200);
            root.getChildren().add(slots[i]);

        }
        closeBtn.setLayoutX(50);
        closeBtn.setLayoutY(50);
        openBtn.setLayoutX(50);
        openBtn.setLayoutY(50);
        Display.root.getChildren().add(openBtn);
    }


    public void addItem(ItemGFX item) {
        ImageView itemView = new ImageView(item.itemGFX);
        itemView.setFitHeight(75);
        itemView.setFitWidth(75);
        itemView.setX(100*itemCount + 15);
        itemView.setY(113);
        root.getChildren().add(itemView);
        Button removeItemBtn = new Button();
        removeItemBtn.setText("ThrowAwayItem");
        removeItemBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                removeItem(itemView, item, removeItemBtn);
            }
        });
        root.getChildren().add(removeItemBtn);
    }

    public void removeItem(ImageView itemView, ItemGFX itemGFX, Button btn) {
        root.getChildren().remove(itemView);
        root.getChildren().remove(btn);
        Domain.removeItem(itemGFX.name);

    }

    public void showInventory() {
        background.setVisible(true);
        previousScene = Display.scene;
        Display.primaryStage.setScene(scene);
    }

    public void hideInventory() {
        background.setVisible(false);
        Display.primaryStage.setScene(previousScene);

    }


}
