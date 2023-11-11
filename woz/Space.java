/* Space class for modeling spaces (rooms, caves, ...)
 */

package woz;
import java.util.*;

class Space extends Node {
  Space (String name) {
    super(name);
  }

  HashMap<String, Item> ItemsInSpace = new HashMap<String, Item>();

  public void welcome () {
    System.out.println("Du er nu ved "+name);
    System.out.println();
    System.out.println("Der er de følgende varer i dette rum:");
    for (Map.Entry<String, Item> entry : ItemsInSpace.entrySet()) {
      System.out.println();
      System.out.println("- " + entry.getKey());
      System.out.println("- Pris: " + entry.getValue().price + " DKK");
    }
    Set<String> exits = edges.keySet();
    System.out.println();
    System.out.println("De nuværende udgange er:");
    for (String exit: exits) {
      System.out.println(" - "+exit);
    }
  }
  
  public void goodbye () {
  }
  
  @Override
  public Space followEdge (String direction) {
    return (Space) (super.followEdge(direction));
  }
}
