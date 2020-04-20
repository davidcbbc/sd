package edu.ufp.inf.sd.rmi.diglib.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class DigLibFactoryImpl extends UnicastRemoteObject implements DigLibFactoryRI {

    private DBMockup db;// = new DBMockup();
    //private ThreadPool pool;// = new ThreadPool(10);
    private HashMap<String, DigLibSessionRI> sessions;// = new HashMap();

    /**
     * Uses RMI-default sockets-based transport. Runs forever (do not
     * passivates) hence, does not need rmid (activation deamon) Constructor
     * must throw RemoteException due to super() export().
     */
    public DigLibFactoryImpl() throws RemoteException {
// Invokes UnicastRemoteObject constructor which exports remote object
        super();
        db = new DBMockup();
//pool = new ThreadPool(10);
        sessions = new HashMap();
    }

    @Override
    public boolean register(String uname, String pw) throws RemoteException {
        if(!db.exists(uname,pw)){
            db.register(uname,pw);
            return true;
        }
        return false;
    }

    @Override
    public DigLibSessionRI login(String uname, String pw) throws RemoteException {
        if (db.exists(uname, pw)) {
            if(!this.sessions.containsKey(uname)){
                DigLibSessionRI digLibSessionRI = new DigLibSessionImpl(this.db,this.sessions);
                this.sessions.put(uname,digLibSessionRI);
                return digLibSessionRI;
            } else {
                return this.sessions.get(uname);
            }
        }
        return null;
    }
}