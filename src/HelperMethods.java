import javax.swing.*;

/**
 * File Name: GeneralHelper.java
 * Coder: Sion Young
 * Date: 8/1/2020
 * Description: A helper class contains methods used across multiple class
 */

public class HelperMethods {

  /**
   * Method: createPopupDialog
   * Summary: Creates a pop-up Dialog to interacte with user
   * @param dialogTitle The title of the window
   * @param msg The message to display
   */
  public void createPopupDialog(String dialogTitle, String msg)
  {
    JOptionPane pane = new JOptionPane(msg);
    JDialog dialog = pane.createDialog(dialogTitle);
    dialog.show();
  }

  /**
   * Methods: generateSqlConditionedString
   * Summary: This method is used specifically in generate report panel
   *          to create the condition(everything after WHERE keyword) for an SQL statement.
   * @param s The original SQL statement
   * @param dateStoreCategory The wrapper contains date(from and to), store, and category
   * @return The complete SQL string ready to run in database.
   */
  public String generateSqlConditionedString(String s, DateStoreCategory dateStoreCategory)
  {
    if(dateStoreCategory.store.equals("1"))
    {
      s += "store_id = 1 AND ";
    }
    if (dateStoreCategory.store.equals("2"))
    {
      s += "store_id = 2 AND ";
    }
    if(!dateStoreCategory.category.equals("*"))
    {
      s += "c.name = '" + dateStoreCategory.category + "' AND ";
    }
    s += "(payment_date >= '" + dateStoreCategory.from + " 00:00:00'" + " AND ";
    s += "payment_date <= '" + dateStoreCategory.to + " 23:59:59')";
    return s;
  }
}
