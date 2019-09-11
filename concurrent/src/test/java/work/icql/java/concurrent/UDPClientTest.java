package work.icql.java.concurrent;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;

/**
 * @author icql
 * @version 1.0
 * @date 2019/5/30 11:09
 * @Title UDPClientTest
 * @Description UDPClientTest
 */
public class UDPClientTest {
    public static void main(String[] args) throws Exception {
        DatagramSocket clientSocket = new DatagramSocket();
        byte[] receiveBuffer = new byte[1024];
        byte[] sendBuffer;

        InetAddress idAddress = Inet4Address.getLocalHost();
        for (int i = 0; i < 100; i++) {

            sendBuffer = ("test" + i).getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, idAddress, 9000);
            clientSocket.send(sendPacket);
            System.out.println(("test" + i));

            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            clientSocket.receive(receivePacket);
            String receiveMsg = new String(receivePacket.getData());
            System.out.println(receiveMsg);
        }
        clientSocket.close();
    }
}
