import java.util.*;
public class VäljPolylinje 
{
	public static final Random		rand = new Random ();
	public static final int		ANTAL_POLYLINJER = 10;

	public static void main (String[] args)
	{
		// skapa ett antal slumpmässiga polylinjer
		Polylinje[]		polylinjer = new Polylinje[ANTAL_POLYLINJER];
		for (int i = 0; i < ANTAL_POLYLINJER; i++)
			polylinjer[i] = slumpPolylinje ();

		// visa polylinjer

		for (int i = 0; i < polylinjer.length; i++)
			System.out.println (polylinjer[i]);

		// bestäm den kortaste av de polylinjer som är gula
		Polylinje	minsta = null;
		double		minlängd = Double.MAX_VALUE;
		for (int i = 0; i < polylinjer.length; i++)
		{
			if (polylinjer[i].getFärg().equals("Gul"))
			{
				if (polylinjer[i].längd() < minlängd)
				{
					minsta = polylinjer[i];
					minlängd = minsta.längd();
				}
			}	
		}

		// visa den valda polylinjen
		if (minsta == null)
			System.out.println ("Finns ingen gul");
			else System.out.println ("\nKortast:" + minsta + minlängd);

		// slumpPunkt returnerar en punkt med ett slumpmässigt namn, som är en stor bokstav i
		// det engelska alfabetet, och slumpmässiga koordinater.
	}

	public static Punkt slumpPunkt ()
	{		
		String		n = "" + (char) (65 + rand.nextInt (26));
		int		x = rand.nextInt (11);
		int		y = rand.nextInt (11);


		return new Punkt (n, x, y);
	}

	// slumpPolylinje returnerar en slumpmässig polylinjem vars färg är antingen blå, eller röd eller gul.
	// namn på polylinjens hörn är stora bokstäver i det engelska alfabetet. Två hörn kan inte ha samma namn.

	public static Polylinje slumpPolylinje ()
	{
		// skapa en tom polylinje, och lägg till hörn till den
		Polylinje	polylinje = new Polylinje ();
		int		antalHörn = 2 + rand.nextInt (7);
		int		antalValdaHörn = 0;
		boolean[]		valdaNamn = new boolean[26];
		int		färg = rand.nextInt(3);
		// ett och samma namn kan inte förekomma flera gånger
		Punkt		valdPunkt = null;
		char		valtChar = 0;
		while (antalValdaHörn < antalHörn)
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

			polylinje.läggTill(valdPunkt);	
			antalValdaHörn++;

		}
		
		
		if (färg == 0)
			polylinje.setFärg("Blå");
		if (färg == 1)
			polylinje.setFärg("Gul");
		if (färg == 2)
			polylinje.setFärg("Röd");
		return polylinje;
	}

}
