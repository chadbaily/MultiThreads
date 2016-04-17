package model;

/**
 * Created by chadbaily on 4/12/16.
 */
public class ServiceQueue extends Queue
{
	private int myNumberCustomersServedSoFar;
	private int myNumberCustomersInLine;
	private int myTotalWaitTime;
	private long myTotalServiceTime;
	private long myTotalIdleTime;
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
		myTotalTime = myTotalTime + idle;
	}

	public void addToWaitTime(int wait)
	{
		myTotalWaitTime = myTotalWaitTime + wait;
	}

	public void addToSericeTime(long service)
	{
		myTotalServiceTime = myTotalServiceTime + service;
	}

	public Customer serveCustomer()
	{
		Customer c = (Customer) this.peek();
		this.dequeue();
		myNumberCustomersServedSoFar = myNumberCustomersServedSoFar + 1;
		return c;
	}

	/**
	 * Takes the total wait time and divides it by the amount of customers that have been served so far to get the average
	 *
	 * @return The average time waited by all customers who have been served so far
	 */
	public int averageWaitTime()
	{
		return myTotalWaitTime / this.getNumberCustomersServedSoFar();
	}

	/**
	 * Takes the total service time and divides it by the amount of customers that have been served so far to get the average
	 *
	 * @return The average service time of all customers who have been served so far
	 */
	public long averageServiceTime()
	{
		return myTotalServiceTime / this.getNumberCustomersServedSoFar();
	}

	/**
	 * Takes the toal idle time and divides it by the amount of customers that have been served so far to get the average
	 *
	 * @return The average idle time of all customers who have been served so far
	 */
	public long averageIdleTime()
	{
		return myTotalIdleTime / this.getNumberCustomersServedSoFar();
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

	public long getTotalServiceTime()
	{
		return myTotalServiceTime;
	}

	public long getTotalIdleTime()
	{
		return myTotalIdleTime;
	}

	public int getTotalTime()
	{
		return myTotalTime;
	}
}

