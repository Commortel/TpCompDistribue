package serveur;

import client.TchatClient;
import java.rmi.Remote;

public interface ITchatServeur extends Remote
{
    public void register(TchatClient c);
    public void dispatch(String msg);
}
