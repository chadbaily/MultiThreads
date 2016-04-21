package view_controller;

import model.*;

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
		ServiceQueueManager myServiceQueueManager;
		UniformCustomerGenerator myUniformCustomerGenerator;

		myServiceQueueManager = new ServiceQueueManager();
		myUniformCustomerGenerator = new UniformCustomerGenerator(500, myServiceQueueManager);


	}
}