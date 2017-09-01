
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextField;

import java.awt.GridLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Font;

import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class Calculateor extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JTextField textField;
	
	private JPanel pnInputs;
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
	private JButton btnDivision;
	private JButton btnMemRead;
	
	public final String NONE = "NONE";
	private String num1;
	private String num2;
	private String operator;
	private JPanel pnHistory;
	private JPanel pnDisplay;
	private DefaultListModel<String> listData;
	private JList list;
	private JScrollPane scrollPane;
	private boolean shiftPressed; // +와 *연산을 위해 시프트가 눌려져있는지 검사
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Calculateor frame = new Calculateor();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calculateor()
	{
		num1 = NONE;
		num2 = NONE;
		operator = NONE;
		shiftPressed = false;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pnDisplay = new JPanel();
		contentPane.add(pnDisplay, BorderLayout.NORTH);
		
		textField = new JTextField();
		pnDisplay.add(textField);
		textField.setFont(new Font("굴림", Font.PLAIN, 24));
		textField.setColumns(20);
		
		pnInputs = new JPanel();
		contentPane.add(pnInputs, BorderLayout.CENTER);
		pnInputs.setLayout(new GridLayout(4, 5, 2, 2));
		
		
		btn7 = new JButton("7");	// 계산기 버튼 생성
		btn7.addActionListener(this); // 계산기 버튼을 눌렀을 때 발생하는 액션
		pnInputs.add(btn7);		// 패널에 버튼 추가
		
		btn8 = new JButton("8");
		btn8.addActionListener(this);
		pnInputs.add(btn8);
		
		btn9 = new JButton("9");
		btn9.addActionListener(this);
		pnInputs.add(btn9);
		
		btnAdd = new JButton("+");
		btnAdd.addActionListener(this);
		pnInputs.add(btnAdd);
		
		btnClearAll = new JButton("C");
		btnClearAll.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				textField.setText("");
				num1 = NONE;
				num2 = NONE;
				operator = NONE;
			}
		});
		pnInputs.add(btnClearAll);
		
		btn4 = new JButton("4");
		btn4.addActionListener(this);
		pnInputs.add(btn4);
		
		btn5 = new JButton("5");
		btn5.addActionListener(this);
		pnInputs.add(btn5);
		
		btn6 = new JButton("6");
		btn6.addActionListener(this);
		pnInputs.add(btn6);
		
		btnMinus = new JButton("-");
		btnMinus.addActionListener(this);
		pnInputs.add(btnMinus);
		
		btnClearText = new JButton("CE");
		btnClearText.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				textField.setText("");
				textField.setEditable(true);
			}
		});
		pnInputs.add(btnClearText);
		
		btn1 = new JButton("1");
		btn1.addActionListener(this);
		pnInputs.add(btn1);
		
		btn2 = new JButton("2");
		btn2.addActionListener(this);
		pnInputs.add(btn2);
		
		btn3 = new JButton("3");
		btn3.addActionListener(this);
		pnInputs.add(btn3);
		
		btnMultiply = new JButton("x");
		btnMultiply.addActionListener(this);
		pnInputs.add(btnMultiply);
		
		btnMemSet = new JButton("M");
		btnMemSet.addActionListener(this);
		pnInputs.add(btnMemSet);
		
		btn0 = new JButton("0");
		btn0.addActionListener(this);
		pnInputs.add(btn0);
		
		btnDot = new JButton(".");
		btnDot.addActionListener(this);
		pnInputs.add(btnDot);
		
		btnEqual = new JButton("=");
		btnEqual.addActionListener(this);
		pnInputs.add(btnEqual);
		
		btnDivision = new JButton("/");
		btnDivision.addActionListener(this);
		pnInputs.add(btnDivision);
		
		btnMemRead = new JButton("MC");
		btnMemRead.addActionListener(this);
		pnInputs.add(btnMemRead);
		
		pnHistory = new JPanel();
		contentPane.add(pnHistory, BorderLayout.EAST);
		
		textField.addKeyListener(new KeyListener() {	// 키보드 입력을 위한 함수

			@Override
			public void keyPressed(KeyEvent e)	// 키 눌렀을 떄 이벤트 발생
			{
				// TODO Auto-generated method stub
				String s = e.getKeyText(e.getKeyCode());
				// System.out.println(s);

				if (!shiftPressed)	// 시프트 안눌러져있을때
				{
					if (s.compareToIgnoreCase("0") >= 0 && s.compareToIgnoreCase("9") <= 0)	// 숫자가 입력됐을때
					{
						if (textField.isEditable())	// 첫 숫자 입력했을때
						{
							String curText = textField.getText();
							// textField.setText(curText + s);
						}
						else
						{
							textField.setEditable(true);	// textField가 다시 수정될 수 있도록 해줌.
							textField.setText("");
						}
					}


					else if (s.equals("Minus") || s.equals("Slash"))
					{
						if (operator.equals(NONE)) // 사칙연산 처음 눌렀을때
						{
							num1 = textField.getText();
							addMemory(num1);
							
							if(s == "Minus")
								addMemory("-");
							else
								addMemory("/");
						} 
						else // 이미 사칙연산이 눌러져있을때 기존에 입력됐던 값들을 계산함
						{
							num2 = textField.getText();
							addMemory(num2);
							if(s == "Minus")
							{
								addMemory("-");
							}
							else
							{
								addMemory("/");
							}
							num1 = doMath(num1, operator, num2);
						}

						textField.setText(num1);
						textField.setEditable(false);

						switch (s)	// 입력된 연산자에 따라 계산 수행
						{
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

					else if (s.equals("Shift"))	// 시프트 키가 눌려져 있는 상태인지를 알려줌
					{
						shiftPressed = true;
					}

					else if (s.equals("Equals"))	// '='이 입력된다면 그 전까지 입력되었던 값들 계산
					{
						if(operator.equals(NONE)) // 사칙연산 처음 눌렀을때
						{
							num1 = textField.getText();
						}
						else
						{
							num2 = textField.getText();
							addMemory(num2);
							num1 = doMath(num1, operator, num2);

							addMemory("=");
							textField.setText(num1);
							textField.setEditable(false);

							addMemory(num1);
							addMemory("-------");
							operator = NONE;
							num1 = NONE;
							num2 = NONE;
						}
					}
					else
					{
					
					}
				} else // 시프트 눌러져있을때
				{
					if (s.compareToIgnoreCase("0") == 8 || s.equals("Equals"))	// 곱하기 연산이나 더하기 연산을 수행
					{
						if (operator.equals(NONE)) // 사칙연산 처음 눌렀을때
						{
							num1 = textField.getText();
							addMemory(num1);
							if (s.equals("8"))
								addMemory("x");
							else
								addMemory("+");
						} 
						else // 이미 사칙연산이 눌러져있을때
						{
							num2 = textField.getText();
							addMemory(num2);
							addMemory(s);
							num1 = doMath(num1, operator, num2);
						}

						textField.setText(num1);
						textField.setEditable(false);

						switch (s)
						{
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

					} 
					else
					{

					}
				}
			}
			@Override
			public void keyReleased(KeyEvent arg0)	// 시프트 키 뗀다면 다시 기존 상태로 돌아감
			{
				shiftPressed = false;
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0)
			{
				
			}
			
			
		});
		
		listData = new DefaultListModel<String>();	// 입력되었던 값들을 저장하기 위한 리스트
		pnHistory.setLayout(new BorderLayout(5, 5));
		list = new JList(listData);

		list.addListSelectionListener(new ListSelectionListener(){	// 리스트에 변수를 추가히기 위한 함수

			@Override
			public void valueChanged(ListSelectionEvent arg0)
			{
				// TODO Auto-generated method stub
				textField.setText((String) list.getSelectedValue());
			}
			
		});
		pnHistory.add(list);
		
		scrollPane = new JScrollPane(list);
		scrollPane.setPreferredSize(new Dimension(120, 200));
		pnHistory.add(scrollPane, BorderLayout.CENTER);
		
	}

	@Override
	public void actionPerformed(ActionEvent e)	// 마우스 입력을 처리하기 위한 함수
	{
		String s = e.getActionCommand();
		System.out.println(s);

		if(s.compareToIgnoreCase("0") >= 0 && s.compareToIgnoreCase("9") <= 0)	// 입력받은 값이 숫자이면
		{
			if(textField.isEditable())	// 첫 숫자 입력했을때
			{
				String curText = textField.getText();
				textField.setText(curText+s);
			}
			else
			{
				textField.setEditable(true);
				textField.setText(s);
			}
		}
		
		else if(s.equals("+") || s.equals("-") ||  s.equals("x") ||  s.equals("/")) // 입력받은 값이 연산자이면
		{
			if(operator.equals(NONE)) // 사칙연산 처음 눌렀을때
			{
				num1 = textField.getText();
				addMemory(num1);
				addMemory(s);
			}
			else // 이미 사칙연산이 눌러져있을때
			{
				num2 = textField.getText();
				addMemory(num2);
				addMemory(s);
				num1 = doMath(num1, operator, num2);
			}
			
			textField.setText(num1);
			textField.setEditable(false);
			
			operator = s;
			num2 = NONE;
			
		}
		
		else if(s.equals("="))
		{
			if(operator.equals(NONE)) // 사칙연산 처음 눌렀을때
			{
				
			}
			else
			{
				num2 = textField.getText();
				addMemory(num2);
				num1 = doMath(num1, operator, num2);

				addMemory(s);
				textField.setText(num1);
				textField.setEditable(false);

				addMemory(num1);
				addMemory("-------");
				operator = NONE;
				num1 = NONE;
				num2 = NONE;
			}
		}
		
		else
		{
			
		}
	}

	
	public String doMath(String num1, String op, String num2)	// 입력받은 숫자와 연산자를 가지고 계산 진행
	{
		int number1 = Integer.parseInt(num1);
		int number2 = Integer.parseInt(num2);
		
		switch (op)
		{
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
		
		return ("" + number1);	// 계산된 값을 반환
	}
	
	void addMemory(String txt)	// listData를 처리하기 위한 함수
	{
		listData.addElement(txt);	// 입력받은 값을 listData에 추가하고
	
		//scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
		
		scrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {  // 스크롤을 자동으로 맨 밑으로 보냄.
	        public void adjustmentValueChanged(AdjustmentEvent e) {  
	            e.getAdjustable().setValue(e.getAdjustable().getMaximum());  
	        }
	    });
	}

}
