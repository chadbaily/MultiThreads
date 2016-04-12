package model;

/**
 * Created by chadbaily on 4/12/16.
 */
public class ServiceQueue extends Queue
{
	private int myNumberCustomersServedSoFar;
	private int myNumberCustomersInLine;
	private int myTotalWaitTime;
	private int myTotalServiceTime;
	private int myTotalIdleTime;

	public ServiceQueue()
	{

	}

	public void addToElapsedTime(int elapsed)
	{

	}

	public void addToToggleTime(int idle)
	{

	}

	public void addToWaitTime(int wait)
	{

	}

	public void addToSericeTime(int service)
	{

	}

	public Customer serveCustomer(Customer customer)
	{
		return null;
	}

	public int averageWaitTime()
	{
		return 0;
	}

	public int averageServiceTime()
	{
		return 0;
	}

	public int averageIdleTime()
	{
		return 0;
	}

	public int getMyNumberCustomersServedSoFar()
	{
		return myNumberCustomersServedSoFar;
	}
}

