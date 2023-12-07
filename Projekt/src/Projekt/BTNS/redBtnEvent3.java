package Projekt.BTNS;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class redBtnEvent3 extends Button {
    public redBtnEvent3(String ImagePath) throws FileNotFoundException {
        Image BTN = new Image(new FileInputStream(ImagePath));
        ImageView BTNView = new ImageView(BTN);

        BTNView.setFitHeight(150);
        BTNView.setFitWidth(150);
        setTranslateX(-450);
        setTranslateY(-250);

        setGraphic(BTNView);
        setBorder(Border.EMPTY);
        setBackground(Background.EMPTY);
    }
}
