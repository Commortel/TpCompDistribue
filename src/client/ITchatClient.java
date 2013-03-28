package client;

import java.rmi.Remote;

public interface ITchatClient extends Remote
{
    public void connect(String svr);
    public void send(String msg);
    public void receive(String msg);
}
