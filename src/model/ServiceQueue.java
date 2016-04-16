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

	public ServiceQueue()
	{
		myNumberCustomersInLine = 0;
		myNumberCustomersServedSoFar = 0;
		myTotalIdleTime = 0;
		myTotalServiceTime = 0;
		myTotalWaitTime = 0;
		myTotalTime = 0;
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

	public int getNumberCustomersServedSoFar()
	{
		return myNumberCustomersServedSoFar;
	}

	public int getNumberCustomersInLine()
	{
		return myNumberCustomersInLine;
	}

	public int getTotalWaitTime()
	{
		return myTotalWaitTime;
	}

	public int getTotalServiceTime()
	{
		return myTotalServiceTime;
	}

	public int getTotalIdleTime()
	{
		return myTotalIdleTime;
	}

	public int getTotalTime()
	{
		return myTotalTime;
	}

	public void setNumberCustomersServedSoFar(int myNumberCustomersServedSoFar)
	{
		this.myNumberCustomersServedSoFar = myNumberCustomersServedSoFar;
	}

	public void setNumberCustomersInLine(int myNumberCustomersInLine)
	{
		this.myNumberCustomersInLine = myNumberCustomersInLine;
	}

	public void setTotalWaitTime(int myTotalWaitTime)
	{
		this.myTotalWaitTime = myTotalWaitTime;
	}

	public void setMyTotalServiceTime(int myTotalServiceTime)
	{
		this.myTotalServiceTime = myTotalServiceTime;
	}

	public void setTotalIdleTime(int myTotalIdleTime)
	{
		this.myTotalIdleTime = myTotalIdleTime;
	}

	public void setTotalTime(int myTotalTime)
	{
		this.myTotalTime = myTotalTime;
	}
}

