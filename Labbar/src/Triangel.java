
public class Triangel 
{
	// Metod för area;

	public static double area (double Basen, double Höjden)
	{
		double area = ((Basen * Höjden) / 2);
		return area;
	}
		
	// Metod för omkrets
	
	public static double omkrets (double a, double b, double c)
	{
		double omkrets = a + b + c;
		return omkrets;
	}
		
	// Metoder för bisektris först separata sedan en total
	
	public static double bisektrisA (double x, double y, double alfa)
	{
		double p = 2 * x * y * Math.cos(alfa / 2);
		double bisA = p / (x + y);
		return bisA;
	}
	
	public static double bisektrisB (double a, double c, double alfa)
	{
		double p = 2 * a * c * Math.cos(alfa / 2);
		double bisB = p / (a + c);
		return bisB;
	}
	
	public static double bisektrisC (double a, double b, double alfa)
	{
		double p = 2 * a * b * Math.cos(alfa / 2);
		double bisB = p / (a + b);
		return bisB;
	}
	
	public static double[] bisektris (double a, double b, double c, double alfa, double beta, double ceta)
	{
		double bisektrisABC[] = new double [3];
		double pa = 2 * b * c * Math.cos(alfa / 2);
		bisektrisABC [0] = pa / (b + c); // för vinkel A
		
		double pb = 2 * a * c * Math.cos(beta / 2); 
		bisektrisABC [1] = pb / (a + c); // för vinkel B
		
		double pc = 2 * a * b * Math.cos(ceta / 2); 
		bisektrisABC [2] = pc / (a + b); // för vinkel C
		
		return bisektrisABC;
	}
	
	// metoder för radie
	
	public static double[] cirkel (double a, double b, double c)
	{
		double radie[] = new double [2];
		double s = (a + b + c) / 2;
		radie [0] = Math.sqrt((s - a) * (s - b) * (s - c)) / 2; // inre 
		radie [1] = (a * b * c) / (4 * Math.sqrt(s * (s - a) * (s - b) * (s - c))); // ytre
		return radie;	
	}
	
	public static double[] vinkel (double A, double a, double b, double c)
	{
		double vinkel[] = new double [3];
		double a1 = (2 * A) / (b * c);
		vinkel [0] = Math.sin(a1);
		double b1 = (2 * A) / (a * c);
		vinkel [1] = Math.sin(b1);
		double c1 = (2 * A) / (a * b);
		vinkel [2] = Math.sin(c1);
		return vinkel;		
	}
}
