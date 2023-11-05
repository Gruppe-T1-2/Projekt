class CommandShoppingList extends BaseCommand implements Command {

    CommandShoppingList () {
        description = "Vis genstandene på shoppinglisten.";
    }
    @Override
    public void execute (Context context, String command, String parameters[]) {
        InventoryManager.shoppingList.PrintMissingItems();
    }
}

