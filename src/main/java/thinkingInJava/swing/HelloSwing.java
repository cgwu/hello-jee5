package thinkingInJava.swing;

import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class HelloSwing {
	public static void main(String[] args) {
		JFrame frame = new JFrame("你好,Swing!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,600);
		
		final JLabel label = new JLabel("一个标签");
		frame.add(label);
		
		frame.setVisible(true);
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		label.setText("新的标签内容");
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				label.setText("新的标签内容");
			}
		});
		
	}
}
