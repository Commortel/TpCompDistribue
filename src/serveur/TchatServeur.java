package serveur;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TchatServeur extends UnicastRemoteObject implements ITchatServeur
{
    private ArrayList<ITchatClient> list;
    
    public TchatServeur() throws RemoteException
    {
        this.list =  new ArrayList<>();
    }
    
    @Override
    public void register(ITchatClient c) throws RemoteException
    {
        this.list.add(c);
    }
    
    @Override
    public void dispatch(String msg) throws RemoteException
    {
        for(int i = 0; i < this.list.size(); i++)
            this.list.get(i).receive(msg);
    }
    
    public static void main(String args[])
    {
        try 
        {
            ITchatServeur ts = new TchatServeur();
            Naming.rebind("serveur", ts);
            System.out.println("Serveur launched");
        } 
        catch (Exception e) 
        {
            Logger.getLogger(TchatServeur.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
}
