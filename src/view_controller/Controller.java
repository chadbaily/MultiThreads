package view_controller;

import model .*;


/**
 * Sample Queue MVC with threading
 *
 */
public class Controller implements Runnable
{
	//Data Members
	private ServiceQueueManager myModel;
	private View myView;
	private boolean mySuspended;
	private Thread myThread;
	private UniformCustomerGenerator myUniformCustomerGenerator;
	
	/**
	 * Basic Constructor
	 */
	public Controller()
	{
		myModel = new ServiceQueueManager();
		myView = new View(this);
        myThread = new Thread(this);
		mySuspended = false;
//		myUniformCustomerGenerator = new UniformCustomerGenerator(myView.get );
		this.start();
		this.startPause();
	}
			
	/**
	 * Displays the customer images in the appropriate lines.
	 * index The queue index for the customers to be printed in.
	 * @param
	 */
	private void displayCustomers(int queue)
	{
		int numInQueue = myModel.getNumCustomers(queue);

		myView.setCustomersInLine(queue, numInQueue);
	}
			
	/**
	 * Runs the thread that updates the view.
	 */
    public void run()
    {
    	try
    	{
    		synchronized(this)
    		{
    			this.updateView();
    		}
    	}
    	catch (InterruptedException e)
    	{
    		System.out.println("Thread suspended.");
    	}
    }
	
	/**
	 * Updates the view.
	 * @throws InterruptedException
	 */
	private void updateView()throws InterruptedException
	{
		while(true)
		{
			this.waitWhileSuspended();
			
			try 
			{
				Thread.sleep(200);
				for(int x = 0; x < 2; x++)
				{
					this.displayCustomers(x);
				}
			} 
			catch (InterruptedException e) 
			{
					e.printStackTrace();
			}
		}
	}
    
    private void waitWhileSuspended() throws InterruptedException
    {
    	while (mySuspended)
    	{
    		this.wait();
    	}
    }
    
    public void suspend()
    {
    	mySuspended = true;
    }
    
    public void start()
    {
        try
        {
            myThread.start();
        }
        catch(IllegalThreadStateException e)
        {
            System.out.println("Thread already started");
        }
    }
    
    public synchronized void resume()
    {
    	mySuspended = false;
    	this.notify();
    }
    
    public void startPause()
    {
    	myView.changeStartPause();
    	if (mySuspended)
    	{
    		this.resume();
    	}
    	else
    	{
    		this.suspend();
    	}
    }

	public static void main(String[] args)
	{
		new Controller();
	}
}