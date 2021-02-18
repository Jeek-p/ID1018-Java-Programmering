
public class EU1 
{
	public static void main (String[] args)
	{
		
		int[]	tal = {3, 4, 5, 9, 2, 3, 6, 1, 9, 5, 3, 7, 8, 2, 3, 4, 0, 2, 5};
		System.out.println (EU1.min(tal));
		System.out.println (EU1.minimum(tal));
		
	}
	
	
		public static int minimum (int[] element)
		{
	
			int		min = element[0];
			for (int i = 1; i < element.length; i++)
			{
				if (min > element[i])
					min = element[i];
			}
			return min;
		}
	
	
		public static int min (int[] element) throws IllegalArgumentException
		{
			if (element.length == 0)
				throw new IllegalArgumentException ("tom samling");

			// h�r ihop med sp�rutskriften 2:
			// int	antalVarv = 1;

			int[]	sekvens = element;
			int		antaletPar = sekvens.length / 2;
			int     antaletOparadeElement = sekvens.length % 2;	
			int     antaletT�nkbaraElement = antaletPar + antaletOparadeElement;
			int[]	delsekvens = new int [antaletT�nkbaraElement];
			int		i = 0;
			int		j = 0;
			while (antaletPar > 0)
			{
				// skilj ur en delsekvens med de t�nkbara elementen
				i = 0;
				j = 0;
				while (j < antaletPar)
				{
					delsekvens[j++] = (sekvens[i] < sekvens[i + 1])? sekvens[i] : sekvens[i +1];
					i += 2;
				}
				if (antaletOparadeElement == 1)
					delsekvens[j] = sekvens[i];

				// utg� nu ifr�n delsekvensen
				sekvens = delsekvens;
				antaletPar = antaletT�nkbaraElement / 2;
				antaletOparadeElement = antaletT�nkbaraElement % 2;
				antaletT�nkbaraElement = antaletPar + antaletOparadeElement;
				// delsekvens = new int[antaletT�nkbaraElement];
				
				// sp�rutskrift 1 - f�r att f�lja sekvensen
				System.out.println (java.util.Arrays.toString (sekvens));

				// sp�rutskrift 2 - f�r att avsluta looopen i f�rv�g
				// f�r att kunna se vad som h�nder i b�rjan
				// if (antalVarv++ == 10)
				 		// System.exit (0);
			}

			// sekvens[0] �r det enda �terst�ende t�nkbara elementet
			// - det �r det minsta elementet
			return sekvens[0];
		}
	

}
