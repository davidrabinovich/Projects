package Mall;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;



public class Mall {
	public static long time = System.currentTimeMillis();
	   public static CheckoutClerk checkoutclerk;
	   public static Clerk [] clerk;
	   public static Customer [] customer;
	   public static Queue arrival_queue=new LinkedList();   
	   public static Semaphore returns = new Semaphore (0, true);
	   public static Semaphore Customercount = new Semaphore (-15, true);
	   public static Semaphore checkout = new Semaphore (0,true);
	   public static Semaphore trio = new Semaphore(0,true);
	public static int returnval = 0;
	public static int checkutval = 0;
	public static int customercount = -15;
	public static void main(String[] args) {
	    try{
	    	
	    	  checkoutclerk = new CheckoutClerk(1);
	    	 customer = new Customer [15];
	    	 clerk = new Clerk[2];
	    	 //checkout_list = new Boolean[];
	    	 
	    	 for (int i =0;i<15;i++) {
	    		 customer[i] = new Customer(i);
	    	 }
	    	 for(int i = 0;i<2;i++)
	    		 clerk[i] = new Clerk(i);
	    	 
	    	 for (int i =0;i<15;i++) {
	    		
	    		 customer[i].start();
	    	 }
	    	 for(int i = 0;i<2;i++)
	    	clerk[i].start();
	    	checkoutclerk.start();
	    }
	    catch(Exception e){
	        e.printStackTrace();
	     }
	}
	   public static void p(Semaphore s) {
		  try {
			s.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	   }
	   public static void v(Semaphore s) {
			if (s.availablePermits() <0)
		s.release();
			
		}
	   }

