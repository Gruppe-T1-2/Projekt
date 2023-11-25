package Presentation;

import Domain.Domain;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DisplayTest extends Application {
    static StackPane root = new StackPane();
    static Scene scene = new Scene(root,300,300);
    static Stage primaryStage = new Stage();
    static DisplayTest test = new DisplayTest();

    public static void main(String[] args) {
        try {
            test.start(primaryStage);
        } catch (Exception e) {
            System.out.println("Exception i main");
        }

    }

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("Velkommen til (Spil navn)!");
        Domain.initEverything();
        stage.setTitle("Klima Kurv");
        stage.setScene(scene);
        InventoryManagerGFX.initInventoryManagerGFX(stage);
        stage.show();
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
