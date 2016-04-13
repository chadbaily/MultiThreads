package view_controller;

/**
 * View for a Poker Game, has a frame, 3 JPanels (Background, each players cards(5)), multiple buttons, and JLabels to
 * indicate what is happening in the game
 *
 * @author chadbaily
 */

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Method;

@SuppressWarnings("serial") public class View extends Frame
{

	/*
	 * Properties for the view
	 */
	public final static int myNumSquares = 5;
	private JLabel[] myCompCardView;
	private JLabel[] myPlayerCardView;
	private JPanel myCompCardPanel;
	private JPanel myPlayerCardPanel;
	private ButtonListener[] myCardListener;
	private ButtonListener myStartButtonListener;
	private ButtonListener myDiscardButtonListener;
	private Controller myController;
	private JButton myStartButton;
	private JLabel myLabel;
	private JLabel myPlayerInfo;
	private JLabel myCPlayerInfo;
	private JLabel myGameInfo;
	private JLabel myBackgroundLabel;
	private JFrame myFrame;
	private ImageIcon myBlankImage;
	private ImageIcon myBackgroundImage;
	private JButton myDiscardButton;

	private JTextArea myOverallStats;
	private JTextArea myCashierStats;
	private JScrollPane myOverallStatsScroll;

	/**
	 methods for the view
	 */

	/**
	 * View constructor used to lay out the view, sets up the initial view for what the player sees
	 * <p>
	 * <pre>
	 * pre:  none
	 * post: the view is set up and initialized
	 * </pre>
	 */
	public View(Controller controller)
	{
		myFrame = new JFrame("Service Queue Simulation");
		myFrame.setSize(600, 600);
		Box myLayout = new Box(BoxLayout.Y_AXIS);

		/*
		Creating the button
		 */
		String myButtonText = "Start Game";
		myStartButton = new JButton(myButtonText);

		myOverallStats = new JTextArea("Chad");

		myOverallStats.setMaximumSize(myOverallStats.getPreferredSize());
		myCashierStats = new JTextArea(myButtonText);

		myCashierStats.setMaximumSize(myOverallStats.getPreferredSize());
		//		myOverallStatsScroll = new JScrollPane(myOverallStats);
		//
		//		myLayout.add(myOverallStatsScroll);
		myLayout.add(myCashierStats);
		myLayout.add(myOverallStats);

		myLayout.add(myStartButton);
		myFrame.add(myLayout, BorderLayout.EAST);

		//				this.associateListeners(controller);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
	}

	/**
	 * Associates each component's listener with the controller and the correct method to invoke when triggered.
	 * <p>
	 * <pre>
	 * pre:  the controller class has be instantiated
	 * post: all listeners have been associated to the controller
	 *       and the method it must invoke
	 * </pre>
	 */
	public void associateListeners(Controller controller)
	{
		Class<? extends Controller> controllerClass;
		Method startGameMethod, selectMethod, discardMethod;
		Class<?>[] classArgs;

		controllerClass = controller.getClass();

		startGameMethod = null;
		selectMethod = null;
		discardMethod = null;
		classArgs = new Class[1];
		try
		{
			classArgs[0] = Class.forName("java.lang.Integer");
		}
		catch (ClassNotFoundException e)
		{
			String error;
			error = e.toString();
			System.out.println(error);
		}
		try
		{
			selectMethod = controllerClass.getMethod("border", classArgs);
			startGameMethod = controllerClass.getMethod("startGame", (Class<?>[]) null);
			discardMethod = controllerClass.getMethod("discard", (Class<?>[]) null);
		}

		catch (NoSuchMethodException exception)
		{
			String error;

			error = exception.toString();
			System.out.println(error);
		}
		catch (SecurityException exception)
		{
			String error;

			error = exception.toString();
			System.out.println(error);
		}

		int i;
		Integer[] args;

		for (i = 0; i < myNumSquares; i++)
		{
			args = new Integer[1];
			args[0] = new Integer(i);
			myCardListener[i] = new ButtonListener(myController, selectMethod, args);
			myPlayerCardView[i].addMouseListener(myCardListener[i]);
		}

		myStartButtonListener = new ButtonListener(controller, startGameMethod, null);
		myDiscardButtonListener = new ButtonListener(controller, discardMethod, null);
		myDiscardButton.addMouseListener(myDiscardButtonListener);
		myStartButton.addMouseListener(myStartButtonListener);
	}

	/**
	 * Method to close the frame and quit the Java App.
	 */
	public void quit()
	{
		myFrame.setVisible(false);
		myFrame.dispose();
		System.exit(0);
	}

}