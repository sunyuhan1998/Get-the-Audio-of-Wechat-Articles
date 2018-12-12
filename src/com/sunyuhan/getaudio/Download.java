package com.sunyuhan.getaudio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author sunyuhan
 *
 * 2018��12��12��
 * 
 * ����ģ��
 */
public class Download {
	 URLConnection conn =null;
     InputStream inStream = null;
     FileOutputStream fs = null;
     File filePath = null;//���غ���ļ�·��
     String filename = "";//���غ���ļ���
	public String downloadNet(String path){
		if (path.equals("error")) {
			return "error";
		}
        try {
        	int byteread = 0;
        	int bytenum = 0;
            URL url = new URL(path);
            long fileLength = ProgressBar.getFileLength(path);
            ActionPer.initPB((int)fileLength);
            conn = url.openConnection();
            inStream = conn.getInputStream();
            //����������Ϊ�ļ���
            filename = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss").format(new Date())+".mp3";
            //ȡ��ǰλ�þ���·��
            filePath = new File("");
            String finalFile = filePath.getAbsolutePath()+"\\����\\"+filename;
            //�����ļ����
            fs = new FileOutputStream(finalFile);
            //����
            byte[] buffer = new byte[1204];
            while ((byteread = inStream.read(buffer)) != -1) {
                fs.write(buffer, 0, byteread);
                //�ƶ�������
                bytenum+=byteread;
                ActionPer.addPB(bytenum);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "���س��ִ���\n";
        }finally {
			try {
				fs.close();
			} catch (IOException e) {
				return "�ļ����ر�ʧ�ܣ�\n";
			}
		}
        return filename;
    }

}
