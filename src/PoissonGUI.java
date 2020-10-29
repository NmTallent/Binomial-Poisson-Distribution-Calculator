import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PoissonGUI extends Calculation implements ActionListener{

	private double poiAnswer = 0;

	private JFrame frame;
	private JPanel panel;
	private JLabel poiLabel;
	private JLabel averageRateOfSuccessLabel;
	private JLabel outcomeLabel1;
	private JLabel XLabel;
	private JLabel errorLabel;
	
	private JTextField averageRate;
	private JTextField xVal;
	private JButton calculateButton1;
	
	
	public PoissonGUI() {
		frame = new JFrame();
		panel = new JPanel();
		averageRate = new JTextField("");
		xVal = new JTextField("");

		poiLabel = new JLabel("Poisson Distribution");
		averageRateOfSuccessLabel = new JLabel("Average Rate of Success: ");

		errorLabel = new JLabel("Input error: Sample size, X val = Integer, Probability = decimal format < 1.");

		XLabel = new JLabel("X: ");
		calculateButton1 = new JButton("Calculate");
		calculateButton1.addActionListener(this);

		outcomeLabel1 = new JLabel("Outcome: " + poiAnswer * 100 + "%");

		frame.add(panel, BorderLayout.CENTER);
		
		frame.add(poiLabel, BorderLayout.PAGE_START);
		
		
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(500, 200));
		panel.add(averageRate);

		panel.add(xVal);
		panel.add(averageRateOfSuccessLabel);

		panel.add(XLabel);
		panel.add(outcomeLabel1);
		panel.add(errorLabel);
		errorLabel.setVisible(false);
		panel.add(calculateButton1);

		averageRate.setBounds(180,10,40,22);
		xVal.setBounds(180, 40, 40, 22);
		averageRateOfSuccessLabel.setBounds(20, 10, 170, 18);
		XLabel.setBounds(158, 40, 85, 18);
		outcomeLabel1.setBounds(300, 40, 130, 18);
		calculateButton1.setBounds(180, 130, 100, 18);
		errorLabel.setBounds(35, 150, 1000, 18);

		frame.setTitle("Poisson Distribution Calculator");
		frame.pack();
		frame.setLocationRelativeTo(null); // centers frame
		frame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			errorLabel.setVisible(false); // reset error label

			int averageInt = Integer.parseInt(averageRate.getText());
			int xValInt = Integer.parseInt(xVal.getText());
			
			if(xValInt < 0 || averageInt < 0){
				throw new IllegalArgumentException();
			}

			poiAnswer = PoissonCalculation(averageInt, xValInt);
			DecimalFormat df = new DecimalFormat("#.###"); // format to 3 decimal places
			df.setRoundingMode(RoundingMode.CEILING); // round up
			String roundedNum = df.format(poiAnswer); // convert poiAnswer to a string and format to 3 decimal places
			outcomeLabel1.setText(("Outcome: " + roundedNum + "%")); // update outcomeLabel
		} catch (Exception error) {
			errorLabel.setVisible(true); // display error label
		}
	}
}
