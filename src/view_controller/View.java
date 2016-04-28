package view_controller;

import java.awt.*;
import java.lang.reflect.Method;
import javax.swing.*;

@SuppressWarnings("serial")
public class View extends JFrame
{
	// Constants
	private final int TELLER_WIDTH = 75;
	private final int TELLER_HEIGHT = 85;
	private final String TELLER_IMG = "images/cashier.png";
	private final String FACE_IMG = "images/face.jpg";
	private final int COUNTER_BOX_WIDTH = 50;
	private final int COUNTER_BOX_HEIGHT = 20;
	private final int CUSTOMER_WIDTH = 50;
	private final int CUSTOMER_HEIGHT = 50;
	private final int ROW_1 = 400;
	private final int ROW_2 = 460;
	private final int MAX_PEOPLE_IN_LINE = 5;
	private final int MAX_NUM_OF_TELLERS = 5;

	// Data Members
	private Image myScaledImage;
	private Controller myController;
	private Container myContentPane;
	private JLabel[] myTotalServed;
	private ButtonListener myStartPauseListener;
	private JLabel[][] myCustomer;
	private JButton myStartPauseButton;
	private JLabel[] myTeller;
	private JPanel mySimPanel;

	// Chad
	private JLabel myLabelNumCustomers;
	private JLabel myLabelMaxServiceTime;
	private JLabel myLabelMaxCashiers;
	private JPanel myInfoPanel;
	private JPanel myInfoSetter;
	private JTextField[] myTextFields;
	private JLabel[] myTextFieldLabels;
	private JLabel[] myTotalOverflow;
	// Text Boxes
	private JTextField myNumCustomers;
	private JTextField myMaxServiceTime;
	private JTextField myMaxCashiers;

	// Constructor

	/**
	 * Constructor that creates the view.
	 * 
	 * @param controller
	 *            the SimulationController that gives function to the buttons.
	 */
	public View(Controller controller)
	{
		Image face = Toolkit.getDefaultToolkit().getImage(FACE_IMG);
		myScaledImage = face.getScaledInstance(CUSTOMER_WIDTH, CUSTOMER_HEIGHT, Image.SCALE_SMOOTH);

		myController = controller;

		// Info Panel
		myInfoPanel = new JPanel();
		myInfoPanel.setLayout(new FlowLayout());

		GridLayout bottom = new GridLayout(0, 2);
		myInfoSetter = new JPanel();
		myInfoSetter.setLayout(bottom);

		myNumCustomers = new JTextField("");
		myMaxServiceTime = new JTextField("");
		myMaxCashiers = new JTextField("");

		// Chad testing
		myLabelNumCustomers = new JLabel("# Customers");
		myLabelMaxServiceTime = new JLabel("Serv Time");
		myLabelMaxCashiers = new JLabel("Cashiers");

		// Creating the text fields and their labels
		myTextFields = new JTextField[MAX_NUM_OF_TELLERS];
		for (int i = 0; i < MAX_NUM_OF_TELLERS; i++)
		{
			myTextFields[i] = new JTextField("  ");
			myTextFields[i].setSize(COUNTER_BOX_WIDTH, COUNTER_BOX_HEIGHT);
			myInfoPanel.add(myTextFields[i]);
		}

		// Start/Pause Button
		myStartPauseButton = new JButton("Pause");

		this.associateListeners(myController);

		// Frame info
		this.setSize(600, 600);
		this.setLocation(100, 100);
		this.setTitle("Queue MVC Chad");
		this.setResizable(false);

		myContentPane = getContentPane();
		myContentPane.setLayout(new BorderLayout());

		// Sim Panel
		mySimPanel = new JPanel();
		mySimPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		mySimPanel.setLayout(null);

		// Customer Served Counter and total overflow
		myTotalServed = new JLabel[MAX_NUM_OF_TELLERS];
		myTotalOverflow = new JLabel[MAX_NUM_OF_TELLERS];
		for (int i = 0; i < myTotalServed.length; i++)
		{
			// Total Served
			myTotalServed[i] = new JLabel("0");
			myTotalServed[i].setSize(COUNTER_BOX_WIDTH, COUNTER_BOX_HEIGHT);
			myTotalServed[i].setLocation(65 + (CUSTOMER_WIDTH * i), ROW_2);
			myTotalServed[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			mySimPanel.add(myTotalServed[i]);

			// Overflow
			myTotalOverflow[i] = new JLabel("0");
			myTotalOverflow[i].setSize(COUNTER_BOX_WIDTH, COUNTER_BOX_HEIGHT);
			myTotalOverflow[i].setLocation(65 + (CUSTOMER_WIDTH * i), 0);
			myTotalOverflow[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			mySimPanel.add(myTotalOverflow[i]);
		}

		// Teller locations
		myTeller = new JLabel[MAX_NUM_OF_TELLERS];

		for (int i = 0; i < MAX_NUM_OF_TELLERS; i++)
		{
			myTeller[i] = new JLabel(new ImageIcon(TELLER_IMG));
			myTeller[i].setSize(TELLER_WIDTH, TELLER_HEIGHT);
			myTeller[i].setLocation(50 + (CUSTOMER_WIDTH * i), ROW_1);
			myTeller[i].setVisible(true);
			mySimPanel.add(myTeller[i]);
		}

		// Customer Lines
		myCustomer = new JLabel[MAX_NUM_OF_TELLERS][MAX_PEOPLE_IN_LINE];
		for (int i = 0; i < MAX_NUM_OF_TELLERS; i++)
		{
			for (int j = 0; j < MAX_PEOPLE_IN_LINE; j++)
			{
				myCustomer[i][j] = new JLabel();
				myCustomer[i][j].setSize(CUSTOMER_WIDTH, CUSTOMER_HEIGHT);
				myCustomer[i][j].setLocation(65 + (CUSTOMER_WIDTH * i), 325 - (50 * j));
				myCustomer[i][j].setVisible(true);
				mySimPanel.add(myCustomer[i][j]);
			}
		}

		// Background
		JLabel bg;
		bg = new JLabel(new ImageIcon("images/background.png"));
		bg.setSize(500, 500);
		bg.setLocation(0, 0);
		mySimPanel.add(bg);
		myContentPane.add(mySimPanel, BorderLayout.CENTER);

		myInfoSetter.add(myLabelNumCustomers);
		myInfoSetter.add(myNumCustomers);

		myInfoSetter.add(myLabelMaxServiceTime);
		myInfoSetter.add(myMaxServiceTime);

		myInfoSetter.add(myLabelMaxCashiers);
		myInfoSetter.add(myMaxCashiers);

		myInfoSetter.add(myStartPauseButton, BorderLayout.EAST);

		myContentPane.add(myInfoSetter, BorderLayout.EAST);
		myContentPane.add(myInfoPanel, BorderLayout.SOUTH);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/*
	 * Methods
	 */

	public void changeStartPause()
	{
		if (myStartPauseButton.getText().equals("Start"))
		{
			myStartPauseButton.setText("Pause");
		}
		else
		{
			myStartPauseButton.setText("Start");
		}
	}

	public void setCustomersInLine(int queue, int numInLine)
	{
		System.out.println("Queue: " + queue + "  numInLine = " + numInLine);

		myTeller[queue].setIcon(new ImageIcon(TELLER_IMG));

		for (int i = 0; i < MAX_PEOPLE_IN_LINE; i++)
		{
			myCustomer[queue][i].setVisible(false);
		}
		try
		{
			for (int i = 0; i < numInLine && i < MAX_PEOPLE_IN_LINE; i++)
			{
				myCustomer[queue][i].setVisible(true);
				myCustomer[queue][i].setIcon(new ImageIcon(myScaledImage));
			}
		}
		catch (NullPointerException e)
		{

		}
	}

	/**
	 * Associates the button with the appropriate method
	 * 
	 * @param controller
	 *            The controller in which the method is included.
	 */
	private void associateListeners(Controller controller)
	{
		Class<? extends Controller> controllerClass;
		Method startPauseMethod;

		controllerClass = myController.getClass();

		startPauseMethod = null;

		try
		{
			startPauseMethod = controllerClass.getMethod("startPause", (Class<?>[]) null);
		}
		catch (SecurityException e)
		{
			String error;

			error = e.toString();
			System.out.println(error);
		}
		catch (NoSuchMethodException e)
		{
			String error;

			error = e.toString();
			System.out.println(error);
		}

		myStartPauseListener = new ButtonListener(myController, startPauseMethod, null);

		myStartPauseButton.addMouseListener(myStartPauseListener);
	}

}