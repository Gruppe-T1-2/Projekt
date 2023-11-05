/* Kommando til at vise en items navn og description.
 */

class CommandExamine extends BaseCommand implements Command {

    CommandExamine () {
        description = "Viser en genstands beskrivelse.";
    }

    String temp;

    @Override
    public void execute (Context context, String command, String parameters[]) {
        if (parameters.length >= 1) {
            temp = parameters[0];
            if (parameters.length != 1) {
                for (int i = 1; i < parameters.length; i++) {
                    temp = temp.concat(" " + parameters[i]);
                }
            }
            InventoryManager.printItemInfo(temp);
        } else {
            System.out.println("Du har ikke denne ting");
        }
    }
}
