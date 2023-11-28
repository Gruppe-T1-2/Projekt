package Projekt.Presentation;


import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ItemGFX {
    File file = new File("src\\Projekt\\Presentation\\images\\Placeholder.PNG");
    Image itemGFX;
    String name = "test";

    public ItemGFX() {
        try {
            itemGFX = new Image(new FileInputStream(file.getPath()));
        } catch (Exception e) {
            e.getMessage();
        }
    }

}
