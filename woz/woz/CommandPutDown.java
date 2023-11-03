import java.util.Scanner;
import java.util.*;

public class CommandPutDown extends BaseCommand implements Command{

    InventoryManager inventoryManager;



    @Override
    public void execute(Context context, String command, String[] parameters) {
        try{
            if (InventoryManager.getItem(parameters[0]).name.equals(parameters[0])) {
                inventoryManager.removeItem(parameters[0]);
                System.out.println(parameters[0] + " Has been removed ");
            } else if (!InventoryManager.getItem(parameters[0]).equals(parameters[0])) {
                System.out.println("No such item in inventory");
            }}catch (ArrayIndexOutOfBoundsException e ){
            System.out.println("Skriv navnet på varen du gerne vil fjerne efter dump ");
        }



    }
}
