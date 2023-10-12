import java.util.*;
public class InventoryManager {
    static HashMap<String, Item> inventory = new HashMap<String, Item>();

    static double CO2Total;
    static double Money;

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

    static public void addItem(String inputName, Item inputItem) {
        inventory.put(inputName, inputItem);
    }

    static public void removeItem(String inputName, Item inputItem) {
        inventory.remove(inputName);
    }

    static public Item getItem(String name) {
        if (inventory.get(name) != null) {
            return inventory.get(name);
        } else {
            System.out.println("Kunne ikke finde en ting med dette navn. Returnerer en default genstand. Check din kode for at finde fejlen");
            inventory.put("Default", new Item("Default Name", "Default Description", 0, 0));
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
            System.out.println("Kunne ikke finde en ting med dette navn. Check din kode for at finde fejlen");
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
