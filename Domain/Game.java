/* Main class for launching the game
 */
package Domain;

import java.util.ArrayList;
import java.util.Scanner;

class Game {
  static World    world    = new World();
  static Context  context  = new Context(world.getEntry());
  static Command  fallback = new CommandUnknown();
  static Registry registry = new Registry(context, fallback);
  static Scanner  scanner  = new Scanner(System.in);
  static ArrayList<Item> itemList = new ArrayList<>();
  static ArrayList<String> tagList = new ArrayList<>();
  
  private static void initRegistry () {
    Command cmdExit = new CommandExit();
    registry.register("afslut", cmdExit);
    registry.register("forlad", cmdExit);
    registry.register("farvel", cmdExit);
    registry.register("gå", new CommandGo());
    registry.register("saml", new CommandPickUp());
    registry.register("smid", new CommandPutDown());
    registry.register("undersøg", new CommandExamine());
    registry.register("inventory", new CommandInventory());
    registry.register("shoppingliste", new CommandShoppingList());
    registry.register("hjælp", new CommandHelp(registry));
  }

  static void initItem() {

    itemList.add(new Item( "Æbler, Sweetango, 8stk",
            "Dyrket i Italien", "Frugt",
            0.5 , 18));
    itemList.add(new Item( "Æbler i bakke, 6stk",
            "Økologiske, lokale æbler, der er dyrket i Danmark", "Frugt",
            0.4 , 15));
    itemList.add(new Item( "Appelsiner, Salling, 6stk",
            " Dyrket i Grækenland", "Frugt",
            0.6, 14));

    itemList.add(new Item ("Bananer, 6pak, ØKO",
            " Dyrket i Equador", "Frugt",
            0.5, 18));


    //Kød:

    itemList.add(new Item( "500g ferskkylling, Salling",
            "Kyllingebryst, fra danske kyllinger", "Kød",
            3.2 , 45));

    itemList.add(new Item( "500g oksekød, Salling",
            "Oksekød, fra fritgående køer PÅ TILBUD", "Kød",
            13.9 , 30));
    itemList.add(new Item( "500g svinekød, Slagteren",
            "Dansk, hakket svinekød ", "Kød",
            4.6 , 25));

    itemList.add(new Item ("500g lammekød, Ludvig",
            "Lammekød fra New Zealand", "Kød",
            21.6, 65));
    //Mejeriprodukter:
    itemList.add(new Item("1L havremælk, Oatly",
            "Havremælk af dansk havre", "Mælk", 0.8, 15));

    itemList.add(new Item("1L letmælk, Arla",
            "Dansk letmælk fra fritgående køer", "Mælk", 1.1, 11));

    itemList.add(new Item("1L mandelmaelk, SPIR",
            "mandelmælk fra spanske mandler", "Mælk", 0.9, 17));

    itemList.add(new Item ("Gul ost, Arla",
            "Gul ost med 31% fedt", "Ost",
            9.6, 20));
    itemList.add(new Item ("Gul, fedtfattig ost, Arla",
            "Gul fedtfattig ost med 17% fedt", "Ost",
            8.7, 22));


    //Slik og chokolade
    itemList.add(new Item ("150g lys chokolade, Milka",
            "Lys chokolade fra Schweiz", "Slik",
            2.7, 12));
    itemList.add(new Item ("150g mørk chokolade, Marabou",
            "Mørk chokolade fra Sverige", "Slik",
            0.9, 14));
    itemList.add(new Item ("100g slik, Haribo",
            "Matador mix", "Slik",
            2.3, 10));

    for (int i = 0; i < itemList.size(); i++) {
      if (itemList.get(i).tag.equals("Frugt")) {
        tagList.add(itemList.get(i).tag);
        world.frugtOgGroent.ItemsInSpace.put(itemList.get(i).name, itemList.get(i));
      } else
      if (itemList.get(i).tag.equals("Kød")) {
        tagList.add(itemList.get(i).tag);
        world.koed.ItemsInSpace.put(itemList.get(i).name, itemList.get(i));
      } else
      if (itemList.get(i).tag.equals("Mælk")|| itemList.get(i).tag.equals("Ost")) {
        tagList.add(itemList.get(i).tag);
        world.mejeriprodukter.ItemsInSpace.put(itemList.get(i).name, itemList.get(i));
      } else
      if (itemList.get(i).tag.equals("Slik")) {
        tagList.add(itemList.get(i).tag);
        world.sliksektion.ItemsInSpace.put(itemList.get(i).name, itemList.get(i));
      }
    }



  }
  
  public static void main (String args[]) {
    System.out.println("Velkommen til (Spil navn)!");
    initRegistry();
    initItem();
    InventoryManager.shoppingList.InitShoppingListRandom(50);
    context.getCurrent().welcome();
    
    while (context.isDone()==false) {
      System.out.print("> ");
      String line = scanner.nextLine();
      registry.dispatch(line);
    }
    System.out.println("Spillet er færdigt!");
  }
}
