package view_controller;

public class MVCBasics
{
	// Properties
	private Controller myController;

	public MVCBasics()
	{
		setController(new Controller());
	}

	// Methods
	public static void main(String[] args)
	{
		new MVCBasics();
	}

	public Controller getController()
	{
		return myController;
	}

	public void setController(Controller controller)
	{
		myController = controller;
	}
}