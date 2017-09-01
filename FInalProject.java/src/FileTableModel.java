

import java.io.File;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.AbstractTableModel;

/** File table model for referencing in detail view */
class FileTableModel extends AbstractTableModel
{

	private File[] files;
	private FileSystemView fileSystemView = FileSystemView.getFileSystemView();
	private String[] columns = { "Icon", "File", "Type", "Size",
			"Last Modified", };

	FileTableModel()
	{
		this(new File[0]);
	}

	FileTableModel(File[] files)
	{
		this.files = files;
	}

	public Object getValueAt(int row, int column)
	{
		File file = files[row];
		switch (column)
		{
		case 0:
			// file icon
			return fileSystemView.getSystemIcon(file);
		case 1:
			// file name
			return fileSystemView.getSystemDisplayName(file);
		case 2:
			// file type
			return fileSystemView.getSystemTypeDescription(file);
		case 3:
			// file size
			calSize fSize = getSize(file.length());
			return String.format(fSize.fileSize + " " + fSize.Unit);
		case 4:
			// last modified time
			return file.lastModified(); 
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
		case 3:
			return Long.class;
		case 4:
			return Date.class;
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

	// change file size bytes => any unit
	public calSize getSize(long _fileSize) 
	{
		calSize siz = new calSize();
		int _Unit = 0;
		while (_fileSize > 1024 && _Unit < 5)
		{
			_fileSize = _fileSize / 1024;
			_Unit++;
		}
		siz.fileSize = _fileSize;

		switch (_Unit)
		{
		case 0:
			siz.Unit = "Bytes";
			break;
		case 1:
			siz.Unit = "KB";
			break;
		case 2:
			siz.Unit = "MB";
			break;
		case 3:
			siz.Unit = "GB";
			break;
		case 4:
			siz.Unit = "TB";
			break;
		}

		return siz;
	}

	// Make class to return file size and unit at the same time
	public class calSize 
	{
		long fileSize;
		String Unit;

		calSize()
		{
			fileSize = 0;
			Unit = null;
		}
	}
}