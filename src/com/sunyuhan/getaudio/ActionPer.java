package com.sunyuhan.getaudio;

import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author sunyuhan
 *
 * 2018��12��12��
 * 
 * ���������߳�
 */
public class ActionPer extends Thread{
	static JTextField jtf = InitGUI.jtf;
	static JTextArea jta = InitGUI.jta;
	@Override
	public void run() {
		String temp = jtf.getText();
		jtf.setText("");
		jta.setText("");
		jta.append("�ѻ�ȡ���ӣ����ڽ���...\n");
		GetAudio client = new GetAudio(temp, "UTF-8");
        String result = client.get();
        if (result.equals("error")) {
        	jta.append("��ַ����ʧ�ܣ�������ĵ�ַ����ȷ��\n");
        	return;
		} else {
			jta.append("�����ɹ�����������...\n");
		}
        String filename = new Download().downloadNet(result);
        if (filename.equals("error")) {
			jta.append("���س��ֹ��ϣ���������ϵ����...\n");
			return;
		}else {
			jta.append("������ϣ��ļ���"+filename+" �뵽������Ŀ¼�²鿴��\n");
		}
	}
	//��ʼ�����������������ý�������󳤶�
	public static void initPB(int max) {
		InitGUI.jpb.setMaximum(max);
	}
	//����������
	public static void addPB(int pb) {
		InitGUI.jpb.setValue(pb);
	}

}
