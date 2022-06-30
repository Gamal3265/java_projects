/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sliesocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gamal
 */
public class ClinetUDP {
     public static void main(String[] args) throws IOException {
         try {
             DatagramSocket  socket =new DatagramSocket();
             Scanner inputFromClinet=new Scanner(System.in);
             byte[]buffer=new byte[2000];
             while(true){
                 System.out.println("Enter Massege");
                 String massgeFromConsole=inputFromClinet.nextLine();
                 if (massgeFromConsole.equals("bye*")) {
                     break;
                 }
                 DatagramPacket outPacket=new DatagramPacket(massgeFromConsole.getBytes(),massgeFromConsole.getBytes().length,InetAddress.getLocalHost(),2000);
                 socket.send(outPacket);
                 
                 DatagramPacket inPacket=new DatagramPacket(buffer,buffer.length);
                 socket.receive(inPacket);
                 String response=new String(inPacket.getData());
                 System.out.println("Massge "+response);
             }
             socket.close();
         } catch (SocketException ex) {
             Logger.getLogger(ClinetUDP.class.getName()).log(Level.SEVERE, null, ex);
         } catch (UnknownHostException ex) {
             Logger.getLogger(ClinetUDP.class.getName()).log(Level.SEVERE, null, ex);
         }
   
    }
}
