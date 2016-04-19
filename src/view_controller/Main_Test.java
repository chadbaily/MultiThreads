package view_controller;

import model.Customer;
import model.ServiceQueue;
import model.UniformCashier;

import java.util.Scanner;
import java.util.Vector;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

/**
 * Created by Chad Baily on 4/14/2016.
 */
public class Main_Test
{
	public static void main(String[] args)
	{
		int myNumCustomers;
		int myNumCashiers;
		UniformCashier myUniformCashier;
		ServiceQueue myServiceQueue;
		Customer customer;
		Vector<Customer> myCustomers;
		Vector<UniformCashier> myCashiers;

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
		for (int i = 0; i < myNumCashiers; i++)
		{
			myUniformCashier = new UniformCashier(500, myServiceQueue);
			myCashiers.add(myUniformCashier);
			myCashiers.get(i).start();
		}




	}
}