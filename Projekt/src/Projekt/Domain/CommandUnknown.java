/* Fallback for when a command is not implemented
 */

package Projekt.Domain;
class CommandUnknown extends BaseCommand implements Command {
  @Override
  public void execute (Context context, String command, String parameters[]) {
    System.out.println("Jeg forstår ikke hvad '"+command+"' betyder.");
  }
}
