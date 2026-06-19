// File: NetworkInterfaceLister.java
import java.net.*;
import java.util.*;

public class NetworkInterfaceLister {
    public static void main(String[] args) throws Exception {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

        System.out.println("========== NETWORK INTERFACE LIST ==========");
        System.out.println();

        while (interfaces.hasMoreElements()) {
            NetworkInterface ni = interfaces.nextElement();

            System.out.println("Interface: " + ni.getName());
            System.out.println("Display: " + ni.getDisplayName());
            System.out.println("Active: " + ni.isUp());
            System.out.println("Multicast: " + ni.supportsMulticast());

            // Get MAC address (if available)
            byte[] mac = ni.getHardwareAddress();
            if (mac != null) {
                System.out.print("MAC: ");
                for (byte b : mac) {
                    System.out.printf("%02X:", b);
                }
                System.out.println();
            } else {
                System.out.println("MAC: Not available");
            }

            // Get IP addresses
            Enumeration<InetAddress> addrs = ni.getInetAddresses();
            while (addrs.hasMoreElements()) {
                InetAddress addr = addrs.nextElement();
                String type = (addr instanceof Inet4Address) ? "IPv4" : "IPv6";
                System.out.println(type + " IP: " + addr.getHostAddress());
            }

            System.out.println("----------------------------------------");
        }
    }
}