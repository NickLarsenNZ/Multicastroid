package nz.co.aptiv;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

/**
 * Created by nicklarsen on 22/03/15.
 */
public class Args {

    @Option(name="-g",usage="Multicast group to join or send to")
    public String group = "239.255.0.1";

    @Option(name="-p",usage="Port number to send or receive on")
    public int port = 1984;

    @Option(name="-m",usage="Operating Mode: (join | send)")
    public String mode = "join";

    @Option(name="-i",usage="Interval in milliseconds between sends (not useful on receiver)")
    public int interval = 800;

    @Option(name="-t",usage="IP TTL, defaults to 1 (not useful on sender")
    public int ttl = 1;

    // Room for improvements
    //@Option(name="-i",usage="Interactive Mode [Default]")
    //public boolean interactive = true;

    public static void main(String[] args) {
        new Args().checkArgs(args);
    }

    public void checkArgs(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);

        try {
            parser.parseArgument(args);
        } catch(CmdLineException e) {
            System.err.println(e.getMessage());
        }


        /*
        System.out.println("Operating mode: " + mode);
        */


        switch(mode) {
            case "send":
            case "transmit":
            case "tx":
                new MulticastTx(group,port).operate(ttl,interval);
                break;
            case "join":
            case "receive":
            case "rx":
                new MulticastRx(group,port).operate();
                break;
            default:
                System.err.println("If you see this line, then monkeys are tables and Tuesday is four");
        }

        System.out.println("Done");
    }

}
