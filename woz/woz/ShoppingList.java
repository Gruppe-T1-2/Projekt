import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ShoppingList {
    HashMap<String, Integer> ItemsMissing = new HashMap<>();


    public void InitShoppingListRandom(int numberOfItems) {
        Random random = new Random();
        for (int i = 1; i <= numberOfItems; i++) {
            int randomIndex = random.nextInt(Game.tagList.size());
            String tagName = Game.tagList.get(randomIndex);
            Integer tagStatus = (int)(Math.random()*10-7);
            AddTag(tagName, tagStatus);
        }
    }

    public void AddTag(String name, Integer i) {
        ItemsMissing.put(name, i);
    }


    public void itemAdded(Item item) {
        if (ItemsMissing.containsKey(item.tag)) {
            ItemsMissing.put(item.tag, ItemsMissing.get(item.tag) - 1);
        }
    }

    public void itemRemoved(Item item) {
        if (ItemsMissing.containsKey(item.tag)) {
            ItemsMissing.put(item.tag, ItemsMissing.get(item.tag) + 1);
        }
    }


    public void PrintMissingItems() {
        for (Map.Entry<String, Integer> entry : ItemsMissing.entrySet()) {
            if (entry.getValue() == 0) {
                System.out.println(entry.getKey());
                System.out.print(entry.getValue());
            }
        }
    }
}