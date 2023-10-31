class CommandInventory extends BaseCommand implements Command{


    @Override
    public void execute(Context context, String command, String[] parameters) {
        //Prints inventory
        InventoryManager.printInventory();

    }
}
