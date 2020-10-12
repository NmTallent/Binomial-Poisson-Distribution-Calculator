import javax.swing.JTextField;

public class Calculation {
	
	public double BinomialCalculation(JTextField sampleSize, JTextField xVal, JTextField probability) {
		
		int sampleSizeInt = Integer.parseInt(sampleSize.getText());
		int xValInt = Integer.parseInt(xVal.getText());
		double probabilityVal = Double.parseDouble(probability.getText());
		
		int numCombinations = combination(sampleSizeInt,xValInt);
		
		double outcomeProbability = numCombinations * 
				(double)Math.pow(probabilityVal, xValInt) * Math.pow(1-probabilityVal, sampleSizeInt - xValInt);
		
		return outcomeProbability;
	}
	
	public static int combination(int n, int r) {
		if(r == 0 || n == r) {
			return 1;
		}else {
			return combination(n-1,r) + combination(n-1,r-1);
		}
	}
}
