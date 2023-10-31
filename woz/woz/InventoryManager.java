import java.util.*;
public class InventoryManager {
    static private HashMap<String, Item> inventory = new HashMap<String, Item>();

    static private double CO2Total;
    static private double Money;

    static public double CO2TotalGet(){
        return CO2Total;
    }

    static public void CO2TotalSet(double input){
        CO2Total = input;
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
            Money -= inputItem.price;
            CO2Total += inputItem.CO2;
        } else {
            System.out.println("Du har ikke nok penge til at købe denne genstand. Genstanden koster " + inputItem.price + " DKK " + "og du har " + Money + " DKK");
        }
    }

    static public void removeItem(String inputName) {
        if (inventory.containsKey(inputName)) {
            Money += inventory.get(inputName).price;
            CO2Total -= inventory.get(inputName).CO2;
            inventory.remove(inputName);
        } else {
            System.out.println("Du har ikke en" + inputName);
        }
    }

    static public Item getItem(String name) {
        if (inventory.get(name) != null) {
            return inventory.get(name);
        } else {
            System.out.println("Kunne ikke finde en ting med dette navn. Returnerer en default Item.");
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
        Set<String> keySet = inventory.keySet();
        System.out.println("Du har de følgende genstande i din kurv:");
        for (int i = 0 ; i < keySet.size() ; i++) {
            System.out.println(" ");
            System.out.println(inventory.get(keySet.iterator().next()).name);

        }
        System.out.println(" ");
        System.out.println("Du har " + Money + " DKK");
        System.out.println(" ");

    }




}
