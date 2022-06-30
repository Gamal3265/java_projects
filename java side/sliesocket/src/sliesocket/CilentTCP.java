/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sliesocket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gamal
 */
public class CilentTCP {
     public static void main(String[] args) {
         try {
            Socket socket =new Socket("localhost",5678);
            Scanner  fromComsole = new Scanner(System.in);
            Scanner  fromServer = new Scanner(socket.getInputStream());
            PrintWriter fromClient=new PrintWriter(socket.getOutputStream(),true);
        
        String input,output;
        
        while(true){
            System.out.println("Clinet: ");
            input=fromComsole.nextLine();
            
            fromClient.println(input);
            output=fromServer.nextLine();
             System.out.print("Server: ");
            System.out.println(output);
        }
         } catch (IOException ex) {
             Logger.getLogger(CilentTCP.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
    }
    
}
