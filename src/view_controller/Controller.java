package view_controller;

/**
 * Controller for the PokerModel game, has three main methods, start, discard, and border. Controls the view for the
 * PokerModel
 *
 * @author chadbaily
 */
public class Controller
{
	///////////////////
	// Properties //
	///////////////////
	public View myView;

	/**
	 * Controller constructor; view must be passed in since controller has responsibility to notify view when some event
	 * takes place.
	 */
	public Controller()
	{
		myView = new View(this);
	}

}