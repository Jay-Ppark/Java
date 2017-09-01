import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.ListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;

public class Phonebook extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnAction;
	private JMenuItem mntmAdd;
	private JMenuItem mntmDelete;
	private JMenuItem mntmExit;
	private JMenu mnCollections;
	private JMenuItem mntmSort;
	private JMenuItem mntmShuffle;
	private JMenuItem mntmDuplicate;
	private JMenuItem mntmDeleteDuplicates;
	private JScrollPane scrollPane;
	private JList list;
	private JLabel lblStatus;

	private List<String> strList;
	private DefaultListModel<String> listModel;
	private DefaultListModel<String> listModelNew;
	private JFrame frame = this;
	private JScrollPane scrollPaneNew;
	private JList listDuplicate;
	private JSplitPane splitPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Phonebook frameX = new Phonebook();
					frameX.setVisible(true);
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnAction = new JMenu("Action");
		menuBar.add(mnAction);

		mntmAdd = new JMenuItem("Add");
		mntmAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str = (String) JOptionPane.showInputDialog(frame,"Please insert contact","Input dialog",JOptionPane.PLAIN_MESSAGE);
				strList.add(str);
				if((str != null) && (str.length() > 0))
				{
					listModel.addElement(str);
				}
			}
		});
		mnAction.add(mntmAdd);

		mntmDelete = new JMenuItem("Delete");
		mntmDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str = (String) JOptionPane.showInputDialog(frame,"Please enter index of contact: ", "Delete dialog",JOptionPane.WARNING_MESSAGE);
				try{
					int index = Integer.parseInt(str);
					listModel.remove(index);
				}
				catch (NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(frame, "Error: Enter Integer!");
				}
				catch (ArrayIndexOutOfBoundsException ex)
				{
					JOptionPane.showMessageDialog(frame, "Error: enter index less than " + listModel.size() + "!");
				}
			}
		});
		mnAction.add(mntmDelete);

		mntmExit = new JMenuItem("Exit");
		mnAction.add(mntmExit);

		mnCollections = new JMenu("Collections");
		menuBar.add(mnCollections);

		mntmSort = new JMenuItem("Sort");
		mntmSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listModel.clear();
				Collections.sort(strList);
				for(String s : strList)
				{
					listModel.addElement(s);
				}
			}
		});
		mnCollections.add(mntmSort);

		mntmShuffle = new JMenuItem("Shuffle");
		mntmShuffle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listModel.clear();
				Collections.shuffle(strList);
				for(String s : strList)
				{
					listModel.addElement(s);
				}
			}
		});
		mnCollections.add(mntmShuffle);

		mntmDuplicate = new JMenuItem("Duplicate");
		mntmDuplicate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				listModelNew.clear();
				for(String s : strList)
				{
					listModelNew.addElement(s);
				}
			}
		});
		mnCollections.add(mntmDuplicate);

		mntmDeleteDuplicates = new JMenuItem("Delete Duplicates");
		mnCollections.add(mntmDeleteDuplicates);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		listModel = new DefaultListModel();
		
		list = new JList(listModel);
		
		scrollPane = new JScrollPane(list);
		//contentPane.add(scrollPane, BorderLayout.CENTER);

		lblStatus = new JLabel("Total");
		contentPane.add(lblStatus, BorderLayout.SOUTH);
		
		listModelNew = new DefaultListModel();
		listDuplicate = new JList(listModelNew);
		scrollPaneNew = new JScrollPane(listDuplicate);
		//contentPane.add(scrollPaneNew, BorderLayout.NORTH);
		
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane,scrollPaneNew);
		splitPane.setResizeWeight(0.5);
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		
		//contentPane.add(list_1, BorderLayout.WEST);

		// contentPane.add(list, BorderLayout.NORTH);

		InitData();
	}

	public void InitData() {
		strList = new Vector<String>();
		for (int i = 0; i < PhoneData.names.length; i++) {
			strList.add(PhoneData.names[i] + ": " + PhoneData.phones[i]);
		}
		
		for(int i = 0; i < strList.size();i++)
		{
			listModel.addElement(strList.get(i));
		}
	}
}
