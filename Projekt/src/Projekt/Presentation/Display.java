package Projekt.Presentation;

import Projekt.Domain.Domain;
import Projekt.Domain.Item;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class Display extends Application {
    public static StackPane root = new StackPane();
    public static Scene scene = new Scene(root,1500,919);
    public static Stage primaryStage = new Stage();
    public static Display test = new Display();
    public static InventoryManagerGFX inventory = new InventoryManagerGFX();
    public static IntroSceneGUI spaceGFX = new IntroSceneGUI();
    public static ShoppingListGFX shoppingList = new ShoppingListGFX();
    public static Tutorial tutorial = new Tutorial();

    @Override
    public void start(Stage stage) {
        Domain.initEverything();
        try {
            shoppingList.initShoppingListGFX();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        primaryStage.setTitle("Klima Kurv");
        primaryStage.setScene(scene);
        inventory.initInventoryManagerGFX(stage);
        try {
            spaceGFX.InitSpaceGFX(root, scene, primaryStage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        primaryStage.show();
        try {
            tutorial.tutorialDisplay();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
