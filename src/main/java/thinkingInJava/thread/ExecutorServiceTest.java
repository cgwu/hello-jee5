package thinkingInJava.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceTest {

	public static void main(String[] args) throws Exception{
//		ExecutorService exec = Executors.newCachedThreadPool();
//		ExecutorService exec = Executors.newFixedThreadPool(5);
//		ExecutorService exec = Executors.newScheduledThreadPool(5);
		ExecutorService exec = Executors.newSingleThreadExecutor();
		for(int i=0;i<5;i++)
			exec.execute(new LiftOff());
		
		exec.shutdown();
		
		//awaitTermination : Blocks until all tasks have completed execution after a shutdown request, 
		//or the timeout occurs, or the current thread is interrupted, 
		//whichever happens first.
		exec.awaitTermination(1, TimeUnit.MINUTES);	
		
		System.out.println();
		System.out.println("Waiting for LiftOff!");
		
	}

}
