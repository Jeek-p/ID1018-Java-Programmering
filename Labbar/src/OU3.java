import		java.util.*;
public class OU3 
{
	public static void main (String[] Args)
	{
		Scanner		in = new Scanner (System.in);
		in.useLocale(Locale.US);

		double[]	a = {0, 3, 4, 1};
		double[][]	b = {{0, 0, 0, 0, 0},{0, 5, 3, 6, 2},{0, 3, 6, 5, 7},{0, 2, 8, 11, 4}};
		double[]	c = {0, 1, 4, 3, 5};
		
		
		int[]	index = DenKortasteVägen.mellanstationer(a, b, c);
		double	längden = DenKortasteVägen.längden(a, b, c);
		System.out.println ("Indexplats i till mellanstation: " + index[0]);
		System.out.println ("Indexplats j till Y: " + index[1]);
		System.out.println("Sträcka: " + index[2]);
		System.out.println ("Längden: " + längden);
						
		
		/*
		Möjlighet att mata in manuellt
		
		double[]	a = new double [3];
		double[][]	b = new double [3][4];
		double[]	c = new double [4];
		
		System.out.println ("Ange avstånd mellan X - Y: ");
		for (int ai = 1; ai <= a.length; ai++)
		{ 
			System.out.println("a" + ai + ":");
			a[ai - 1] = in.nextDouble();
			for (int bj = 1; bj <= 4; bj++)
			{
				System.out.println("b" + ai + bj +":");
				b[ai - 1][bj - 1] = in.nextDouble();
			} + 
				
		}
		for (int ci = 1; ci <= 4; ci++)
		{
			System.out.println("c" + ci + ":");
			c[ci - 1] = in.nextDouble();
		}
		
		DenKortasteVägen	beräkning = new DenKortasteVägen ();
		double v = beräkning.längden(a, b, c);
		System.out.println ("Kortast avstånd är: " + v);
		*/
		
			
			
			






	}

}
