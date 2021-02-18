import java.util.*;
public class V�ljPolylinje 
{
	public static final Random		rand = new Random ();
	public static final int		ANTAL_POLYLINJER = 10;

	public static void main (String[] args)
	{
		// skapa ett antal slumpm�ssiga polylinjer
		Polylinje[]		polylinjer = new Polylinje[ANTAL_POLYLINJER];
		for (int i = 0; i < ANTAL_POLYLINJER; i++)
			polylinjer[i] = slumpPolylinje ();

		// visa polylinjer

		for (int i = 0; i < polylinjer.length; i++)
			System.out.println (polylinjer[i]);

		// best�m den kortaste av de polylinjer som �r gula
		Polylinje	minsta = null;
		double		minl�ngd = Double.MAX_VALUE;
		for (int i = 0; i < polylinjer.length; i++)
		{
			if (polylinjer[i].getF�rg().equals("Gul"))
			{
				if (polylinjer[i].l�ngd() < minl�ngd)
				{
					minsta = polylinjer[i];
					minl�ngd = minsta.l�ngd();
				}
			}	
		}

		// visa den valda polylinjen
		if (minsta == null)
			System.out.println ("Finns ingen gul");
			else System.out.println ("\nKortast:" + minsta + minl�ngd);

		// slumpPunkt returnerar en punkt med ett slumpm�ssigt namn, som �r en stor bokstav i
		// det engelska alfabetet, och slumpm�ssiga koordinater.
	}

	public static Punkt slumpPunkt ()
	{		
		String		n = "" + (char) (65 + rand.nextInt (26));
		int		x = rand.nextInt (11);
		int		y = rand.nextInt (11);


		return new Punkt (n, x, y);
	}

	// slumpPolylinje returnerar en slumpm�ssig polylinjem vars f�rg �r antingen bl�, eller r�d eller gul.
	// namn p� polylinjens h�rn �r stora bokst�ver i det engelska alfabetet. Tv� h�rn kan inte ha samma namn.

	public static Polylinje slumpPolylinje ()
	{
		// skapa en tom polylinje, och l�gg till h�rn till den
		Polylinje	polylinje = new Polylinje ();
		int		antalH�rn = 2 + rand.nextInt (7);
		int		antalValdaH�rn = 0;
		boolean[]		valdaNamn = new boolean[26];
		int		f�rg = rand.nextInt(3);
		// ett och samma namn kan inte f�rekomma flera g�nger
		Punkt		valdPunkt = null;
		char		valtChar = 0;
		while (antalValdaH�rn < antalH�rn)
		{
	
			while (true)
			{
				valdPunkt = slumpPunkt();
				if (valdaNamn[(int)(valdPunkt.getNamn().toCharArray()[0]) - 65] == false)
				{
					valdaNamn[((int)(valdPunkt.getNamn().toCharArray()[0]) - 65)] = true;
					break;
				}
				
			}

			polylinje.l�ggTill(valdPunkt);	
			antalValdaH�rn++;

		}
		
		
		if (f�rg == 0)
			polylinje.setF�rg("Bl�");
		if (f�rg == 1)
			polylinje.setF�rg("Gul");
		if (f�rg == 2)
			polylinje.setF�rg("R�d");
		return polylinje;
	}

}
