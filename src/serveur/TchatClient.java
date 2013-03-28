package serveur;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import serveur.TchatServeur;

public class TchatClient extends UnicastRemoteObject implements ITchatClient 
{
    private ITchatServeur serveur;
    
    public TchatClient() throws RemoteException
    {
    }
            
    @Override
    public void connect(String svr) throws RemoteException
    {
        try 
        {
            this.serveur = (ITchatServeur) Naming.lookup(svr);
            System.out.println("Client connecté");
            this.serveur.register(this);
        } 
        catch (Exception e) 
        {
            Logger.getLogger(TchatClient.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void send(String msg) throws RemoteException
    {
       this.serveur.dispatch(msg);
    }

    @Override
    public void receive(String msg) throws RemoteException
    {
        System.out.println(msg);
    }
    
    public static void main(String args[]) throws RemoteException
    {
        ITchatClient tc = new TchatClient();
        tc.connect("serveur");
        //tc.send("Hello World");
    }

}
