package first;
import java.awt.*;  
import javax.swing.*;  
  
  
public class  ImageDemo  
{  
  
  
    public ImageDemo(){  
        //����ͼƬ
        ImageIcon icon=new ImageIcon("G:\\eclipse-workspace\\classTest_ThunderGame\\backgroud1.jpg");  
        //Image im=new Image(icon);  
        //��ͼƬ����label
        JLabel label=new JLabel(icon);  
          
        //����label�Ĵ�С
        label.setBounds(0,0,800,600);  
          
        JFrame frame=new JFrame();  
          
        //��ȡ���ڵĵڶ��㣬��label����
        frame.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));  
              
        //��ȡframe�Ķ���������������Ϊ͸��
        JPanel j=(JPanel)frame.getContentPane();  
        j.setOpaque(false);  
  
        JPanel panel=new JPanel();  
        JTextField jta=new JTextField(10);  
        //JTextArea jta=new JTextArea(10,60);  
        JButton jb=new JButton("ȷ��");  
        JButton jb2=new JButton("����");  
  
        panel.add(jta);  
        panel.add(jb);  
        panel.add(jb2);  
  
        panel.setOpaque(false);  
  
        frame.add(panel);  
        frame.add(panel);  
        frame.setSize(800,600);  
        frame.setVisible(true);  
  
  
  
  
    }  
    public static void main(String[] args)   
    {  
        new ImageDemo();  
    }  
} 