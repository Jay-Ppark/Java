import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ConverterFrame extends JFrame
{
	private JLabel lblDistance;
	private JTextField txtKmDistance;
	private JButton btnCalculate;
	private JTextField txtMileDistance;
	
	public ConverterFrame()
	{
		super("Converter");
		lblDistance = new JLabel("Distance in Km");
		txtKmDistance = new JTextField(10);
		btnCalculate = new JButton("Calculate");
		txtMileDistance = new JTextField(50);
		txtMileDistance.setEditable(false);
		
		setLayout(new GridLayout(2, 2));
		this.add(lblDistance);
		this.add(txtKmDistance);
		this.add(btnCalculate);
		this.add(txtMileDistance);
		btnCalculate.addActionListener(new CalculateHandler());
	}
	
	public void showWindow()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 100);
		setVisible(true);
	}
	
	public class CalculateHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			double km = Double.parseDouble(txtKmDistance.getText());
			String ret = String.format("%.3f mile(s)", km * 0.621);
			txtMileDistance.setText(ret);
		}
		
	}
}
