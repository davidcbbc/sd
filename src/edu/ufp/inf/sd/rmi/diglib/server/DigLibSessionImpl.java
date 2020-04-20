package edu.ufp.inf.sd.rmi.diglib.server;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

public class DigLibSessionImpl implements DigLibSessionRI {
    private DBMockup db;
    private HashMap<String, DigLibSessionRI> sessions;


    public DigLibSessionImpl(DBMockup db, HashMap<String, DigLibSessionRI> sessions) {
        this.db = db;
        this.sessions = sessions;
    }

    @Override
    public Book[] search(String title, String author) throws RemoteException {
        return db.select(title,author);
    }

    @Override
    public void logout() throws RemoteException {

    }
}
