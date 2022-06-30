/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sliesocket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author gamal
 */
public class ServerTCP {
    public static void main(String[] args) throws IOException {
        ServerSocket serverocket =new ServerSocket(5678);
        Socket socket=serverocket.accept();
        
        Scanner  fromComsole = new Scanner(System.in);
        Scanner fromClient=new Scanner(socket.getInputStream());
        PrintWriter fromServer=new PrintWriter(socket.getOutputStream(),true);
        
        String inputFromServer,inputfromConsole;
        
        while(true){
            inputFromServer=fromClient.nextLine();
            System.out.println("Clinet:"+inputFromServer);
            if(inputFromServer.equals("exit")){
                 break;
            }
               
            System.out.print("Server: ");
            
            inputfromConsole=fromComsole.nextLine();
            fromServer.println(inputfromConsole);
        }
        
    }
    
}
