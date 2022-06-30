package formalproteam;

public class SimpleParse {
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
    public SimpleParse(String msg){
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
    public void Expr()throws Exception{
        Token nt=getNextToken();
        switch(nt.type){
            case Num:
                E();
                eat(Type.EDF);
                break;
            case VAR:
                E();
                eat(Type.EDF);
                break;
            case SUB:
                 break;
                default:
                     Error("unexpected token");
              
        }
    }
    //E=TE`
    public void E()throws Exception{
        Token nt=getNextToken();
        switch(nt.type){
            case Num:
                T();
               E_prime();
                break;
              case VAR:
                T();
               E_prime();
                break;
                default:
                    Error("unexpected token");
        }
    }
    //E`=+E
    //E`=-E
    //E`=h
    public void E_prime()throws Exception{
        Token nt=getNextToken();
        switch(nt.type){
            case ADD:
                eat(Type.ADD);
                E();
                break;
             case SUB:
                eat(Type.SUB);
                E();
                break;
           
            case EDF:
                break;
            default:
                     Error("unexpected token");
        }
    }
     //T=FT`
    //T=num
    public void T()throws Exception{
        Token nt=getNextToken();
        switch(nt.type){
             case VAR:
                 F();
                T_prime();
                break;
            case Num:
                F();
                T_prime();
                break;
            default:
                     Error("unexpected token");
        }
    }
   
    public void T_prime()throws Exception{
        Token nt=getNextToken();
        switch(nt.type){
           
            case POWER:
                eat(Type.POWER);
                F();
                break;
            case ADD:
            case SUB:
            case EDF:
                break;
                
            default:
                     Error("unexpected token");
        }
    }
     //F=xF`
    public void F()throws Exception{
        Token nt=getNextToken();
        switch(nt.type){
            case Num:
                eat(Type.Num);
                 F_prime();
                break;
             case VAR:
                 eat(Type.VAR);
                break;
            default:
            Error("unexpected token");
        }
    }
      public void F_prime()throws Exception{
        Token nt=getNextToken();
        switch(nt.type){
           case VAR:
               eat(Type.VAR);
               F_prime();
               break;
            case POWER:
            case ADD:
            case SUB:
            case EDF:
                break;        
            default:
                     Error("unexpected token");
        }
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
