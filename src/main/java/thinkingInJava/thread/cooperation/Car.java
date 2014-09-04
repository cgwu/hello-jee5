package thinkingInJava.thread.cooperation;

public class Car {
	private volatile boolean waxOn = false;

	public synchronized void waxed() {
		waxOn = true;
		notifyAll();
	}

	public synchronized void buffed() {
		waxOn = false;
		notifyAll();
	}

	public synchronized void waitForWaxing() throws InterruptedException {
		if (waxOn == false)
			wait();
	}

	public synchronized void waitForBuffing() throws InterruptedException {
		if (waxOn == true)
			wait();
	}
}
