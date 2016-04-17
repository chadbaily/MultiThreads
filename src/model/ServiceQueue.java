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

	public Customer serveCustomer()
	{
		Customer c = (Customer) this.peek();
		this.dequeue();
		myNumberCustomersServedSoFar = myNumberCustomersServedSoFar + 1;
		return c;
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
		return this.size();
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

	public void setNumberCustomersServedSoFar(int NumberCustomersServedSoFar)
	{
		this.myNumberCustomersServedSoFar = NumberCustomersServedSoFar;
	}

	public void setNumberCustomersInLine(int NumberCustomersInLine)
	{
		this.myNumberCustomersInLine = NumberCustomersInLine;
	}

	public void setTotalWaitTime(int TotalWaitTime)
	{
		this.myTotalWaitTime = TotalWaitTime;
	}

	public void setMyTotalServiceTime(int TotalServiceTime)
	{
		this.myTotalServiceTime = TotalServiceTime;
	}

	public void setTotalIdleTime(int TotalIdleTime)
	{
		this.myTotalIdleTime = TotalIdleTime;
	}

	public void setTotalTime(int TotalTime)
	{
		this.myTotalTime = TotalTime;
	}
}

