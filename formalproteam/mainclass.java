/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formalproteam;

import java.io.StringReader;


/**
 *
 * @author gamal
 */
public class mainclass {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) throws Exception {
        String ch[]={"1-4x^3-x^6","-4-4+x-2+x+x^8", "-x-1+x^2-x^5", "3+4x^7+3-5", "3x+9x^9", "3x^2", "2x^3", "x^5+3x^6+x^4+9x^7","3x+2x^2+5-x-2"};
//        OTHER error EQUATIONS 
//                String ch[]={"x^5-3x^6+x^4+9x^7", "5x12+5x+10","x-2x^2-x","2x2+4x+5","x-2x^2-3x+x^6"};
        for (int i = 0; i < ch.length; i++) {
            System.out.println("\n\n**************");
            String msg = ch[i];
            
            StringReader reader = new StringReader (msg);
		Lexer le=new Lexer(reader );
		Token tok;
		while((tok=le.getTokenType()) !=null)
			        System.out.println(tok.toString());	
            
            SimpleParse sp = new SimpleParse(msg);
            sp.Expr();
            System.out.println("\nSuccess");
//            
//                SimpleParsertest sp = new SimpleParsertest(msg);
//             Ast.Exper root=sp.Expr();
//            System.out.println(root.prefix());
//            System.out.println("\nSuccess");

            
            
            
            
            
            		//4
//		TermExpr e1 = new TermExpr(4,0);
//
//		//-2x
//		TermExpr e2 = new TermExpr(-2,1);
//
//		//3x^2
//		TermExpr e3 = new TermExpr(3,2);
//
//		PolynomialExpr e4 = new PolynomialExpr();
//		e4.addTerm(e2);
//		e4.addTerm(e1);
//		e4.addTerm(e3);
//
//		System.out.println(e4);
//
//		e4.diffrentiate();
//
//		System.out.println(e4);


        }
    }
}
