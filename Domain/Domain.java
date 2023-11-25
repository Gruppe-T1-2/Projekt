package Domain;

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
}
