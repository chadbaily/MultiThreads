package view_controller;

import model.Cashier;
import model.Customer;
import model.ServiceQueue;

import java.util.Scanner;
import java.util.Vector;

/**
 * Created by Chad Baily on 4/14/2016.
 */
public class Main_Test
{
	public static void main(String[] args)
	{
		int myNumCustomers;
		int myNumCashiers;
		Cashier myCashier;
		ServiceQueue myServiceQueue;
		Customer customer;
		Vector<Customer> myCustomers;
		Vector<Cashier> myCashiers;

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the amount of Cashiers and Customers");
		myNumCashiers = scan.nextInt();
		myNumCustomers = scan.nextInt();

		myServiceQueue = new ServiceQueue();
		myCustomers = new Vector<>();
		myCashiers = new Vector<>();

		//Making x customers
		for (int i = 0; i < myNumCustomers; i++)
		{
			customer = new Customer();
			myCustomers.add(customer);
			myServiceQueue.insertCustomer(customer);
		}

		//Making x Cashiers
		for(int i =0; i < myNumCashiers; i++)
		{
			myCashier = new Cashier(500, myServiceQueue);
			myCashiers.add(myCashier);
			myCashiers.get(i).start();
		}

		//		myServiceQueue.dequeue();
		//		System.out.println(myServiceQueue.getNumberCustomersInLine());
	}
}