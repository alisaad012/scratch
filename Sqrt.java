public class Sqrt {

    static final int ERROR = -13;

    public static double[] mid_sqrt(double NUM) {
	double low = 0;
	double high = NUM;
	double ans = (low + high) / 2.0;
	double guess = ans * ans;
	int guesses = 1;
	while(Math.abs(guess - NUM) > Math.pow(10, ERROR)) {
	    if (guess < NUM) {
		low = (low + ans) / 2.0;
	    }
	    else {
		high = (high + ans) / 2.0;
	    }
	    ans = (low + high) / 2.0;
	    guess = ans * ans;
	    guesses++;
	}
	return new double[] {ans, (double) guesses};
    }

    public static double[] quot_sqrt(double NUM) {
	double ans = 1.0;
	double quotient = NUM / ans;
	int guesses = 1;
	while(Math.abs(ans * ans - NUM) > Math.pow(10, ERROR)) {
	    ans = (ans + quotient) / 2.0;
	    quotient = NUM / ans;
	    guesses++;
	}
	return new double[] {ans, (double) guesses};
    }

    public static void mid_sqrt_print(double NUM) {
	double [] returned = mid_sqrt(NUM);
	System.out.printf("~ Midpoint Square Root Method ~%n");
	System.out.printf("\tThe square root of %f is %." + (-1 * ERROR - 1) + "f. (%d guesses)%n", NUM, returned[0], (int) returned[1]);
    }

    public static void quot_sqrt_print(double NUM) {
	double [] returned = quot_sqrt(NUM);
	System.out.printf("~ Quotient Square Root Method ~%n");
	System.out.printf("\tThe square root of %f is %." + (-1 * ERROR - 1) + "f. (%d guesses)%n", NUM, returned[0], (int) returned[1]);
    }

    public static void pow_sqrt_print(double NUM) {
	double ans = Math.pow(NUM, 0.5);
	System.out.printf("~ 0.5 Exponent Square Root Method ~%n");
	System.out.printf("\tThe square root of %f is %f.%n", NUM, ans);
    }

    public static void def_sqrt_print(double NUM) {
	double ans = Math.sqrt(NUM);
	System.out.printf("~ Default Square Root Method ~%n");
	System.out.printf("\tThe square root of %f is %f.%n", NUM, ans);
    }

    public static void sqrt(double NUM) {
	System.out.printf("===== %f =====%n", NUM);
	mid_sqrt_print(NUM);
	quot_sqrt_print(NUM);
	pow_sqrt_print(NUM);
	def_sqrt_print(NUM);
	System.out.println();
    }

    public static void main(String[] args) {
	System.out.println();
	for(int c = 0; c < args.length; c++) {
	    try {
		double NUM = Double.parseDouble(args[c]);
		sqrt(NUM);
	    }
	    catch (NumberFormatException ex) {
		System.out.printf("%s is not a number%n%n", args[c]);
	    }
	}
    }

}
