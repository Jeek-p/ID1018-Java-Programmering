import java.util.*;
import java.lang.*;

public class OU2 
{
	
	public static void main (String[] args)
	{
		Scanner		in = new Scanner (System.in);
		in.useLocale(Locale.US);
		
		// Info om trianglen
		
		System.out.println ("Mata in information om triangeln.\nAnge sidornas l�ngd och dess motst�ende vinkel d�r sidan c �r basen.");
		System.out.println ();
		System.out.println ("Ange basen c p� triangeln och dess motst�ende vinkel: ");
		double c = in.nextDouble ();
		double vC = in.nextDouble ();
		while (vC >= 180 || vC == 0)
		{
			System.out.println ("Ogiltig vinkel, v�nligen ange ny vinkel: ");
			double vC1 = in.nextDouble ();
			vC = vC1;
		}	
		double radC = StrictMath.toRadians(vC);
		
		System.out.println ("Sida a l�ngd och dess motst�ende vinkel: ");
		double a = in.nextDouble ();
		double vA = in.nextDouble ();
		while (vC + vA >= 180 || vA == 0)
		{
			System.out.println ("Ogiltig vinkel, v�nligen ange ny vinkel: ");
			double vA1 = in.nextDouble ();
			vA = vA1;
		}
		double radA = StrictMath.toRadians(vA);
		
		System.out.println ("Sida b l�ngd och dess motst�ende vinkel: ");
		double b = in.nextDouble ();
		double vB = in.nextDouble ();
		while (!(vC + vA + vB == 180) || vC == 0)
		{
			System.out.println ("Ogiltig vinkel, v�nligen ange ny vinkel: ");
			double vB1 = in.nextDouble ();
			vB = vB1;
		}
		double radB = StrictMath.toRadians(vB);
		
		System.out.println ("Ange h�jden: ");
		double h = in.nextDouble();
		
		// val av info
		
		System.out.println ("____________________________________________________ ");
		System.out.println ("V�lj ett av f�ljande alternativ: ");
		while (true)
		{
		System.out.println ("[1] Ber�kna triangelns omkrets");
		System.out.println ("[2] Ber�kna triangelns area");
		System.out.println ("[3] Ber�kna triangelns bisektriser");
		System.out.println ("[4] Ber�kna den inre och den ytre cirkelns radie");
		System.out.println ("[5] Ber�kna triangelns vinklar");
		System.out.print ("Val: ");
		
		int v = in.nextInt ();
		while (v > 5 & v < 1)
		{
			System.out.println ("Ogiltigt val, v�lj nytt alternativ: ");
			int v2 = in.nextInt ();
			v = v2;
		}
		
		// Anropar metoder fr�n class Triangel beroende p� val
		

		if (v == 1)
		{
			 double v1 = Triangel.omkrets (a, b, c);
			 System.out.println (v1);	
		}
		if ( v== 2)
		{
			double v2 = Triangel.area (c, h);
			System.out.println (v2);
		}
		if (v == 3)
		{
			double Ba = Triangel.bisektris(a, b, c, radA, radB, radC)[0];
			double Bb = Triangel.bisektris(a, b, c, radA, radB, radC)[1];
			double Bc = Triangel.bisektris(a, b, c, radA, radB, radC)[2];
			System.out.println ("A: " + Ba + " | " + "B: " + Bb + " | " + "C: " + Bc);
		}
		if (v == 4)
		{
			double v4i = Triangel.cirkel(a, b, c)[0];
			double v4y = Triangel.cirkel(a, b, c)[1];
			System.out.println ("Inre: " + v4i + " | " + "Ytre: " + v4y);
		}
		if (v == 5)
		{
			double ra = c * h;
			double rva = Triangel.vinkel (ra, a, b, c)[0];
			double rvad = Math.toDegrees(rva);
			double rvb = Triangel.vinkel (ra, a, b, c)[1];
			double rvbd = Math.toDegrees(rvb);
			double rvc = Triangel.vinkel (ra, a, b, c)[2];
			double rvcd = Math.toDegrees(rvc);
			System.out.println ("vinkel A: " + rvad + " | " + "vinkel B: " + rvbd + " | " + "vinkel C: " + rvcd);			
		}
		System.out.println ();
		System.out.println ("Nytt val: ");
		System.out.println ();
		}
	

	}
}
