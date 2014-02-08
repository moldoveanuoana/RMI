 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sss;

/**
 *
 * @author Oana-Maria
 */

import java.rmi.registry.*;
import java.util.Scanner;
//import sss.Generator;

public class Server {

public static void main(String[] args) throws Exception {
    try{
        Generator Ob = new Generator();
        Scanner sc = new Scanner(System.in);
        System.out.print("Portul : ");
        int port = sc.nextInt();
        Registry reg = LocateRegistry.createRegistry(port);
        reg.rebind("Ob",Ob);
        System.out.println("Serverul s-a legat la" + " registrul RMI");
    }
    catch(Exception e){
        System.out.println("Deconectare!");
        System.exit(0);
    }
 }
}
