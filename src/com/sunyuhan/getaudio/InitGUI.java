package com.sunyuhan.getaudio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author sunyuhan
 *
 * 2018��12��11��
 * 
 * GUI���ƣ�һ����ʾ��һ��������һ�������
 */
public class InitGUI extends JFrame{
	private static final long serialVersionUID = 1L;
	static JFrame jf1 = new JFrame("��ȡ΢��ͼ����Ƶ author��SunYuHan");	
	static JTextArea jta;
	static JTextField jtf;
	static JProgressBar jpb;
	//���ƴ��ڷ���
	public void init() {
		//��ʼ��
		jta = new JTextArea();
		jpb = new JProgressBar();
		jtf = new JTextField("�ڴ�����΢��ͼ������");
		//��������
		jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf1.setLocation(600, 150);
		jf1.setSize(550, 190);
		jf1.setResizable(false);
		jf1.setLayout(null);
		jta.setEditable(false);
		jpb.setMaximum(0);
		jpb.setStringPainted(true);
		jtf.setEditable(true);
		jta.setBounds(0, 0, 550, 90);
		jpb.setBounds(0, 102, 550, 15);
		jtf.setBounds(0, 124, 550, 30);
		//��ӵ�����
		jf1.add(new JScrollPane(jta));
		jf1.add(jta);
		jf1.add(jpb);
		jf1.add(jtf);
		//�ɼ�
		jf1.setVisible(true);
		
		jtf.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				 jtf.setText("�ڴ�����΢��ͼ������");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				 jtf.setText("");
				
			}
		});
		jtf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!jtf.getText().equals("")) {
					new ActionPer().start();
				}
			}

		});
	}

}
