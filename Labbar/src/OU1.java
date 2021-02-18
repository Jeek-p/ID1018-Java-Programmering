import java.util.*;

public class OU1 
{
	public static void main (String[] args)
	{
		System.out.println ("TEMPERATURER\n");

		// inmatningsverktyg
		Scanner		in = new Scanner (System.in);
		in.useLocale(Locale.US);

		// mata in uppgifter om antalet veckor och antalet mätningar
		System.out.print ("antalet veckor: ");
		int		antalVeckor = in.nextInt ();
		System.out.print ("antalet mätningar per vecka: ");
		int		antalMätningarPerVecka = in.nextInt ();

		// plats att lagra temperaturer
		double [][]		t = new double [antalVeckor + 1][antalMätningarPerVecka + 1];

		// mata in temperaturerna
		for (int vecka = 1; vecka <= antalVeckor; vecka++)
		{
			System.out.println ("temperaturer - vecka " + vecka + ":");
			for (int mätning =1; mätning <= antalMätningarPerVecka; mätning++)
				t[vecka][mätning] = in.nextDouble ();
		}
		System.out.println ();

		// visa temperaturerna
		System.out.println ("temperaturerna:");
		for (int vecka = 1; vecka <= antalVeckor; vecka++)
		{
			for (int mätning = 1; mätning <= antalMätningarPerVecka; mätning++)
				System.out.print(t[vecka][mätning] + " ");
			System.out.println ();
		}
		System.out.println ();

		// den minsta, den största och medeltemperaturen - veckovis
		double[]	minT = new double [antalVeckor + 1];
		double[]	maxT = new double [antalVeckor + 1];
		double []	sumT = new double [antalVeckor + 1];
		double []	medelT = new double [antalVeckor + 1];
		// koden ska skrivas här

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

			// visa den minsta, den största och medeltemperaturen för varje vecka
			// koden ska skrivas här

			System.out.print ("Vecka: " + v + " | Lägsta temp: " + minT[v] + " | Högsta temp: " + maxT[v] + " | Medel temp: ");
			System.out.printf ("%4.2f | ", medelT[v]);
			System.out.println ();

		}

		// den minsta, den största och medeltemperaturen - hela mätperioden
		double minTemp = minT[1];
		double	maxTemp = maxT[1];
		double sumTemp = sumT[1];
		double medelTemp = 0;
		//koden ska skrivas här

		for (int j = 2; j <= antalVeckor; j++)
		{
			if (minTemp > minT[j])
				minTemp = minT[j];
			if (maxTemp < maxT[j])
				maxTemp = maxT[j];
			sumTemp += sumT[j];
		}
		medelTemp = (sumTemp / (antalVeckor * antalMätningarPerVecka));

		// visa den minsta, den största och medeltemperaturen i hela mätperioden
		// koden ska skrivas här

		System.out.println ("Periodens minsta temp: " + minTemp);
		System.out.println ("Periodens högsta temp: +" + maxTemp);
		System.out.print ("Periodens medel temp: ");
		System.out.printf ("%4.2f", medelTemp);

	}

}
