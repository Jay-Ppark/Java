import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExceptionFrame extends JFrame {

	private JPanel contentPane;
	private JPanel pnInput;
	private JPanel pnDisplay;
	private JLabel lblInput;
	private JTextField txtInputField;
	private JLabel lblNumber;
	private JTextField txtNumber;
	private JLabel lblIndex;
	private JTextField txtIndex;
	private JLabel lblArray;

	private int index;
	private int array[];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExceptionFrame frame = new ExceptionFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ExceptionFrame() {

		index = 0;
		array = new int[10];

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		pnInput = new JPanel();
		contentPane.add(pnInput, BorderLayout.CENTER);
		pnInput.setLayout(new GridLayout(3, 2, 0, 0));

		lblInput = new JLabel("              Input number of array");
		pnInput.add(lblInput);

		txtInputField = new JTextField();
		txtInputField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int num = Integer.parseInt(txtInputField.getText());
					for(int i = 0;i < index; i++)
					{
						if(num == array[i])
							throw new DuplicateValueException();
					}
					array[index] = num;
					index++;

					String str = "";
					for (int i = 0; i < index; i++) {
						str = str + array[i] + " ";
					}
					lblArray.setText(str);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,
							"Please enter only integer value!",
							"Invalid input", JOptionPane.ERROR_MESSAGE);
				} catch (ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null,
							"Array may contain only 10 elements.",
							"Array full", JOptionPane.ERROR_MESSAGE);
				}
				catch(DuplicateValueException ex)
				{
					JOptionPane.showMessageDialog(null,
							"Please enter only unique integer!",
							"Duplicate", JOptionPane.ERROR_MESSAGE);
				}
				/*finally
				{
					String str = "";
					for (int i = 0; i < index; i++) {
						str = str + array[i] + " ";
					}
					lblArray.setText(str);
				}*/
			}
		});
		pnInput.add(txtInputField);
		txtInputField.setColumns(10);

		lblNumber = new JLabel("                                Number");
		pnInput.add(lblNumber);

		txtNumber = new JTextField();
		txtNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try
			{
				int b = Integer.parseInt(txtNumber.getText());
				for(int i = 0; i < index; i++)
				{
					if(b == array[i])
					{
						txtIndex.setText(String.valueOf(i));
					}
					else
					{
						throw new NumberNotFoundException();
					}
				}
			}
			catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,
						"Please enter only integer value!",
						"Invalid input", JOptionPane.ERROR_MESSAGE);
			}
			catch(NumberNotFoundException ex)
			{
				JOptionPane.showMessageDialog(null,
						"Number not found in array!",
						"Not Found", JOptionPane.ERROR_MESSAGE);
			}
			finally
			{
				
			}
			}
		});
		pnInput.add(txtNumber);
		txtNumber.setColumns(10);

		lblIndex = new JLabel("                                  Index");
		pnInput.add(lblIndex);

		txtIndex = new JTextField();
		txtIndex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try
			{
				int a = Integer.parseInt(txtIndex.getText());
				txtNumber.setText(String.valueOf(array[a]));
			}
			
			catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,
						"Please enter only integer value!",
						"Invalid input", JOptionPane.ERROR_MESSAGE);
			}
			catch (ArrayIndexOutOfBoundsException ex)
			{
				JOptionPane.showMessageDialog(null,
						"Array out of bounds!!!",
						"out of bounds!!!", JOptionPane.ERROR_MESSAGE);
			}
			finally
			{
				
			}
			
			}
		});
		pnInput.add(txtIndex);
		txtIndex.setColumns(10);

		pnDisplay = new JPanel();
		contentPane.add(pnDisplay, BorderLayout.SOUTH);
		pnDisplay.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblArray = new JLabel("");
		pnDisplay.add(lblArray);
	}
}
