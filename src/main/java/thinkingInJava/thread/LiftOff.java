package thinkingInJava.thread;

public class LiftOff implements Runnable {
	protected int countDown = 10;

	private static int taskCount = 0;
	private final int id = taskCount++;

	public void LifetOff() {
	}

	public void LifetOff(int countDown) {
		this.countDown = countDown;
	}

	public String status() {
		return "#" + id + "(" + countDown + "), ";
	}

	@Override
	public void run() {
		while (countDown > 0) {
			System.out.print(status());
			countDown--;
			Thread.yield();
		}
	}
}
