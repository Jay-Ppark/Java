import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloWorldGUI
{

	public static void main(String[] args)
	{
		// Set up the window
		JFrame frame = new JFrame();
		frame.setTitle("Java Windows");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Add a label
		JLabel label = new JLabel("Hello World!");
		frame.getContentPane().add(label);
		
		// Show the window
		frame.setSize(300, 100);
		frame.setVisible(true);
	}
}
