package view_controller;

/**
 * View for a Poker Game, has a frame, 3 JPanels (Background, each players cards(5)), 
 * multiple buttons, and JLabels to indicate what is happening in the game
 * @author chadbaily
 */
import java.awt.*;
import java.lang.reflect.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class View extends Frame
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

	///////////////////////
	// Methods //
	///////////////////////

	/**
	 * View constructor used to lay out the view, sets up the initial view for
	 * what the player sees
	 *
	 * <pre>
	 * pre:  none
	 * post: the view is set up and initialized
	 * </pre>
	 */
	public View(Controller controller)
	{

		String value;

		int i;
		myFrame = new JFrame("Swing Version");
		myFrame.setSize(600, 600);

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		myCompCardView = new JLabel[myNumSquares];
		myPlayerCardView = new JLabel[myNumSquares];

		String myButtonText = "Start Game";
		myStartButton = new JButton(myButtonText);

		myDiscardButton = new JButton("Discard");

		myCardListener = new ButtonListener[myNumSquares];

		myCompCardPanel = new JPanel(new GridLayout(1, 5, 8, 8));
		myPlayerCardPanel = new JPanel(new GridLayout(1, 5, 8, 8));

		myBackgroundImage = new ImageIcon("src/cards/background.jpg");
		myBackgroundLabel = new JLabel(myBackgroundImage);
		myBackgroundLabel.setLayout(new GridBagLayout());
		myBackgroundLabel.setOpaque(false);
		myFrame.add(myBackgroundLabel);

		myBlankImage = new ImageIcon("src/cards/E.GIF");
		myPlayerCardPanel.setOpaque(true);
		myCompCardPanel.setOpaque(true);

		/*
		 * Sets the cards up with 2 rows of 5 cards, there backs facing up
		 */
		for (i = 0; i < myNumSquares; i++)
		{
			myCompCardView[i] = new JLabel(myBlankImage, JLabel.CENTER);
			myPlayerCardView[i] = new JLabel(myBlankImage, JLabel.CENTER);

			myCompCardView[i].setOpaque(false);
			myPlayerCardView[i].setOpaque(false);

			myPlayerCardPanel.add(myPlayerCardView[i]);
			myCompCardPanel.add(myCompCardView[i]);
		}

		myPlayerCardPanel.setOpaque(false);
		myCompCardPanel.setOpaque(false);

		myController = controller;


		myGameInfo = new JLabel();
		myGameInfo.setForeground(Color.white);

		myLabel.setForeground(Color.white);

		myLabel.setSize(getSize());
		myLabel.setFont(new Font("Serif", Font.BOLD, 16));

		myPlayerInfo.setSize(getSize());
		myPlayerInfo.setFont(new Font("Serif", Font.BOLD, 16));

		myCPlayerInfo.setSize(getSize());
		myCPlayerInfo.setFont(new Font("Serif", Font.BOLD, 16));

		myGameInfo.setSize(getSize());
		myGameInfo.setFont(new Font("Serif", Font.BOLD, 16));

		c.gridx = 0;
		c.gridy = 4;
		myBackgroundLabel.add(myStartButton, c);

		c.gridx = 0;
		c.gridy = 5;
		myBackgroundLabel.add(myGameInfo, c);

		c.gridx = 0;
		c.gridy = 1;
		myBackgroundLabel.add(myCompCardPanel, c);

		c.gridx = 0;
		c.gridy = 3;
		myBackgroundLabel.add(myPlayerCardPanel, c);

		c.gridx = 1;
		c.gridy = 2;
		myBackgroundLabel.add(myLabel, c);

		c.gridx = 0;
		c.gridy = 0;
		myBackgroundLabel.add(myPlayerInfo, c);

		c.gridx = 1;
		c.gridy = 0;
		myBackgroundLabel.add(myCPlayerInfo, c);

		this.associateListeners(controller);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
	}

	/**
	 * Associates each component's listener with the controller and the correct
	 * method to invoke when triggered.
	 *
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