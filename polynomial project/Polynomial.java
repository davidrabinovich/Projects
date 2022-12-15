public class Polynomial {
	private double[] coeff;
	private int deg;

	public Polynomial(double[] coeff) // constructor method
	{
		this.coeff = coeff;
		deg = degree();
	}

	public Polynomial(Polynomial b) {
		this.coeff = b.coeff;
		this.deg = b.deg;
	}

	public Polynomial() {
		this.coeff = null;
		this.deg = 0;
	}

	public int degree() {
		int deg = coeff.length - 1; // deg = length-1 because there's always one less degree than coefficients
									// because of the 0 degree
		return deg;
	}

	public int getdeg() // simple get method for the degree
	{
		return deg;
	}

	public int evaluate(int x) // method to evaluate a polynomial given x
	{
		int value = 0; // final value that you will return
		int co = 0;// since coefficients go from highest degree to lowest, start at 0 because thats
					// the highest degree
		for (int j = deg; j >= 0; j--) // since coefficient is stating at 0, which is the coefficient for highest
										// degree, start with the highest degree
		{
			value += coeff[co] * power(x, j);// adds every degree together
			co++;
		}

		return value;
	}

	public int power(int x, int j) { // method to find the power of a given variable and exponent
		int y = 1;
		for (int i = j; i > 0; i--) {
			y *= x;
		}
		return y;
	}

	public void Add(Polynomial b) {// adds a polynomial to our current polynomial
		Polynomial a = this;
		if (a.deg == b.deg) { // if they are the same degree simply add them
			for (int i = 0; i < coeff.length; i++) {
				a.coeff[i] = a.coeff[i] + b.coeff[i]; // t
			}
		} else if (a.deg > b.deg) { // if they aren't the same, if a is bigger find out how much bigger
			int x = a.deg - b.deg;
			for (int i = 0; i < b.coeff.length; i++) {
				a.coeff[i + x] = a.coeff[i + x] + b.coeff[i]; // once you know how much bigger a is, the coefficients
																// for degrees > b stay the same and add the other
																// coefficients
			}
		} else {// same as step two but switch a and b
			Polynomial temp = new Polynomial(a.coeff);
			a.coeff = b.coeff;
			a.deg = degree();
			int x = a.deg - temp.deg;
			for (int i = 0; i < temp.coeff.length; i++) {
				a.coeff[i + x] = a.coeff[i + x] + temp.coeff[i];
			}
		}

	}

	public void Subtract(Polynomial b) {// same thing as finding the sum but subtracting instead of adding
		Polynomial a = this;
		if (a.deg == b.deg) {
			for (int i = 0; i < coeff.length; i++) {
				a.coeff[i] = a.coeff[i] - b.coeff[i];
			}
		} else if (a.deg > b.deg) {
			int x = a.deg - b.deg;
			for (int i = 0; i < b.coeff.length; i++) {
				a.coeff[i + x] = a.coeff[i + x] - b.coeff[i];
			}
		} else {
			Polynomial temp = new Polynomial(a.coeff);
			a.coeff = b.coeff;
			a.deg = degree();
			int x = temp.deg - temp.deg;
			for (int i = 0; i < temp.coeff.length; i++) {
				a.coeff[i + x] = temp.coeff[i] - b.coeff[i + x];
			}
			for (int i = 0; i < x; i++) {
				a.coeff[i] *= -1;// if b is bigger the bigger coefficients all have to be negated
			}

		}

	}

	public void Scale(int t) {// for each coefficient, multiply it with the scaler
		Polynomial a = this;
		for (int i = 0; i < coeff.length; i++) {
			a.coeff[i] *= t;
		}
	}

	public void Multiply(Polynomial b) {// hardest part by far start by creating an array one less than the two
										// polynomials lengths added together
		Polynomial a = this;
		Polynomial temp = new Polynomial(a.coeff);
		double[] mult = new double[(a.coeff.length + b.coeff.length) - 1];
		for (int i = 0; i < a.coeff.length; i++)
			for (int j = 0; j < b.coeff.length; j++) {
				mult[i + j] += temp.coeff[i] * b.coeff[j];// in the loop, multiply the coefficients together and if
															// there are still coefficients with the same degree add
															// them together

			}
		a.coeff = mult;
		a.deg = degree();

	}

	public Polynomial Sum(Polynomial b) {// same as add, but create a new polynomial to store the answer in
		Polynomial a = this;
		double[] sum = new double[(a.coeff.length)];
		Polynomial c = new Polynomial(a.coeff);
		if (a.deg == b.deg) {
			for (int i = 0; i < coeff.length; i++) {
				sum[i] = a.coeff[i] + b.coeff[i];
			}
		} else if (a.deg > b.deg) {
			int x = a.deg - b.deg;
			for (int i = 0; i < b.coeff.length; i++) {
				sum[i + x] = a.coeff[i + x] + b.coeff[i];
			}
		} else {
			Polynomial temp = new Polynomial(a.coeff);
			a.coeff = b.coeff;// switch the new polynomial instead of a
			a.deg = degree();
			int x = temp.deg - a.deg;
			for (int i = 0; i < temp.coeff.length; i++) {
				sum[i + x] = temp.coeff[i + x] + a.coeff[i];
			}
		}
		c.coeff = sum;
		c.deg = sum.length - 1;
		return c;
	}

	public Polynomial Diff(Polynomial b) {// same as the sum but with subtraction
		Polynomial a = this;
		double[] diff = new double[(a.coeff.length)];
		Polynomial c = new Polynomial(a.coeff);
		if (a.deg == b.deg) {
			for (int i = 0; i < coeff.length; i++) {
				diff[i] = a.coeff[i] - b.coeff[i];
			}
		} else if (a.deg > b.deg) {
			int x = a.deg - b.deg;
			for (int i = 0; i < b.coeff.length; i++) {
				diff[i + x] = a.coeff[i + x] - b.coeff[i];
			}
		} else {
			Polynomial temp = new Polynomial(a);
			a.coeff = b.coeff;
			a.deg = b.deg;
			int x = c.deg - a.deg;
			for (int i = 0; i < a.coeff.length; i++) {
				diff[i + x] = temp.coeff[i] - a.coeff[i + x];
			}
			for (int i = 0; i < x; i++) {
				diff[i] *= -1;
			}

		}
		c.coeff = diff;
		c.deg = diff.length - 1;
		return c;
	}

	public Polynomial Product(Polynomial b) {// same as multiply but storing it in a new polynomial c
		Polynomial a = this;
		Polynomial c = new Polynomial(a.coeff);
		double[] mult = new double[(a.coeff.length + b.coeff.length) - 1];
		for (int i = 0; i < a.coeff.length; i++)
			for (int j = 0; j < b.coeff.length; j++) {
				mult[i + j] += a.coeff[i] * b.coeff[j];
			}
		c.coeff = mult;
		c.deg = mult.length - 1;
		return c;

	}

}
