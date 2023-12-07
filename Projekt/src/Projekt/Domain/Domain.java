package Projekt.Domain;

import java.util.HashMap;
import java.util.List;

public class Domain {
    public static void initEverything() {
        Game.initRegistry();
        Game.initItem();
        ShoppingList.InitShoppingListRandom(50);
        Game.context.getCurrent().welcome();
    }

    public static boolean GetIsDone() {
        return Game.context.isDone();
    }

    public static String GetNextLine() {
        return Game.scanner.nextLine();
    }

    public static void dispatch(String line) {
        Game.registry.dispatch(line);
    }

    public static void removeItem(String itemname){ InventoryManager.removeItem(itemname);}

    public static void addItem(Item item){ InventoryManager.addItem(item);}

    public static Item getItemFromSpace(String spaceName, String itemName) {
        return Game.world.spaceList.get(spaceName).ItemsInSpace.get(itemName);
    }

    public static void removeItemFromSpace(String spaceName, String itemName) {
        Game.world.spaceList.get(spaceName).ItemsInSpace.remove(itemName);
    }

    public static void addItemToSpace(Item item) {
        if (item.tag.equals("Frugt")) {
            Game.world.frugtOgGroent.ItemsInSpace.put(item.name, item);
        } else if (item.tag.equals("Kød")) {
            Game.world.koed.ItemsInSpace.put(item.name, item);
        } else if (item.tag.equals("Mælk") || item.tag.equals("Ost")) {
            Game.world.mejeriprodukter.ItemsInSpace.put(item.name, item);
        } else if (item.tag.equals("Slik")) {
            Game.world.sliksektion.ItemsInSpace.put(item.name, item);
        }

    }

    public static Integer getTagAmount(String tagname) {
        return ShoppingList.ItemsMissing.get(tagname);
    }



    public static boolean checkIfItemExists(String spaceName, String itemName) {
        if (Game.world.spaceList.get(spaceName).ItemsInSpace.containsKey(itemName)) {
            return true;
        } else {
            return false;
        }
    }

    public static int getScore() {
        Score.CalculateScore();
        return Score.GFXscore;

    }

    public static double getMoney() {
        return InventoryManager.MoneyGet();
    }

    public static HashMap<String, Integer> getShoppingList() {
        return ShoppingList.ItemsMissing;
    }

    public static String[] getScoreTXT() {
        return Score.scoreTxt;
    }

    public static List<Item> getTop3() {
        return InventoryManager.getTop3Items();
    }


}
