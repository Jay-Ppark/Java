/** **************************************************** *
 *  		                     				         *
 *  				File Manager Program    		     *
 *                                      				 * 
 * ***************************************************** *
 * 										 				 *
 *  		Java Programming class final project 		 *
 * 										 				 *
 *				by Heo Kyujeong, Park JaeHyung	 		 *
 * 										 				 *
 * 										 				 *
 * ***************************************************** */
  

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import java.awt.Panel;
import java.awt.GridLayout;

import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FileManager extends JFrame
{
	public static final String APP_TITLE = "File Management";

	/** Used to get file Information. */
	private Desktop desktop;
	private FileSystemView fileSystemView;
	private File currentFile;

	/** File-System tree */
	private DefaultTreeModel treeModel;

	/** Table model for File[]. */
	private FileTableModel fileTableModel;
	private ListSelectionListener listSelectionListener;
	private FileListModel listTableModel;
	private int rowIconPadding = 6;

	/** valuables to use GUI */
	private JPanel gui;
	private JPanel pnTopMenu;
	
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnEdit;
	private JMenu mnView;
	private JMenu mnHelp;
	private JMenu mnColor;

	private JMenuItem mntmOpenFolder;
	private JMenuItem mntmOpenFile;
	private JMenuItem mntmNewFolder;
	private JMenuItem mntmNewFile;
	private JMenuItem mntmDelete;
	private JMenuItem mntmExit;
	private JMenuItem mntmRename;
	private JMenuItem mntmCopy;
	private JMenuItem mntmCut;
	private JMenuItem mntmPaste;
	private JMenuItem mntmDetails;
	private JMenuItem mntmList;
	private JMenuItem mntmColorCyan;
	private JMenuItem mntmColorWhite;
	private JMenuItem mntmColorYellow;
	private JMenuItem mntmColorRed;
	
	private Font font1;               
	private Font font2;
	private Font font3;             

	private JMenu mnFont;                        
	private JMenuItem mntmFontBold;		
	private JMenuItem mntmFontRoman;					
	private JMenuItem mntmFontItalic;        
	private JSplitPane pnViewMenu;
	private JSplitPane pnLocation;
	private JTextField txtLocationValue;
	private JLabel lblLocation;

	private JScrollPane pnScrollTree;
	private JTree tree;
	private JPanel pnFile;
	private CardLayout cardLayout;
	private JPanel pnCard;
	private JScrollPane pnScrollTable;
	private JScrollPane pnScrollSimple;
	private JTable table;
	private JTable listTable;
	private JPanel pnFileDetails;
	private JPanel pnDetailsLabels;
	private JLabel lblName;
	private JLabel lblPath;
	private JLabel lblModi;
	private JLabel lblSize;
	private JPanel pnDetailsValues;
	private JLabel lblNameValue;
	private JTextField txtPathValue;
	private JLabel lblModiValue;
	private JLabel lblSizeValue;
	private JPanel pnProgressBar;
	private JProgressBar progressBar;
	
	/** Used to create file */
	private FileInputStream input;
	private FileOutputStream output;
	
	private String fileName;
	private String dirFiles[];
	private boolean copiedIsDir;
	private File src;
	private File cuttedFile;
	private boolean isCutted;	// File is copied or cutted
	private boolean canPaste;	// Tells whether Copied/Cutted File is exist or not
	private boolean isList;		// Tells whether the current mode is a detail or a list
	private boolean cellSizesSet = false;
	private boolean cellSizesSetL = false;

	public FileManager()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 487);
		gui = new JPanel();
		gui.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(gui);
		gui.setLayout(new BorderLayout(0, 0));

		fileSystemView = FileSystemView.getFileSystemView();
		desktop = Desktop.getDesktop();

		pnTopMenu = new JPanel();
		gui.add(pnTopMenu, BorderLayout.NORTH);
		pnTopMenu.setLayout(new BorderLayout(0, 0));

		menuBar = new JMenuBar();
		pnTopMenu.add(menuBar, BorderLayout.NORTH);

		mnFile = new JMenu("File");
		menuBar.add(mnFile);

		/** Folder open */
		mntmOpenFolder = new JMenuItem("Open Folder");
		mntmOpenFolder.setAccelerator(KeyStroke.getKeyStroke('O',InputEvent.CTRL_MASK)); // Hotkey[Ctrl+O]
		mntmOpenFolder.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				openFile("Directory");
			}
		});

		mntmOpenFolder.setHorizontalAlignment(SwingConstants.LEFT);
		mnFile.add(mntmOpenFolder);

		/** File open */
		mntmOpenFile = new JMenuItem("Open File");
		mntmOpenFile.setAccelerator(KeyStroke.getKeyStroke('O',
				InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK)); // Hotkey[Ctrl+Shift+O]
		mntmOpenFile.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				openFile("File");
			}
		});
		mntmOpenFile.setHorizontalAlignment(SwingConstants.LEFT);
		mnFile.add(mntmOpenFile);

		/** Create new folder */
		mntmNewFolder = new JMenuItem("New Folder");
		mntmNewFolder.setAccelerator(KeyStroke.getKeyStroke('N',
				InputEvent.CTRL_MASK)); // Hotkey[Ctrl + N]
		mntmNewFolder.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				newFolder();
			}
		});
		mntmNewFolder.setHorizontalAlignment(SwingConstants.LEFT);
		mnFile.add(mntmNewFolder);

		/** Create new file */
		mntmNewFile = new JMenuItem("New File");
		mntmNewFile.setAccelerator(KeyStroke.getKeyStroke('N',
				InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK)); // Ctrl+Shift+N
		mntmNewFile.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				newFile();
			}
		});
		mnFile.add(mntmNewFile);

		/** Delete file */
		mntmDelete = new JMenuItem("Delete");
		mntmDelete
				.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));// Delete
		mntmDelete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				deleteFile();
			}
		});

		mnFile.add(mntmDelete);

		/** Exit Process */
		mntmExit = new JMenuItem("Exit");
		mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));// Escape
		mntmExit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				exitFile();
			}
		});
		mnFile.add(mntmExit);

		mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);

		/** Rename file / folder */
		mntmRename = new JMenuItem("Rename");
		mntmRename.setAccelerator(KeyStroke.getKeyStroke('R',
				InputEvent.CTRL_MASK));// CTRL + R
		mntmRename.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				renameFile();
			}
		});
		mnEdit.add(mntmRename);

		/** Copy file */
		mntmCopy = new JMenuItem("Copy");
		mntmCopy.setAccelerator(KeyStroke.getKeyStroke('Q',
				InputEvent.CTRL_MASK)); // Ctrl + N
		mntmCopy.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				copyFile();
				isCutted = false;
				canPaste = true;
			}
		});
		mnEdit.add(mntmCopy);

		/** Cut file */
		mntmCut = new JMenuItem("Cut");
		mntmCut.setAccelerator(KeyStroke
				.getKeyStroke('E', InputEvent.CTRL_MASK)); // Ctrl + N
		mntmCut.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				cutFile();
				isCutted = true;
				canPaste = true;
			}
		});
		mnEdit.add(mntmCut);

		/** Paste file */
		mntmPaste = new JMenuItem("Paste");
		mntmPaste.setAccelerator(KeyStroke.getKeyStroke('W',
				InputEvent.CTRL_MASK));
		mntmPaste.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if (canPaste)	// If cutted/copied file is exist
				{
					pasteFile();
					if (isCutted)	// If existed file is cutted file
					{
						currentFile = cuttedFile;
						deleteFile();	// delete original file
					}
				}
				else
				{
					showErrorMessage("Copied file not Exist", "Copy / Cut File");
				}
				isCutted = false;
				canPaste = false;
			}
		});
		mnEdit.add(mntmPaste);

		mnView = new JMenu("View");
		menuBar.add(mnView);

		/** View mode to Detail */
		mntmDetails = new JMenuItem("Details");
		mntmDetails.setAccelerator(KeyStroke.getKeyStroke('D',
				InputEvent.CTRL_MASK));
		mntmDetails.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				cardLayout.show(pnCard, "cardTable");
				isList = false;
			}
		});
		mnView.add(mntmDetails);

		/** View mode to List */
		mntmList = new JMenuItem("List");
		mntmList.setAccelerator(KeyStroke.getKeyStroke('L',
				InputEvent.CTRL_MASK));
		mntmList.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				cardLayout.show(pnCard, "cardSimple");
				isList = true;
			}
		});
		mnView.add(mntmList);
		
		mnColor = new JMenu("Color");
		mnView.add(mnColor);
		//change background color to Cyan
		mntmColorCyan = new JMenuItem("Cyan");
		mntmColorCyan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table.setBackground(Color.CYAN);
				listTable.setBackground(Color.CYAN);
			}
		});
		mntmColorCyan.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnColor.add(mntmColorCyan);
		//change background color to Yellow
		mntmColorYellow = new JMenuItem("Yellow");
		mntmColorYellow.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mntmColorYellow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table.setBackground(Color.YELLOW);
				listTable.setBackground(Color.YELLOW);
			}
		});
		mnColor.add(mntmColorYellow);
		//change background color to White
		mntmColorWhite = new JMenuItem("White");
		mntmColorWhite.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mntmColorWhite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table.setBackground(Color.WHITE);
				listTable.setBackground(Color.WHITE);
			}
		});
		//change background color to Red
		mntmColorRed = new JMenuItem("Red");
		mntmColorRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table.setBackground(Color.RED);
				listTable.setBackground(Color.RED);
			}
		});
		mntmColorRed.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnColor.add(mntmColorRed);
		mnColor.add(mntmColorWhite);
		
		mnFont = new JMenu("Font");
		mnView.add(mnFont);
		
		//change font to Bold
		font1 = new Font("BOLD",Font.BOLD, 15);                   
		font2 = new Font("ROMAN_BASELINE",Font.ROMAN_BASELINE,15);
		font3 = new Font("ITALIC", Font.ITALIC, 15) ;  
		
		mntmFontBold = new JMenuItem("Bold");
		mntmFontBold.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.ALT_MASK));
		mntmFontBold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table.setFont(font1);
				listTable.setFont(font1);
			}
		});
		mnFont.add(mntmFontBold);
		
		mntmFontRoman = new JMenuItem("Roman_Baseline");
		mntmFontRoman.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_MASK));
		mntmFontRoman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table.setFont(font2);
				listTable.setFont(font2);
			}
		});
		mnFont.add(mntmFontRoman);
		
		mntmFontItalic = new JMenuItem("Italic");
		mntmFontItalic.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.ALT_MASK));
		mntmFontItalic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table.setFont(font3);
				listTable.setFont(font3);
			}
		});
		mnFont.add(mntmFontItalic);

		/** View help menu */
		mnHelp = new JMenu("Help");
		mnHelp.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				showHelp();
			}
		});
		menuBar.add(mnHelp);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setAutoCreateRowSorter(true);
		table.setShowVerticalLines(false);

		listTable = new JTable();
		listTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listTable.setAutoCreateRowSorter(true);
		listTable.setShowVerticalLines(false);

		// listener that's notified when a lists selection value changes
		listSelectionListener = new ListSelectionListener()
		{
			@Override
			public void valueChanged(ListSelectionEvent lse)
			{

				if (!isList)
				{
					int row = table.getSelectionModel().getLeadSelectionIndex();
					setFileDetails(((FileTableModel) table.getModel())
							.getFile(row));
				}
				else
				{
					int row = listTable.getSelectionModel()
							.getLeadSelectionIndex();
					setFileDetails(((FileListModel) listTable.getModel())
							.getFile(row));
				}
			}
		};
		table.getSelectionModel().addListSelectionListener(
				listSelectionListener);

		listTable.getSelectionModel().addListSelectionListener(
				listSelectionListener);

		// the File tree
		DefaultMutableTreeNode root = new DefaultMutableTreeNode();
		treeModel = new DefaultTreeModel(root);

		// listener that's notified when the TreeSelectionModel changes
		TreeSelectionListener treeSelectionListener = new TreeSelectionListener()
		{
			public void valueChanged(TreeSelectionEvent tse)
			{
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tse
						.getPath().getLastPathComponent();
				showChildren(node);
				setFileDetails((File) node.getUserObject());
			}
		};

		// show the file system roots.
		File[] roots = fileSystemView.getRoots();
		for (File fileSystemRoot : roots)
		{
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(
					fileSystemRoot);
			root.add(node);
			
			// show the file system
			File[] files = fileSystemView.getFiles(fileSystemRoot, true);
			for (File file : files)
			{
				if (file.isDirectory())
				{
					node.add(new DefaultMutableTreeNode(file));
				}
			}

		}

		tree = new JTree(treeModel);
		tree.setRootVisible(false);
		tree.addTreeSelectionListener(treeSelectionListener);
		tree.setCellRenderer(new FileTreeCellRenderer());
		tree.expandRow(0);
		pnScrollTree = new JScrollPane(tree);

		tree.setVisibleRowCount(15);

		Dimension preferredSize = pnScrollTree.getPreferredSize();
		Dimension widePreferred = new Dimension(200,
				(int) preferredSize.getHeight());
		pnScrollTree.setPreferredSize(widePreferred);

		txtLocationValue = new JTextField();
		
		lblLocation = new JLabel("Location: ");
		pnLocation = new JSplitPane();
		pnTopMenu.add(pnLocation, BorderLayout.SOUTH);
		pnLocation.setLeftComponent(lblLocation);
		pnLocation.setRightComponent(txtLocationValue);

		txtLocationValue.setColumns(10);

		pnViewMenu = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnScrollTree,
				pnFile);

		gui.add(pnViewMenu, BorderLayout.CENTER);

		pnFile = new JPanel();
		pnViewMenu.setRightComponent(pnFile);
		pnFile.setLayout(new BorderLayout(0, 0));

		cardLayout = new CardLayout();
		pnCard = new JPanel(cardLayout);
		pnFile.add(pnCard);

		// view files in detail layout
		pnScrollTable = new JScrollPane(table); // 자세한 파일 정보 레이아웃
		pnCard.add(pnScrollTable, "cardTable");

		// view files in list layout
		pnScrollSimple = new JScrollPane(listTable); // 간단한 파일 정보 레이아웃
		pnCard.add(pnScrollSimple, "cardSimple");

		pnFileDetails = new JPanel();
		pnFile.add(pnFileDetails, BorderLayout.SOUTH);
		pnFileDetails.setLayout(new BorderLayout(0, 0));

		pnDetailsLabels = new JPanel();
		pnFileDetails.add(pnDetailsLabels, BorderLayout.WEST);
		pnDetailsLabels.setLayout(new GridLayout(0, 1, 2, 0));

		lblName = new JLabel("Name:");
		pnDetailsLabels.add(lblName);

		lblPath = new JLabel("Path:");
		pnDetailsLabels.add(lblPath);

		lblModi = new JLabel("Last Modified:");
		pnDetailsLabels.add(lblModi);

		lblSize = new JLabel("File Size:");
		pnDetailsLabels.add(lblSize);

		pnDetailsValues = new JPanel();
		pnFileDetails.add(pnDetailsValues, BorderLayout.CENTER);
		pnDetailsValues.setLayout(new GridLayout(0, 1, 2, 1));

		lblNameValue = new JLabel("");
		pnDetailsValues.add(lblNameValue);

		txtPathValue = new JTextField();
		pnDetailsValues.add(txtPathValue);
		txtPathValue.setColumns(10);

		lblModiValue = new JLabel("");
		pnDetailsValues.add(lblModiValue);

		lblSizeValue = new JLabel("");
		pnDetailsValues.add(lblSizeValue);

		pnProgressBar = new JPanel();
		gui.add(pnProgressBar, BorderLayout.SOUTH);
		pnProgressBar.setLayout(new BorderLayout(3, 3));

		progressBar = new JProgressBar();
		pnProgressBar.add(progressBar, BorderLayout.EAST);
	}

	/** Open File or Folder */
	private void openFile(String fileType) 
	{
		JFileChooser fileChooser = new JFileChooser();
		
		// if want to open file
		if (fileType.equals("File"))
		{
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		}
		// if want to open directory
		else if (fileType.equals("Directory"))
		{
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		}
		fileChooser.addChoosableFileFilter(new MyFilter(".txt", "txt Files"));
		fileChooser.addChoosableFileFilter(new MyFilter(".hwp", "hwp Files"));
		fileChooser.addChoosableFileFilter(new MyFilter(".jpg", "jpg Files"));
		fileChooser.addChoosableFileFilter(new MyFilter(".avi", "avi Files"));
		
		
		int returnValue = fileChooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION)
		{
			File selectedFile = fileChooser.getSelectedFile();
			try
			{
				desktop.open(selectedFile); // open file
			} catch (Throwable t)
			{
				showThrowable(t);
			}
		}
	}

	/** Make new folder */
	private void newFolder()
	{
		// if the location is not selected
		if (currentFile == null)
		{
			showErrorMessage("No location selected for new file.",
					"Select Location");
			return;
		}

		String newName = JOptionPane.showInputDialog(gui, "Enter Folder Name");

		try
		{
			boolean created;
			File parentFile = currentFile;
			if (!parentFile.isDirectory())
			{
				parentFile = parentFile.getParentFile();
			}
			File file = new File(parentFile, newName);

			created = file.mkdir();

			if (created)
			{
				TreePath parentPath = tree.getSelectionPath();

				DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) parentPath
						.getLastPathComponent();

				// add the new node..
				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(
						file);

				treeModel.insertNodeInto(newNode, parentNode,
						parentNode.getChildCount());
				showChildren(parentNode);
				System.out.println("Folder Created!");
			}
			else
			{
				String msg = "The file '" + file + "' could not be created.";
				showErrorMessage(msg, "Create Failed");
			}

		} catch (Throwable t)
		{
			showThrowable(t);
		}

		gui.repaint();
	}

	/** Make new file */
	private void newFile()
	{
		if (currentFile == null)
		{
			showErrorMessage("No location selected for new file.",
					"Select Location");
			return;
		}

		String newName = JOptionPane.showInputDialog(gui, "Enter File Name");

		try
		{
			boolean created;
			File parentFile = currentFile;

			if (!parentFile.isDirectory())
			{
				parentFile = parentFile.getParentFile();
			}
			File file = new File(parentFile, newName + ".txt");

			// If file name is exist => false
			created = file.createNewFile();

			if (created)
			{
				TreePath parentPath = tree.getSelectionPath();
				DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) parentPath
						.getLastPathComponent();

				showChildren(parentNode);

				System.out.println("File Created!");
			}
			else
			{
				String msg = "The file '" + file + "' could not be created.";
				showErrorMessage(msg, "Create Failed");
			}

		} catch (Throwable t)
		{
			showThrowable(t);
		}

		gui.repaint();
	}

	/** Delete file or folder */
	private void deleteFile() 
	{
		if (currentFile == null)
		{
			showErrorMessage("Not selected for deletion", "Select!!");
			return;
		}

		int result;
		
		// When deleteFile() method called by Paste method
		if (isCutted)
		{
			result = JOptionPane.OK_OPTION;
		}
		// when we want just delete file
		else
		{
			result = JOptionPane.showConfirmDialog(gui,
					"Are you sure you want to delete this file?",
					"Delete File", JOptionPane.ERROR_MESSAGE);
		}
		if (result == JOptionPane.OK_OPTION)
		{
			try
			{
				TreePath parentPath = tree.getSelectionPath();

				DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) parentPath
						.getLastPathComponent();
				boolean isDirec = currentFile.isDirectory();
				boolean deleted = currentFile.delete();
				if (deleted)
				{
					if (isDirec)
					{
						// delete the node
						TreePath currentPath = tree.getSelectionPath();

						DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) currentPath
								.getLastPathComponent();

						treeModel.removeNodeFromParent(currentNode);

					}
					System.out
							.println("<" + currentFile + ">" + " is deleted!");
				}
				else
				{
					TreePath currentPath = tree.getSelectionPath();
					DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) currentPath
							.getLastPathComponent();

					treeModel.removeNodeFromParent(currentNode);
					/* if directory is not empty delete, delete everything until
					   directory is empty and finally delete the selected directory */
					deleteDir(currentFile);
					System.out.println("<" + currentFile + ">" + " is deleted!");
				}
				showChildren(parentNode);
			} catch (Throwable t)
			{
				showThrowable(t);
			}
		}

		gui.repaint();
	}

	public void deleteDir(File file)
	{
		File[] contents = file.listFiles();
		if (contents != null)
		{
			for (File f : contents)
			{
				deleteDir(f);
			}
		}
		file.delete();
	}

	/** Exit the application */
	private void exitFile()
	{
		System.exit(0);
	}

	/** Rename the file or directory */
	private void renameFile()
	{
		if (currentFile == null)
		{
			showErrorMessage("No file selected to rename.", "Select File");
			return;
		}
		String newName = JOptionPane.showInputDialog(gui, "Enter New Name");
		if (newName != null)
		{
			try
			{
				TreePath parentPath = tree.getSelectionPath();

				DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) parentPath
						.getParentPath().getLastPathComponent();

				File newFile;
				boolean renamed = currentFile.renameTo(newFile = new File(
						currentFile.getParentFile(), newName));

				if (renamed)
				{
					if (currentFile.isDirectory())
					{
						TreePath currentPath = tree.getSelectionPath();
						DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) currentPath
								.getLastPathComponent();

						// delete the old node
						treeModel.removeNodeFromParent(currentNode.getNextNode());
						DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(
								newFile);

						// and make new node
						System.out.println(currentNode);
						treeModel.insertNodeInto(newNode, currentNode,currentNode.getChildCount());
					
					}

					else
					{
						currentFile.renameTo(new File(newName));
					}

					showChildren((DefaultMutableTreeNode) parentNode.getLastChild());
					System.out.println("rename Succeed");
				}
				else
				{
					String msg = "The file '" + currentFile
							+ "' could not be renamed.";
					showErrorMessage(msg, "Rename Failed");
				}
			} catch (Throwable t)
			{
				showThrowable(t);
			}
		}
		gui.repaint();
	}

	/** Copy file or directory */
	private void copyFile()
	{
		input = null;
		if (currentFile.isDirectory()) 
		{
			dirFiles = currentFile.list(); // list of file inside the selected folder
			fileName = currentFile.getName();
			src = currentFile;
			copiedIsDir = true;
		}
		else
		{
			try
			{
				input = new FileInputStream(currentFile);
				fileName = currentFile.getName();
				copiedIsDir = false;
			} catch (IOException e)
			{
				System.out.println(e);
			}
		}
		System.out.println(currentFile + " is Copied!");
	}

	/** Cut file or directory */
	private void cutFile()
	{
		cuttedFile = currentFile;
		copyFile();
		System.out.println(currentFile + " is Cutted!");
	}

	/** Paste copied or cutted file */
	private void pasteFile()
	{
		output = null;
		if (copiedIsDir)
		{
			if (currentFile == null)
			{
				showErrorMessage("No location selected for new file.",
						"Select Location");
				return;
			}

			try
			{
				boolean created;
				File parentFile = currentFile;
				if (!parentFile.isDirectory())
				{
					parentFile = parentFile.getParentFile();
				}
				File file = new File(parentFile, fileName);

				created = file.mkdir();

				File srcFolder = src;
				File destFolder = file;

				if (created)
				{

					TreePath parentPath = tree.getSelectionPath();
					DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) parentPath
							.getLastPathComponent();

					// add the new node
					DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(
							file);
					
					treeModel.insertNodeInto(newNode, parentNode,
							parentNode.getChildCount());

					showChildren(parentNode);
				}
				else
				{
					String msg = "The file '" + file
							+ "' could not be created.";
					showErrorMessage(msg, "Create Failed");
				}

				try
				{
					pasteFolder(srcFolder, destFolder);
				} catch (IOException e)
				{
					e.printStackTrace();
				}

			} catch (Throwable t)
			{
				showThrowable(t);
			}

			gui.repaint();
		}
		else
		{
			if (currentFile == null)
			{
				showErrorMessage("No location selected for new file.",
						"Select Location");
				return;
			}

			try
			{
				boolean created;
				File parentFile = currentFile;

				if (!parentFile.isDirectory())
				{
					parentFile = parentFile.getParentFile();
				}

				File file = new File(parentFile, fileName);

				created = file.createNewFile();

				if (created)
				{
					TreePath parentPath = tree.getSelectionPath();
					DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) parentPath
							.getLastPathComponent();

					showChildren(parentNode);
				}
				else
				{
					String msg = "The file '" + file
							+ "' could not be created.";
					showErrorMessage(msg, "Create Failed");
				}

				try
				{	// write contents to new file
					int readBuffer = 0;
					byte[] buffer = new byte[512];
					output = new FileOutputStream(file);
					while ((readBuffer = input.read(buffer)) != -1)
					{
						output.write(buffer, 0, readBuffer);
					}
					input.close();
					output.close();
				} catch (IOException e)
				{
					System.out.println(e);
				}

			} catch (Throwable t)
			{
				showThrowable(t);
			}
		}
	}

	/** Paste folder by reculsive method */
	private void pasteFolder(File src, File dest) throws IOException
	{
		if (src.isDirectory())
		{
			String files[] = src.list();

			for (String pasteFile : files)
			{
				File srcFile = new File(src, pasteFile);
				File destFile = new File(dest, pasteFile);
				pasteFolder(srcFile, destFile);
			}
		}
		else
		{
			FileInputStream in = new FileInputStream(src);
			FileOutputStream out = new FileOutputStream(dest);

			byte[] buffer = new byte[1024];

			int length;
			// copy the file content in bytes
			while ((length = in.read(buffer)) > 0)
			{
				out.write(buffer, 0, length);
			}

			in.close();
			out.close();
		}

	}

	// Help -> show shortcut
	private void showHelp()
	{

		String header[] = { "Command", "Shortcuts", "Description" };
		String contents[][] = { { "Command", "Shortcuts", "Description" },
				{ "Open Folder", "CTRL + O", "Open folder" },
				{ "Open File", "CTRL + SHIFT + O", "Open File" },
				{ "New Folder", "CTRL + N", "Make new Folder" },
				{ "New File", "CTRL + SHIFT + N", "Make new File" },
				{ "Delete", "DELETE", "Delete" },
				{ "Exit", "ESC", "End application" },
				{ "Rename", "CTRL + O", "Open folder by dialog box" },
				{ "Copy", "CTRL + C", "Copy" }, { "Cut", "CTRL + X", "Cut" },
				{ "Paste", "CTRL + V", "Paste" },
				{"Cyan","CTRL + SHIFT + C","Change background color to cyan"},
				{"Yellow","CTRL + SHIFT + Y","Change background color to yellow"},
				{"Red","CTRL + SHIFT + R","Change background color to Red"},
				{"White","CTRL + SHIFT + W","Change background color to White"},
				{"Bold","Alt + B","Change font to Bold"},
				{"Bold","Alt + R","Change font to Roman_Baseline"},
				{"Bold","Alt + I","Change font to Italic"}
				
				};

		JTable helpTable = new JTable(contents, header);

		helpTable.setSize(new Dimension(800, 800));
		helpTable.setPreferredSize(new Dimension(800, helpTable
				.getPreferredSize().height));
		helpTable.setEnabled(false);
		JOptionPane jd = new JOptionPane(helpTable);
		jd.setEnabled(false);
		jd.showMessageDialog(gui, helpTable, "Help", JOptionPane.DEFAULT_OPTION);
	}

	private void showThrowable(Throwable t)
	{
		t.printStackTrace();
		JOptionPane.showMessageDialog(gui, t.toString(), t.getMessage(),
				JOptionPane.ERROR_MESSAGE);
		gui.repaint();
	}

	// show error message
	private void showErrorMessage(String errorMessage, String errorTitle)
	{
		JOptionPane.showMessageDialog(gui, errorMessage, errorTitle,
				JOptionPane.ERROR_MESSAGE);
	}

	/** set Detail table data to detail view */
	private void setTableData(final File[] files)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				if (fileTableModel == null)
				{
					fileTableModel = new FileTableModel();
					table.setModel(fileTableModel);

				}
				table.getSelectionModel().removeListSelectionListener(
						listSelectionListener);
				fileTableModel.setFiles(files);
				table.getSelectionModel().addListSelectionListener(
						listSelectionListener);
				if (!cellSizesSet)
				{
					if (files.length != 0)
					{
						Icon icon = fileSystemView.getSystemIcon(files[0]);

						// size adjustment to better account for icons
						table.setRowHeight(icon.getIconHeight()
								+ rowIconPadding);
					}

					setColumnWidth(0, -1);
					setColumnWidth(4, 100);
					table.getColumnModel().getColumn(3).setMaxWidth(120);

					cellSizesSet = true;
				}
			}
		});

	}
	
	/** set simple table data to list view */
	private void setListTableData(final File[] files)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				if (listTableModel == null)
				{
					listTableModel = new FileListModel();
					listTable.setModel(listTableModel);

				}
				listTable.getSelectionModel().removeListSelectionListener(
						listSelectionListener);
				listTableModel.setFiles(files);
				listTable.getSelectionModel().addListSelectionListener(
						listSelectionListener);

				if (!cellSizesSetL)
				{
					if (files.length != 0)
					{
						Icon icon = fileSystemView.getSystemIcon(files[0]);

						// size adjustment to better account for icons
						listTable.setRowHeight(icon.getIconHeight()
								+ rowIconPadding);
					}

					listTable.getColumnModel().getColumn(0).setMaxWidth(30);
					listTable.getColumnModel().getColumn(1).setMaxWidth(200);

					cellSizesSetL = true;
				}
			}
		});

	}

	/** Set column width in detail view */
	private void setColumnWidth(int column, int width)
	{
		TableColumn tableColumn = table.getColumnModel().getColumn(column);
		if (width < 0)
		{
			// use the preferred width of the header..
			JLabel label = new JLabel((String) tableColumn.getHeaderValue());
			Dimension preferred = label.getPreferredSize();
			// altered 10->14 as per camickr comment.
			width = (int) preferred.getWidth() + 14;
		}
		tableColumn.setPreferredWidth(width);
		tableColumn.setMaxWidth(width);
		tableColumn.setMinWidth(width);
	}

	/** show all file */
	private void showChildren(final DefaultMutableTreeNode node)
	{
		tree.setEnabled(false);
		progressBar.setVisible(true);
		progressBar.setIndeterminate(true);

		SwingWorker<Void, File> worker = new SwingWorker<Void, File>()
		{
			@Override
			public Void doInBackground()
			{
				File file = (File) node.getUserObject();
				if (file.isDirectory())
				{
					File[] files = fileSystemView.getFiles(file, true); // !!
					if (node.isLeaf())
					{
						for (File child : files)
						{
							if (child.isDirectory())
							{
								publish(child);
							}
						}
					}
					setTableData(files);
					setListTableData(files);

				}
				return null;
			}

			@Override
			protected void process(List<File> chunks)
			{
				for (File child : chunks)
				{
					node.add(new DefaultMutableTreeNode(child));
				}
			}

			@Override
			protected void done()
			{
				progressBar.setIndeterminate(false);
				progressBar.setValue(100);
				// progressBar.setVisible(true);
				tree.setEnabled(true);
			}
		};
		worker.execute();
	}

	/** Set detail information of file */
	private void setFileDetails(File file)
	{
		currentFile = file;
		Icon icon = fileSystemView.getSystemIcon(file);
		lblNameValue.setIcon(icon);
		lblNameValue.setText(fileSystemView.getSystemDisplayName(file));
		txtLocationValue.setText(file.getParent());
		txtPathValue.setText(file.getPath());
		lblModiValue.setText(new Date(file.lastModified()).toString());
		lblSizeValue.setText(file.length() + " bytes");

		JFrame f = (JFrame) gui.getTopLevelAncestor();
		if (f != null)
		{
			f.setTitle(APP_TITLE + " :: "
					+ fileSystemView.getSystemDisplayName(file));
		}

		gui.repaint();
	}

	/** Launch the application. */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					FileManager frame = new FileManager();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

}

class MyFilter extends javax.swing.filechooser.FileFilter
{
	String type;
	String desc;

	public MyFilter(String type, String desc)
	{
		this.type = type;
		this.desc = desc;
	}

	public boolean accept(File f)
	{
		return f.getName().endsWith(type) || f.isDirectory();
	}

	public String getDescription()
	{
		return desc;
	}
}