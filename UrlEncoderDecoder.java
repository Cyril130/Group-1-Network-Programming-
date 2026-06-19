// File: UrlEncoderDecoder.java
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UrlEncoderDecoder {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("========== URL ENCODER / DECODER ==========");
        System.out.print("Text: ");
        String text = sc.nextLine();

        // Encode the text for safe URL use
        String encoded = URLEncoder.encode(text, StandardCharsets.UTF_8);
        
        // Decode the encoded text back to original
        String decoded = URLDecoder.decode(encoded, StandardCharsets.UTF_8);

        System.out.println();
        System.out.println("Encoded: " + encoded);
        System.out.println("Decoded: " + decoded);
        
        sc.close();
    }
}
