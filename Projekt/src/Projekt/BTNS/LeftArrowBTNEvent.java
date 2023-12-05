package Projekt.BTNS;

import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class LeftArrowBTNEvent extends Button {
    public LeftArrowBTNEvent(String ImagePath) throws FileNotFoundException {
        Image LeftArrow = new Image(new FileInputStream(ImagePath));
        ImageView LeftArrowView = new ImageView(LeftArrow);

        LeftArrowView.setFitHeight(100);
        LeftArrowView.setFitWidth(100);
        setTranslateX(-700);
        setTranslateY(0);

        setGraphic(LeftArrowView);
        setBorder(Border.EMPTY);
        setBackground(Background.EMPTY);
    }
}
