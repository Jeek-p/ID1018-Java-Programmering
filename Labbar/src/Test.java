
import java.util.Scanner;

import java.util.Random;

import java.util.Scanner;
import java.util.Random;

public class Test
{


	// Testar s� att klassera beter sig som de borde

	// Tar en input som v�ljer vilken klass som ska testas

	// Testar

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		Punkt[] punkter = new Punkt []
				{new Punkt ("A", 1, 1),
				new Punkt ("B", 2, 2)};
					
		System.out.print("V�lj vilken polylinje: VPolylinje (1) eller NPolylinje (2): ");
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
		
		// �ndrar f�rg och bredd
		
		System.out.println ("�ndrar f�rg och bredd: ");
		polylinje.setF�rg ("gul");
		polylinje.setBredd(2);
		System.out.println (polylinje);
		System.out.println ();
		

		System.out.println ("L�gger till C framf�r B: ");
		polylinje.l�ggTillFramf�r(new Punkt ("C", 3, 3), "B");
		System.out.println(polylinje);
		System.out.println ();
	

		System.out.println ("Tar bort B:");
		polylinje.taBort ("B");
		System.out.println (polylinje);
		System.out.println ();

		System.out.println ("Polylinjens l�ngd: ");
		System.out.println (polylinje.l�ngd());
		System.out.println ();


		// Iterator
		System.out.println("G�r �ver polylinjen och skriver ut punkterna: ");
		for (Punkt h�rn : polylinje) 
		{
			System.out.println(h�rn.toString());
		}


		// Skapar polylinje vektorer

		System.out.println ("Skapar polylinjevektorer ");
		final int	PolyL�ngd = 10;

		Polylinje4[] vPolelinje = new Polylinje4[PolyL�ngd];
		Polylinje4[] nPolelinje = new Polylinje4[PolyL�ngd];
		Polylinje4[] b�daPolylinjer = new Polylinje4[PolyL�ngd];

		for (int i = 0; i < PolyL�ngd; i++) 
		{
			vPolelinje[i] = slumpPolylinje(0);
			nPolelinje[i] = slumpPolylinje(1);
			b�daPolylinjer[i] = slumpPolylinje(2);
		}
		

		// visa polylinjer
		
		System.out.println("Den kortaste gula polylinjen i vPolylinje[] �r: " + Polylinjer.Polylinjer(vPolelinje).toString());
		System.out.println("Den kortaste gula polylinjen i nPolylinje[] �r: " + Polylinjer.Polylinjer(nPolelinje).toString());
		System.out.println("Den kortaste gula polylinjen i b�daPolylinje[] �r: " + Polylinjer.Polylinjer(b�daPolylinjer).toString());

	}



	public static Polylinje4 slumpPolylinje(int vilken) 
	{

	      // skapa en tom polylinje, och l�gg till h�rn till den

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
        // ett och samma namn kan inte f�rekomma flera g�nger
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
            polylinje.l�ggTill(valdPunkt);
            antalValdaHorn++;

        }
        
        int		f�rg = rand.nextInt(3);
        if (f�rg == 0)
			polylinje.setF�rg("Bl�");
		if (f�rg == 1)
			polylinje.setF�rg("Gul");
		if (f�rg == 2)
			polylinje.setF�rg("R�d");
  
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
