package thinkingInJava.thread;

import java.util.concurrent.TimeUnit;

public class Sleeper extends Thread {
	private int duration;

	public Sleeper(String name, int duration) {
		super(name);
		this.duration = duration;
		start();
		System.out.println(name+" after Sleeper() construction.");
	}

	@Override
	public void run() {
		try {
			TimeUnit.MILLISECONDS.sleep(duration);
		} catch (InterruptedException e) {
			System.out.println(this.getName() + " is interrupted." + "isInterrupted():"
					+ this.isInterrupted());
			return;
		}
		System.out.println(getName() + " has awakened");
	}

}
