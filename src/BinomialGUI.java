

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

public class BinomialGUI extends Calculation implements ActionListener {

	private double binAnswer = 0;
	private JFrame frame;
	private JPanel panel;
	private JLabel binLabel;
	private JLabel sampleSizeLabel;
	private JLabel probabilityLabel;
	private JLabel outcomeLabel1;
	private JLabel XLabel;
	private JLabel errorLabel;
	private JTextField sampleSize;
	private JTextField binProbability;
	private JTextField xVal;
	private JButton calculateButton1;

	// GUI Constructor
	public BinomialGUI() {
		frame = new JFrame();
		panel = new JPanel();
		sampleSize = new JTextField("");
		binProbability = new JTextField("");
		xVal = new JTextField("");

		binLabel = new JLabel("Binomial Distribution");
		sampleSizeLabel = new JLabel("Sample size: ");
		probabilityLabel = new JLabel("Probability: ");
		errorLabel = new JLabel("Input error: Sample size, X val = Integer, Probability = decimal format < 1.");

		XLabel = new JLabel("X: ");
		calculateButton1 = new JButton("Calculate");
		calculateButton1.addActionListener(this);

		outcomeLabel1 = new JLabel("Outcome: " + binAnswer * 100 + "%");

		frame.add(panel, BorderLayout.CENTER);

		frame.add(binLabel, BorderLayout.PAGE_START);

		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(500, 200));
		panel.add(sampleSize);
		panel.add(binProbability);
		panel.add(xVal);
		panel.add(sampleSizeLabel);
		panel.add(probabilityLabel);
		panel.add(XLabel);
		panel.add(outcomeLabel1);
		panel.add(errorLabel);
		errorLabel.setVisible(false);
		panel.add(calculateButton1);

		sampleSize.setBounds(100, 10, 40, 20);
		binProbability.setBounds(100, 40, 40, 20);
		xVal.setBounds(100, 70, 40, 20);
		sampleSizeLabel.setBounds(20, 10, 85, 18);
		probabilityLabel.setBounds(28, 40, 85, 18);
		XLabel.setBounds(81, 70, 85, 18);
		outcomeLabel1.setBounds(300, 40, 130, 18);
		calculateButton1.setBounds(180, 130, 100, 18);
		errorLabel.setBounds(35, 150, 1000, 18);

		frame.setTitle("Binomial Distribution Calculator");
		frame.pack();
		frame.setLocationRelativeTo(null); // centers frame
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// try catch checks for input errors and displays error message if needed.
		try {
			errorLabel.setVisible(false); // reset error label

			int sampleSizeInt = Integer.parseInt(sampleSize.getText());
			int xValInt = Integer.parseInt(xVal.getText());
			double probabilityVal = Double.parseDouble(binProbability.getText());
			if (probabilityVal < 0 || probabilityVal > 1 || sampleSizeInt < xValInt) {
				throw new IllegalArgumentException();
			}
			binAnswer = BinomialCalculation(sampleSizeInt, xValInt, probabilityVal);
			DecimalFormat df = new DecimalFormat("#.###"); // format to 3 decimal places
			df.setRoundingMode(RoundingMode.CEILING); // round up
			String roundedNum = df.format(binAnswer); // convert binAnswer to a string and format to 3 decimal places
			outcomeLabel1.setText(("Outcome: " + roundedNum + "%")); // update outcomeLabel
		} catch (Exception error) {
			errorLabel.setVisible(true); // display error label
		}
	}
}
