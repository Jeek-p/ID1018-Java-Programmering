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
		
		linje.läggTill(p1);
		linje.läggTill(p2);
		linje.läggTill(p3);
		linje.läggTill(p4);
		System.out.println (linje);
		
		// gethörn, färg, bredd etc
		System.out.println (Arrays.toString(linje.getHörn()) + "(" + linje.getFärg() + ")" + "[" + linje.getBredd() + "]");
		
		// lägga till punkt
		
		linje.läggTillFramför(p5, "B");
		System.out.println (linje);
		
		// ta bort en punk
		
		linje.taBort("B");
		System.out.println (linje);
		
		// ändra färg/bredd
		
		String		G = "Gul";
		linje.setFärg(G);
		linje.setBredd(3);
		System.out.println (linje);
		
	
		Polylinje.PolylinjeIterator iterator = linje.new PolylinjeIterator();
		while (iterator.finnsHörn())
		{
			System.out.println ("Hörn: " + iterator.hörn());
			iterator.gåFram();
		}
		
		  
		  		 
		 
	       
		
		
	}

}
