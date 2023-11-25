package Presentation;

import javafx.scene.control.*;
import javafx.event.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import Domain.Domain;
import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javafx.scene.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;

public class InventoryManagerGFX {
    ArrayList<ItemGFX> itemGFXlist = new ArrayList<ItemGFX>();
    static Image inventoryBackground;

    static InventoryManagerGFX inventoryManagerGFX = new InventoryManagerGFX();

    public static void initInventoryManagerGFX(Stage primaryStage) {
        File file = new File(String.valueOf(inventoryManagerGFX.getClass().getResource("images/InventoryBackground.png")));
        TextField textField = new TextField();
        try {
            System.out.println(file.getName());
            inventoryBackground = ImageIO.read(file);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Button btn = new Button();
        btn.setText("Inventory");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                showInventory();
            }
        });
        Display.root.getChildren().add(btn);
        Display.root.getChildren().add(btn);
    }

    public static void showInventory() {


    }


}
