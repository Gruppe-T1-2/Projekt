class CommandInventory extends BaseCommand implements Command{

    CommandInventory () {
        description = "Viser genstandene og mængden af DKK i din kurv.";
    }

    @Override
    public void execute(Context context, String command, String[] parameters) {
        //Prints inventory
        InventoryManager.printInventory();

    }
}
