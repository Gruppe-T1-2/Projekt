/* Space class for modeling spaces (rooms, caves, ...)
 */

import java.util.*;

class Space extends Node {
  Space (String name) {
    super(name);
  }

  HashMap<String, Item> ItemsInSpace = new HashMap<String, Item>();

  public void welcome () {
    System.out.println("Du er nu ved "+name);
    Set<String> exits = edges.keySet();
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
