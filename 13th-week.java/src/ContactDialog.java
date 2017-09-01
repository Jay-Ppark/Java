import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;


public class ContactDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldName;
	private JTextField textFieldPhone;
	
	private Contact contact;
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public ContactDialog(Phonebook frame) {
		
		super(frame,true);
		
		setTitle("Contact Info");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		setBounds(100, 100, 445, 212);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(2, 2, 5, 5));
		{
			JLabel lblName = new JLabel("Name:");
			lblName.setHorizontalAlignment(SwingConstants.TRAILING);
			contentPanel.add(lblName);
		}
		{
			textFieldName = new JTextField();
			contentPanel.add(textFieldName);
			textFieldName.setColumns(10);
		}
		{
			JLabel lblPhone = new JLabel("Phone:");
			lblPhone.setHorizontalAlignment(SwingConstants.TRAILING);
			contentPanel.add(lblPhone);
		}
		{
			textFieldPhone = new JTextField();
			contentPanel.add(textFieldPhone);
			textFieldPhone.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						contact.setName(textFieldName.getText());
						contact.setPhone(textFieldPhone.getText());
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		contact = new Contact("","");
	}

	public ContactDialog(Phonebook frame,Contact cont)
	{
		this(frame);
		this.contact = cont;
		textFieldName.setText(contact.getName());
		textFieldPhone.setText(contact.getPhone());
		
	}
	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

}
