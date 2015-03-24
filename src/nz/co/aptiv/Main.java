package nz.co.aptiv;


import java.util.Properties;

public class Main {



    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println("\nDone");
            }
        });

        // Some fixes for Dual-Stack (TTL wasn't being set)
        Properties props = System.getProperties();
        props.setProperty("java.net.preferIPv4Stack","true");
        System.setProperties(props);

        System.out.println("Multicastroid has started");
        System.out.println("Going to the Args parser");
        Args.main(args);

    }
}
