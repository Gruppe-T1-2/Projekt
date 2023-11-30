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

    itemList.add(new Item( "Æbler i bakke,",
            "8-pack æbler, dyrket i Italien", "Frugt",
            0.6 , 18));

    itemList.add(new Item( "Æbler ØKO",
            "1kg Økologiske, lokale æbler, der er dyrket i Danmark - Salling ØKO", "Frugt",
            0.4 , 22));

    itemList.add(new Item( "Appelsiner",
            "6 stk appelsiner, dyrket i Grækenland - Salling", "Frugt",
            0.6, 21));

    itemList.add(new Item ("Bananer",
            "6-pack bananer, dyrket i Equador - ØKO", "Frugt",
            0.5, 18));


    //Kød:


    itemList.add(new Item( "Kyllingebrystfillet",
            "450g Kyllingebryst, fra danske kyllinger - Salling" , "Kød",
            1.6 , 45));

    itemList.add(new Item( "Oksekød",
            "500g Oksekød, fra fritgående køer - Salling", "Kød",
            7 , 45));
    itemList.add(new Item( "Kylling",
            "500g Dansk, hakket svinekød - Antonius ", "Kød",
            2.3 , 25));

    itemList.add(new Item ("Lammekød",
            "500g Lammekød fra Irland - Möllers", "Kød",
            10.7, 65));


    //Mejeriprodukter:


    itemList.add(new Item("Havremælk",
            "1L Havremælk af dansk havre - Oatly", "Mælk", 0.8, 15));

    itemList.add(new Item("Letmælk",
            "1L Dansk letmælk fra fritgående køer - Arla", "Mælk", 1.1, 11));

    itemList.add(new Item("Mandelmælk",
            "1L mandelmælk fra spanske mandler - Naturli'", "Mælk", 0.9, 17));

    itemList.add(new Item ("Gul ost",
            "240g Gul ost med 31% fedt - Riberhus", "Ost",
            2.4, 20));
    itemList.add(new Item ("Flødeost",
            "450g Hytteost 1,5% fedt - Salling", "Ost",
            1.75, 20));


    //Slik og chokolade


    itemList.add(new Item ("Lys chokolade",
            "100g Lys chokolade, fra Schweiz - Milka", "Slik",
            0.27, 7));
    itemList.add(new Item ("Mørk chokolade",
            "100g Mørk chokolade, fra Sverige - Marabou", "Slik",
            0.09, 14));
    itemList.add(new Item ("Slik",
            "100g Matador mix - Haribo", "Slik",
            0.23, 10));

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
