package serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ITchatServeur extends Remote
{
    public void register(ITchatClient c) throws RemoteException;
    public void dispatch(String msg) throws RemoteException;
}
