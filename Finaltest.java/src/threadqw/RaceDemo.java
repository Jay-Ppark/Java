package threadqw;

public class RaceDemo {
	public static void main(String[] args) {
		Racer racer = new Racer();
		Thread tortoiseThread = new Thread(racer, "Tortoise");
		Thread hareThread = new Thread(racer, "Hare");
		Thread DuckThread = new Thread(racer, "Duck");
		Thread CatThread = new Thread(racer, "Cat");
		//Race to start. tell threads to start
		tortoiseThread.start();
		hareThread.start();
		DuckThread.start();
		CatThread.start();
		System.out.println(tortoiseThread.isInterrupted());
		System.out.println(hareThread.isInterrupted());
		System.out.println(DuckThread.isInterrupted());
		System.out.println(CatThread.isInterrupted());
	}
}
