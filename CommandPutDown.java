import java.util.Scanner;
import java.util.*;

public class CommandPutDown extends BaseCommand implements Command{
    Item item;
    InventoryManager inventoryManager;
    Scanner scan = new Scanner(System.in);
    String input;

    @Override
    public void execute(Context context, String command, String[] parameters) {
        System.out.println("Hvilken vare vil du gerne ligge tilbage? ");
        input = scan.nextLine();
        try {
            if (InventoryManager.inventory.get(input).name.equals(input)) {
                inventoryManager.removeItem(input);
                System.out.println(input + " Has been removed ");


            } else if (!inventoryManager.inventory.get(input).name.equals(input)) {
                System.out.println("No such item in inventory");
            }
        }catch (NullPointerException Exception){
            System.out.println("No such item in inventory");
        }


    }
}
