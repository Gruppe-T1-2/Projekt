class CommandInventory extends BaseCommand implements Command{
    InventoryManager inventoryManager;

    @Override
    public void execute(Context context, String command, String[] parameters) {
        //Prints inventory
        inventoryManager.printInventory();

    }
}
