package thinkingInJava.thread;

public class Test {

	public static void main(String[] args) {
		LiftOff lo = new LiftOff();
		lo.run();
		
		System.out.println();
		System.out.println("main exit.");
	}
}
