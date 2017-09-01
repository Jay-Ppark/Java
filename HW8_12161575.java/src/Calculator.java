import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.GridLayout;

import javax.swing.JList;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class Calculator extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel pnDisplay;
	private JPanel pnInput;
	private JPanel pnHistory;
	private JScrollPane scrollPane;
	private JTextField textField;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btnAdd;
	private JButton btnClearAll;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btnMinus;
	private JButton btnClearText;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btnMultiply;
	private JButton btnMemSet;
	private JButton btn0;
	private JButton btnDot;
	private JButton btnEqual;
	private JButton btnDivide;
	private JButton btnMemRead;
	private JList list;
	

	// String to store input data
	private String num1;
	private String num2;
	private String operator;
	private final String NONE = "NONE";
	private DefaultListModel<String> listData;
	private String result = "";
	private boolean pressShift;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
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
	public Calculator() {

		/*
		 * GUI code
		 */
		setTitle("Simple Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		pnDisplay = new JPanel();
		contentPane.add(pnDisplay, BorderLayout.NORTH);
		pnDisplay.setLayout(new GridLayout(0, 1, 0, 0));

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setFont(new Font("Courier New", Font.PLAIN, 28));
		pnDisplay.add(textField);
		textField.setColumns(10);

		pnInput = new JPanel();
		contentPane.add(pnInput, BorderLayout.CENTER);
		pnInput.setLayout(new GridLayout(4, 5, 5, 5));

		btn7 = new JButton("7");
		btn7.setFont(new Font("����", Font.BOLD, 14));
		btn7.addActionListener(this);
		pnInput.add(btn7);

		btn8 = new JButton("8");
		btn8.setFont(new Font("����", Font.BOLD, 14));
		btn8.addActionListener(this);
		pnInput.add(btn8);

		btn9 = new JButton("9");
		btn9.setFont(new Font("����", Font.BOLD, 14));
		btn9.addActionListener(this);
		pnInput.add(btn9);

		btnAdd = new JButton("+");
		btnAdd.setFont(new Font("����", Font.BOLD, 14));
		btnAdd.addActionListener(this);
		pnInput.add(btnAdd);

		btnClearAll = new JButton("C");
		btnClearAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// reset all the data
				textField.setText("");
				num1 = NONE;
				num2 = NONE;
				operator = NONE;
				listData.clear();
			}
		});
		btnClearAll.setFont(new Font("����", Font.BOLD, 14));
		pnInput.add(btnClearAll);

		btn4 = new JButton("4");
		btn4.setFont(new Font("����", Font.BOLD, 14));
		btn4.addActionListener(this);
		pnInput.add(btn4);

		btn5 = new JButton("5");
		btn5.setFont(new Font("����", Font.BOLD, 14));
		btn5.addActionListener(this);
		pnInput.add(btn5);

		btn6 = new JButton("6");
		btn6.setFont(new Font("����", Font.BOLD, 14));
		btn6.addActionListener(this);
		pnInput.add(btn6);

		btnMinus = new JButton("-");
		btnMinus.setFont(new Font("����", Font.BOLD, 14));
		btnMinus.addActionListener(this);
		pnInput.add(btnMinus);

		btnClearText = new JButton("CE");
		btnClearText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// reset the textfield only
				textField.setText("");
				textField.setEditable(true);
			}
		});
		btnClearText.setFont(new Font("����", Font.BOLD, 14));
		pnInput.add(btnClearText);

		btn1 = new JButton("1");
		btn1.setFont(new Font("����", Font.BOLD, 14));
		btn1.addActionListener(this);
		pnInput.add(btn1);

		btn2 = new JButton("2");
		btn2.setFont(new Font("����", Font.BOLD, 14));
		btn2.addActionListener(this);
		pnInput.add(btn2);

		btn3 = new JButton("3");
		btn3.setFont(new Font("����", Font.BOLD, 14));
		btn3.addActionListener(this);
		pnInput.add(btn3);

		btnMultiply = new JButton("x");
		btnMultiply.setFont(new Font("����", Font.BOLD, 14));
		btnMultiply.addActionListener(this);
		pnInput.add(btnMultiply);

		btnMemSet = new JButton("MS");
		btnMemSet.setFont(new Font("����", Font.BOLD, 14));
		pnInput.add(btnMemSet);

		btn0 = new JButton("0");
		btn0.setFont(new Font("����", Font.BOLD, 14));
		btn0.addActionListener(this);
		pnInput.add(btn0);

		btnDot = new JButton(".");
		btnDot.setFont(new Font("����", Font.BOLD, 14));
		pnInput.add(btnDot);

		btnEqual = new JButton("=");
		btnEqual.setFont(new Font("����", Font.BOLD, 14));
		btnEqual.addActionListener(this);
		pnInput.add(btnEqual);

		btnDivide = new JButton("/");
		btnDivide.setFont(new Font("����", Font.BOLD, 14));
		btnDivide.addActionListener(this);
		pnInput.add(btnDivide);

		btnMemRead = new JButton("MR");
		btnMemRead.setFont(new Font("����", Font.BOLD, 14));
		pnInput.add(btnMemRead);

		pnHistory = new JPanel();
		contentPane.add(pnHistory, BorderLayout.EAST);
		pnHistory.setPreferredSize(new Dimension(120, 200));

		listData = new DefaultListModel();
		pnHistory.setLayout(new BorderLayout(5, 5));
		list = new JList(listData);
		scrollPane = new JScrollPane(list);
		scrollPane.setPreferredSize(new Dimension(120, 200));
		pnHistory.add(scrollPane, BorderLayout.CENTER);
		// this is for list select
		list.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				textField.setText((String) list.getSelectedValue());
			}
		});

		// pnHistory.add(list);

		/*
		 * End of GUI code
		 */

		// initialize data
		num1 = NONE;
		num2 = NONE;
		operator = NONE;

		// this is for keyboard
		textField.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) // if we press key and then make
												// event
			{
				// TODO Auto-generated method stub
				String s = e.getKeyText(e.getKeyCode());

				if (!pressShift) // when shift is not pressed because of
									// equal/plus and 8/*
				{
					if (s.compareToIgnoreCase("0") >= 0
							&& s.compareToIgnoreCase("9") <= 0) // input number
					{
						if (textField.isEditable()) {
							String curText = textField.getText();
						} else {
							textField.setEditable(true);
							textField.setText("");
						}
					}

					else if (s.equals("Minus") || s.equals("Slash")) // minus
																		// and
																		// division
					{
						if (operator.equals(NONE)) {
							num1 = textField.getText();
							listData.addElement(num1);

							if (s == "Minus")
								listData.addElement("-");
							else
								listData.addElement("/");
						} else {
							num2 = textField.getText();
							listData.addElement(num2);
							if (s == "Minus") {
								listData.addElement("-");
							} else {
								listData.addElement("/");
							}
							num1 = doMath(num1, operator, num2);
						}

						textField.setText(num1);
						textField.setEditable(false);

						switch (s) {
						case "Minus":
							operator = "-";
							break;
						case "Slash":
							operator = "/";
							break;
						default:
							break;
						}
						num2 = NONE;

					}

					else if (s.equals("Shift")) // if shift is pressed and then
												// make pressShift true
					{
						pressShift = true;
					}

					else if (s.equals("Equals")) // equal
					{
						if (operator.equals(NONE)) {
							num1 = textField.getText();
						} else {
							num2 = textField.getText();
							listData.addElement(num2);
							num1 = doMath(num1, operator, num2);

							listData.addElement("=");
							textField.setText(num1);
							textField.setEditable(false);

							listData.addElement(num1);
							listData.addElement("-----");
							operator = NONE;
							num1 = NONE;
							num2 = NONE;
						}
					}

				} else // when shift is pressed ex) plus or multiply
				{
					if (s.equals("Equals") || s.compareToIgnoreCase("0") == 8) // plus
																				// or
																				// multiply
					{
						if (operator.equals(NONE)) {
							num1 = textField.getText();
							listData.addElement(num1);
							if (s.equals("8"))
								listData.addElement("x");
							else
								listData.addElement("+");
						} else {
							num2 = textField.getText();
							listData.addElement(num2);
							listData.addElement(s);
							num1 = doMath(num1, operator, num2);
						}

						textField.setText(num1);
						textField.setEditable(false);

						switch (s) {
						case "8":
							operator = "x";
							break;
						case "Equals":
							operator = "+";
							break;
						default:
							break;
						}
						num2 = NONE;

					} else {

					}
				}
			}

			@Override
			public void keyTyped(KeyEvent arg0) {

			}

			@Override
			public void keyReleased(KeyEvent arg0) // not press shift then
													// change pressShift to
													// false
			{
				pressShift = false;

			}

		});
	}

	// Receive the events from all buttons
	@Override
	public void actionPerformed(ActionEvent e) {
		// Get the string from the button
		String s = e.getActionCommand();

		// Check if the button is number
		if (s.compareToIgnoreCase("0") >= 0 && s.compareToIgnoreCase("9") <= 0) {
			// if textFiled is for inputting (editable) then append the number
			// else the set editable and set the number to the text
			if (textField.isEditable()) {
				// insert the number to last position of textField
				String curText = textField.getText();
				textField.setText(curText + s);
			} else {
				textField.setEditable(true);
				textField.setText(s);
			}

		}
		// Check if the button is operator
		else if (s.equals("+") || s.equals("-") || s.equals("x")
				|| s.equals("/")) {
			// check if there is operator exist
			if (operator.equals(NONE)) {
				// update the data
				num1 = textField.getText();
				listData.addElement(num1);
				listData.addElement(s);
			} else {
				// get the number2
				num2 = textField.getText();
				listData.addElement(num2);
				listData.addElement(s);
				// calculate the previous operator before store the new one
				num1 = doMath(num1, operator, num2);
			}

			// display the result
			textField.setText(num1);
			textField.setEditable(false);

			// reset the input filed
			operator = s;
			num2 = NONE;
		}
		// check if button is '='
		else if (s.equals("=")) {
			// get the number2
			num2 = textField.getText();
			listData.addElement(num2);
			// calculate the previous operator before store the new one
			num1 = doMath(num1, operator, num2);

			// display the result
			listData.addElement(s);
			textField.setText(num1);
			textField.setEditable(false);

			listData.addElement(num1);
			listData.addElement("-----");
			// reset the input filed
			operator = NONE;
			num1 = NONE;
			num2 = NONE;

		}

	}

	/**
	 * Do the operator and return the value in String.
	 * 
	 * @param num1
	 *            1st number
	 * @param num2
	 *            2nd number
	 * @param op
	 *            the operator
	 * @return result
	 */
	// Math method
	private String doMath(String num1, String op, String num2) {
		// convert to number
		int number1 = Integer.parseInt(num1);
		int number2 = Integer.parseInt(num2);

		// do the operator
		switch (op) {
		case "+":
			number1 = number1 + number2;
			break;
		case "-":
			number1 = number1 - number2;
			break;
		case "x":
			number1 = number1 * number2;
			break;
		case "/":
			number1 = number1 / number2;
			break;
		default:
			break;
		}

		// convert to string and return it
		return ("" + number1);
	}

}
