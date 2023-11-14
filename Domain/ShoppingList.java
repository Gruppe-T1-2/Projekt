package Domain;
import java.util.*;

public class ShoppingList {
    HashMap<String, Integer> ItemsMissing = new HashMap<String, Integer>();
    private HashMap<String, Integer> TagTracker = new HashMap<String, Integer>();



    public void InitShoppingListRandom(int numberOfItems) {
        Random random = new Random();

        for (int i = 0; i < Game.tagList.size(); i++) {
            ItemsMissing.put(Game.tagList.get(i), 0);
        }

        for (int i = 1; i <= numberOfItems; i++) {
            int randomIndex = random.nextInt(Game.tagList.size());
            String tagName = Game.tagList.get(randomIndex);
            Integer tagStatus = (int)((Math.random()*10));
            if (tagStatus%2 == 0) {
                tagStatus = 1;
            } else {
                tagStatus = 2;
            }
            i += tagStatus;
            ItemsMissing.put(tagName, tagStatus);
            TagTracker.put(tagName, tagStatus);
        }
    }

    public void AddTag(String name, Integer i) { ItemsMissing.put(name, i); }


    public void itemAdded(Item item) {
        if (ItemsMissing.containsKey(item.tag)) {
            TagTracker.put(item.tag, TagTracker.get(item.tag) - 1);
            if (TagTracker.get(item.tag) >= 0) {
                ItemsMissing.put(item.tag, TagTracker.get(item.tag));
            }
        }
    }

    public void itemRemoved(Item item) {
        if (ItemsMissing.containsKey(item.tag)) {
            TagTracker.put(item.tag, TagTracker.get(item.tag) + 1);
            if (TagTracker.get(item.tag) >= 0) {
                ItemsMissing.put(item.tag, TagTracker.get(item.tag));
            }
        }
    }


    public void PrintMissingItems() {
        for (Map.Entry<String, Integer> entry : ItemsMissing.entrySet()) {
            if (entry.getValue() != 0) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}