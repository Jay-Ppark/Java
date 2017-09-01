import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingWorker;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Random;

public class RandomGenThread extends JFrame
{

	private JPanel contentPane;
	private JPanel pnInput;
	private JPanel pnStatus;
	private JLabel lblInput;
	private JTextField textField;
	private JButton btnStart;
	private JButton btnStop;
	private JProgressBar progressBar;
	private JLabel lblStatus;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	private Thread workThread;
	private Random ran;
	private SwingWorker<Integer, String> worker;
	private JLabel lblTo;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					RandomGenThread frame = new RandomGenThread();
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
	public RandomGenThread() {
		ran = new Random();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		pnInput = new JPanel();
		contentPane.add(pnInput, BorderLayout.NORTH);
		pnInput.setLayout(new GridLayout(0, 6, 0, 1));

		lblInput = new JLabel("Number of loops");
		pnInput.add(lblInput);

		textField = new JTextField();
		pnInput.add(textField);
		textField.setColumns(10);

		btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				progressBar.setValue(0);
				textArea.setText("");
				lblStatus.setText("");

				final int number;
				try {
					number = Integer.parseInt(textField.getText());
				} catch (NumberFormatException ex) {
					lblStatus.setText("Enter an integer!");
					return;
				}

				// workThread = new Thread(new CalculatorClass(number));
				// workThread.start();

				worker = new SwingWorker<Integer, String>()
				{
					@Override
					protected Integer doInBackground() throws Exception
					{
						btnStart.setEnabled(false);
						btnStop.setEnabled(true);
						lblStatus.setText("Running...");
						int cnt = 0;
						try
						{
							for (int i = 0; i < number; i++)
							{
								if (Thread.currentThread().isInterrupted())
								{
									break;
								}
								Thread.sleep(100);
								cnt++;
								publish(String.valueOf((i + 1) * 100 / number));
								//progressBar.setValue((i + 1) * 100 / number);
								textArea.append((i + 1) + ". Random number = " + ran.nextInt() + "\n");
							
							}
							lblStatus.setText("Printed " + cnt + " number(s)");
						} catch (InterruptedException ex) {
							lblStatus.setText("Error performing computation.");
						} finally {
							btnStart.setEnabled(true);
							btnStop.setEnabled(false);
							lblStatus.setText("Print " + cnt + " work");
						}
						return null;
					}
					
					@Override
					protected void process(List<String> chunks)
					{
						super.process(chunks);
						for (int i = 0; i < chunks.size(); i++)
						{
							progressBar.setValue(Integer.parseInt(chunks.get(i)));
							
						}
					}
				};
				worker.execute();

			}
		});
		
		lblTo = new JLabel("to");
		pnInput.add(lblTo);
		
		textField_1 = new JTextField();
		pnInput.add(textField_1);
		textField_1.setColumns(10);
		pnInput.add(btnStart);

		btnStop = new JButton("Stop");
		btnStop.setEnabled(false);
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!worker.isCancelled())
				{
					worker.cancel(true);
					/*if (workThread.isAlive()) {
						workThread.interrupt();
					}*/
				}
				
			}
		});
		pnInput.add(btnStop);

		textArea = new JTextArea();
		textArea.setEditable(false);

		scrollPane = new JScrollPane(textArea);
		contentPane.add(scrollPane, BorderLayout.CENTER);

		pnStatus = new JPanel();
		contentPane.add(pnStatus, BorderLayout.SOUTH);
		pnStatus.setLayout(new GridLayout(0, 2, 0, 2));

		progressBar = new JProgressBar();
		pnStatus.add(progressBar);

		lblStatus = new JLabel("Status");
		pnStatus.add(lblStatus);
	}

	class CalculatorClass implements Runnable
	{
		int num;

		public CalculatorClass(int numOfWork) {
			this.num = numOfWork;
		}

		@Override
		public void run() {
			btnStart.setEnabled(false);
			btnStop.setEnabled(true);
			lblStatus.setText("Running...");
			int cnt = 0;
			try {
				for (int i = 0; i < num; i++) {
					if (Thread.currentThread().isInterrupted()) {
						break;
					}
					Thread.sleep(100);
					cnt++;

					progressBar.setValue((i + 1) * 100 / num);
					textArea.append((i + 1) + ". Random number = "
							+ ran.nextInt() + "\n");
				}
				lblStatus.setText("Printed " + cnt + " number(s)");
			} catch (InterruptedException ex) {
				lblStatus.setText("Error performing computation.");
			} finally {
				btnStart.setEnabled(true);
				btnStop.setEnabled(false);
				lblStatus.setText("Print " + cnt + " work");
			}
		}
	}
}
