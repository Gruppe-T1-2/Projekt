/* Command interface
 */
package woz;
interface Command {
  void execute (Context context, String command, String parameters[]);
  String getDescription ();
}

