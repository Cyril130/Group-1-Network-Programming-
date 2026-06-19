// File: TcpUdpCompareJava.java
// Run: java TcpUdpCompareJava tcpserver | tcpclient | udpserver | udpclient
import java.io.*;
import java.net.*;

public class TcpUdpCompareJava {
    public static void main(String[] args) throws Exception {
        String mode = args.length > 0 ? args[0] : "tcpclient";

        if (mode.equals("tcpserver")) {
            // TCP Server
            ServerSocket ss = new ServerSocket(6000);
            System.out.println("TCP Server waiting on port 6000...");
            Socket s = ss.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            System.out.println("TCP Server received: " + in.readLine());
            out.println("TCP ACK: reliable connection");
            s.close();
            ss.close();
        } 
        else if (mode.equals("tcpclient")) {
            // TCP Client
            Socket s = new Socket("127.0.0.1", 6000);
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out.println("Hello through TCP");
            System.out.println("TCP Client received: " + in.readLine());
            s.close();
        } 
        else if (mode.equals("udpserver")) {
            // UDP Server
            DatagramSocket ds = new DatagramSocket(6001);
            System.out.println("UDP Server waiting on port 6001...");
            byte[] buf = new byte[1024];
            DatagramPacket p = new DatagramPacket(buf, buf.length);
            ds.receive(p);
            System.out.println("UDP Server received: " + new String(p.getData(), 0, p.getLength()));
            byte[] r = "UDP ACK: datagram received".getBytes();
            ds.send(new DatagramPacket(r, r.length, p.getAddress(), p.getPort()));
            ds.close();
        } 
        else {
            // UDP Client
            DatagramSocket ds = new DatagramSocket();
            byte[] msg = "Hello through UDP".getBytes();
            ds.send(new DatagramPacket(msg, msg.length, InetAddress.getByName("127.0.0.1"), 6001));
            byte[] buf = new byte[1024];
            DatagramPacket p = new DatagramPacket(buf, buf.length);
            ds.receive(p);
            System.out.println("UDP Client received: " + new String(p.getData(), 0, p.getLength()));
            ds.close();
        }
    }
}