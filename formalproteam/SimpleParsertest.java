package formalproteam;

public class SimpleParsertest {
    private  String msg;
    private  int loookhead;
    public class Token{
    String symbol;
    Type type;
    public Token(String symbol,Type type){
        this.symbol=symbol;
        this.type=type;
    }
}
    
    public static enum Type{Num,ADD,MULT,SUB,VAR,POWER,EDF};
    public SimpleParsertest(String msg){
        this.msg=msg;
        this.loookhead=0;
    }
    public Token getNextToken()throws Exception{
        if(loookhead>=msg.length())
            return new Token("",Type.EDF);
        char chr=msg.charAt(loookhead);
        if(chr>= '0' && chr<='9')
            return new Token(chr+"",Type.Num);
        if(chr=='+')
            return new Token("+",Type.ADD);
        if(chr=='-')
            return new Token("-",Type.SUB);
        if(chr=='*')
            return new Token("*",Type.MULT);
          if(chr=='^')
            return new Token("^",Type.POWER);
        if(chr=='x')
            return new Token("x",Type.VAR);
        Error("unexpected token");
        return null;
    }
    public void Error(String msg)throws Exception{
        throw new Exception(msg);
//        System.out.println(msg.toString());
    }
    //Expr=E$
    public Ast.Exper Expr()throws Exception{
         Ast.Exper root=null,left=null,right=null;
        Token nt=getNextToken();
        switch(nt.type){
            case Num:
                right=E(left);
                eat(Type.EDF);
                root=new Ast.AddExper(left,right);
                break;
            case VAR:
                right=E(left);
                eat(Type.EDF);
                root=new Ast.AddExper(left,right);
                break;
            case SUB:
                root=left;
                 break;
                default:
                     Error("unexpected token");
              
        }
        return root;
    }
    //E=TE`
    public Ast.Exper E(Ast.Exper left)throws Exception{
        Ast.Exper root=null,right=null;
        Token nt=getNextToken();
        switch(nt.type){
            case Num:
                left=T(left);
               root=E_prime(left);
               root=new Ast.AddExper(left,right);
                break;
              case VAR:
                left=T(left);
               right=E_prime(left);
               root=new Ast.VARExper(left,right);
                break;
                default:
                    Error("unexpected token");
        }
        return root;
    }
   
    public Ast.Exper E_prime(Ast.Exper left)throws Exception{
          Ast.Exper root=null,right;
        Token nt=getNextToken();
        switch(nt.type){
            case ADD:
                eat(Type.ADD);
                right=E(left);
                root=new Ast.AddExper(left,right);
                break;
             case SUB:
                eat(Type.SUB);
                right=E(left);
                root=new Ast.SUPExper(left,right);
                break;
           
            case EDF:
                root=left;
                break;
            default:
                     Error("unexpected token");
        }
        return root;
    }
     //T=FT`
    //T=num
    public Ast.Exper T(Ast.Exper left)throws Exception{
          Ast.Exper root=null,right=null;
        Token nt=getNextToken();
        switch(nt.type){
             case VAR:
                right= F(left);
                left= T_prime(left);
               root=new Ast.VARExper(left,right);
                break;
            case Num:
               right= F(left);
                left= T_prime(left);
               root=new Ast.VARExper(left,right);
                break;
            default:
                     Error("unexpected token");
        }
        return root;
    }
   
    public Ast.Exper T_prime(Ast.Exper left)throws Exception{
          Ast.Exper root=null,right=null;
        Token nt=getNextToken();
        switch(nt.type){
            case POWER:
                eat(Type.POWER);
               root= F(left);
                break;
            case ADD:
                root=left;
            case SUB:
                root=left;
            case EDF:
                root=left;
                break;
                
            default:
                     Error("unexpected token");
        }
        return root;
    }
     //F=xF`
    public Ast.Exper F(Ast.Exper left)throws Exception{
          Ast.Exper root=null,right=null;
        Token nt=getNextToken();
        switch(nt.type){
            case Num:
                eat(Type.Num);
                left=new Ast.VARExper(left, right);
                 root=F_prime(left);
                break;
             case VAR:
                 eat(Type.VAR);
                  root=left;
                break;
            default:
            Error("unexpected token");
        }
        return root;
    }
      public Ast.Exper F_prime(Ast.Exper left)throws Exception{
           Ast.Exper root=null,right=null;
        Token nt=getNextToken();
        switch(nt.type){
           case VAR:
               eat(Type.VAR);
               left=new Ast.VARExper(left, right);
               root=F_prime(left);
               break;
            case POWER:
            case ADD:
                 root=left;
            case SUB:
                 root=left;
            case EDF:
                root=left;
                break;        
            default:
                     Error("unexpected token");
        }
        return root; 
    }
     
     //
    public void eat(Type type)throws Exception{
        Token tok=getNextToken();
        if(tok.type==type)
            loookhead++;
       else
            Error("unexpected token");
        }
    
 
}
//E ::= T E'
//E' ::= + T E'
//E' ::= - T E'
//E' ::= ''
//T ::= F T'
//T' ::= ^ F
//T' ::= ''
//F ::= N F'
//F ::= X
//F' ::= X F'
//F' ::= ''
