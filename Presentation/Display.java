package Presentation;

import Domain.Domain;
import javafx.scene.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.*;

public class Display {
    static StackPane root = new StackPane();
    static Scene scene = new Scene(root, 300, 250);
    static Stage primaryStage = new Stage();

    public static void main(String[] args) {
        System.out.println("Velkommen til (Spil navn)!");
        Domain.initEverything();
        primaryStage.setTitle("Klima Kurv");
        primaryStage.setScene(scene);
        primaryStage.show();
        InventoryManagerGFX.initInventoryManagerGFX(primaryStage);
        System.out.println("Spillet er færdigt!");
    }

    public static void gameOnGoing() {

        while (!Domain.GetIsDone()) {
            System.out.print("> ");
            String line = Domain.GetNextLine();
            Domain.dispatch(line);
        }
    }
}
