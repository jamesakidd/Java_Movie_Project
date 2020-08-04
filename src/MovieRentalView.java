import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.*;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

/**
 * Program Name: MovieRentalView.java
 * Purpose:
 * Coder: 
 * Date: Jul 14, 2020
 * Program Name: MovieRentalView.java Purpose: Coder: Date: Jul 14, 2020
 */

public class MovieRentalView extends JFrame
{
	JTabbedPane tabbedPane;
	JPanel addCustomer;
	
	// Customer Firstname
	JLabel cust_lblFirstName;
	JTextField cust_tflFirstName;

	// Customer Lastname
	JLabel cust_lblLastName;
	JTextField cust_tflLastName;

	// Customer Email
	JLabel cust_lblEmail;
	JTextField cust_tflEmailField;

	// Customer Address
	JLabel cust_lblAddress_1;
	JTextField cust_tflAddress_1;

	// Customer Address 2
	JLabel cust_lblAddress_2;
	JTextField cust_tflAddress_2;

	// Customer Postal
	JLabel cust_lblPostal;
	JFormattedTextField cust_tflPostal;

	// Customer Phone
	JLabel cust_lblPhone;
	JFormattedTextField cust_tflPhone;

	// Customer Country
	JLabel cust_lblCountry;
	protected JComboBox<String> cust_cmbCountry;

	// Customer City
	JLabel cust_lblCity;
	JComboBox<String> cust_cmbCity;

	// Empty Cells
	JLabel cust_lblEmptyCell_1;
	JLabel cust_lblEmptyCell_2;
	JLabel cust_lblEmptyCell_3;
	
	// Clear Button
	JButton cust_btnClear;
	
	// Customer Button
	JButton cust_btnAddCustomer;
	
	// Error Cell
	JLabel cust_lblError;
	

	MovieRentalView()
	{
		super("Movie Rental and Database");
		SetupJFrame();
		CreateTabbedForms();
		CreateAddCustomerPane();
		CreateAddNewFilmPane();
		CreateAddNewRentalTransactionPane();
		CreateGenerateReportPane();
		this.setVisible(true);
	}

	public void SetupJFrame()
	{
		// boiler plate code
		// ensures window is closed when user exits
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(580, 580);
		this.setLocationRelativeTo(null); // centers the frame in the screen
		this.setLayout(null);// This is to center the JTabbedPane
	}

	public void CreateTabbedForms()
	{
		// This JTabbedPane will have different forms and reports for the user to switch
		// through
		JTabbedPane tabbedPane = new JTabbedPane();
		// setting the size of the tabbedPane 5px smaller than the size of the JFrame
		tabbedPane.setBounds(0, 0, 575, 575);

		// JPanels for the JTabbedPane
		addCustomer = new JPanel();
		JPanel addActor = new JPanel();
		JPanel addFilm = new JPanel();
		JPanel newRental = new JPanel();
		JPanel report = new JPanel();

		// Adding the JPanels to the tabbedPane with appropriate titles
		tabbedPane.add("Add a new customer", addCustomer);
		tabbedPane.add("Add a new actor", addActor);
		tabbedPane.add("Add a new film", addFilm);
		tabbedPane.add("Rent a movie", newRental);
		tabbedPane.add("Generate report", report);

		this.add(tabbedPane);
	}

	private void CreateAddCustomerPane()
	{
		// Build UI
		instantiateJComponentsForCustomerPane();
		addJComponentsToCustomerPanel();
	}
	
	// Add listener to the comboBox and data
  public void addCountryComboListener(ActionListener listener) {
  	cust_cmbCountry.addActionListener(listener);
  }
  
  public void addCustomerButtonLIstener(ActionListener listener) {
  	cust_btnAddCustomer.addActionListener(listener);
  }
  
  // Update CountryList
  public void updateCountryList(List<String> countries) {
  	cust_cmbCountry.removeAllItems();
  	cust_cmbCountry.addItem("-");
  	for(int i = 0; i < countries.size(); ++i) {
  		cust_cmbCountry.addItem(countries.get(i).toString());
  	}
  }
  
  // Updates the cityComboBox
  public void setCityComboBox(List<String> cities ) {
  	cust_cmbCity.removeAllItems();
  	for(int i = 0; i < cities.size(); ++i) 
  		cust_cmbCity.addItem(cities.get(i).toString());
  }


  
  
	private void CreateGenerateReportPane()
	{
		// Sion's Codes
	}

	private void CreateAddNewRentalTransactionPane()
	{
		// Evan's codes
	}

	private void CreateAddNewFilmPane()
	{
		// Evan's codes
	}

	public void instantiateJComponentsForCustomerPane()
	{

		// Firstname
		cust_lblFirstName = new JLabel("First Name: ");
		cust_tflFirstName = new JTextField("");

		// Lastname
		cust_lblLastName = new JLabel("Last Name: ");
		cust_tflLastName = new JTextField("");

		// Email
		cust_lblEmail = new JLabel("Email: ");
		cust_tflEmailField = new JTextField("");

		// Address
		cust_lblAddress_1 = new JLabel("Adress 1: ");
		cust_tflAddress_1 = new JTextField("");

		// Address 2
		cust_lblAddress_2 = new JLabel("Adress 2: ");
		cust_tflAddress_2 = new JTextField("");

		// Postal
		cust_lblPostal = new JLabel("Postal: ");
    MaskFormatter postalMask = null;
		try
		{
			postalMask = new MaskFormatter("U#U-#U#");
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		cust_tflPostal = new JFormattedTextField(postalMask);

		// Phone
		cust_lblPhone = new JLabel("Phone: ");
    MaskFormatter phoneMask = null;
		try
		{
			phoneMask = new MaskFormatter("(###) ###-####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cust_tflPhone = new JFormattedTextField(phoneMask);

		// Country
		String[] country = {"-"};
		cust_lblCountry = new JLabel("Country: ");
		cust_cmbCountry = new JComboBox<String>(country);

		// City
		cust_lblCity = new JLabel("City: ");
		String[] city = {"-"};
		cust_cmbCity = new JComboBox<String>(city);
		
		// Empty
		cust_lblEmptyCell_1 = new JLabel("");
		cust_lblEmptyCell_2 = new JLabel("");

		// Clear and Add Button
		cust_btnClear = new JButton("Clear");
		cust_btnAddCustomer = new JButton("Add Customer");
		
		// Empty
		cust_lblEmptyCell_3 = new JLabel("");
		
		// Error
		cust_lblError = new JLabel("");
	}
	
	public void addJComponentsToCustomerPanel() {
		// Add JComponents to the addCustomer panel
		addCustomer.setLayout(new GridLayout(16, 2));

		// Firstname
		addCustomer.add(cust_lblFirstName);
		addCustomer.add(cust_tflFirstName);

		// Lastname
		addCustomer.add(cust_lblLastName);
		addCustomer.add(cust_tflLastName);

		// Email
		addCustomer.add(cust_lblEmail);
		addCustomer.add(cust_tflEmailField);

		// Address
		addCustomer.add(cust_lblAddress_1);
		addCustomer.add(cust_tflAddress_1);

		// Address 2
		addCustomer.add(cust_lblAddress_2);
		addCustomer.add(cust_tflAddress_2);

		// Postal
		addCustomer.add(cust_lblPostal);
		addCustomer.add(cust_tflPostal);

		// Phone
		addCustomer.add(cust_lblPhone);
		addCustomer.add(cust_tflPhone);

		// Country
		addCustomer.add(cust_lblCountry);
		addCustomer.add(cust_cmbCountry);

		// City
		addCustomer.add(cust_lblCity);
		addCustomer.add(cust_cmbCity);

		// Empty cells
		addCustomer.add(cust_lblEmptyCell_1);
		addCustomer.add(cust_lblEmptyCell_2);
		
		// Clear, Add Buttons
		addCustomer.add(cust_btnClear);
		addCustomer.add(cust_btnAddCustomer);
		
		// Empty, Error
		addCustomer.add(cust_lblEmptyCell_3);
		addCustomer.add(cust_lblError);
		
	}
	
  // Validate the input
  public boolean validateCustomer() {
  	
  	// Check if empty
  	if(this.cust_tflFirstName.getText().equals("")) {
  		this.cust_lblError.setText("Invalid firstname");
  		return false;
  	}
  	if(this.cust_tflLastName.getText().equals("")) {
  		this.cust_lblError.setText("Invalid lastname");
  		return false;
  	}
  	// Get first address, no need to validate second address
  	if(this.cust_lblAddress_1.getText().equals("")) {
  		this.cust_lblError.setText("Invalid address: Requirest at least one");
  		return false;
  	}
  	
  	// validate email
  	if (this.cust_tflEmailField.getText().equals("")) {
  		this.cust_lblError.setText("Invalid email");
  		return false;
    }
    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
        "[a-zA-Z0-9_+&*-]+)*@" + 
        "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
        "A-Z]{2,7}$";          
    Pattern pat = Pattern.compile(emailRegex);  
    if(!pat.matcher(this.cust_tflEmailField.getText()).matches()) {
    	this.cust_lblError.setText("Invalid email");
    	return false;
    } 
    
   // validate phone
    String phoneRegex = "^\\(?([0-9]{3})\\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$";          
    Pattern phonePat = Pattern.compile(phoneRegex);  
    if(!phonePat.matcher(this.cust_tflPhone.getText()).matches()) {
    	this.cust_lblError.setText("Invalid phone");
    	return false;
    } 
     
    if(this.cust_tflPhone.getText().equals("")) {
    	this.cust_lblError.setText("Invalid phone");
    	return false;
    }
    
  	// only need to validate country
    if(this.cust_cmbCountry.getSelectedItem().equals("-")){
    	this.cust_lblError.setText("Invalid Country");
    	return false;
    }
  	return true;
  }
	
	// Use to display messages
	public void displayMessage(String msg) {
    JOptionPane.showMessageDialog(this,msg);  
	}

}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MovieRentalView extends JFrame
{
  JTabbedPane tabbedPane;
  JPanel pnlAddCustomer;
  JPanel pnlAddActor;
  JPanel pnlAddFilm;
  JPanel pnlNewRental;
  JPanel pnlGenerateReport;
  JPanel pnlGenerateReportNorth;

  JComboBox cbCategory;
  JComboBox cbStore;

  JTextField tflFrom;
  JTextField tflTo;

  protected  JTextField tflFirstname;
  protected  JTextField tflLastname;

  JLabel lblFirstname;
  JLabel lblLastname;
  JLabel lblAddNewActorTitle;
  JLabel lblGenerateReportTitle;

  JButton btnAddActor;
  JButton btnCleanActor;
  JButton btnClearGenerateReportView;
  JButton btnGenerateReport;

  JTable tblGenerateReport;
  JScrollPane scpGenerateReport;
  GridBagConstraints gbc;

  MovieRentalView()
  {
    super("Movie Rental and Database");
    setupJFrame();
    createTabbedForms();
    CreateAddCustomerPane();
    createAddActorPane();
    createAddNewFilmPane();
    createAddNewRentalTransactionPane();
    createGenerateReportPane();
    this.setVisible(true);
  }

  /**
   * Method: SetupJFrame
   * Summary: Initiate the JFrame for the app
   */
  public void setupJFrame()
  {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(580,580);
    this.setLocationRelativeTo(null); //centers the frame in the screen
    this.setLayout(null);//This is to center the JTabbedPane
  }

  /**
   * Method: createTabbedForms
   * Summary: create 5 tabbed forms for the program
   */
  public void createTabbedForms()
  {
    //This JTabbedPane will have different forms and reports for the user to switch through
    tabbedPane = new JTabbedPane();
    //setting the size of the tabbedPane 5px smaller than the size of the JFrame
    tabbedPane.setBounds(0,0,575,575);

    //JPanels for the JTabbedPane
    pnlAddCustomer = new JPanel();
    pnlAddActor = new JPanel();
    pnlAddFilm = new JPanel();
    pnlNewRental = new JPanel();
    pnlGenerateReport = new JPanel();

    //Adding the JPanels to the tabbedPane with appropriate titles
    tabbedPane.add("Add a new customer",pnlAddCustomer);
    tabbedPane.add("Add a new actor",pnlAddActor);
    tabbedPane.add("Add a new film",pnlAddFilm);
    tabbedPane.add("Rent a movie",pnlNewRental);
    tabbedPane.add("Generate report",pnlGenerateReport);
    //adding the tabbedPane to the JFrame
    this.add(tabbedPane);
  }

  private void CreateAddCustomerPane()
  {
    // Scully's codes
  }

  /**
   * Method: createAddActorPane
   * Summary: Create add actor panel and its JComponents for the program
   */
  private void createAddActorPane()
  {
    // instantiate JComponent For Add Actor;
    lblAddNewActorTitle = new JLabel("Add a New Actor to Database");
    lblFirstname = new JLabel("First Name:");
    lblLastname = new JLabel("Last Name:");
    pnlAddActor.setLayout(new GridBagLayout());
    lblAddNewActorTitle.setPreferredSize(new Dimension(250, 50));
    tflFirstname = new JTextField(20);
    tflLastname = new JTextField(20);
    btnAddActor = new JButton("Add Actor");
    btnCleanActor = new JButton("Clear");
    gbc = new GridBagConstraints();

    // setupTitleForAddActor();
    gbc.insets = new Insets(3,3,3,3);
    gbc.anchor = GridBagConstraints.CENTER;
    setGBCPosition(1,0);
    pnlAddActor.add(lblAddNewActorTitle, gbc);

    //setupAllLabelsForAddActor();
    gbc.anchor = GridBagConstraints.NORTHEAST;
    gbc.weightx = 0.01;

    setGBCPosition(0,2);
    pnlAddActor.add(lblFirstname, gbc);

    setGBCPosition(0,3);
    pnlAddActor.add(lblLastname, gbc);


    //setupAllJTextFieldForAddActor();
    gbc.anchor = GridBagConstraints.LINE_START;
    gbc.weightx = 0.8;
    setGBCPosition(1,2);
    pnlAddActor.add(tflFirstname, gbc);

    setGBCPosition(1,3);
    pnlAddActor.add(tflLastname, gbc);

    //setupButtonForAddActor();
    gbc.weighty = 1;
    gbc.weightx = 0.01;

    gbc.anchor = GridBagConstraints.FIRST_LINE_END;
    setGBCPosition(0,5);
    pnlAddActor.add(btnCleanActor, gbc);

    gbc.anchor = GridBagConstraints.FIRST_LINE_START;
    setGBCPosition(1,5);
    pnlAddActor.add(btnAddActor, gbc);
  }

  /**
   * Method: createGenerateReportPane
   * Summary: Create the generate report panel and add it the the JFrame;
   */
  private void createGenerateReportPane()
  {
    //setUpAllLablesForGenerateReport();
    tblGenerateReport = new JTable();
    pnlGenerateReport.setLayout(new BorderLayout());
    lblGenerateReportTitle = new JLabel("Generate Report", SwingConstants.CENTER);
    pnlGenerateReport.add(lblGenerateReportTitle, BorderLayout.NORTH);
    pnlGenerateReportNorth = new JPanel();
    pnlGenerateReportNorth.setLayout(new GridBagLayout());
    scpGenerateReport = new JScrollPane(tblGenerateReport);
    cbCategory = new JComboBox();
    cbCategory.setSize(30,15);
    cbStore = new JComboBox();
    cbStore.setSize(30,15);
    tflFrom = new JTextField(20);
    tflTo = new JTextField(20);
    btnClearGenerateReportView = new JButton("Clear");
    btnGenerateReport = new JButton("Generate Report");
    gbc = new GridBagConstraints();

    //setUpAllJCompoboxesForGenerateReport();
    gbc.weightx = 0.1;
    gbc.anchor = GridBagConstraints.FIRST_LINE_START;
    setGBCPosition(0,2);
    pnlGenerateReportNorth.add(new JLabel("Select by Category"), gbc);

    setGBCPosition(0,3);
    pnlGenerateReportNorth.add(new JLabel("Select Store"), gbc);

    setGBCPosition(2,2);
    pnlGenerateReportNorth.add(new JLabel("From (DD-MM-YYYY)"), gbc);

    setGBCPosition(2,3);
    pnlGenerateReportNorth.add(new JLabel("To   (DD-MM-YYYY)"), gbc);

    setGBCPosition(1,2);
    pnlGenerateReportNorth.add(cbCategory, gbc);

    setGBCPosition(1,3);
    pnlGenerateReportNorth.add(cbStore, gbc);

    setGBCPosition(4,2);
    pnlGenerateReportNorth.add(tflFrom, gbc);

    setGBCPosition(4,3);
    pnlGenerateReportNorth.add(tflTo, gbc);

    //setUpAllButtonsForGenerateReport();
    setGBCPosition(0,5);
    pnlGenerateReportNorth.add(btnGenerateReport, gbc);

    setGBCPosition(1,5);
    pnlGenerateReportNorth.add(btnClearGenerateReportView, gbc);

    pnlGenerateReport.add(pnlGenerateReportNorth, BorderLayout.CENTER);
    pnlGenerateReport.add(scpGenerateReport, BorderLayout.SOUTH);
  }

  private void createAddNewRentalTransactionPane()
  {
    //Evan's codes
  }

  private void createAddNewFilmPane()
  {
    // Evan's codes
  }

  /**
   * Method: addAddActorButtonListener
   * Summary: Add an action listener to the buttons for add actor panel
   * @param listener An AddActorListener object
   */
  public void addAddActorButtonListener(ActionListener listener)
  {
    btnAddActor.addActionListener(listener);
    btnCleanActor.addActionListener(listener);
  }

  /**
   * Method: addGenerateReportLisenter
   * Summary: Add an action listener to the buttons for generate report panel
   * @param listener An GenerateReportListener object
   */
  public void addGenerateReportLisenter(ActionListener listener) {
    btnClearGenerateReportView.addActionListener(listener);
    btnGenerateReport.addActionListener(listener);
  }

  /**
   * Method: setGBCPosition
   * Summary: A helper method to set GridBagConstrains coordinates.
   *          GridBagLayout is used in add actor and generate report panels.
   * @param x x coordinate
   * @param y y coordinate
   */
  public void setGBCPosition(int x, int y)
  {
    gbc.gridx = x;
    gbc.gridy = y;
  }
  /**
   * Method: clearGeneratereportInput
   * Summary: Clear/reset inputs for generate report panel
   */
  public void clearGeneratereportInput() {
    tflFrom.setText("");
    tflTo.setText("");
    cbCategory.setSelectedIndex(0);
    cbStore.setSelectedIndex(0);
  }
}
