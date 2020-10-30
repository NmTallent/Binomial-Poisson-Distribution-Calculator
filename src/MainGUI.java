/*
 * @Author: Nick Tallent & Landon Leigh
 * @Version 1.0
 * 
 * Date: 10/10/2020
 * 
 *  ** FINISHED 10/29/2020 **
 *  
 * Description: This program calculates a Binomial distribution or Poisson distribution.
 * A GUI will appear when the program is executed and allow for the user to select to input data for
 * a Binomial Distribution or a Poisson Distribution then another GUI will appear for either type of distribution.
 */

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainGUI implements ActionListener {

	private JFrame frame;
	private JPanel panel;
	private JButton binButton;
	private JButton poiButton;

	public MainGUI() {
		frame = new JFrame();
		panel = new JPanel();
		panel.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		binButton = new JButton("Binomial Probability Calculator");
		poiButton = new JButton("Poisson Probability Calculator");
		frame.add(panel);
		panel.add(binButton);
		panel.add(poiButton);

		panel.setPreferredSize(new Dimension(500, 400));
		binButton.setBounds(130, 75, 250, 100);
		poiButton.setBounds(130, 200, 250, 100);

		binButton.addActionListener(this);
		poiButton.addActionListener(this);

		frame.setTitle("Select Binomial or Poisson Calculator");
		frame.pack();
		frame.setLocationRelativeTo(null); // centers frame
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainGUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == binButton)
			new BinomialGUI();
		if (e.getSource() == poiButton)
			new PoissonGUI();
	}

}
