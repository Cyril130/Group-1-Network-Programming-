// File: LocalHostInfo.java
import java.net.*;
import java.util.*;

public class LocalHostInfo {
    public static void main(String[] args) throws Exception {
        // Get and display local host information
        InetAddress local = InetAddress.getLocalHost();
        System.out.println("Local host: " + local.getHostName());
        System.out.println("Local IP: " + local.getHostAddress());
        System.out.println("========================================");

        // Get all network interfaces
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

        while (interfaces.hasMoreElements()) {
            NetworkInterface ni = interfaces.nextElement();

            System.out.println("\nInterface: " + ni.getName() + " - " + ni.getDisplayName());
            System.out.println("  Active: " + ni.isUp());
            System.out.println("  Multicast: " + ni.supportsMulticast());

            // Get MAC address (hardware address)
            byte[] mac = ni.getHardwareAddress();
            if (mac != null) {
                System.out.print("  MAC Address: ");
                for (byte b : mac) {
                    System.out.printf("%02X:", b);
                }
                System.out.println();
            } else {
                System.out.println("  MAC Address: Not available");
            }

            // Get all IP addresses assigned to this interface
            Enumeration<InetAddress> addrs = ni.getInetAddresses();
            while (addrs.hasMoreElements()) {
                InetAddress addr = addrs.nextElement();
                String type = (addr instanceof Inet4Address) ? "IPv4" : "IPv6";
                System.out.println("  " + type + " Address: " + addr.getHostAddress());
            }
        }
    }
}