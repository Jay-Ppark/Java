import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JButton;

import java.awt.Insets;

import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ContactPanel extends JPanel {
	private JLabel lblName;
	private JLabel lblPhone;
	private JButton btnEdit;
	private JButton btnDelete;
	
    private Contact contact;
    private Phonebook parent;
	/**
	 * Create the panel.
	 */
	public ContactPanel(Phonebook frame,Contact cont) {
		setBorder(new LineBorder(Color.BLUE));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblName = new JLabel("Name Label");
		lblName.setFont(new Font("굴림", Font.BOLD, 15));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.weighty = 1.0;
		gbc_lblName.weightx = 1.0;
		gbc_lblName.fill = GridBagConstraints.VERTICAL;
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.gridwidth = 3;
		gbc_lblName.insets = new Insets(5, 5, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		add(lblName, gbc_lblName);
		
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Contact c = new Contact(lblName.getText(), lblPhone.getText());
				ContactDialog dlg = new ContactDialog(null,c);
				dlg.setContact(c);
				dlg.setVisible(true);
				c=dlg.getContact();
				if(c.getName() != null && c.getPhone() != null)
				{
					if(c.getName().trim().length() > 0 && c.getPhone().trim().length() > 0)
					{
						//parent.getListPanel();
						lblName.setText(c.getName());
						
						lblPhone.setText(c.getPhone());
					}
				}
			}
			
		});
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.fill = GridBagConstraints.BOTH;
		gbc_btnEdit.weighty = 1.0;
		gbc_btnEdit.weightx = 1.0;
		gbc_btnEdit.insets = new Insets(5, 5, 5, 5);
		gbc_btnEdit.gridx = 3;
		gbc_btnEdit.gridy = 0;
		add(btnEdit, gbc_btnEdit);
		
		lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("굴림", Font.ITALIC, 15));
		GridBagConstraints gbc_lblPhone = new GridBagConstraints();
		gbc_lblPhone.fill = GridBagConstraints.BOTH;
		gbc_lblPhone.weighty = 1.0;
		gbc_lblPhone.weightx = 1.0;
		gbc_lblPhone.gridwidth = 3;
		gbc_lblPhone.insets = new Insets(5, 5, 5, 5);
		gbc_lblPhone.gridx = 0;
		gbc_lblPhone.gridy = 1;
		add(lblPhone, gbc_lblPhone);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				parent.removeContactPanel(ContactPanel.this);
				parent.updateGUI();
			}
		});
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(5, 5, 5, 5);
		gbc_btnDelete.fill = GridBagConstraints.BOTH;
		gbc_btnDelete.weighty = 1.0;
		gbc_btnDelete.weightx = 1.0;
		gbc_btnDelete.gridx = 3;
		gbc_btnDelete.gridy = 1;
		add(btnDelete, gbc_btnDelete);

		contact = cont;
		lblName.setText(contact.getName());
		lblPhone.setText(contact.getPhone());
		
		parent = frame;
	}

}
