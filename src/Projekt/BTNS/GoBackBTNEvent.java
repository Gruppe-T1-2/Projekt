package Projekt.BTNS;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GoBackBTNEvent extends Button {
    public GoBackBTNEvent(String ImagePath) throws FileNotFoundException {
        Image Arrow = new Image(new FileInputStream(ImagePath));
        ImageView ArrowView = new ImageView(Arrow);

        ArrowView.setFitHeight(100);
        ArrowView.setFitWidth(100);
        setTranslateX(-700);
        setTranslateY(400);

        setGraphic(ArrowView);
        setBorder(Border.EMPTY);
        setBackground(Background.EMPTY);
    }
}
