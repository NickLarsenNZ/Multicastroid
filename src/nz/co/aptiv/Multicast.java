package nz.co.aptiv;

/**
 * Created by nicklarsen on 22/03/15.
 */
public class Multicast {
    private String group;
    private int port;

    public Multicast(String group,int port) {
        setPort(port);
        setGroup(group);
    }

    public void operate() {
        return;
    }


    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
