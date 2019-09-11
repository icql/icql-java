package work.icql.java.concurrent;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author icql
 * @version 1.0
 * @date 2019/5/30 10:03
 * @Title TCPServerTest
 * @Description TCPServerTest
 */
public class TCPServerTest {
    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(9999);
        boolean flag;
        System.out.println("服务器开始运行......");
        flag = true;
        while(flag){
            final Socket client = server.accept();

            new Thread(new Runnable(){
                @Override
                public void run(){
                    boolean runFlag = true;
                    try{
                        InetAddress addr = client.getInetAddress();
                        System.out.println("客户端："+ addr.getHostName() + "\t" + addr.getHostAddress()  + "连接成功" );
                        Scanner scan = new Scanner(client.getInputStream());
                        PrintStream out = new PrintStream(client.getOutputStream());

                        while(runFlag){
                            if(scan.hasNext()){
                                String str = scan.next();
                                if("Exit".equalsIgnoreCase(str.trim())){
                                    out.println("Bye!!!");
                                    runFlag = false;
                                    System.out.println("客户端："+ addr.getHostName() + "/t" + addr.getHostAddress()  + "退出连接" );
                                }
                                out.println("ECHO:" + str.trim());
                            }
                        }
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                    try{
                        client.close();
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                }
            }).start();

        }
        System.out.println("服务器停止运行......");
        server.close();
    }
}
