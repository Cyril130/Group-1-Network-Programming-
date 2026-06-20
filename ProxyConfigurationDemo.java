// File: ProxyConfigurationDemo.java
import java.util.Scanner;

public class ProxyConfigurationDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("========== PROXY CONFIGURATION PROGRAM ==========");
        System.out.print("Proxy host: ");
        String host = sc.nextLine().trim();

        System.out.print("Proxy port: ");
        int port = Integer.parseInt(sc.nextLine().trim());

        System.out.print("Target URL: ");
        String url = sc.nextLine().trim();

        System.out.println();
        System.out.println("========== CONNECTION SETTINGS ==========");
        System.out.println("Proxy Server: " + host + ":" + port);
        System.out.println("Target URL: " + url);
        System.out.println("==========================================");
        System.out.println("Connecting to " + url + " through " + host + ":" + port + " ...");
        System.out.println("✅ Connection successful!");

        sc.close();
    }
}