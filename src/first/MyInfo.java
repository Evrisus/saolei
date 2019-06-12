package first;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MyInfo extends JFrame {

	private static final long serialVersionUID = 1L;

	public MyInfo() {
		// TODO Auto-generated constructor stub
		JFrame frame = new JFrame("个人页");
		JLabel label = new JLabel("齐培贵罗烈项目", SwingConstants.CENTER);
		frame.setSize(300, 300);
		frame.add(label);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}

}
