package Projekt.Presentation;

import Projekt.Domain.Domain;
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

import javax.imageio.ImageIO;

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
    ImageView closeBtnImageview;
    ImageView openBtnImageview;
    ImageView removeBtnImageview;
    ImageView[] slots = new ImageView[14];
    int itemCount = 0;

    public void initInventoryManagerGFX(Stage primaryStage) {
        File file = new File("src\\Projekt\\Presentation\\images\\InventoryBackground.png");
        File slotFile = new File("src\\Projekt\\Presentation\\images\\InventorySlot.png");
        try {
            Image image = new Image(new FileInputStream(file.getPath()));
            slotImage = new Image(new FileInputStream(slotFile.getPath()));
            Image openBtnImage = new Image(new FileInputStream("src\\Projekt\\Presentation\\images\\basket-152089_640.png"));
            Image closeBtnImage = new Image(new FileInputStream("src\\Projekt\\Presentation\\images\\delete-2935433_640.png"));
            Image removeBtnImage = new Image(new FileInputStream("src\\Projekt\\Presentation\\images\\clear-1727486_640.png"));
            openBtnImageview = new ImageView(openBtnImage);
            closeBtnImageview = new ImageView(closeBtnImage);
            removeBtnImageview = new ImageView(removeBtnImage);
            background = new ImageView(image);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        background.setFitHeight(800);
        background.setFitWidth(800);
        background.setPreserveRatio(true);
        Button openBtn = new Button();
        openBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                showInventory();
            }
        });


        openBtn.setGraphic(openBtnImageview);
        openBtn.setScaleX(0.1);
        openBtn.setScaleY(0.1);
        openBtn.setBorder(null);
        openBtn.setBackground(null);

        Button closeBtn = new Button();

        closeBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                hideInventory();
            }
        });

        closeBtn.setGraphic(closeBtnImageview);
        closeBtn.setScaleX(0.1);
        closeBtn.setScaleY(0.1);
        closeBtn.setBorder(null);
        closeBtn.setBackground(null);

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
            slots[i].setY(300);
            root.getChildren().add(slots[i]);

        }
        closeBtn.setLayoutX(-295);
        closeBtn.setLayoutY(-295);
        openBtn.setLayoutX(-295);
        openBtn.setLayoutY(-280);
        Display.root.getChildren().add(openBtn);
    }


    public void addItem(ItemGFX item) {
        ImageView itemView = new ImageView(item.itemGFX);
        itemView.setFitHeight(75);
        itemView.setFitWidth(75);
        itemView.setX(100*itemCount + 15);
        if (itemCount > 7) {
            itemView.setY(213);
        } else {
            itemView.setY(113);
        }
        root.getChildren().add(itemView);
        Button removeItemBtn = new Button();
        removeItemBtn.setLayoutX(75*itemCount - 275);
        removeItemBtn.setGraphic(removeBtnImageview);
        removeItemBtn.setScaleX(0.1);
        removeItemBtn.setScaleY(0.1);
        removeItemBtn.setBorder(null);
        removeItemBtn.setBackground(null);
        if (itemCount > 7) {
            removeItemBtn.setLayoutY(100);
        } else {
            removeItemBtn.setLayoutY(-80);
        }
        removeItemBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                removeItem(itemView, item, removeItemBtn);
            }
        });
        root.getChildren().add(removeItemBtn);
        itemCount += 1;
    }

    public void removeItem(ImageView itemView, ItemGFX itemGFX, Button btn) {
        root.getChildren().remove(itemView);
        root.getChildren().remove(btn);
        Domain.removeItem(itemGFX.name);
        itemCount -= 1;

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
