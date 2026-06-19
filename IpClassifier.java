// File: IpClassifier.java
import java.net.*;
import java.util.*;

public class IpClassifier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter IP addresses to classify. Press Enter (empty line) to exit.");
        System.out.println("========================================");

        while (true) {
            System.out.print("IP: ");
            String value = sc.nextLine().trim();
            
            if (value.isEmpty()) {
                System.out.println("Exiting...");
                break;
            }

            try {
                InetAddress a = InetAddress.getByName(value);
                
                // Check if it's IPv4 (contains dots and matches IPv4 pattern)
                if (value.contains(":") && !value.contains(".")) {
                    System.out.println(value + " is IPv6");
                } else if (value.matches("^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}$")) {
                    System.out.println(value + " is IPv4");
                } else if (value.contains(":")) {
                    System.out.println(value + " is IPv6");
                } else {
                    System.out.println(value + " is not a direct IP literal (it may be a hostname)");
                }
            } catch (Exception e) {
                System.out.println(value + " is INVALID");
            }
        }
    }
}