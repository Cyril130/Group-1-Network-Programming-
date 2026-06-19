// File: NetworkDevices.java
interface NetworkDevice {
    void connect();
    void sendData(String data);
    void disconnect();
}

class EthernetDevice implements NetworkDevice {
    public void connect() {
        System.out.println("Ethernet connected");
    }

    public void sendData(String data) {
        System.out.println("Ethernet sending: " + data);
    }

    public void disconnect() {
        System.out.println("Ethernet disconnected");
    }
}

class WiFiDevice implements NetworkDevice {
    public void connect() {
        System.out.println("Wi-Fi connected");
    }

    public void sendData(String data) {
        System.out.println("Wi-Fi sending: " + data);
    }

    public void disconnect() {
        System.out.println("Wi-Fi disconnected");
    }
}

public class NetworkDevices {
    public static void main(String[] args) {
        // Create an array of NetworkDevice objects
        NetworkDevice[] devices = {
            new EthernetDevice(),
            new WiFiDevice()
        };

        // Polymorphism in action: same method calls, different behavior
        for (NetworkDevice d : devices) {
            d.connect();
            d.sendData("Lab test message");
            d.disconnect();
            System.out.println(); // Blank line between devices
        }
    }
}