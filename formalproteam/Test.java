package formalproteam;



public class Test
{
    int con=0;
    int pow=0;
    
    public Test(int con,int pow)
	{
            this.con=con;
            this.pow=pow;
        }
	public void Testfinal()
	{
		//4
		TermExpr e1 = new TermExpr(con,pow);

		//-2x
//		TermExpr e2 = new TermExpr(-2,1);

		//3x^2
//		TermExpr e3 = new TermExpr(3,2);

//		PolynomialExpr e1 = new PolynomialExpr();
//		e4.addTerm(e2);
//		e4.addTerm(e1);
//		e4.addTerm(e3);

		System.out.println(e1);

		e1.diffrentiate();

		System.out.println(e1);

	}
}