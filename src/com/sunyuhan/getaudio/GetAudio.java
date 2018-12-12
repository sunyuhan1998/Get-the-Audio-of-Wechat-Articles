package com.sunyuhan.getaudio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * @author sunyuhan
 *
 * 2018��12��11��
 * 
 * ����΢��ͼ�����ӻ�ȡ���е���Ƶ
 * ʵ��ԭ��
	  ΢�Ż�ȡ��Ƶ��ͨ��madiaID���̨������Ƶ�ģ�
	  �����id�ڲ�����Ƶǰ���Ѿ�д��ҳ�����ˣ�����
	  ����Ϊ��voice_encode_fileid��ֻҪ��ȡ��
	  ������Ե�ֵ��������ƴ��url�Ϳ��Ի����Ƶ�����ӡ�
 */
public class GetAudio {
	private String u;
    private String encoding;

    public GetAudio(String u, String encoding) {
        this.u = u;
        this.encoding = encoding;
    }

    public String get(){
    	try {
			// �������ӣ�����һ��URL����
			URL url = new URL(u);
			// ��URL
			HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
			// �õ�������������ҳ����
			BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), encoding));
			String line;
			String result = "";
			while ((line = reader.readLine()) != null) {
			   result +=line;
			}
			//id�ַ�����ʼ��
			int id = result.indexOf("voice_encode_fileid");
			//�����Χֻ��һ����ֵ��һ������MediaID�ĳ���
			result = result.substring(id+21,id+55);
			//id�ַ���������
			int id2 = result.indexOf("\">");
			//MediaID
			result = result.substring(0,id2);
			//ƴ��url
			result = "https://res.wx.qq.com/voice/getvoice?mediaid="+result;
			return result;
		} catch (Exception e) {
			return "error";
		}
    }

}
