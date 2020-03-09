package edu.ufp.inf.sd.rmi.pingpong.server;

        import edu.ufp.inf.sd.rmi.pingpong.client.PongRI;

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
public class PingImpl extends UnicastRemoteObject implements PingRI {

    // Uses RMI-default sockets-based transport
    // Runs forever (do not passivates) - Do not needs rmid (activation deamon)
    // Constructor must throw RemoteException due to export()
    public PingImpl() throws RemoteException {
        // Invokes UnicastRemoteObject constructor which exports remote object
        super();
    }

    @Override
    public void ping(Ball b , PongRI pongRI) throws RemoteException {
        System.out.println("ping(): Id of this ball " + b.getId());
        pongRI.pong(b);
    }
}
