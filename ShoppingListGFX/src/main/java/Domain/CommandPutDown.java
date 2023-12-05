package Domain;

public class CommandPutDown extends BaseCommand implements Command {
    CommandPutDown () {
        description = "Fjern en ting fra din kurv og placer den i rummet.";
    }

    String temp;
    @Override
    public void execute(Context context, String command, String[] parameters) {
        try{
            if (parameters.length >= 1) {
                temp = parameters[0];
                if (parameters.length != 1) {
                    for (int i = 1; i < parameters.length; i++) {
                        temp = temp.concat(" " + parameters[i]);
                    }
                }
                Game.context.current.ItemsInSpace.put(temp, InventoryManager.getItem(temp));
                InventoryManager.removeItem(temp);
                System.out.println(temp + " er blevet fjernet.");
            } else if (!InventoryManager.getItem(temp).name.equals(temp)) {
                System.out.println("Du har ikke denne ting.");
            }
        } catch (ArrayIndexOutOfBoundsException e ){
            System.out.println("Skriv navnet på varen du gerne vil fjerne efter dump ");
        }



    }
}
