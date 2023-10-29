public class Item {
    String name = "Default name";
    String description = "Default description";

    double CO2 = 0;
    double price = 0;

    public Item(String name, String description, double CO2, double price) {

        this.name = name;
        this.description = description;
        this.CO2 = CO2;
        this.price = price;

    }
    Item pinkLady = new Item( "Æbler, Sweetango",
            "Produceret i Italien",
            0.5 , 16);
    Item oekoaebler = new Item( "Danske æbler, Salling ØKO",
            "Økologiske, lokale æbler, der er produceret i Danmark",
            0.3 , 20);

    Item kylling = new Item( "500g ferskkylling, Salling",
            "Kyllingebryst, fra danske kyllinger",
            3.1 , 50);

    Item havremaelk = new Item("1L havremælk, Oatly",
            "Havremælk af dansk havre", 0.8, 15);

    Item letmaelk = new Item("1L letmælk, Arla",
            "Dansk letmælk fra fritgående køer", 2.1, 11);

    Item mandelmaelk = new Item("1L mandenmaelk, SPIR",
            "mandelmælk", 0.7, 16);


}
