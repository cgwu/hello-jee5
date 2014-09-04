package thinkingInJava.thread;

public class MoreBasicThread {
	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 5; i++) {
			// new Thread(new LiftOff()).start();
			Thread t = new Thread(new LiftOff());
			if (i == 4) {
				t.setPriority(Thread.MAX_PRIORITY);
			}
			t.start();
			// t.join();
		}

		System.out.println();
		System.out.println("Waiting for LiftOff!");
	}
}
