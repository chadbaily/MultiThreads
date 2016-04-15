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
	private int myTotalTime;

	public ServiceQueue(int myNumberCustomersServedSoFar, int myNumberCustomersInLine, int myTotalWaitTime,
			int myTotalServiceTime, int myTotalIdleTime, int myTotalTime)
	{
		this.myNumberCustomersServedSoFar = myNumberCustomersServedSoFar;
		this.myNumberCustomersInLine = myNumberCustomersInLine;
		this.myTotalWaitTime = myTotalWaitTime;
		this.myTotalServiceTime = myTotalServiceTime;
		this.myTotalIdleTime = myTotalIdleTime;
		this.myTotalTime = myTotalTime;
	}

	public ServiceQueue()
	{

	}

	public void addToTotalTime(int idle)
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

	public int getMyNumberCustomersInLine()
	{
		return myNumberCustomersInLine;
	}

	public int getMyTotalWaitTime()
	{
		return myTotalWaitTime;
	}

	public int getMyTotalServiceTime()
	{
		return myTotalServiceTime;
	}

	public int getMyTotalIdleTime()
	{
		return myTotalIdleTime;
	}

	public int getMyTotalTime()
	{
		return myTotalTime;
	}
}

