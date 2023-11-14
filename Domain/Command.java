/* Command interface
 */
package Domain;
interface Command {
  void execute (Context context, String command, String parameters[]);
  String getDescription ();
}

