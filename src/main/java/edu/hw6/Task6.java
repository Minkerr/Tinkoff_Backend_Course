package edu.hw6;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task6 {
    private Task6() {
    }

    private static final int MIN_PORT = 0;
    private static final int MAX_PORT = 49151;

    private static boolean availableUDP(int port) {
        try (DatagramSocket ds = new DatagramSocket(port)) {
            return true;
        } catch (IOException ignored) {
        }
        return false;
    }

    private static boolean availableTCP(int port) {
        try (ServerSocket ss = new ServerSocket(port)) {
            return true;
        } catch (IOException ignored) {
        }
        return false;
    }

    private static boolean available(int port) {
        return availableTCP(port) && availableUDP(port);
    }

    public static List<Integer> findBusyPorts() throws IOException {
        List<Integer> ports = new ArrayList<>();
        for (int i = MIN_PORT; i <= MAX_PORT; i++) {
            if (!available(i)) {
                ports.add(i);
            }
        }
        return ports;
    }

    @SuppressWarnings("MagicNumber")
    private static Map<Integer, String> generateApplicationMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(135, "EPMAP");
        map.put(137, "NetBIOS Name Service");
        map.put(138, "NetBIOS Datagram Service");
        map.put(139, "NetBIOS Session Service");
        map.put(445, "MICROSOFT-DS");
        map.put(843, "Adobe Flash");
        map.put(1900, "Simple Service Discovery Protocol (SSDP)");
        map.put(3306, "MySQL");
        map.put(3702, "Web Services Dynamic Discovery");
        map.put(5353, "Multicast DNS");
        map.put(17500, "Dropbox");
        map.put(27017, "MongoDB");
        return map;
    }

    @SuppressWarnings("MagicNumber")
    public static List<String[]> findBusyPortsWithInfo() {
        List<Integer> ports = null;
        Map<Integer, String> map = null;
        try {
            ports = findBusyPorts();
            map = generateApplicationMap();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<String[]> table = new ArrayList<>();
        for (Integer port : ports) {
            if (!availableTCP(port)) {
                String[] row = new String[3];
                row[0] = "TCP";
                row[1] = Integer.toString(port);
                row[2] = map.getOrDefault(port, "");
                table.add(row);
            }
            if (!availableUDP(port)) {
                String[] row = new String[3];
                row[0] = "UDP";
                row[1] = Integer.toString(port);
                row[2] = map.getOrDefault(port, "");
                table.add(row);
            }
        }
        return table;
    }
}
