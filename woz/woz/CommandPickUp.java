public class CommandPickUp extends BaseCommand implements Command{
    Item item;


    @Override
    public void execute(Context context, String command, String[] parameters) {
        // Før man kan putte en item i en inventory skal der eksistere et objekt. Ved ikke hvor jeg fortsætter pt så laver bare lige det her som et test.
        // Nu kan man købe flere æbler, men når man fjerne den så fjerne man kun den ene.
        // Vi skal endten gøre så den tæller hvor mange af hver vare spilleren vælger eller så man kun kan have en af hver vare.

        Item test = new Item("æble", "Lækkert æble", "Test", 10.1, 8);

        InventoryManager.addItem(test);

    }
}
