package woz;
public class Item {
    String name = "Default name";
    String description = "Default description";

    String tag = "Default tag";

    double CO2 = 0;
    double price = 0;

    public Item(String name, String description, String tag, double CO2, double price) {

        this.name = name;
        this.description = description;
        this.tag = tag;
        this.CO2 = CO2;
        this.price = price;

    }
}
