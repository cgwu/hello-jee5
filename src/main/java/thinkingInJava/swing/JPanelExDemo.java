package thinkingInJava.swing;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JPanelExDemo {
	public static void main(String[] args) {
		JFrame frame = new JFrame("你好,Swing!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.setLayout(new BorderLayout());
		
//		final JPanel panel = new JPanel();
//		frame.add(panel);
		
		final JImagePanel imgPanel = new JImagePanel();
		frame.add(imgPanel,BorderLayout.CENTER);
		imgPanel.setBounds(0, 100, 600, 600);
		
		JButton btn1 = new JButton("变亮");
		JButton btn2 = new JButton("变暗");
		frame.add(btn1,BorderLayout.WEST);
		frame.add(btn2,BorderLayout.EAST);
		
		btn1.setActionCommand("变亮");
		btn1.addActionListener(imgPanel);
		
		btn2.setActionCommand("变暗");
		btn2.addActionListener(imgPanel);
		
		frame.setVisible(true);
	}
}
