package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class getiddress {

	public static void main(String[] args) throws UnknownHostException { 
        // ֱ��ͨ��InetAddress.getLocalHost()������ȡ��ip��ַ, ��ʵ����ִ��hostname -i �õ���ip��ַ
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println("ip ��ַ:" + inetAddress.getHostAddress() + ", �Ƿ��ǻػ�����: " + inetAddress.isLoopbackAddress());
    }
}
