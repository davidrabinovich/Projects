package Mall;

public class CheckoutClerk extends Thread{
	
		public int checkout_clerknum;
		public static int num_selfcheckoutsavailable = 3;
		public static long time = System.currentTimeMillis();
	public void msg(String m) {
		System.out.println("["+(System.currentTimeMillis()-time)+"] "+getName()+": "+m);
	}
	public CheckoutClerk(int checkout_clerknum) {
		setName("Checkout_clerk- " + checkout_clerknum);
		this.checkout_clerknum=checkout_clerknum;
	}
	public void run() {
		while(Mall.Customercount.availablePermits()<0) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
if(num_selfcheckoutsavailable >0) {
	
		num_selfcheckoutsavailable--;
		Mall.checkout.release();
		msg("checked out customer ");
		try {
			sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
	
		msg("no more customers, clerk is leaving");

}
}
