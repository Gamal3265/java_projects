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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gamal
 */
public class SserverUDP {
    public static void main(String[] args) {
        try {
            DatagramSocket  socket =new DatagramSocket(2000);
            byte []buffer=new byte[1080];
            DatagramPacket io=new DatagramPacket(buffer,buffer.length);
            
            while(true){
                socket.receive(io);
                System.out.println("Clint Massege recive");
                String massge=new String(io.getData());
                InetAddress address= io.getAddress();
                int port=io.getPort();
                String serverResponse="Message "+massge;
                DatagramPacket outPacket=new DatagramPacket(serverResponse.getBytes(),serverResponse.getBytes().length,address,port);
                socket.send(outPacket);
                
            } 
            
        } catch (SocketException ex) {
            Logger.getLogger(SserverUDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SserverUDP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
