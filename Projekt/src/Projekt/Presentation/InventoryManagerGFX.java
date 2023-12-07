package Projekt.Presentation;

import Projekt.Domain.Domain;
import Projekt.Domain.Item;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;

public class InventoryManagerGFX {
    ArrayList<ImageView> itemViewlist = new ArrayList<ImageView>();


    Pane root = new Pane();
    Scene scene = new Scene(root,1500,919);
    Scene previousScene;
    Image slotImage;
    Image removeBtnImage;
    ImageView background;
    ImageView closeBtnImageview;
    ImageView openBtnImageview;
    ImageView crownImageView;
    ImageView[] slots = new ImageView[14];
    ArrayList<Button> removeItemBtn = new ArrayList<>();
    int itemCount = 0;

    Label label = new Label();

    public void initInventoryManagerGFX(Stage primaryStage) {
        File file = new File("src\\Projekt\\Presentation\\images\\InventoryBackground.png");
        File slotFile = new File("src\\Projekt\\Presentation\\images\\InventorySlot.png");
        try {
            Image image = new Image(new FileInputStream(file.getPath()));
            slotImage = new Image(new FileInputStream(slotFile.getPath()));
            Image openBtnImage = new Image(new FileInputStream("src\\Projekt\\Presentation\\images\\basket-152089_640.png"));
            Image closeBtnImage = new Image(new FileInputStream("src\\Projekt\\Presentation\\images\\delete-2935433_640.png"));
            Image crownImage = new Image(new FileInputStream("src\\Projekt\\Presentation\\images\\1_krone_confettiworld-p.png"));
            removeBtnImage = new Image(new FileInputStream("src\\Projekt\\Presentation\\images\\clear-1727486_640.png"));
            openBtnImageview = new ImageView(openBtnImage);
            closeBtnImageview = new ImageView(closeBtnImage);
            crownImageView = new ImageView(crownImage);
            background = new ImageView(image);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        background.setFitHeight(919);
        background.setFitWidth(1500);
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
            slots[i].setX(100*i + 40);
            slots[i].setY(100);
            root.getChildren().add(slots[i]);

        }
        for (int i = 0; i < slots.length/2; i++) {
            slots[i] = new ImageView(slotImage);
            slots[i].setX(100*i + 40);
            slots[i].setY(300);
            root.getChildren().add(slots[i]);

        }
        closeBtn.setTranslateX(-300);
        closeBtn.setTranslateY(-300);
        openBtn.setTranslateX(-700);
        openBtn.setTranslateY(-400);
        Display.root.getChildren().add(openBtn);

        label.setFont(new Font("Arial", 40));
        label.setTextFill(Color.RED);
        label.setText(Domain.getMoney() + " ");
        label.setTranslateX(450);
        label.setTranslateY(400);
        Display.root.getChildren().add(label);

        crownImageView.setTranslateX(600);
        crownImageView.setTranslateY(400);
        crownImageView.setScaleX(0.1);
        crownImageView.setScaleY(0.1);
        Display.root.getChildren().add(crownImageView);


    }

    public void updateMoney() {
        label.setText(Domain.getMoney() + " ");
    }



    public void addItem(Item item, ImageView itemView) {
        Domain.addItem(item);
        updateMoney();
        Display.shoppingList.updateShoppingList();
        ImageView itemViewClone = new ImageView(itemView.getImage());
        itemViewClone.setFitHeight(75);
        itemViewClone.setFitWidth(75);
        itemViewClone.setTranslateX(100*itemCount + 50);
        if (itemCount > 7) {
            itemViewClone.setTranslateY(210);
        } else {
            itemViewClone.setTranslateY(110);
        }
        root.getChildren().add(itemViewClone);
        removeItemBtn.add(new Button());
        int lastElement = removeItemBtn.size() - 1;
        ImageView removeBtnImageview = new ImageView(removeBtnImage);
        System.out.println(lastElement);
        System.out.println(removeItemBtn.get(lastElement));
        removeItemBtn.get(lastElement).setTranslateX(100*itemCount - 240);
        removeItemBtn.get(lastElement).setGraphic(removeBtnImageview);
        removeItemBtn.get(lastElement).setScaleX(0.1);
        removeItemBtn.get(lastElement).setScaleY(0.1);
        removeItemBtn.get(lastElement).setBorder(null);
        removeItemBtn.get(lastElement).setBackground(null);
        if (itemCount > 7) {
            removeItemBtn.get(lastElement).setTranslateY(100);
        } else {
            removeItemBtn.get(lastElement).setTranslateY(-80);
        }
        removeItemBtn.get(lastElement).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                removeItem(itemViewClone, item, removeItemBtn.get(lastElement));
            }
        });
        root.getChildren().add(removeItemBtn.get(lastElement));
        itemCount += 1;
    }

    public void removeItem(ImageView itemView, Item item, Button btn) {
        root.getChildren().remove(itemView);
        root.getChildren().remove(btn);
        Domain.addItemToSpace(item);
        Domain.removeItem(item.name);
        updateMoney();
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
