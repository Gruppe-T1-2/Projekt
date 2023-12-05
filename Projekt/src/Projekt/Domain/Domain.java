package Projekt.Domain;

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


}
