/* Command for transitioning between spaces
 */
package Domain;
class CommandGo extends BaseCommand implements Command {
  CommandGo() {
    description = "Følg en udgang.";
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
      context.transition(temp);
    } else
    if (guardEq(parameters, 1)) {
      System.out.println("Ukendt udgang");
      return;
    }
  }
}
