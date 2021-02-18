
public class DenKortasteV�gen 
{
	
	public static int[] mellanstationer (double[] a, double[][] b, double[] c)
	{
		double kortastavst�nd = Double.POSITIVE_INFINITY;
		int index [] = {1, 1,1};
		for (int i = 1; i < 4; i++)
		{
			for (int j = 1; j < 5; j++)
			{
				if (a[i] + b[i][j] + c[j] < kortastavst�nd)
				{
					kortastavst�nd = (a[i] + b[i][j] + c[j]);
					
					index [0] = (i);
					index [1] = (j);
					index [2] = (i * 4) - 4 + j;
				}
				
			}
		}
		return index;
	}


	public static double l�ngden (double[] a, double[][] b, double[] c)
	{
		int[]	index = DenKortasteV�gen.mellanstationer(a, b, c);
		double kortastavst�nd = a[index[0]] + b[index[0]][index[1]] + c[index[1]];
		return 	kortastavst�nd;				
	}


}
