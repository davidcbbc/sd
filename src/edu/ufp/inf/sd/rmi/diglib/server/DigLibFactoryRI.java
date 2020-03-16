package edu.ufp.inf.sd.rmi.diglib.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author rmoreira
 */
public interface DigLibFactoryRI extends Remote {
    public boolean register(String uname, String pw) throws RemoteException;
    public DigLibSessionRI login(String uname, String pw) throws RemoteException;
}