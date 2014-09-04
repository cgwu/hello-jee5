package thinkingInJava.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class TaskWithResult implements Callable<String> {
	private int id;

	public TaskWithResult(int id) {
		this.id = id;
	}

	@Override
	public String call() throws Exception {
//		TimeUnit.SECONDS.sleep(id);
		return "TaskWithResult.id=" + id;
	}

}
