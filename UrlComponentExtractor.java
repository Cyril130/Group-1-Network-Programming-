// File: UrlComponentExtractor.java
import java.net.*;
import java.util.Scanner;

public class UrlComponentExtractor {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter URL: ");
        URL u = new URL(sc.nextLine().trim());

        System.out.println("\n========== URL COMPONENTS ==========");
        System.out.println("Protocol: " + u.getProtocol());
        System.out.println("Host: " + u.getHost());
        System.out.println("Port: " + (u.getPort() == -1 ? "Default" : u.getPort()));
        System.out.println("Path: " + u.getPath());
        System.out.println("Query: " + (u.getQuery() != null ? u.getQuery() : "None"));
        System.out.println("Fragment: " + (u.getRef() != null ? u.getRef() : "None"));
        
        sc.close();
    }
}