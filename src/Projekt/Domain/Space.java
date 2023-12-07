/* Space class for modeling spaces (rooms, caves, ...)
 */

package Projekt.Domain;
import java.util.*;

class Space extends Node {
  Space (String name) {
    super(name);
  }

  HashMap<String, Item> ItemsInSpace = new HashMap<String, Item>();

  public void welcome () {
    Set<String> exits = edges.keySet();
  }
  
  @Override
  public Space followEdge (String direction) {
    return (Space) (super.followEdge(direction));
  }
}
