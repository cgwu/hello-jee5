package thinkingInJava.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedDemo implements Runnable {
	private static volatile int cnt = 0;
	private static Lock lock = new ReentrantLock();
	private static Object syncRoot = new Object();

	public/* 方法1: synchronized */void foo() {
		// lock.lock(); //方法2:
		try {
			synchronized (syncRoot) {	//方法3:
				++cnt;
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(cnt + " foo() called:" + this);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// lock.unlock();	//方法2:
		}
		Thread.yield();
	}

	@Override
	public void run() {
		while (true) {
			foo();
		}
	}

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 5; i++) {
			Thread t = new Thread(new SynchronizedDemo());
			t.setDaemon(true);
			t.start();
		}

		TimeUnit.MILLISECONDS.sleep(1000);
	}
}
