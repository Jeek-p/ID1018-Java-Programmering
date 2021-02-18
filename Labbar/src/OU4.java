import java.util.*;
import static java.lang.System.out;
public class OU4 
{
	public static void main (String[] args)
	{
		out.println ("OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTR�NGAR\n");

		// MATA IN TV� NATURLIGA HELTAL

		Scanner		in = new Scanner (System.in);
		out.println ("tv� naturliga heltal:");
		String		tal1 = in.next ();
		String		tal2 = in.next ();
		out.println ();

		// addera heltalen och visa resultatet

		String		summa = addera (tal1, tal2);
		visa (tal1, tal2, summa, '+');
		String		differens = subtrahera (tal1, tal2);
		visa (tal1, tal2, differens, '-');


		// addera tar emot tv� naturliga heltal givna som teckenstr�ngar, och returnerar deras 
		// summa som en teckenstr�ng.
	}


	public static String addera (String tal1, String tal2)
	{
		if (tal1.length() > tal2.length())
		{
			// s�tter tal1 till kortaste och tal2 till l�ngsta
			String t = tal1;
			tal1 = tal2;
			tal2 = t;
		}

		int		t1 = tal1.length();
		int		t2 = tal2.length();
		int 	diff = t2 - t1;
		int		carry = 0;
		String	sum = "";


		// adderar upp till talet vid tal1 l�ngd
		for (int i = t1 -1; i >= 0; i--)
		{
			int summa = ((tal1.charAt(i) -'0') + (tal2.charAt(i + diff) -'0') + carry);
			sum += (char) (summa % 10 + '0');
			carry = summa / 10;
		}

		// adderar resterande
		for (int i = t2 - t1 -1; i >= 0; i--)
		{
			int summa = ((tal2.charAt(i) -'0') + carry);
			sum += (char) (summa % 10 + '0');
			carry = summa / 10;
		}
		if (carry > 0)
			sum += (char)(carry + '0');

		StringBuilder	sb = new StringBuilder(sum);
		String	  omv�nt = sb.reverse().toString();
		return omv�nt;
	}

	// subtrahera tar emot tv� naturliga heltal givna som teckenstr�ngar, och returnerar deras diffferens som en teckenstr�ng
	// Det f�rsta heltalet �r inte mindre �n det andra heltalet.


	public static String subtrahera (String tal1, String tal2)
	{
		if (tal1.length() < tal2.length())
		{
			// s�tter tal1 till kortaste
			String t = tal1;
			tal1 = tal2;
			tal2 = t;
		}
		int		t1 = tal1.length();
		int		t2 = tal2.length();
		int 	diff = t1 - t2;
		int		carry = 0;
		String	sum = "";

		// f�rsta subtraktionen 
		for (int i = t2 -1; i >= 0; i--)
		{
			int summa = ((tal1.charAt(i + diff) -'0') - (tal2.charAt(i) -'0') - carry);
			if (summa < 0) 
			{ 
				summa = summa + 10; 
				carry = 1; 
			} 
			else
				carry = 0; 
			sum += (char)(summa + '0'); 
		}

		for (int i = t1 - 1 - t2; i >= 0; i--)
		{
			int summa = ((tal1.charAt(i) -'0') - carry);
			if (summa < 0) 
			{ 
				summa = summa + 10; 
				carry = 1; 
			} 
			else
				carry = 0; 
			sum += (char)(summa + '0');
		}

		StringBuilder	sb = new StringBuilder(sum);
		String	  omv�nt = sb.reverse().toString();
		return omv�nt;


	}

	// visa visar tv� givna naturliga heltal, och resultatet av en arimetisk operation utf�rd i samband med heltalen

	public static void visa (String tal1, String tal2, String resultat, char operator)
	{
		// s�tt en l�mplig l�ngd p� heltalen och resultatet
		int		len1 = tal1.length ();
		int		len2 = tal2.length ();
		int		len = resultat.length ();
		int		maxLen = Math.max (Math.max(len1, len2), len);
		tal1 = sattLen (tal1, maxLen - len1);
		tal2 = sattLen (tal2, maxLen - len2);
		resultat = sattLen (resultat, maxLen - len);

		// visa heltalen och resultatet
		out.println (" " + tal1);
		out.println ("" + operator + "" + tal2);
		for ( int i = 0; i < maxLen + 2; i++)
			out.print("-");
		out.println ();
		out.println (" " + resultat + "\n");
	}

	// sattLen l�gger till ett angivet antal mellanslag i b�rjan av en given str�ng 

	public static String sattLen (String s, int antal)
	{
		StringBuilder    sb = new StringBuilder (s);
		for (int i = 0; i < antal; i++)
			sb.insert(0, " ");
		return sb.toString ();
	}

}
