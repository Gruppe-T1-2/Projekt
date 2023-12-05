package Projekt.Presentation;

import Domain.Domain;
import Domain.Item;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Display extends Application {
    public static Pane root = new Pane();
    public static Scene scene = new Scene(root,800,800);
    public static Stage primaryStage = new Stage();
    public static Display test = new Display();
    public static InventoryManagerGFX inventory = new InventoryManagerGFX();

    public static ShoppingListGFX shoppingList = new ShoppingListGFX();

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("Velkommen til (Spil navn)!");
        Domain.initEverything();
        primaryStage.setTitle("Klima Kurv");
        primaryStage.setScene(scene);
        inventory.initInventoryManagerGFX(stage);
        Domain.addItem(new Item("test", "test", "test", 1, 1));
        shoppingList.initShoppingListGFX(stage);
        primaryStage.show();
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
