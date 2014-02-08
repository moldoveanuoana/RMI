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
import java.rmi.*; 
import java.rmi.server.*;
import java.lang.*;

public class C extends UnicastRemoteObject implements I {
     double val, memory;
     int nr_ordine;
     public C(double i,int nr) throws RemoteException {
         val = i;
         nr_ordine = nr;
     }
     public double adunare(double i) {
         val += i; 
         System.out.println(nr_ordine + "\t: " + val);
         return val;
     }
     public double scadere(double i){
         val -= i;
         System.out.println(nr_ordine + "\t: " + val);
         return val;
     }
     public double inmultire(double i){
         val *= i;
         System.out.println(nr_ordine + "\t: " + val);
         return val;
     }
   
    public double impartire(double i){
        val = val/i;
        System.out.println(nr_ordine + "\t: " + val);
        return val;
    }
     public double patrat(){
         val =(double)Math.sqrt(val);
         System.out.println(nr_ordine + "\t: " + val);
         return val;
     }
     public String putere(double i){
         val = Math.pow(val, i);
         System.out.println(nr_ordine + "\t: " + val);
         return Double.toString(val);
     }
     public String factorial(){
         int a = (int)val;
         double calc = 1;
         if(val == 0 || val ==1){
             val = 1;
             System.out.println(nr_ordine + "\t: " + val);
             return Double.toString(val);
         }
         else     
             if(a == val && val >1){
                 for(int j =2; j<= val; j++)
                     calc *= j;
                 val = calc;
                 System.out.println(nr_ordine + "\t: " + val);
                 return Double.toString(val);
             }
             else{
                 System.out.println("Factorialul se aplica numai pe numere naturale!");
                  val = 0;
                 return "-1";
                
             }
         
     }
     
     public double curent() {
         System.out.println(nr_ordine + "\t: " + val);
         return val; 
         
     }
    
     public double inversare(){

             val = 1/val;
             System.out.println(nr_ordine + "\t: " + val);
             return val;
         
     }
    
     public void stoc(){
         memory = val;
     }

  
     public void citeste(){
         val = memory;
         System.out.println(nr_ordine + "\t: " + val);
     }
     public void sterge(){
         memory  =0;
     }
    
     public void adunare_mem(double i){
         memory += val;
         System.out.println(nr_ordine + "\t: " + val);
     }
     public void scadere_mem(double i){
         memory -= val;
     }

   
    public double afis_mem() throws RemoteException {
        return memory;
    }
    public void sterge_c(){
        val = 0;
        
    }
            }