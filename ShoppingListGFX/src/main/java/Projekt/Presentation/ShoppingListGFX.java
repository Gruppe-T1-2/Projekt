package Projekt.Presentation;

import Domain.InventoryManager;
import Domain.ShoppingList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ShoppingListGFX extends Application {
    private ShoppingList shoppingList;
    private Pane root;
    private Scene scene;
    private Scene previousScene;
    private int itemCount = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        initItem();
        InventoryManager.shoppingList.InitShoppingListRandom(50);

        ShoppingListGFX shoppingListGFX = new ShoppingListGFX();
        shoppingListGFX.initShoppingListGFX(primaryStage);

        primaryStage.setTitle("Shopping List App");
        primaryStage.setScene(shoppingListGFX.getScene());
        primaryStage.show();
    }

    private void initItem() {
        // Your existing initItem() method code
    }

    public void initShoppingListGFX(Stage primaryStage) {
        root = new Pane();
        scene = new Scene(root, 800, 800);

        Button openBtn = new Button();
        openBtn.setText("Open Shopping List");
        openBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                showShoppingList();
            }
        });

        Button closeBtn = new Button();
        closeBtn.setText("Close Shopping List");
        closeBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                hideShoppingList();
            }
        });

        root.getChildren().add(closeBtn);

        for (int i = 0; i < 7; i++) {
            Button itemBtn = new Button();
            itemBtn.setText("Item " + (i + 1));
            itemBtn.setLayoutX(100 * i);
            itemBtn.setLayoutY(100);
            root.getChildren().add(itemBtn);
        }

        for (int i = 0; i < 7; i++) {
            Button itemBtn = new Button();
            itemBtn.setText("Item " + (i + 8));
            itemBtn.setLayoutX(100 * i);
            itemBtn.setLayoutY(200);
            root.getChildren().add(itemBtn);
        }

        closeBtn.setLayoutX(50);
        closeBtn.setLayoutY(50);
        openBtn.setLayoutX(50);
        openBtn.setLayoutY(50);

        Display.root.getChildren().add(openBtn);
    }

    public void showShoppingList() {
        InventoryManager.shoppingList.PrintMissingItems();
    }

    public void hideShoppingList() {
        Display.primaryStage.setScene(previousScene);
    }

    public Scene getScene() {
        return scene;
    }
}
