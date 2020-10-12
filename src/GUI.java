/*
 * @Author: Nick Tallent & Landon Leigh
 * @Version 1.0
 * 
 * Date: 10/10/2020
 * 
 *  ** WORK IN PROGRESS **
 *  
 * Description: This program calculates a Binomial distribution or Poisson distribution.
 * A GUI will appear when the program is executed and allow for the user to select to input data for
 * a Binomial Distribution or a Poisson Distribution.
 */



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

public class GUI extends Calculation implements ActionListener{
	
	private double binAnswer = 0;
	private double poiAnswer = 0;

	private JFrame frame;
	private JPanel panel;
	private JLabel binLabel;
	private JLabel poiLabel;
	private JLabel sampleSizeLabel;
	private JLabel probabilityLabel;
	private JLabel outcomeLabel1;
	private JLabel XLabel;
	private JTextField sampleSize;
	private JTextField binProbability;
	private JTextField xVal;
	private JButton calculateButton1;
	
	// GUI Constructor
	public GUI() {
		frame = new JFrame();
		panel = new JPanel();
		sampleSize = new JTextField("");
		binProbability = new JTextField("");
		xVal = new JTextField("");
		
		binLabel= new JLabel("Binomial Distribution");
		poiLabel = new JLabel("Poisson Distribution");
		sampleSizeLabel = new JLabel("Sample size: ");
		probabilityLabel = new JLabel("Probability: ");
		
		XLabel = new JLabel("X: ");
		calculateButton1 = new JButton("Calculate");
		calculateButton1.addActionListener(this);
	
		outcomeLabel1 = new JLabel("Outcome: " + binAnswer*100 + "%");
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(binLabel, BorderLayout.PAGE_START);
		frame.add(poiLabel, BorderLayout.WEST);
		
		panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(500,400));
		panel.add(sampleSize);
		panel.add(binProbability);
		panel.add(xVal);
		panel.add(sampleSizeLabel);
		panel.add(probabilityLabel);
		panel.add(XLabel);
		panel.add(outcomeLabel1);
		panel.add(calculateButton1);
		
		sampleSize.setBounds(100,10,40,20);
		binProbability.setBounds(100,40,40,20);
		xVal.setBounds(100,70,40,20); 
		sampleSizeLabel.setBounds(20, 10, 85, 18);
		probabilityLabel.setBounds(28, 40, 85, 18);
		XLabel.setBounds(81, 70, 85, 18);
		outcomeLabel1.setBounds(300,40,130,18);
		calculateButton1.setBounds(160,130,100,18);
		
		
		frame.setTitle("Binomial and Poisson Distribution Calculator");
		frame.pack();
		frame.setLocationRelativeTo(null); // centers frame
		frame.setVisible(true);
		
		
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUI();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		binAnswer = BinomialCalculation(sampleSize, xVal, binProbability) * 100; // convert to percentage
		DecimalFormat df = new DecimalFormat("#.###"); // format to 3 decimal places
		df.setRoundingMode(RoundingMode.CEILING); // round up
		String roundedNum = df.format(binAnswer); // convert binAnswer to a string and format to 3 decimal places
		outcomeLabel1.setText(("Outcome: " + roundedNum + "%")); // update outcomeLabel
	}

}
