// File: ReachabilityChecker.java
import java.net.*;
import java.util.Scanner;

public class ReachabilityChecker {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter hostname or IP: ");
        String host = sc.nextLine().trim();

        long start = System.currentTimeMillis();

        try {
            InetAddress address = InetAddress.getByName(host); // Resolve host name.
            boolean reachable = address.isReachable(3000); // 3-second timeout.
            long elapsed = System.currentTimeMillis() - start;

            System.out.println("IP Address: " + address.getHostAddress());
            System.out.println("Reachable: " + reachable);
            System.out.println("Time taken: " + elapsed + " ms");
        } catch (UnknownHostException e) {
            System.out.println("Host cannot be resolved.");
        }
    }
}