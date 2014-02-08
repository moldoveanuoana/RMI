/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rmi;

/**
 *
 * @author Oana-Maria
 */
import java.rmi.*;

public interface I extends Remote{
    double afis_mem() throws RemoteException;
    void adunare_mem(double i) throws RemoteException;
    double adunare(double i) throws RemoteException;
    double curent() throws RemoteException;
    double scadere(double i) throws RemoteException;
    void scadere_mem(double i) throws RemoteException;
    double inmultire(double i) throws RemoteException;
    public double impartire(double i) throws RemoteException;
    double patrat() throws RemoteException;
    String putere(double i) throws RemoteException;
    String factorial() throws RemoteException;
    double inversare() throws RemoteException;
    void stoc() throws RemoteException;
    void citeste() throws RemoteException;
    void sterge() throws RemoteException;
    void sterge_c() throws RemoteException;
}