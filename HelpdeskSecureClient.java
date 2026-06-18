// File: HelpdeskSecureClient.java
// Client for the secure helpdesk server
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class HelpdeskSecureClient {
    static final String HOST = "127.0.0.1";
    static final int PORT = 5001;
    static final String TOKEN = "NET123|";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Registration number: ");
        String reg = sc.nextLine();
        System.out.print("Issue: ");
        String issue = sc.nextLine();

        // Notice: The client adds the token "NET123|" to the start of the message!
        String message = "WRONGTOKEN|S12345:A";

        try (Socket socket = new Socket(HOST, PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            out.println(message);
            System.out.println(in.readLine());
        } catch (IOException e) {
            System.out.println("Server unreachable: " + e.getMessage());
        }
    }
}