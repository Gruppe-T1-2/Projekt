import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ShoppingList {
    private Map<String, String> ItemsMissing = new HashMap<>();

    String[] items = {"æble", "banan", "citron", "daddel", "estragon", "fersken", "grapefrugt"}; //Items fra indkøbsliste

    public void InitShoppingListRandom(int numberOfItems) {
        Random random = new Random();
        for (int i = 1; i <= numberOfItems; i++) {
            int randomIndex = random.nextInt(items.length); // Generer random items
            String itemName = items[randomIndex];           // fra items til indkøbslisten
            String itemStatus = random.nextBoolean() ? "Mangler" : "Ikke på indkøbsliste";
            AddItem(itemName, itemStatus);
        }
    }

    public void AddItem(String itemName, String status) {
        ItemsMissing.put(itemName, status);
    }

    public void RemoveItem(String itemName) {
        ItemsMissing.remove(itemName);
    }

    public void PrintMissingItems() {
        for (Map.Entry<String, String> entry : ItemsMissing.entrySet()) {
            if ("Mangler".equals(entry.getValue())) {
                System.out.println(entry.getKey());
            }
        }
    }

    public static void main(String[] args) {
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.InitShoppingListRandom(10);
        System.out.println("Indkøbsliste:");
        shoppingList.PrintMissingItems();
    }
}