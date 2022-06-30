/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemsolving;

import java.util.Scanner;

/**
 *
 * @author gamal
 */
public class Problemsolving {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);  
        
        System.out.println("Enter a ");
        int a=sc.nextInt();
        System.out.println("Enter b ");
        int b=sc.nextInt();
        int res=0;
        while (a<=b) {            
            a=a*3;
            b=b*2;
            System.out.println(a+" "+b);
            res++;
        }
        System.out.println("result : "+res);
        System.out.println("a : "+a);
    }
    
}
