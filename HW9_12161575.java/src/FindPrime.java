import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

import org.apache.commons.math3.primes.Primes;

@SuppressWarnings("serial")
public class FindPrime extends JFrame {

	private JPanel contentPane;
	private JTextField textField1;
	private JButton btnStop;
	private JButton btnStart;
	private JTextArea txtArea;
	private JProgressBar progressBar;
	private JScrollPane scrollPane;

	private WorkerClass worker;
	private JLabel lblTo;
	private JTextField textField2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindPrime frame = new FindPrime();
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
	public FindPrime() {

		setTitle("Find Prime Numbers");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pnInput = new JPanel();
		pnInput.setLayout(new GridLayout(0, 6, 0, 0));
		contentPane.add(pnInput, BorderLayout.NORTH);

		JLabel lblFind = new JLabel("Find prime from");
		pnInput.add(lblFind);

		textField1 = new JTextField();
		textField1.setColumns(10);
		pnInput.add(textField1);

		btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// reset all views
				progressBar.setValue(0); // reset JProgressBar
				txtArea.setText(""); // clear JTextArea
				
				// get user input
				int number1;
				int number2;
				try {
					number1 = Integer.parseInt(textField1.getText());
					number2 = Integer.parseInt(textField2.getText());
				} catch (NumberFormatException ex) {
					txtArea.setText("Enter an integer.");
					return;
				} 
				
				worker = new WorkerClass(number1, number2);
				worker.execute();
			}
		});

		lblTo = new JLabel("to");
		pnInput.add(lblTo);

		textField2 = new JTextField();
		pnInput.add(textField2);
		textField2.setColumns(10);
		pnInput.add(btnStart);

		btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (worker != null) {
					if (!worker.isCancelled()) {
						worker.cancel(true);
					}
				}
			}
		});
		btnStop.setEnabled(false);
		pnInput.add(btnStop);

		JPanel pnList = new JPanel();
		contentPane.add(pnList, BorderLayout.CENTER);
		pnList.setLayout(new BorderLayout(0, 0));

		txtArea = new JTextArea();
		txtArea.setEditable(false);

		scrollPane = new JScrollPane(txtArea,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		pnList.add(scrollPane);

		JPanel pnStatus = new JPanel();
		pnStatus.setLayout(new GridLayout(0, 1, 10, 0));
		contentPane.add(pnStatus, BorderLayout.SOUTH);

		progressBar = new JProgressBar();
		pnStatus.add(progressBar);
	}
	// SwingWorker
	public class WorkerClass extends SwingWorker<Integer, String> {
		int num1;
		int num2;
		int count;
		
		

		public WorkerClass(int number1, int number2) {
			num1 = number1;
			num2 = number2;
			count = 0;
			
		}

		@Override
		//main process
		protected Integer doInBackground() throws Exception {
			// disable Start button and enable Cancel button
			btnStart.setEnabled(false);
			btnStop.setEnabled(true);
			count = 0;
			
			try {
				for (int i = num1; i <= num2; i++) {
					if (Thread.currentThread().isInterrupted()) {
						break;
					}
					// do some complex work here
					Thread.sleep(100);
					publish(String.valueOf((i - num1 + 1) * 100
                            / (num2 - num1)));
					
					
					// update the view
					if (isPrime(i)) {
						txtArea.append(String.valueOf(i) + '\n');
						
						// update the result
						count++;
					}
					
				}
				// update the status
				
			} catch (InterruptedException e) {
				// update the status
				txtArea.setText("Stop!!");
			}
			return count;
		}

		// displays published values
		protected void process(List<String> publishedVals) {
			
			for (int i = 0; i < publishedVals.size(); i++) {
				progressBar.setValue(Integer.parseInt(publishedVals.get(i)));
			}
			
		} // end method process

		// code to execute when doInBackground completes
		protected void done() {
			// disable Start button and enable Stop button
			btnStart.setEnabled(true);
			btnStop.setEnabled(false);
			
		}
	}
// know what is prime number
	public boolean isPrime(int a) {
		return Primes.isPrime(a);
	}
}
