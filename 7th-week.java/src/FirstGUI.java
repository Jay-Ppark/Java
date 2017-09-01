import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class FirstGUI {

	public static void main(String[] args) {
	JFrame object = new JFrame("This is our first GUI");
	object.setVisible(true);
	object.setSize(300, 300);
	object.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	GridLayout layout = new GridLayout(1,2);
	object.setLayout(layout);
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	object.add(panel1);
	object.add(panel2);
	panel1.setLayout(new FlowLayout());
	panel2.setLayout(new GridLayout(2,2));
	
	
	JButton x = new JButton("click");
	panel1.add(x);
	x.setForeground(Color.red);
	x.setBackground(Color.green);
	
	JButton y = new JButton();
	y.setText("y click");
	panel2.add(y);
	JButton y2 = new JButton();
	y2.setText("y2 click");
	panel2.add(y2);
	JButton y3 = new JButton();
	y3.setText("y3 click");
	panel2.add(y3);
	 
	y3.addActionListener(new FirstGUI().new dosommthing());
	y2.addActionListener(new FirstGUI().new dosommthing1()); 
	
	
	}
	

	private class dosommthing implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("You clicked on Y3 button");
			
		}
		}
	private	class dosommthing1 implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("You clicked on Y2 button");
				
			}	
		
		
	}


}

