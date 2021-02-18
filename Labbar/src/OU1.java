import java.util.*;

public class OU1 
{
	public static void main (String[] args)
	{
		System.out.println ("TEMPERATURER\n");

		// inmatningsverktyg
		Scanner		in = new Scanner (System.in);
		in.useLocale(Locale.US);

		// mata in uppgifter om antalet veckor och antalet m�tningar
		System.out.print ("antalet veckor: ");
		int		antalVeckor = in.nextInt ();
		System.out.print ("antalet m�tningar per vecka: ");
		int		antalM�tningarPerVecka = in.nextInt ();

		// plats att lagra temperaturer
		double [][]		t = new double [antalVeckor + 1][antalM�tningarPerVecka + 1];

		// mata in temperaturerna
		for (int vecka = 1; vecka <= antalVeckor; vecka++)
		{
			System.out.println ("temperaturer - vecka " + vecka + ":");
			for (int m�tning =1; m�tning <= antalM�tningarPerVecka; m�tning++)
				t[vecka][m�tning] = in.nextDouble ();
		}
		System.out.println ();

		// visa temperaturerna
		System.out.println ("temperaturerna:");
		for (int vecka = 1; vecka <= antalVeckor; vecka++)
		{
			for (int m�tning = 1; m�tning <= antalM�tningarPerVecka; m�tning++)
				System.out.print(t[vecka][m�tning] + " ");
			System.out.println ();
		}
		System.out.println ();

		// den minsta, den st�rsta och medeltemperaturen - veckovis
		double[]	minT = new double [antalVeckor + 1];
		double[]	maxT = new double [antalVeckor + 1];
		double []	sumT = new double [antalVeckor + 1];
		double []	medelT = new double [antalVeckor + 1];
		// koden ska skrivas h�r

		for (int v = 1; v <= antalVeckor; v++)
		{
			minT[v] = t[v][1];
			maxT[v] = t[v][1];
			sumT[v] = t[v][1];
			for (int k = 2; k < t[v].length; k++)
			{
				if (t[v][k] < minT[v])
					minT[v] = t[v][k];
				if	(t[v][k] > maxT[v])
					maxT[v] = t[v][k];
				sumT[v] += t[v][k];

			}
			medelT[v] = (double) sumT[v] / (t[v].length - 1);

			// visa den minsta, den st�rsta och medeltemperaturen f�r varje vecka
			// koden ska skrivas h�r

			System.out.print ("Vecka: " + v + " | L�gsta temp: " + minT[v] + " | H�gsta temp: " + maxT[v] + " | Medel temp: ");
			System.out.printf ("%4.2f | ", medelT[v]);
			System.out.println ();

		}

		// den minsta, den st�rsta och medeltemperaturen - hela m�tperioden
		double minTemp = minT[1];
		double	maxTemp = maxT[1];
		double sumTemp = sumT[1];
		double medelTemp = 0;
		//koden ska skrivas h�r

		for (int j = 2; j <= antalVeckor; j++)
		{
			if (minTemp > minT[j])
				minTemp = minT[j];
			if (maxTemp < maxT[j])
				maxTemp = maxT[j];
			sumTemp += sumT[j];
		}
		medelTemp = (sumTemp / (antalVeckor * antalM�tningarPerVecka));

		// visa den minsta, den st�rsta och medeltemperaturen i hela m�tperioden
		// koden ska skrivas h�r

		System.out.println ("Periodens minsta temp: " + minTemp);
		System.out.println ("Periodens h�gsta temp: +" + maxTemp);
		System.out.print ("Periodens medel temp: ");
		System.out.printf ("%4.2f", medelTemp);

	}

}
