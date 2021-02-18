import java.util.*;
import static java.lang.System.out;
public class OU4 
{
	public static void main (String[] args)
	{
		out.println ("OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRÄNGAR\n");

		// MATA IN TVÅ NATURLIGA HELTAL

		Scanner		in = new Scanner (System.in);
		out.println ("två naturliga heltal:");
		String		tal1 = in.next ();
		String		tal2 = in.next ();
		out.println ();

		// addera heltalen och visa resultatet

		String		summa = addera (tal1, tal2);
		visa (tal1, tal2, summa, '+');
		String		differens = subtrahera (tal1, tal2);
		visa (tal1, tal2, differens, '-');


		// addera tar emot två naturliga heltal givna som teckensträngar, och returnerar deras 
		// summa som en teckensträng.
	}


	public static String addera (String tal1, String tal2)
	{
		if (tal1.length() > tal2.length())
		{
			// sätter tal1 till kortaste och tal2 till längsta
			String t = tal1;
			tal1 = tal2;
			tal2 = t;
		}

		int		t1 = tal1.length();
		int		t2 = tal2.length();
		int 	diff = t2 - t1;
		int		carry = 0;
		String	sum = "";


		// adderar upp till talet vid tal1 längd
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
		String	  omvänt = sb.reverse().toString();
		return omvänt;
	}

	// subtrahera tar emot två naturliga heltal givna som teckensträngar, och returnerar deras diffferens som en teckensträng
	// Det första heltalet är inte mindre än det andra heltalet.


	public static String subtrahera (String tal1, String tal2)
	{
		if (tal1.length() < tal2.length())
		{
			// sätter tal1 till kortaste
			String t = tal1;
			tal1 = tal2;
			tal2 = t;
		}
		int		t1 = tal1.length();
		int		t2 = tal2.length();
		int 	diff = t1 - t2;
		int		carry = 0;
		String	sum = "";

		// första subtraktionen 
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
		String	  omvänt = sb.reverse().toString();
		return omvänt;


	}

	// visa visar två givna naturliga heltal, och resultatet av en arimetisk operation utförd i samband med heltalen

	public static void visa (String tal1, String tal2, String resultat, char operator)
	{
		// sätt en lämplig längd på heltalen och resultatet
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

	// sattLen lägger till ett angivet antal mellanslag i början av en given sträng 

	public static String sattLen (String s, int antal)
	{
		StringBuilder    sb = new StringBuilder (s);
		for (int i = 0; i < antal; i++)
			sb.insert(0, " ");
		return sb.toString ();
	}

}
