
public class DuplicateValueException extends Exception {
	
	public DuplicateValueException()
	{
		super("Integer can not be a duplicate.");
	}
	
	public DuplicateValueException(String message)
	{
		super(message);
	}

}
