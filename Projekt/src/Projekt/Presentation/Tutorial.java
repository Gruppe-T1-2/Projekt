package Projekt.Presentation;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Stack;
public class Tutorial {
    Label tutorialTxtDisplay;
    StackPane root = new StackPane();
    Scene scene = new Scene(root, 1500, 919);
    Background background;

    String backgroundPath = "src\\Projekt\\Presentation\\images\\79988.jpg";
    String closeListPath = "src\\Projekt\\Presentation\\images\\START.png";
    String[] tutorialTxt = {"Velkommen Spiller. Dette er et spil, som har til formål, at gøre dig klogere på, hvordan man kan formindsker sit eget CO2-aftryk.",
            "Alle CO2-scores er taget ud fra DCA - Nationalt Center for Fødevarer og Landbrug og scoren kan oversættes til 'Klimaaftryk, kg CO2-ækv. pr kg fødevare'",
            "Ledetråde du kan tage med, på din indkøbstur er:",
            "Importering af varer fra udlandet tilføjer som regel 0.2 til deres CO2-score ",
            "Mejeriprodukter med mere fedt har som regel en højere CO2-score. Dette skyldes blandt andet, at mere koncentrering af mælk er et krav, for at øge fedtindholdet.\nDerfor kræver det også flere ressourcer.",
            "Kødafdelingen er der hvor den højeste CO2-score findes. Det er dog også der den største difference i varene er.\nTænk gerne over faktorer som udledning af gasser og hvor mange ressourcer der skal bruges pr kg fødevare.",
            "Du er på indkøbstur, og har taget en shoppingliste med, som du kan tilgå når som helst ved at klikke på ikonen i det øvre venstre hjørne.",
            "Du har et begrænset budget og skal forsøge at handle så bæredygtigt som muligt.",
            "Du bevæger dig rundt i spillet ved hjælp af de røde knapper og pile du ser på skærmen. De rykker dig rundt i forskellige rum hvor du får muligheden for at vælge varer",
            "For at fjerne varene igen skal du trykke på din indkøbskurv i det øvre venstre hjørne og fjerne den vare du vil",
            "Held og lykke!"};

    public void tutorialDisplay() throws FileNotFoundException {

        Image backgroundImage = new Image(new FileInputStream(backgroundPath));
        Image closeBtnImage = new Image(new FileInputStream(closeListPath));

        ImageView background = new ImageView(backgroundImage);
        ImageView closeBtnView = new ImageView(closeBtnImage);

        background.setFitWidth(1500);
        background.setFitHeight(919);

        Button closeBtn = new Button();
        closeBtn.setGraphic(closeBtnView);
        closeBtn.setBorder(null);
        closeBtn.setBackground(null);
        closeBtn.setScaleX(1);
        closeBtn.setScaleY(1);
        closeBtn.setTranslateX(200);
        closeBtn.setTranslateY(200);
        closeBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Display.primaryStage.setScene(Display.scene);
            }
        });

        tutorialTxtDisplay = new Label();
        tutorialTxtDisplay.setFont(Font.font("Arial", 20));
        tutorialTxtDisplay.setTextFill(Color.WHITE);
        tutorialTxtDisplay.setTranslateY(-150);
        root.getChildren().add(background);
        root.getChildren().add(closeBtn);
        root.getChildren().add(tutorialTxtDisplay);
        for (int i = 0; i < tutorialTxt.length; i++) {
            tutorialTxtDisplay.setText(tutorialTxtDisplay.getText() + tutorialTxt[i] + "\n \n");
        };
        Display.primaryStage.setScene(scene);
    }
}
