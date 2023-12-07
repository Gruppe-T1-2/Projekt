package Projekt.BTNS;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class EndGameBTN extends Button {
    public EndGameBTN(String ImagePath) throws FileNotFoundException {
        Image endGameBTN = new Image(new FileInputStream(ImagePath));
        ImageView EndGameBTNView = new ImageView(endGameBTN);

        EndGameBTNView.setFitHeight(150);
        EndGameBTNView.setFitWidth(150);

        setTranslateX(-450);
        setTranslateY(-250);

        setGraphic(EndGameBTNView);
        setBorder(Border.EMPTY);
        setBackground(Background.EMPTY);
    }
}
