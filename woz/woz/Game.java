/* Main class for launching the game
 */

import java.util.Scanner;

class Game {
  static World    world    = new World();
  static Context  context  = new Context(world.getEntry());
  static Command  fallback = new CommandUnknown();
  static Registry registry = new Registry(context, fallback);
  static Scanner  scanner  = new Scanner(System.in);

  static InventoryManager inventory = new InventoryManager();
  
  private static void initRegistry () {
    Command cmdExit = new CommandExit();
    registry.register("afslut", cmdExit);
    registry.register("forlad", cmdExit);
    registry.register("farvel", cmdExit);
    registry.register("gå", new CommandGo());
    registry.register("undersøg", new CommandExamine());
    registry.register("hjælp", new CommandHelp(registry));
  }
  
  public static void main (String args[]) {
    System.out.println("Velkommen til (Spil navn)!");
    initRegistry();
    context.getCurrent().welcome();
    
    while (context.isDone()==false) {
      System.out.print("> ");
      String line = scanner.nextLine();
      registry.dispatch(line);
    }
    System.out.println("Spillet er færdigt!");
  }
}
