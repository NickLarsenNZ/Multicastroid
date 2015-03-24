package nz.co.aptiv;

import com.sun.org.apache.xpath.internal.operations.Mult;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * Created by nicklarsen on 22/03/15.
 */
public class MulticastTx extends Multicast {

    public MulticastTx(String group, int port) {
        super(group, port);
    }

    public void operate(int ttl, int interval) {
        System.out.println("Multicast Sender on Group: " + this.getGroup() + ":" + this.getPort());
        System.out.println("Send interval: " + interval + "ms");
        System.out.println("Packet TTL: " + ttl);
        String updateMsg = "";

        MulticastSocket socket = null;
        DatagramPacket packet = null;
        byte[] buffer;

        try {
            //socket = new DatagramSocket();
            socket = new MulticastSocket();
            long counter = 0;
            String msg = "";

            while(true) {
                msg = "Multicast message " + ++counter;
                buffer = msg.getBytes();

                InetAddress address = InetAddress.getByName(this.getGroup());
                packet = new DatagramPacket(buffer, buffer.length, address, this.getPort());

                socket.setTimeToLive(ttl);

                socket.send(packet);

                updateMsg = "Sent packet: " + counter + "\r";
                System.out.write(updateMsg.getBytes());
                try {
                    Thread.sleep(interval);
                } catch (InterruptedException ie) {
                    System.err.println("\nThread Interupt Exception: " + ie.getMessage());
                }
            }
        } catch (IOException ioe) {
            System.err.println("\nIOException: " + ioe.getMessage());
        }

    }
}
