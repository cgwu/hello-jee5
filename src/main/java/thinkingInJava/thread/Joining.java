package thinkingInJava.thread;

public class Joining {

	public static void main(String[] args) {
		Sleeper zhangsan = new Sleeper("张三", 1500);
		Joiner lisi = new Joiner("李四", zhangsan);

		Sleeper wangwu = new Sleeper("王五", 1500);
		Joiner zhaoliu = new Joiner("赵六", wangwu);

		zhangsan.interrupt();
	}

}
