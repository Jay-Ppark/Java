
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.SwingWorker;

public class PRIME {

   private JFrame frmFindPrime;
   private JPanel pninput;
   private JPanel pnStatus;
   private JLabel lblNewLabel;
   private JTextField textField;
   private JLabel lblNewLabel_1;
   private JTextField textField_1;
   private JButton btnStop;
   private JButton btnStart;
   private JProgressBar progressBar;
   private JTextArea textArea;
   private JScrollPane scrollPane;

   private SwingWorker<Integer, String> swingworker;
   int number1;
   int number2;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               PRIME window = new PRIME();
               window.frmFindPrime.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the application.
    */
   public PRIME() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      frmFindPrime = new JFrame();
      frmFindPrime.setTitle("Find Prime Numbers");
      frmFindPrime.setBounds(100, 100, 600, 300);
      frmFindPrime.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      pninput = new JPanel();
      frmFindPrime.getContentPane().add(pninput, BorderLayout.NORTH);
      pninput.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

      lblNewLabel = new JLabel("Find prime from");
      pninput.add(lblNewLabel);

      textField = new JTextField();
      pninput.add(textField);
      textField.setColumns(10);

      lblNewLabel_1 = new JLabel("to");
      pninput.add(lblNewLabel_1);

      textField_1 = new JTextField();
      pninput.add(textField_1);
      textField_1.setColumns(10);

      btnStart = new JButton("Start");
      btnStart.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            progressBar.setValue(0);
            textArea.setText("");
            final int number1;
            final int number2;
            try {
               number1 = Integer.parseInt(textField.getText());
               number2 = Integer.parseInt(textField_1.getText());

            } catch (NumberFormatException ex) {
               textArea.setText("Enter the Integers!");
               return;
            }

            swingworker = new SwingWorker<Integer, String>() {

               @Override
               protected Integer doInBackground() throws Exception {
                  btnStart.setEnabled(false);
                  btnStop.setEnabled(true);
                  int check_num = 0;
                  try {
                     for (int i = number1; i <= number2; i++) {
                        if (Thread.currentThread().isInterrupted()) {
                           break;
                        }
                        Thread.sleep(100);
                        publish(String.valueOf((i - number1 + 1) * 100
                              / (number2 - number1)));
                        for (int j = 1; j <= i; j++) {
                           if (i % j == 0) {
                              check_num++;
                           }
                        }
                        if (check_num == 2 && i != 2)
                           textArea.append(i + "\n");
                        check_num = 0;
                     }
                  } catch (InterruptedException ex) {
                     textArea.setText("Erorr!!");
                  } finally {
                     btnStart.setEnabled(true);
                     btnStop.setEnabled(false);
                  }

                  return null;
               }

               protected void process(List<String> chunks) {
                  super.process(chunks);
                  for (int i = 0; i < chunks.size(); i++) {
                     progressBar.setValue(Integer.parseInt(chunks.get(i)));

                  }
               }

            };

            swingworker.execute();

         }
      });
      pninput.add(btnStart);

      btnStop = new JButton("Stop");
      btnStop.setEnabled(false);
      btnStop.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            if (!swingworker.isCancelled())
               swingworker.cancel(true);

            btnStop.setEnabled(false);
            btnStart.setEnabled(true);

         }

      });
      pninput.add(btnStop);

      pnStatus = new JPanel();
      frmFindPrime.getContentPane().add(pnStatus, BorderLayout.SOUTH);
      pnStatus.setLayout(new GridLayout(0, 1, 0, 0));

      progressBar = new JProgressBar();
      pnStatus.add(progressBar);

      textArea = new JTextArea();
      scrollPane = new JScrollPane(textArea);
      frmFindPrime.getContentPane().add(scrollPane, BorderLayout.CENTER);

   }

}