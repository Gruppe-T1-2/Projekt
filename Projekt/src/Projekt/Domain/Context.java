/* Context class to hold all context relevant to a session.
 */

package Projekt.Domain;
class Context {
  Space current;
  boolean done = false;
  
  Context (Space node) {
    current = node;
  }
  
  public Space getCurrent() {
    return current;
  }

  public void makeDone () {
    done = true;
  }
  
  public boolean isDone () {
    return done;
  }
}

