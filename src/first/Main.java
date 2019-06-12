package first;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Main extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;

	// ǰ�ڲ�������
	JMenuItem JmiNew, JmiSave, JmiOpen, JmiExit, Jmichuji, Jmizhongji, Jmigaoji, JmishowInFo, JmiZiding;

	Toolkit toolKit = Toolkit.getDefaultToolkit();

	Clipboard clipboard = toolKit.getSystemClipboard();
														
	//����ͼ��
	ImageIcon icon = new ImageIcon("G:\\eclipse-workspace\\classTest_ThunderGame\\mine.png");
	ImageIcon icon1 = new ImageIcon("G:\\eclipse-workspace\\classTest_ThunderGame\\flag.png");
	private static int NUM = 1;// ���NuM�����������Ա�дһ���������ı�
	// private static final int SNUM = 9;// ���SUM��ɨ�׵ĸ��������Ա�д�������ı�
	private JButton[][] jb;
	private int[][] map;
	boolean[][] flags;
	boolean[][] flag;
	int coutTime;



	public Main(int SNUM, int Mines) {// ��Ҫ���湹�캯��
		setTitle("ɨ��");


		// ��ʼ������
		NUM = Mines;

		JMenuBar greenBar = new JMenuBar();// �˵�����
		greenBar.setOpaque(true);
		greenBar.setBackground(new Color(250, 250, 250));
		greenBar.setPreferredSize(new Dimension(800, 28));
		greenBar.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));

		//�˵�
		JMenu fileMenu1 = new JMenu("��Ϸ");
		JMenu fileMenu2 = new JMenu("�Ѷ�");
		JMenu fileMenu3 = new JMenu("����:");
		greenBar.add(fileMenu1);
		greenBar.add(fileMenu2);
		greenBar.add(JmishowInFo = fileMenu3);
		fileMenu1.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
		fileMenu2.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
		fileMenu3.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
		// �˵���
		fileMenu1.add(JmiNew = new JMenuItem("����Ϸ "));
		fileMenu1.add(JmiSave = new JMenuItem("���а�"));
		fileMenu1.add(JmiZiding = new JMenuItem("�Զ���"));
		fileMenu1.addSeparator();
		fileMenu1.add(JmiExit = new JMenuItem("�˳�"));
		fileMenu2.add(Jmichuji = new JMenuItem("����"));
		fileMenu2.add(Jmizhongji = new JMenuItem("�м� "));
		fileMenu2.add(Jmigaoji = new JMenuItem("�߼� "));
		fileMenu3.add(JmishowInFo = new JMenuItem("��������Ϣ "));
		JmiNew.addActionListener(this);
		JmiExit.addActionListener(this);
		JmiSave.addActionListener(this);
		JmishowInFo.addActionListener(this);
		Jmichuji.addActionListener(this);
		Jmizhongji.addActionListener(this);
		Jmigaoji.addActionListener(this);
		JmiZiding.addActionListener(this);
		JmiZiding.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
		JmishowInFo.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
		JmiNew.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
		JmiSave.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
		JmiExit.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
		Jmichuji.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
		Jmizhongji.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
		Jmigaoji.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
		setJMenuBar(greenBar);
		Image icon = Toolkit.getDefaultToolkit().getImage("G:\\eclipse-workspace\\classTest_ThunderGame\\mine.png");
		setIconImage(icon);
		setLayout(new GridLayout(SNUM, SNUM));
		jb = new JButton[SNUM][SNUM];
		map = new int[SNUM][SNUM]; //����ťӳ�䵽������
		flags = new boolean[map.length][map[0].length];//����㿪��¼��
		flag = new boolean[map.length][map[0].length];//����㿪��¼��
		int count = 0;

		// ����
		while (count < NUM) {
			int i = (int) (Math.random() * map.length);// hang
			int j = (int) (Math.random() * map[0].length);// lie
			if (map[i][j] != '*') {
				map[i][j] = '*';
				count++;

			}
		}
		for (int i = 0; i < SNUM; i++) {
			for (int j = 0; j < SNUM; j++) {
				jb[i][j] = new JButton();
				jb[i][j].setName(i + "_" + j);
				jb[i][j].setBackground(new Color(220, 220, 220));

				jb[i][j].setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 10));
				jb[i][j].addActionListener(this);
				jb[i][j].addMouseListener(this);// ����mouse����
				add(jb[i][j]);

			}

		}

		// ��ʱ��
		JLabel ststus = new JLabel();
		JLabel Times = new JLabel();
		JLabel miao = new JLabel();
		add(ststus);
		add(Times);
		Times.setText(" 0  ");
		miao.setText("��");
		setTimer(Times);
		coutTime = 0;
		ststus.setText("                                              ʱ��");
		greenBar.add(ststus);
		greenBar.add(Times, RIGHT_ALIGNMENT);
		greenBar.add(miao, RIGHT_ALIGNMENT);
		Times.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
		ststus.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
		miao.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 16));
		setSize(700, 700);
		setLocationRelativeTo(null);
		setVisible(true);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // ������һ��
	}
		
	
	private void setTimer(JLabel time) {//ʱ�����
		final JLabel varTime = time;

		Timer timeAction = new Timer(1000, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				coutTime++;
				varTime.setText("" + coutTime);
			}
		});
		timeAction.start();
	}

	private void showTheClick(int x, int y) {// ����¼�ʵ��
		if (map[x][y] == '*') {

			jb[x][y].setIcon(icon);
			showMines();
		} else {
			int count1 = 0;
			for (int a = x - 1; a <= x + 1; a++) {
				for (int b = y - 1; b <= y + 1; b++) {
					if (!(a < 0 || b < 0 || b >= map[0].length || a >= map.length) && map[a][b] == '*')
						count1++;
				}
			}
			flags[x][y] = true;
			if (count1 == 0) {
				jb[x][y].setBackground(Color.white);
			} else {
				jb[x][y].setText(count1 + "");
				jb[x][y].setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 20));
				jb[x][y].setBackground(Color.white);
			}

			if (count1 == 0) {
				for (int i = x - 1; i <= x + 1; i++) {
					for (int j = y - 1; j <= y + 1; j++) {
						if (!(i < 0 || j < 0 || i >= map.length || j >= map[0].length)) {
							if (!(i == x && j == y) && flags[i][j] == false) {
								showTheClick(i, j);//ѭ������
							} else {
								//��ֹ�ظ�����
							}

						}

					}
				}
			}
		}
	}

	private void showMines() {// ��ʾ������
		// TODO Auto-generated method stub
		for (int i = 0; i < map.length; i++) {// ����
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] == '*') {
					jb[i][j].setIcon(icon);
					//

				}
			}
		}

		// ������Ϸ
		int b = JOptionPane.showOptionDialog(null, "��ѽ��ը��ը�ˣ�����Ϸ��", "ȷ�Ͽ�", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, null, null);
		if (b == 1) {
			System.exit(0);

		} else {
			setVisible(false);
			new Main(map.length,NUM);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {//�����ʾ
		// TODO Auto-generated method stub
		if (e.getSource() == JmiNew) {
			setVisible(false);
			new Main(map.length,NUM);
		} else if (e.getSource() == JmiSave) {

		
		} else if (e.getSource() == JmiExit) {
			System.exit(0);
		} else if (e.getSource() == JmiZiding) {
			new SelfMines();
		} else if (e.getSource() == Jmichuji) {
			setVisible(false);
			new Main(5,3);
		} else if (e.getSource() == JmishowInFo) {
			new MyInfo();
		} else if (e.getSource() == Jmizhongji) {
			setVisible(false);
			new Main(10,10);
		} else if (e.getSource() == Jmigaoji) {
			setVisible(false);
			new Main(20,60);
		} else {
			Object obj = e.getSource();
			int x, y;
			String[] strM = ((JButton) obj).getName().split("_");
			x = Integer.parseInt(strM[0]);
			y = Integer.parseInt(strM[1]);

			showTheClick(x, y);

			checkSuccess();// ����Ƿ���Ϸ����
		}

	}



	private void checkSuccess() {
		// TODO Auto-generated method stub
		int count = map.length * map[0].length;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (flags[i][j] == true)
					count--;
			}
		}
		if (count == NUM) {
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");//��Ψһ��ʾuuid


			int i = JOptionPane.showOptionDialog(null, "��ϲ������ˣ��Ƿ������", "ȷ�Ͽ�", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, null, null);
			// ststus.setText("hello"+i);
			if (i == 1) {
				System.exit(0);

			} else {
				setVisible(false);
				new Main(map.length,NUM);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int c = e.getButton();
		if (c == MouseEvent.BUTTON3) {
			Object obj1 = e.getSource();
			int x, y;

			String[] strM = ((JButton) obj1).getName().split("_");
			x = Integer.parseInt(strM[0]);
			y = Integer.parseInt(strM[1]);
			if (flag[x][y] == false && flags[x][y] == false) {//������
				jb[x][y].setIcon(icon1);
				flag[x][y] = true;
			} else {
				jb[x][y].setIcon(null);
				flag[x][y] = false;

			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
