package nz.co.aptiv;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * Created by nicklarsen on 22/03/15.
 */
public class MulticastRx extends Multicast {


    public MulticastRx(String group, int port) {
        super(group, port);
    }

    public void operate() {
        System.out.println("Multicast Receiver on Group: " + this.getGroup() + ":" + this.getPort());

        MulticastSocket socket = null;
        DatagramPacket packet = null;
        byte[] buffer = new byte[256];

        try {
            socket = new MulticastSocket(this.getPort());
            InetAddress address = InetAddress.getByName(this.getGroup());
            socket.joinGroup(address);

            while(true) {
                packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String msg = new String(buffer, 0, packet.getLength());
                System.out.println("Got message from : " + this.getGroup() + ":" + this.getPort() + " -> " + msg);
            }

        } catch (IOException ioe) {
            System.err.println("\nIOException: " + ioe.getMessage());
        }

    }
}
