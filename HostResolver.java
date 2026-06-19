// File: HostResolver.java
import java.net.*;
import java.util.Scanner;

public class HostResolver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter domain: ");
        String domain = sc.nextLine().trim();

        try {
            InetAddress[] addresses = InetAddress.getAllByName(domain); // DNS resolution
            System.out.println("\nResolved addresses for: " + domain);
            System.out.println("========================================");

            for (InetAddress a : addresses) {
                System.out.println("Host: " + a.getHostName());
                System.out.println("IP: " + a.getHostAddress());
                System.out.println("Type: " + (a instanceof Inet4Address ? "IPv4" : "IPv6"));
                System.out.println("----------------------------------------");
            }
        } catch (UnknownHostException e) {
            System.out.println("Host cannot be resolved.");
        }
    }
}