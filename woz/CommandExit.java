/* Command for exiting program
 */
package woz;
class CommandExit extends BaseCommand implements Command {
  CommandExit () {
    description = "Aflsut spillet.";
  }
  @Override
  public void execute (Context context, String command, String parameters[]) {
    context.makeDone();
  }
}
