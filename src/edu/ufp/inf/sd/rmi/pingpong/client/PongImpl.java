package edu.ufp.inf.sd.rmi.pingpong.client;

import edu.ufp.inf.sd.rmi.pingpong.server.Ball;
import edu.ufp.inf.sd.rmi.pingpong.server.PingRI;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <p>Title: Projecto SD</p>
 * <p>Description: Projecto apoio aulas SD</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: UFP </p>
 * @author Rui S. Moreira
 * @version 3.0
 */
public class PongImpl extends UnicastRemoteObject implements PongRI {

    PingRI pingRI;
    // Uses RMI-default sockets-based transport
    // Runs forever (do not passivates) - Do not needs rmid (activation deamon)
    // Constructor must throw RemoteException due to export()
    public PongImpl(PingRI p) throws RemoteException {
        // Invokes UnicastRemoteObject constructor which exports remote object
        super();
        pingRI = p;
    }

    @Override
    public void pong(Ball b) throws RemoteException {
        //System.out.println("CalculadorImpl - print(): someone called me with msg = "+ msg);
        System.out.println("Pong with ball id " + b.getId());
        pingRI.ping(b, this);
    }

    @Override
    public void startPlaying(Ball b) throws RemoteException {
        //System.out.println("CalculadorImpl - print(): someone called me with msg = "+ msg);
        System.out.println("startPlaying with ball id " + b.getId());
        pingRI.ping(b, this);
    }
}
