// File: PortScanner.java
import java.net.*;

public class PortScanner {
    public static void main(String[] args) {
        String host = args.length > 0 ? args[0] : "127.0.0.1";
        int[] ports = {21, 22, 25, 53, 80, 443};

        System.out.println("Scanning host: " + host);
        System.out.println("================================");

        for (int port : ports) {
            try (Socket socket = new Socket()) {
                socket.connect(new InetSocketAddress(host, port), 1000); // 1-second timeout
                System.out.println("Port " + port + " is OPEN");
            } catch (Exception e) {
                System.out.println("Port " + port + " is CLOSED");
            }
        }
    }
}
