import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Phonebook extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldFilter;
	private JScrollPane scrollPane;
	private JButton btnAdd;
	

	private List<ContactPanel> listPanel;
	private JPanel pnList;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Phonebook frame = new Phonebook();
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
	public Phonebook() {
		setTitle("PhoneBook");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		textFieldFilter = new JTextField();
		contentPane.add(textFieldFilter, BorderLayout.NORTH);
		textFieldFilter.setColumns(10);
		
		pnList = new JPanel();
		scrollPane = new JScrollPane(pnList);
		pnList.setLayout(new GridLayout(0, 1, 0, 0));
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		
		
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ContactDialog dlg = new ContactDialog(Phonebook.this);
				dlg.setVisible(true);
				Contact c = dlg.getContact();
				if(c.getName() != null && c.getPhone() != null)
				{
					if(c.getName().trim().length() > 0 && c.getPhone().trim().length() > 0)
					{
						listPanel.add(new ContactPanel(Phonebook.this, c));
						pnList.add(listPanel.get(listPanel.size()-1));
						updateGUI();
						scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
					}
				}
			}
		});
		contentPane.add(btnAdd, BorderLayout.SOUTH);
		
		listPanel=new ArrayList<ContactPanel>();
		initData();
	}

	private void initData()
	{
		for(int i=0;i<ContactData.rawData.length;i++)
		{
			String[] str = ContactData.rawData[i].split(":");
			Contact contact = new Contact(str[0].trim(),str[1].trim());
			ContactPanel cp = new ContactPanel(Phonebook.this,contact);
			listPanel.add(cp);
			pnList.add(listPanel.get(listPanel.size()-1));
		}
	}
	public void removeContactPanel(ContactPanel contactPanel)
	{
		pnList.remove(contactPanel);
		listPanel.remove(contactPanel);
	}
	
	public void updateGUI()
	{
		revalidate();
		repaint();
	}
}
