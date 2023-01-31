package Mall;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.Semaphore;
public class Clerk extends Thread {
	public int clerknum;
	Random r = new Random();
		public static long time = System.currentTimeMillis();
		public  void msg(String m) {
			System.out.println("["+(System.currentTimeMillis()-time)+"] "+getName()+": "+m);
		}
		public Clerk(int clerknum) {
			setName("Clerk- " + clerknum+1);
			this.clerknum=clerknum+1;
		}
public void run() {
while(Mall.Customercount.availablePermits()<0) {
Mall.returns.release();
try {
	sleep(r.nextInt(3000));
} catch (InterruptedException e) {
	e.printStackTrace();
}
	}
msg("no more customers, leaving store");
}
public static void v(Semaphore s) {
	if (s.availablePermits() <0) {
		
s.release();
	//msg("returns complete");
}}

}

