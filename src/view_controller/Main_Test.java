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

		myServiceQueue.insertCustomer(myCustomer1);
		myServiceQueue.insertCustomer(myCustomer2);
		myServiceQueue.insertCustomer(myCustomer3);
		myServiceQueue.insertCustomer(myCustomer4);
		myServiceQueue.insertCustomer(myCustomer5);

		myCashier.start();

		//		myServiceQueue.dequeue();
		//		System.out.println(myServiceQueue.getNumberCustomersInLine());
	}
}