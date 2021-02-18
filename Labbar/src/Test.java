
import java.util.Scanner;

import java.util.Random;

import java.util.Scanner;
import java.util.Random;

public class Test
{


	// Testar så att klassera beter sig som de borde

	// Tar en input som väljer vilken klass som ska testas

	// Testar

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		Punkt[] punkter = new Punkt []
				{new Punkt ("A", 1, 1),
				new Punkt ("B", 2, 2)};
					
		System.out.print("Välj vilken polylinje: VPolylinje (1) eller NPolylinje (2): ");
		int val;
		val = in.nextInt();

		// Skapar

		
		Polylinje4 polylinje = null;
		switch (val)
		{
			case 1:
				polylinje = new VPolylinje (punkter);
				break;
			case 2:
				polylinje = new NPolylinje (punkter);
				break;	
		}

		System.out.println ("Visa vald polylinje: ");
		System.out.println (polylinje);
		System.out.println ();
		
		// Ändrar färg och bredd
		
		System.out.println ("Ändrar färg och bredd: ");
		polylinje.setFärg ("gul");
		polylinje.setBredd(2);
		System.out.println (polylinje);
		System.out.println ();
		

		System.out.println ("Lägger till C framför B: ");
		polylinje.läggTillFramför(new Punkt ("C", 3, 3), "B");
		System.out.println(polylinje);
		System.out.println ();
	

		System.out.println ("Tar bort B:");
		polylinje.taBort ("B");
		System.out.println (polylinje);
		System.out.println ();

		System.out.println ("Polylinjens längd: ");
		System.out.println (polylinje.längd());
		System.out.println ();


		// Iterator
		System.out.println("Går över polylinjen och skriver ut punkterna: ");
		for (Punkt hörn : polylinje) 
		{
			System.out.println(hörn.toString());
		}


		// Skapar polylinje vektorer

		System.out.println ("Skapar polylinjevektorer ");
		final int	PolyLängd = 10;

		Polylinje4[] vPolelinje = new Polylinje4[PolyLängd];
		Polylinje4[] nPolelinje = new Polylinje4[PolyLängd];
		Polylinje4[] bådaPolylinjer = new Polylinje4[PolyLängd];

		for (int i = 0; i < PolyLängd; i++) 
		{
			vPolelinje[i] = slumpPolylinje(0);
			nPolelinje[i] = slumpPolylinje(1);
			bådaPolylinjer[i] = slumpPolylinje(2);
		}
		

		// visa polylinjer
		
		System.out.println("Den kortaste gula polylinjen i vPolylinje[] är: " + Polylinjer.Polylinjer(vPolelinje).toString());
		System.out.println("Den kortaste gula polylinjen i nPolylinje[] är: " + Polylinjer.Polylinjer(nPolelinje).toString());
		System.out.println("Den kortaste gula polylinjen i bådaPolylinje[] är: " + Polylinjer.Polylinjer(bådaPolylinjer).toString());

	}



	public static Polylinje4 slumpPolylinje(int vilken) 
	{

	      // skapa en tom polylinje, och lägg till hörn till den

        Random rand = new Random();
        Polylinje4 polylinje;

        switch (vilken) 
        {
            case 0:
                polylinje = new NPolylinje();
                break;

            case 1:
                polylinje = new VPolylinje();
                break;

            case 2:
                int random = rand.nextInt(2);
                if (random == 0) 
                {
                    polylinje = new NPolylinje();
                } 
                else 
                {
                    polylinje = new VPolylinje();
                }
                break;

            default:
                polylinje = new NPolylinje();

        }

        int antalHorn = 2 + rand.nextInt(7);
        int antalValdaHorn = 0;
        boolean[] valdaNamn = new boolean[26];
        // ett och samma namn kan inte förekomma flera gånger
        Punkt valdPunkt = null;
        while (antalValdaHorn < antalHorn) 
        {
            valdPunkt = slumpPunkt(); // ny slumpPunkt
            while (true) 
            {
                if (!valdaNamn[((int) (valdPunkt.getNamn().toCharArray()[0]) - 65)]) 
                { // Om den nyas namn INTE finns
                    valdaNamn[((int) (valdPunkt.getNamn().toCharArray()[0]) - 65)] = true; // Markera som tager
                    break; // Hoppa ur loopen
                }
                valdPunkt = slumpPunkt(); // Om taget skapa en ny och testa igen
            }
            polylinje.läggTill(valdPunkt);
            antalValdaHorn++;

        }
        
        int		färg = rand.nextInt(3);
        if (färg == 0)
			polylinje.setFärg("Blå");
		if (färg == 1)
			polylinje.setFärg("Gul");
		if (färg == 2)
			polylinje.setFärg("Röd");
  
        return polylinje;

    }

	public static Punkt slumpPunkt ()
	{	
		Random rand = new Random ();
		String		n = "" + (char) (65 + rand.nextInt (26));
		int		x = rand.nextInt (11);
		int		y = rand.nextInt (11);


		return new Punkt (n, x, y);
	}

}
