package Mall;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.Semaphore;
public class Customer extends Thread{
	public static int triocounter = 0;
	int customernum;//sets up for identifying each customer
	public static long time = System.currentTimeMillis();//to display the time for messages
	public void msg(String m) {//the message function shown in the project
		System.out.println("["+(System.currentTimeMillis()-time)+"] "+getName()+": "+m);
	}
	public Customer(int custnum) {
		setName("Customer- " + custnum+1);
		this.customernum=custnum+1;
	}
	public int getcustomernum() {
		return this.customernum;
	}
	public void run() {
		gotomall();
		Mall.v(Mall.Customercount);
		msg("ending customer " + getcustomernum());
	}
	
		
	
	public void gotomall() {
		Random random = new Random();//making random for this class
		try {
			sleep(random.nextInt(2000));//chooses when customer enters the mall
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		msg("arrived at the mall");
		if (random.nextInt(10)+1 <4) {
			msg("has returns");
try {
	Mall.returns.acquire();
	msg("Returning items");
} catch (InterruptedException e) {
	e.printStackTrace();
}	

}
		try {
			sleep(random.nextInt(5000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Mall.p(Mall.checkout);
		try {
			sleep(random.nextInt(5000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		msg("checkout complete");
		CheckoutClerk.num_selfcheckoutsavailable++;
		try {
			sleep(random.nextInt(5000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		msg("waiting to leave");
		if(triocounter>0||triocounter%3!=0)
		p(Mall.trio);
		v(Mall.trio);
	}
	public void p(Semaphore s) {
		try {
			Mall.trio.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		triocounter++;
	}
	public void v(Semaphore s) {
	
			Mall.trio.release();
			
		
	}
}
