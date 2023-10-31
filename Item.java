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
    //Frugt og grønt:
    Item sweetango = new Item( "Æbler, Sweetango, 8stk",
            "Dyrket i Italien",
            0.5 , 18);
    Item franskeaebler = new Item( "Æbler i bakke, 6stk",
            "Økologiske, lokale æbler, der er dyrket i Danmark",
            0.4 , 15);
    Item appelsiner = new Item( "Appelsiner, Salling, 6stk",
            " Dyrket i Grækenland",
            0.6, 14);

    Item bananer = new Item ("Bananer, 6pak, ØKO",
            " Dyrket i Equador",
            0.5, 18);


    //Kød:

    Item kylling = new Item( "500g ferskkylling, Salling",
            "Kyllingebryst, fra danske kyllinger",
            3.2 , 45);

    Item okse = new Item( "500g oksekød, Salling",
            "Oksekød, fra fritgående køer PÅ TILBUD",
            13.9 , 30);
    Item svinekoed = new Item( "500g svinekød, Slagteren",
            "Dansk, hakket svinekød ",
            4.6 , 25);

    Item lammekoed = new Item ("500g lammekød, Ludvig",
            "Lammekød fra New Zealand",
            21.6, 65);
    //Mejeriprodukter:
    Item havremaelk = new Item("1L havremælk, Oatly",
            "Havremælk af dansk havre", 0.8, 15);

    Item letmaelk = new Item("1L letmælk, Arla",
            "Dansk letmælk fra fritgående køer", 1.1, 11);

    Item mandelmaelk = new Item("1L mandenmaelk, SPIR",
            "mandelmælk fra spanske mandler", 0.9, 17);

    Item fedtOst = new Item ("Gul ost, Arla",
            "Gul ost med 31% fedt",
            9.6, 20);
    Item ost = new Item ("Gul, fedtfattig ost, Arla",
            "Gul fedtfattig ost med 17% fedt",
            8.7, 22);


    //Slik og chokolade
    Item lysChokolade = new Item ("150g lys chokolade, Milka",
            "Lys chokolade fra Schweiz",
            2.7, 12);
    Item moerkChokolade = new Item ("150g mørk chokolade, Marabou",
            "Mørk chokolade fra Sverige",
            0.9, 14);
    Item slik = new Item ("100g slik, Haribo",
            "Matador mix",
            2.3, 10);
}
