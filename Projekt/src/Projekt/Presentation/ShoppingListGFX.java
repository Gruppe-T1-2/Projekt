package Projekt.Presentation;

import Projekt.Domain.Domain;
import Projekt.Domain.InventoryManager;
import Projekt.Domain.ShoppingList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class ShoppingListGFX {

    Pane root = new Pane();
    Scene scene = new Scene(root,1500,919);
    String kødPath = "src\\Projekt\\Presentation\\images\\kød.png";
    String mælkPath = "src\\Projekt\\Presentation\\images\\mælk.png";
    String ostPath = "src\\Projekt\\Presentation\\images\\cheese.png";
    String grøntPath = "src\\Projekt\\Presentation\\images\\frugt.png";
    String slikPath = "src\\Projekt\\Presentation\\images\\Capture.png";
    String backgroundPath = "src\\Projekt\\Presentation\\images\\shoppingList.jpg";
    String openListPath = "src\\Projekt\\Presentation\\images\\openList.png";
    String closeListPath = "src\\Projekt\\Presentation\\images\\delete-2935433_640.png";

    Label kødTal = new Label();
    Label mælkTal = new Label();
    Label ostTal = new Label();
    Label grøntTal = new Label();
    Label slikTal = new Label();
    private Scene previousScene;
    private int itemCount = 0;

    HashMap<String, Integer> shoppingList = Domain.getShoppingList();

    public void initShoppingListGFX() throws FileNotFoundException {
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


        Display.root.getChildren().add(openBtn);

        Image ostImage = new Image(new FileInputStream(ostPath));
        Image kødImage = new Image(new FileInputStream(kødPath));
        Image mælkImage = new Image(new FileInputStream(mælkPath));
        Image frugtImage = new Image(new FileInputStream(grøntPath));
        Image slikImage = new Image(new FileInputStream(slikPath));
        Image backgroundImage = new Image(new FileInputStream(backgroundPath));
        Image closeBtnImage = new Image(new FileInputStream(closeListPath));
        Image openBtnImage = new Image(new FileInputStream(openListPath));

        ImageView ostView = new ImageView(ostImage);
        ImageView kødView = new ImageView(kødImage);
        ImageView mælkView = new ImageView(mælkImage);
        ImageView frugtView = new ImageView(frugtImage);
        ImageView slikView = new ImageView(slikImage);
        ImageView background = new ImageView(backgroundImage);
        ImageView closeBtnView = new ImageView(closeBtnImage);
        ImageView openBtnView = new ImageView(openBtnImage);

        background.setFitWidth(1500);
        background.setFitHeight(919);

        closeBtn.setGraphic(closeBtnView);
        openBtn.setGraphic(openBtnView);
        openBtn.setBorder(null);
        openBtn.setBackground(null);
        closeBtn.setBorder(null);
        closeBtn.setBackground(null);

        openBtn.setScaleX(0.1);
        openBtn.setScaleY(0.1);

        closeBtn.setScaleX(0.1);
        closeBtn.setScaleY(0.1);

        openBtn.setTranslateX(-600);
        openBtn.setTranslateY(-400);

        closeBtn.setTranslateX(-330);
        closeBtn.setTranslateY(-280);

        ostView.setTranslateX(0);
        kødView.setTranslateX(-200);
        mælkView.setTranslateX(-100);
        frugtView.setTranslateX(0);
        slikView.setTranslateX(-50);

        ostView.setScaleX(0.3);
        ostView.setScaleY(0.3);
        kødView.setScaleX(0.3);
        kødView.setScaleY(0.3);
        mælkView.setScaleX(0.3);
        mælkView.setScaleY(0.3);
        frugtView.setScaleX(0.3);
        frugtView.setScaleY(0.3);
        slikView.setScaleX(0.3);
        slikView.setScaleY(0.3);


        ostView.setTranslateY(650);
        kødView.setTranslateY(450);
        mælkView.setTranslateY(150);
        frugtView.setTranslateY(100);
        slikView.setTranslateY(-225);

        root.getChildren().add(background);
        root.getChildren().add(closeBtn);
        root.getChildren().add(ostView);
        root.getChildren().add(kødView);
        root.getChildren().add(mælkView);
        root.getChildren().add(frugtView);
        root.getChildren().add(slikView);

        Label ostText = new Label("Ost:");
        Label kødText = new Label("Kød:");
        Label mælkText = new Label("Mælk:");
        Label frugtText = new Label("Frugt:");
        Label slikText = new Label("Slik:");

        ostText.setTranslateX(300);
        kødText.setTranslateX(300);
        mælkText.setTranslateX(300);
        frugtText.setTranslateX(300);
        slikText.setTranslateX(300);

        ostText.setTranslateY(835);
        kødText.setTranslateY(635);
        mælkText.setTranslateY(435);
        frugtText.setTranslateY(265);
        slikText.setTranslateY(35);

        ostText.setFont(new Font("Arial", 20));
        kødText.setFont(new Font("Arial", 20));
        mælkText.setFont(new Font("Arial", 20));
        frugtText.setFont(new Font("Arial", 20));
        slikText.setFont(new Font("Arial", 20));

        root.getChildren().add(ostText);
        root.getChildren().add(kødText);
        root.getChildren().add(mælkText);
        root.getChildren().add(frugtText);
        root.getChildren().add(slikText);

        ostTal.setTranslateX(400);
        kødTal.setTranslateX(400);
        mælkTal.setTranslateX(400);
        grøntTal.setTranslateX(400);
        slikTal.setTranslateX(400);

        ostTal.setTranslateY(835);
        kødTal.setTranslateY(635);
        mælkTal.setTranslateY(435);
        grøntTal.setTranslateY(265);
        slikTal.setTranslateY(35);

        ostTal.setFont(new Font("Arial", 20));
        kødTal.setFont(new Font("Arial", 20));
        mælkTal.setFont(new Font("Arial", 20));
        grøntTal.setFont(new Font("Arial", 20));
        slikTal.setFont(new Font("Arial", 20));

        root.getChildren().add(ostTal);
        root.getChildren().add(kødTal);
        root.getChildren().add(mælkTal);
        root.getChildren().add(grøntTal);
        root.getChildren().add(slikTal);

        updateShoppingList();
    }

    void updateShoppingList() {
        kødTal.setText(Domain.getTagAmount("Kød").toString());
        mælkTal.setText(Domain.getTagAmount("Mælk").toString());
        slikTal.setText(Domain.getTagAmount("Slik").toString());
        grøntTal.setText(Domain.getTagAmount("Frugt").toString());
        ostTal.setText(Domain.getTagAmount("Ost").toString());
    }

    public void showShoppingList() {
        previousScene = Display.scene;
        Display.primaryStage.setScene(scene);
    }

    public void hideShoppingList() {
        Display.primaryStage.setScene(previousScene);
    }
}
