import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.mysql.cj.jdbc.CallableStatement;

/**
 * Coder:   Evan Somers, Sion Young, James Kidd, James Scully
 * Date:    Aug 5, 2020
 * Purpose: A new window in the program for users to select actors and add them to a list
 */


public class FilmActorSelection extends JFrame {
	//class attributes
    private JList jList;
    private JList selectedList;
    private JButton copyButton;
    public ArrayList<String> selectedActors = new ArrayList<String>();
    
	//constructor method to build frame
    public FilmActorSelection() {
        super("Choose actors");
        setLayout(new FlowLayout());

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(450, 200);
        
        JScrollPane actorsListPane = new JScrollPane();
        ArrayList<Integer> selected = new ArrayList<Integer>();
    		try
    		{
    			jList = new JList(getActors().toArray());
    			
    		} catch (SQLException e1)
    		{
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
        jList.setFixedCellHeight(35);
        jList.setFixedCellWidth(120);
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jList.setVisibleRowCount(4);
        add(new JScrollPane(jList));
        
        copyButton = new JButton("Add actor");

        //adds the selected list element to the selected actors list to the right
        copyButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            	//nothing selected, do nothing
            	if(jList.getSelectedValue() == null) {
            		
            	}
            	else if(selectedActors.contains(jList.getSelectedValue().toString()))
            		JOptionPane.showMessageDialog(getContentPane(), "Actor already added to list");
            	else{
            		selectedActors.add(jList.getSelectedValue().toString());
            		selectedList.setListData(selectedActors.toArray());
            	}
            }
        });
        
        //adding everything to the frame
        add(copyButton);
        selectedList = new JList();
        selectedList.setFixedCellHeight(18);
        selectedList.setFixedCellWidth(120);
        jList.setVisibleRowCount(4);
        jList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane selectedPane = new JScrollPane(selectedList);
        add(selectedPane);
        
        this.setVisible(true);
    }

	/**
	 * Method: getActors
	 * Summary: returns a list of all actors from the database
	 *
	 * @return ArrayList<String>
	 */
    public ArrayList<String> getActors() throws SQLException{
    	Connection myConn = null;
  		CallableStatement myStmt = null;
  		ResultSet myRslt = null;
  		ArrayList<String> actors = new ArrayList<String>();
  		//Step 1: Use a try-catch to attempt the database connection
  		try
  		{
  			//create a Connection object by calling a static method of DriverManager class
  			myConn = DriverManager.getConnection(
  					"jdbc:mysql://localhost:3306/demo?useSSL=false","root","password"
  					);
  			
  			//Step 2: create a Statement object by calling a method of the Connection object
  			myStmt = (CallableStatement) myConn.prepareCall("SELECT CONCAT(first_name, \" \", last_name) AS Name FROM sakila.actor");
  			
  			//Step 3: pass in a query string to the Statement object using a method
  			// called executeQuery().
  			//Assign the returned ResultSet object to myRslt.
  			myRslt = myStmt.executeQuery();
  			
  			//Step 4: PROCESS the myRslt result set object using a while loop
  			while(myRslt.next())
  			{
  				actors.add(myRslt.getString("name"));
  			}
  			
  					
  		}
  		catch(Exception ex)
  		{
  			System.out.println("Exception caught, message is " + ex.getMessage());
  		}
  		
  		//DO THE finally block!
  		finally
  		{
  			//put your clean up code here to close the objects. Standard practice is to
  			//close them in REVERSE ORDER of creation
  			if(myRslt != null)
  				myRslt.close();
  			if(myStmt != null)
  				myStmt.close();
  			if(myConn != null)
  				myConn.close();			
  		}
  		return actors;
    }

    //method for exporting the list of actors that the user selected
	//the user can then import the list to the other jframe window
    public ArrayList<String> exportActors(){
    	return selectedActors;
    }
    public static void main(String[] args) {
    	FilmActorSelection filmSelection = new FilmActorSelection();
        
    }
}