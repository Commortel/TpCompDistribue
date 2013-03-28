package serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ITchatClient extends Remote
{
    public void connect(String svr) throws RemoteException;
    public void send(String msg) throws RemoteException;
    public void receive(String msg) throws RemoteException;
}
