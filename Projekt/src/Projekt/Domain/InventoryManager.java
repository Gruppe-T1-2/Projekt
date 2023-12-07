package Projekt.Domain;

import java.util.*;
public class InventoryManager {
    static private HashMap<String, Item> inventory = new HashMap<String, Item>();

    static ShoppingList shoppingList = new ShoppingList();

    static private double Score = 0;
    static private double Money = 200;

    static public double ScoreGet(){
        return Score;
    }

    static public void ScoreSet(double input){
        Score = input;
    }

    static public double MoneyGet(){
        return Money;
    }

    static public void MoneySet(double input) {
        Money = input;
    }

    static public void addItem(Item inputItem) {
        if (inputItem.price < Money) {
            inventory.put(inputItem.name, inputItem);
            shoppingList.itemAdded(inputItem);
            Money -= inputItem.price;
            Score += inputItem.CO2;
        } else {
            System.out.println("Du har ikke nok penge til at købe denne genstand. Genstanden koster " + inputItem.price + " DKK " + "og du har " + Money + " DKK");
        }
    }

    static public void removeItem(String inputName) {
        if (inventory.containsKey(inputName)) {
            shoppingList.itemRemoved(inventory.get(inputName));
            Money += inventory.get(inputName).price;
            Score -= inventory.get(inputName).CO2;
            inventory.remove(inputName);
        } else {
            System.out.println("Du har ikke en " + inputName);
        }
    }

    static public Item getItem(String name) {
        if (inventory.get(name) != null) {
            return inventory.get(name);
        } else {
            inventory.put("Default", new Item("Default Name", "Default Description", "Default tag", 0, 0));
            return inventory.get("Default");

        }
    }


    static public List<Item> getTop3Items() {
        List<Item> itemList = new ArrayList<>(inventory.values());

        Collections.sort(itemList, (item1, item2) -> Double.compare(item2.CO2, item1.CO2));

        int topItemsCount = Math.min(3, itemList.size());
        List<Item> top3Items = itemList.subList(0, topItemsCount);

        return top3Items;
    }





}
