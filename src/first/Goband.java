package first;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Goband extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	Dimension demission= new Dimension(1000, 600);
	public Goband() {
		super("������");


		setLayout(null);
		// ����ͼ
		ImageIcon icon = new ImageIcon("G:\\eclipse-workspace\\classTest_ThunderGame\\backgroud1.jpg");
		ImageIcon icon1 = new ImageIcon("G:\\eclipse-workspace\\classTest_ThunderGame\\Gogame.jpg");
		//��������������		
		
        //��ͼƬ����label�� 
        JLabel label=new JLabel(icon);  
        JLabel GameImageContainer=new JLabel(icon1);  
          
        //����label�Ĵ�С
        label.setBounds(0,0,1000,800);  
        GameImageContainer.setBounds(100, 500, 400, 400);
        GameImageContainer.setLocation(100, 500);
          
        JFrame frame=new JFrame();  
          
        //��ȡ���ڵĵڶ��㣬��label����
        frame.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));  
              
        //��ȡframe�Ķ���������������Ϊ͸��
        JPanel j=(JPanel)frame.getContentPane();  
        j.setOpaque(false);  
  
        JPanel panel=new JPanel();  
        JPanel panel1=new JPanel();  
        panel1.setBounds(0, 0, 200, 200);

        panel1.add(GameImageContainer);
     
        panel.setOpaque(false);  
        panel1.setOpaque(false);  
        
        frame.add(panel);  
        frame.add(panel1);  
        frame.setSize(demission);  
        frame.setVisible(true);  
  
  
  
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Goband();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
