package thinkingInJava.thread;

import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements Runnable {

	@Override
	public void run() {
		while (true) {
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				// e.printStackTrace();
				System.out.println("sleep interrupted.");
			}
			System.out.println(Thread.currentThread() + " " + this);
		}

	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Thread daemon = new Thread(new SimpleDaemons());
			daemon.setDaemon(true);
			daemon.start();
		}
		System.out.println("all daemons started.");
		try {
			TimeUnit.MILLISECONDS.sleep(175);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
