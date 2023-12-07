package Projekt.Domain;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Item {
    public String name = "Default name";
    public String description = "Default description";

    String tag = "Default tag";

    double CO2 = 0;
    public double price = 0;

    public Item(String name, String description, String tag, double CO2, double price) {

        this.name = name;
        this.description = description;
        this.tag = tag;
        this.price = price;
        this.CO2 = CO2;

    }
}
