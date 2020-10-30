
public class Calculation {

	/*
	 * This method takes the sample size, X value in question, and the probability.
	 * Returns the result of the binomial distribution formula nCr * p^x * (1-p)^n-x
	 */
	public double BinomialCalculation(int sampleSize, int xVal, double probability) {

		int numCombinations = combination(sampleSize, xVal);

		double outcomeProbability = numCombinations * (double) Math.pow(probability, xVal)
				* Math.pow(1 - probability, sampleSize - xVal);

		return outcomeProbability * 100; // convert to percentage
	}

	public double PoissonCalculation(int averageRateOfSuccess, int xVal) {
		return (Math.pow(Math.E, -averageRateOfSuccess) * (Math.pow(averageRateOfSuccess, xVal)))
				/ (double) factorial(xVal) * 100;
	}

	// This method calculates the number of possible combinations, otherwise known
	// as nCr
	public static int combination(int n, int r) {
		if (r == 0 || n == r) {
			return 1;
		} else {
			return combination(n - 1, r) + combination(n - 1, r - 1);
		}
	}

	public static int factorial(int x) {
		if (x == 1) {
			return 1;
		} else {
			return x * factorial(x - 1);
		}
	}
}
