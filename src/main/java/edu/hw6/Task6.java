package edu.hw6;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Task6 {
    private Task6() {
    }

    private static final int MIN_PORT = 0;
    private static final int MAX_PORT = 49151;

    private static final Map<Integer, String> APPLICATION_MAP = Map.of(
        135, "EPMAP",
        137, "NetBIOS Name Service",
        138, "NetBIOS Datagram Service",
        139, "NetBIOS Session Service",
        445, "MICROSOFT-DS",
        843, "Adobe Flash",
        1900, "Simple Service Discovery Protocol (SSDP)",
        3306, "MySQL",
        3702, "Web Services Dynamic Discovery",
        5353, "Multicast DNS"
    );

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
    public static List<String[]> findBusyPortsWithInfo() {
        List<String[]> table = new ArrayList<>();
        for (int port = MIN_PORT; port <= MAX_PORT; port++) {
            if (!availableTCP(port)) {
                String[] row = new String[3];
                row[0] = "TCP";
                row[1] = Integer.toString(port);
                row[2] = APPLICATION_MAP.getOrDefault(port, "");
                table.add(row);
            }
            if (!availableUDP(port)) {
                String[] row = new String[3];
                row[0] = "UDP";
                row[1] = Integer.toString(port);
                row[2] = APPLICATION_MAP.getOrDefault(port, "");
                table.add(row);
            }
        }
        return table;
    }
}
