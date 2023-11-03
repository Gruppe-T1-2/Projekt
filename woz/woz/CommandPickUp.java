public class CommandPickUp extends BaseCommand implements Command{
    Item item;


    @Override
    public void execute(Context context, String command, String[] parameters) {
        // Før man kan putte en item i en inventory skal der eksistere et objekt. Ved ikke hvor jeg fortsætter pt så laver bare lige det her som et test.

        Item test = new Item("æble", "Lækkert æble", "Test", 10.1, 8);
        InventoryManager.addItem(test);

    }
}
