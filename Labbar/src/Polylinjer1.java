
public class Polylinjer1 
{

	public class Polylinje 
	{
		private Punkt[]		h�rn;
		private String		f�rg = "svart";
		private int			bredd = 1;

		public Polylinje ()
		{
			this.h�rn = new Punkt [0];
		}

		public Polylinje (Punkt[] h�rn)
		{
			this.h�rn = new Punkt [h�rn.length];
			for (int i = 0; i < h�rn.length; i++)
				this.h�rn[i] = new Punkt (h�rn[i]);
		}

		public String toString () 
		{
			String	s = "";
			for (int i = 0; i < this.h�rn.length; i++)
				s += this.h�rn[i].toString() + " ";
			return (s + "(" + this.f�rg + ")" + "[" + this.bredd + "]");
		}

		public Punkt[] getH�rn () 
		{
			return this.h�rn;
		}

		public String getF�rg () 
		{
			return this.f�rg;
		}

		public int getBredd () 
		{
			return this.bredd;
		}

		public void setF�rg (String f�rg) 
		{
			String	f�rg2 = f�rg;
			this.f�rg = f�rg2;
		}

		public void setBredd (int bredd) 
		{
			int		bredd2 = bredd;
			this.bredd = bredd2;
		}

		public double l�ngd () 
		{
			double l�ngd = 0;
			for (int i = 0; i < h�rn.length -1; i++)
			{
				l�ngd += h�rn[i].avst�nd(h�rn[i + 1]);
			}
			return l�ngd;
		}

		public void l�ggTill (Punkt h�rn)
		{
			Punkt[]		h = new Punkt[this.h�rn.length + 1];
			int		i = 0;
			for (i = 0; i < this.h�rn.length; i++)
				h[i] = this.h�rn[i];
			h[i] = new Punkt (h�rn);

			this.h�rn = h;
		}

		public void l�ggTillFramf�r (Punkt h�rn, String h�rnNamn) 
		{
			Punkt[] a = new Punkt[this.h�rn.length +1];
			int p = 0;
			for (int i = 0; i < this.h�rn.length; i++)
			{
				if (h�rnNamn.equals(this.h�rn[i].getNamn()))
				{
					p = i;
					break;
				}

			}
			for (int j = 0, s = 0; s < this.h�rn.length; j++, s++)
			{
				if (j == p)
				{
					a[j] = h�rn;
					j++;
				}
				a[j] = this.h�rn[s];

			}
			this.h�rn = a;
		}

		public void taBort (String h�rnNamn) 
		{
			int p = 0;
			for (int i = 0; i < this.h�rn.length; i++)
			{
				if (h�rnNamn.equals(this.h�rn[i].getNamn()))
				{
					p = i;
					break;
				}

			}

			Punkt[] a = new Punkt[this.h�rn.length -1];
			for (int j = 0, s = 0; s < this.h�rn.length; j++, s++)
			{
				if (s == p)
				{
					a[j] = this.h�rn[s+1];
					s++;
				}
				a[j] = this.h�rn[s];
			}
			this.h�rn = a;
		}




	}


}
