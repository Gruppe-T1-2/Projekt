package Projekt.BTNS;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class RightArrowBTNEvent extends Button {
    public RightArrowBTNEvent(String ImagePath) throws FileNotFoundException {
        Image RightArrow = new Image(new FileInputStream(ImagePath));
        ImageView RightArrowView = new ImageView(RightArrow);

        RightArrowView.setFitHeight(100);
        RightArrowView.setFitWidth(100);
        setTranslateX(700);
        setTranslateY(0);
        setRotate(180);

        setGraphic(RightArrowView);
        setBorder(Border.EMPTY);
        setBackground(Background.EMPTY);
    }
}
