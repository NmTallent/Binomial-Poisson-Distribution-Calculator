import javax.swing.JTextField;

public class Calculation {
	
	public double BinomialCalculation(JTextField sampleSize, JTextField xVal, JTextField probability) {
		
		int sampleSizeInt = Integer.parseInt(sampleSize.getText());
		int xValInt = Integer.parseInt(xVal.getText());
		double probabilityVal = Double.parseDouble(probability.getText());
		
		int NcR = factorial(sampleSizeInt)/(factorial(sampleSizeInt-xValInt)*factorial(xValInt));
		
		return NcR * Math.pow(probabilityVal, xValInt) * Math.pow(1-probabilityVal, sampleSizeInt - xValInt);
	}
	
	public static int factorial(int x) {
		if(x == 0) {
			return 1;
		}else {
			return (x * factorial(x-1));
		}
	}
}
