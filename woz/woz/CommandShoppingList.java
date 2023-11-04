class CommandShoppingList extends BaseCommand implements Command {
    @Override
    public void execute (Context context, String command, String parameters[]) {
        Game.shoppingList.PrintMissingItems();
    }
}

