package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class getiddress {

	public static void main(String[] args) throws UnknownHostException { 
        // 直接通过InetAddress.getLocalHost()方法获取的ip地址, 其实就是执行hostname -i 得到的ip地址
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println("ip 地址:" + inetAddress.getHostAddress() + ", 是否是回环网卡: " + inetAddress.isLoopbackAddress());
    }
}
