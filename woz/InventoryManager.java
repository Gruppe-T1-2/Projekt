package woz;

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

    static public void printItemInfo(String name) {
        if (inventory.get(name) != null) {
            Item item = inventory.get(name);
            System.out.println("Denne genstand hedder: " + item.name);
            System.out.println(" ");
            System.out.println(item.description);
            System.out.println(" ");
        } else {
            System.out.println("Kunne ikke finde en ting med dette navn.");
        }

    }

    static public void printInventory() {
        System.out.println("Du har følgende varer i din kurv:");
        for (Map.Entry<String, Item> entry : inventory.entrySet()) {
            System.out.println();
            System.out.println("- " + entry.getKey());
            System.out.println("- Pris: " + entry.getValue().price + " DKK");

        }
        System.out.println();
        System.out.println("Du har " + Money + " DKK");
        System.out.println();

    }




}
