package threadqw;

public class HelloRunnable implements Runnable {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread x = new Thread(new HelloRunnable(){
			@Override
				public void run()
				{
					System.out.println("Hello from a thread!");
				}
		});
		x.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}


	
	
}
