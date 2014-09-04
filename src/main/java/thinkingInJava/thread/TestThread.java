package thinkingInJava.thread;

public class TestThread {

	public static void main(String[] args) throws Exception {
		Thread thread = new Thread(new LiftOff());
		thread.start();
		
		thread.join();	//wait thread exit.
		
		System.out.println();
		System.out.println("main exit.");
	}

}
