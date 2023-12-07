package Projekt.Domain;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Item {
    public String name;
    public String description;

    String tag;

    double CO2;
    public double price;

    public Item(String name, String description, String tag, double CO2, double price) {

        this.name = name;
        this.description = description;
        this.tag = tag;
        this.price = price;
        this.CO2 = CO2;

    }
}
