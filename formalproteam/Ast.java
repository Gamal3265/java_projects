package formalproteam;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gamal
 */
public class Ast {
    public static abstract class Exper{
        public abstract int evaluate();
        public abstract String prefix();
    }
    public static class AddExper extends Exper{
       Exper left,right;
       public AddExper(Exper left,Exper right){
           this.left=left;
           this.right=right;
       }
        public String toString() {
            return left.toString()+ " + "+right.toString();
        }
        public int evaluate() {
            return left.evaluate()+right.evaluate();
        }
        public String prefix() {
            return " + "+left.toString()+ " "+right.toString();
        }
       
    }
    public static class SUPExper extends Exper{
       Exper left,right;
       public SUPExper(Exper left,Exper right){
           this.left=left;
           this.right=right;
       }
        public String toString() {
            return left.toString()+ " + "+right.toString();
        }
        public int evaluate() {
            return left.evaluate()+right.evaluate();
        }
        public String prefix() {
            return " + "+left.toString()+ " "+right.toString();
        }
       
    }
    public static class VARExper extends Exper{
       Exper left,right;
       public VARExper(Exper left,Exper right){
           this.left=left;
           this.right=right;
       }
        public String toString() {
            return left.toString()+ " + "+right.toString();
        }
        public int evaluate() {
            return left.evaluate()+right.evaluate();
        }
        public String prefix() {
            return " + "+left.toString()+ " "+right.toString();
        }
       
    }

    public static class MultiExper extends Exper{
       Exper left,right;
       public MultiExper(Exper left,Exper right){
           this.left=left;
           this.right=right;
       }
        public String toString() {
            return left.toString()+ " * "+right.toString();
        }
        public int evaluate() {
            return left.evaluate()*right.evaluate();
        }
        public String prefix() {
            return " * "+left.toString()+ " "+right.toString();
        }
       
    }
        public static class NumExper extends Exper{
       int val;
       public NumExper(int val){
           this.val=val;
       }
        public String toString() {
            return val+ "";
        }
        public int evaluate() {
            return val;
        }
        public String prefix() {
            return val +"";
        }
       
    }

}
