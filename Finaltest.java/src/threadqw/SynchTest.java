package threadqw;

public class SynchTest implements Runnable {
	private int c = 0;

	public synchronized void value() {
		for (int i = 0; i < 10000; i++) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		// Create the object with the run() method
		Runnable runnable = new SynchTest();

		// Create the thread supplying it with the runnable object
		Thread thread = new Thread(runnable, "thread-1");
		Thread thread2 = new Thread(runnable, "thread-2");
		// Here the key point is passing same object, if you pass runnable2 for
		// thread2,
		// then its not applicable for synchronization test and that wont give
		// expected
		// output Synchronization method means "it is not possible for two
		// invocations
		// of synchronized methods on the same object to interleave"

		// Start the thread
		thread.start();
		thread2.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		value();
	}

}
