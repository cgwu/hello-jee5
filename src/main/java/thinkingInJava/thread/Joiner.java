package thinkingInJava.thread;

public class Joiner extends Thread {
	Sleeper sleeper;

	public Joiner(String name, Sleeper sleeper) {
		super(name);
		this.sleeper = sleeper;
		start();
	}

	@Override
	public void run() {
		try {
			sleeper.join();
		} catch (InterruptedException e) {
			System.out.println(getName() + " is interrupted.");
		}
		System.out.println(getName() + " join completed.");
	}
}
