/* Command interface
 */
package Projekt.Domain;
interface Command {
  void execute (Context context, String command, String parameters[]);
  String getDescription ();
}

