package first;
import java.awt.*;  
import javax.swing.*;  
  
  
public class  ImageDemo  
{  
  
  
    public ImageDemo(){  
        //加载图片
        ImageIcon icon=new ImageIcon("G:\\eclipse-workspace\\classTest_ThunderGame\\backgroud1.jpg");  
        //Image im=new Image(icon);  
        //将图片放入label
        JLabel label=new JLabel(icon);  
          
        //设置label的大小
        label.setBounds(0,0,800,600);  
          
        JFrame frame=new JFrame();  
          
        //获取窗口的第二层，将label放入
        frame.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));  
              
        //获取frame的顶层容器，并设置为透明
        JPanel j=(JPanel)frame.getContentPane();  
        j.setOpaque(false);  
  
        JPanel panel=new JPanel();  
        JTextField jta=new JTextField(10);  
        //JTextArea jta=new JTextArea(10,60);  
        JButton jb=new JButton("确定");  
        JButton jb2=new JButton("重置");  
  
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