package Projekt.Domain;

public class CommandPickUp extends BaseCommand implements Command {

    CommandPickUp () {
        description = "Saml en ting op.";
    }

    String temp;

    @Override
    public void execute(Context context, String command, String[] parameters) {
        if (parameters.length >= 1) {
            temp = parameters[0];
            if (parameters.length != 1) {
                for (int i = 1; i < parameters.length; i++) {
                    temp = temp.concat(" " + parameters[i]);
                }
            }
            if (Game.context.current.ItemsInSpace.get(temp) != null) {
                if (InventoryManager.MoneyGet() > Game.context.current.ItemsInSpace.get(temp).price) {
                    InventoryManager.addItem(Game.context.current.ItemsInSpace.get(temp));
                    Game.context.current.ItemsInSpace.remove(temp);
                } else {
                    System.out.println("Du har ikke nok penge til at købe denne genstand.");
                }
            } else {
                System.out.println("Kunne ikke finde denne genstand. Indtast navnet på en genstand i rummet.");
            }
        } else {
            System.out.println("Kunne ikke finde denne genstand. Indtast navnet på en genstand i rummet.");
        }
    }
}
