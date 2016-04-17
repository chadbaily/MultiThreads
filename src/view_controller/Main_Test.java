package view_controller;

import model.Cashier;
import model.Customer;
import model.ServiceQueue;

/**
 * Created by Chad Baily on 4/14/2016.
 */
public class Main_Test
{
	public static void main(String[] args)
	{

		ServiceQueue myServiceQueue = new ServiceQueue();
		Cashier myCashier = new Cashier(1000, myServiceQueue);

		Customer myCustomer1 = new Customer();
		Customer myCustomer2 = new Customer();
		Customer myCustomer3 = new Customer();
		Customer myCustomer4 = new Customer();
		Customer myCustomer5 = new Customer();

		myServiceQueue.enqueue(myCustomer1);
		myServiceQueue.enqueue(myCustomer2);
		myServiceQueue.enqueue(myCustomer3);
		myServiceQueue.enqueue(myCustomer4);
		myServiceQueue.enqueue(myCustomer5);

		myCashier.start();
		myCashier.suspend();
		System.out.println("Did it!");

		//		myServiceQueue.dequeue();
		//		System.out.println(myServiceQueue.getNumberCustomersInLine());
	}
}