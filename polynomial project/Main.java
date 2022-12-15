
public class Main {
	
	public static void main(String[] args) {
		double [] ff = {3,2,2};
		Polynomial l = new Polynomial(ff);
		double [] yy = {2,2,2};
		Polynomial m = new Polynomial(yy);
		//l.Multiply(m);
		
		Polynomial n = new Polynomial (l.Product(m));
		
		System.out.println(n.evaluate(5));
		
		
		n=(l.Diff(m));
		System.out.println(n.evaluate(5));
		
		n = new Polynomial(l.Sum(m));
		System.out.println(n.evaluate(5));
	
			}
	
		
	}


