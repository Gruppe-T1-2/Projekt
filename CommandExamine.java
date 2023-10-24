/* Kommando til at vise en items navn og description.
 */

class CommandExamine extends BaseCommand implements Command {
    @Override
    public void execute (Context context, String command, String parameters[]) {
        if (parameters.length > 1) {
            System.out.println("Skriv kun navnet på en ting, når du bruger examine kommandoen");

        } else {
            InventoryManager.printItemInfo(parameters[0]);
        }
    }
}
