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
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class GUI {
	
	
	private JFrame frame;
	private JPanel panel;
	private JLabel binLabel;
	private JLabel poiLabel;
	// GUI Constructor
	public GUI() {
		frame = new JFrame();
		panel = new JPanel();
		binLabel= new JLabel("Binomial Distribution");
		poiLabel = new JLabel("Poisson Distribution");
		
		panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		panel.setLayout(new GridLayout(1,1));
		panel.setPreferredSize(new Dimension(500,500));
		
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(binLabel, BorderLayout.PAGE_START);
		frame.add(poiLabel, BorderLayout.WEST);
		
		
		frame.setTitle("Binomial and Poisson Distribution Calculator");
		frame.pack();
		frame.setLocationRelativeTo(null); // centers frame
		frame.setVisible(true);
		
		System.out.println("Nick can you see the difference");
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUI();
	}

}
