import java.util.Arrays;

public class PolylinjeTest 
{
	public static void main (String[] args)
	{
		Polylinje	linje = new Polylinje ();
		
		// ange antal punkter
		Punkt	p1 = new Punkt ("A", 3, 4);
		Punkt	p2 = new Punkt ("B", 1, 2);
		Punkt	p3 = new Punkt ("C", 2, 3);
		Punkt	p4 = new Punkt ("D", 5, 1);
		Punkt	p5 = new Punkt ("E", 3, 2);
		Punkt	p6 = new Punkt ("F", 6, 6);
		
		// addera till linjen och skriv ut
		
		linje.l�ggTill(p1);
		linje.l�ggTill(p2);
		linje.l�ggTill(p3);
		linje.l�ggTill(p4);
		System.out.println (linje);
		
		// geth�rn, f�rg, bredd etc
		System.out.println (Arrays.toString(linje.getH�rn()) + "(" + linje.getF�rg() + ")" + "[" + linje.getBredd() + "]");
		
		// l�gga till punkt
		
		linje.l�ggTillFramf�r(p5, "B");
		System.out.println (linje);
		
		// ta bort en punk
		
		linje.taBort("B");
		System.out.println (linje);
		
		// �ndra f�rg/bredd
		
		String		G = "Gul";
		linje.setF�rg(G);
		linje.setBredd(3);
		System.out.println (linje);
		
	
		Polylinje.PolylinjeIterator iterator = linje.new PolylinjeIterator();
		while (iterator.finnsH�rn())
		{
			System.out.println ("H�rn: " + iterator.h�rn());
			iterator.g�Fram();
		}
		
		  
		  		 
		 
	       
		
		
	}

}
