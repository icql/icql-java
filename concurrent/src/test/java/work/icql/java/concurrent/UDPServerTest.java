package work.icql.java.concurrent;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author icql
 * @version 1.0
 * @date 2019/5/30 10:03
 * @Title UDPServerTest
 * @Description UDPServerTest
 */
public class UDPServerTest {
    public static void main(String[] args) throws Exception{
        DatagramSocket serverSocket = new DatagramSocket(9000);
        byte[] receiveBuffer = new byte[1024];
        byte[] sendBuffer = new byte[1024];

        while(true){
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer,receiveBuffer.length);
            serverSocket.receive(receivePacket);
            String receiveMsg = new String(receivePacket.getData());
            InetAddress address = receivePacket.getAddress();
            int port = receivePacket.getPort();

            sendBuffer = ("ECHO:" + address.getHostName() + receiveMsg).getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer,sendBuffer.length,address,port);
            serverSocket.send(sendPacket);

            if("exit".equals(receiveMsg.toLowerCase())){
                break;
            }
        }
        serverSocket.close();
    }
}
