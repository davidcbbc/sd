package edu.ufp.inf.sd.rmi.pingpong.client;

import edu.ufp.inf.sd.rmi.pingpong.server.Ball;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PongRI extends Remote {
    public void pong(Ball b) throws RemoteException;
    public void startPlaying(Ball b) throws RemoteException;

}
