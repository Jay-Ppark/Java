import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ConverterFrame extends JFrame
{
	private JLabel labelDistance;
	private JTextField txtKmDistance;
	private JButton btnCalculate;
	private JTextField txtMileDistance;
	
	public ConverterFrame()
	{
		super("Converter");
		setLayout(new GridLayout(2,2));
		setSize(300, 100);
		this.add(labelDistance);
		this.add(txtKmDistance);
		this.add(btnCalculate);
		this.add(txtMileDistance);
		setVisible(true);
	}
}