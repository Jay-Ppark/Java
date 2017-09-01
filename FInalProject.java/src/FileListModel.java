

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.AbstractTableModel;

/** File table model for referencing in list view */
class FileListModel extends AbstractTableModel
{

	private File[] files;
	private FileSystemView fileSystemView = FileSystemView.getFileSystemView();
	private String[] columns = { "", "", };

	FileListModel()
	{
		this(new File[0]);
	}

	FileListModel(File[] files)
	{
		this.files = files;
	}

	public Object getValueAt(int row, int column)
	{
		File file = files[row];
		switch (column)
		{
		case 0:
			return fileSystemView.getSystemIcon(file);
		case 1:
			return fileSystemView.getSystemDisplayName(file);
		default:
			System.err.println("Logic Error");
		}
		return "";
	}

	public int getColumnCount()
	{
		return columns.length;
	}

	public Class<?> getColumnClass(int column)
	{
		switch (column)
		{
		case 0:
			return ImageIcon.class;
		}
		return String.class;
	}

	public String getColumnName(int column)
	{
		return columns[column];
	}

	public int getRowCount()
	{
		return files.length;
	}

	public File getFile(int row)
	{
		return files[row];
	}

	public void setFiles(File[] files)
	{
		this.files = files;
		fireTableDataChanged();
	}


}