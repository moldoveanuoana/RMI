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
import java.io.IOException;
import java.rmi.*;
import java.util.*;
import sss.I_Generator;
import sss.I;
public class Client
{

    public static void main(String[] args) throws RemoteException, Exception {
        double val = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Adresa serverului: ");
        String adresa = sc.next();
        int port =  sc.nextInt();
        String url = "rmi://" + adresa+ ":" + port + "/Ob";
        I_Generator Ob = null;
        I serv = null;
        try {
             Ob = (I_Generator) Naming.lookup(url);
        }
        catch(Exception e) {
             System.out.println("Conectare esuata");
             System.exit(0);
        }
        try {
            serv = Ob.server_propriu();
        }
        catch(Exception e) {
             System.out.println(e.getMessage());
        }
        System.out.println("Meniu:");
        System.out.println("+ Adunare");
        System.out.println("- Scadere");
        System.out.println("* Inmultire");
        System.out.println("/ Impartire");
        System.out.println("# Radical");
        System.out.println("^ La o putere");
        System.out.println("! Factorial");
        System.out.println("$ Inversare");
        System.out.println("A Afisarea valorii curente");
        System.out.println("S Deconectarea clientului!");
        System.out.println("& Stocheaza in memorie valoarea!");
        System.out.println("C Valoarea memoriei devine operandul curent!");
        System.out.println("X Valoarea memoriei este (re)initializata cu 0!");
        System.out.println("= Afiseaza valoarea din memorie");
        System.out.println("~ Scade din memorie operandul curent");
        System.out.println("Q Aduna la memorie operandul curent");
        String c = "+-*/#^!$AS&CX~Q=";
        double x = 0;
        String s= null;
        try{
            boolean ok = true;
            for( ; ; ) {
                try{
                System.out.print("Operatie dorita : ");
                ok = true;
              
                s = sc.nextLine();
                if(s.length()!= 1 || c.contains(s)== false) 
                    throw new Exception("Comanda introdusa nu e valida!");
                else{
                    if(s.equals("A")){
                       ok= false;
                       System.out.println("Valoarea curenta este: " + serv.curent());
                    }
                    if(s.equals("S")){
                        System.out.println("Valoarea curenta este: " + serv.curent());
                        ok= false;
                        System.exit(0);
                    }
                   if(s.equals("&")){
                       ok=false;
                       serv.stoc();
                   }
                   if(s.equals("C")){
                       ok=false;    
                       serv.citeste();
                   }      
                   if(s.equals("X")){
                        ok=false;
                        serv.sterge();
                   }
                   if(s.equals("!")){
                       ok= false;
                       String o =serv.factorial();
                       if(o.compareTo("-1") == 0 ){
                           System.out.println("Factorialul nu s-a putut aplica, fie din cauza ca numarul nu este natural fie din acauza ca valoarea rezultata e prea mare!");
                           serv.sterge_c();
                           System.out.println("Valoarea curenta este: " + serv.curent());
                        }
                       else
                           System.out.println("Valoarea curenta este: " + o);
                   }
                   if(s.equals("#")){
                       ok=false;
                       if(serv.curent() <0){
                           System.out.println("Radicalul de ordin 2 se aplica pe numere pozitive");
                           serv.sterge_c();
                           System.out.println("Valoarea curenta este: " + serv.curent());
                       }
                      else
                           System.out.println("Valoarea curenta este: " + serv.patrat());
                   }
                   if(s.equals("$")){
                       ok= false;
                       if(serv.curent()==0){
                           System.out.println("Nu se poate imparti la 0!!!");
                           serv.sterge_c();
                           System.out.println("Valoarea curenta este: " + serv.curent());
                       }
                       else 
                           System.out.println("Valoarea curenta este: " + serv.inversare());
                   }
                   if(s.equals("=")){
                       ok=false;
                       System.out.println("Valoarea din memorie este: " + serv.afis_mem());
                   }
                   if(s.equals("~")){
                       ok=false;
                       serv.scadere_mem(serv.curent());
                   }
                   if(s.equals("Q")){
                       ok=false;
                       serv.adunare_mem(serv.curent());
                   }
                   if(ok){
                        System.out.print("Valoarea : ");
                        try{
                            String ss = sc.nextLine();
                            x= Double.parseDouble(ss);
                       }
                       catch(Exception e){
                            System.out.println("Numarul nu a fost introdus corespunzator!");
                       }
                       if(s .equals("+"))
                           System.out.println("Valoarea curenta este: " +  serv.adunare(x));
                       else
                           if(s.equals("-"))
                              System.out.println("Valoarea curenta este: " + serv.scadere(x));
                           else
                               if(s.equals("*"))
                                  System.out.println("Valoarea curenta este: " + serv.inmultire(x));
                               else
                                   if(s.compareTo("/") == 0){
                                       if(x == 0){
                                          System.out.println("Infinit! => resetam valoarea curenta");
                                          serv.sterge_c();
                                          System.out.println("Valoarea curenta este: " + serv.curent());
                                       }
                                       else{
                                           double y = serv.impartire(x);
                                           System.out.println("Valoarea curenta este: " + y);
                                       }
                                    }
                                   else
                                       if(s.equals("^")){
                                          String p =serv.putere(x);
                                          if(p.compareTo("NaN") == 0){
                                              System.out.println("Not a number...initializam valoarea curenta automat cu 0");
                                              serv.sterge_c();
                                              System.out.println("Valoarea curenta este: " + serv.curent());
                                          }
                                          else
                                              System.out.println("Valoarea curenta este: " + p);    
                                       }
                   }
                 }
               }
               catch(Exception e){
                    if(e.getMessage().compareTo("Connection refused to host: 192.168.1.10; nested exception is: \n" +
                          "	java.net.ConnectException: Connection refused: connect")== 0)
                        throw new IOException("A aparut o eroare!");
                    else
                         System.out.println(e.getMessage());
               }
             
          }
       }
        catch(Exception e){
            if(e.getMessage().compareTo("A aparut o eroare!")==0)
                System.out.println(" S-a intrerupt legatura cu serverul!");
            else
                System.out.println("Ati fost deconectat!");
            System.exit(0);
        }
      
    }
}
