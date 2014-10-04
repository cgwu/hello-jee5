package thinkingInJava.swing;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class JImagePanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = -8091892134707569312L;
	
	private BufferedImage i3;
	private float factor = 1.0f;
	private float offset = 0.0f;
	
	public JImagePanel(){
		try {
			i3 = ImageIO.read(new File("C:\\Users\\cg\\Pictures\\mm.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void paint(Graphics g) {
		super.paint(g);
		RescaleOp r = new RescaleOp(factor, offset, null);
		BufferedImage tmp = r.filter(i3, null);
		g.drawImage(tmp, 0, 0, 440, 589, this);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("变亮")) {
//			System.out.println("lighter");
			this.factor += 0.3;
			this.repaint();
		} else if (arg0.getActionCommand().equals("变暗")) {
//			System.out.println("darker");
			this.factor -= 0.3;
			this.repaint();
		} else if (arg0.getActionCommand().equals("恢复")) {
		} else if (arg0.getActionCommand().equals("退出")) {
		}
	}
}
