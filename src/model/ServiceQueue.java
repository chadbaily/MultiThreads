package model;

/**
 * Created by chadbaily on 4/12/16.
 */
public class ServiceQueue extends Queue
{
	private int myNumberCustomersServedSoFar;
	private int myNumberCustomersInLine;
	private long myTotalWaitTime;
	private long myTotalServiceTime;
	private long myTotalIdleTime;
	private int myTotalTime;

	public ServiceQueue()
	{
		myNumberCustomersInLine = this.size();
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

	/**
	 * Method that takes in a customer, sets their enrty time, then adds them to the queue
	 *
	 * @param customer
	 */
	public void insertCustomer(Customer customer)
	{
		customer.setEntryTime(System.currentTimeMillis());
		this.enqueue(customer);
	}

	/**
	 * Method that sets the wait time for the customer by using their enrty time - the current time. They are then dequeued
	 * and the proper methods are updated to show that a customer has been served
	 *
	 * @return the customer that was served
	 */
	public Customer serveCustomer()
	{
		Customer c = (Customer) this.peek();
		((Customer) this.peek()).setWaitTime(System.currentTimeMillis() - c.getEntryTime());
		myTotalWaitTime = myTotalWaitTime + ((Customer) this.peek()).getWaitTime();
		myTotalServiceTime = myTotalServiceTime + ((Customer) this.peek()).getServiceTime();
		//Delete me later
		System.out.println("Wait Time: " + ((Customer) this.peek()).getWaitTime());
		this.dequeue();
		myNumberCustomersServedSoFar = myNumberCustomersServedSoFar + 1;
		myNumberCustomersInLine = this.size();
		//Delete me later
		System.out.println("Average Wait Time: " + this.averageWaitTime());
		System.out.println("Average Service Time: " + this.averageServiceTime());

		return c;
	}

	/**
	 * Takes the total wait time and divides it by the amount of customers that have been served so far to get the average
	 *
	 * @return The average time waited by all customers who have been served so far
	 */
	public long averageWaitTime()
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

	public long getTotalWaitTime()
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

