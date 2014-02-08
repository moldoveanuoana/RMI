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
public interface I_Generator extends Remote{
    I server_propriu() throws Exception;
}
