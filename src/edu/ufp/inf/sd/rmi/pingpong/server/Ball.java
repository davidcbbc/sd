package edu.ufp.inf.sd.rmi.pingpong.server;

import java.io.Serializable;

public class Ball implements Serializable {
    private int id;

    public Ball(int id) {
        this.id = id;
    }

    public int getId(){
        return this.id;
    }
}
