import java.util.*;
public class Polylinje 
{
	private Punkt[]		hörn;
	private String		färg = "svart";
	private int			bredd = 1;

	public Polylinje ()
	{
		this.hörn = new Punkt [0];
	}

	public Polylinje (Punkt[] hörn)
	{
		this.hörn = new Punkt [hörn.length];
		for (int i = 0; i < hörn.length; i++)
			this.hörn[i] = new Punkt (hörn[i]);
	}

	public String toString () 
	{
		String	s = "";
		for (int i = 0; i < this.hörn.length; i++)
			s += this.hörn[i].toString() + " ";
		return (s + "(" + this.färg + ")" + "[" + this.bredd + "]");
	}

	public Punkt[] getHörn () 
	{
		Punkt[]		p = new Punkt[this.hörn.length];
		for (int i = 0; i < this.hörn.length; i++)
			p[i] = new Punkt(this.hörn[i]);

		return p;
	}

	public String getFärg () 
	{
		return this.färg;
	}

	public int getBredd () 
	{
		return this.bredd;
	}

	public void setFärg (String färg) 
	{
		this.färg = färg;
	}

	public void setBredd (int bredd) 
	{
		this.bredd = bredd;
	}

	public double längd () 
	{
		double längd = 0;
		for (int i = 0; i < hörn.length -1; i++)
		{
			längd += hörn[i].avstånd(hörn[i + 1]);
		}
		return längd;
	}

	public void läggTill (Punkt hörn)
	{
		Punkt[]		h = new Punkt[this.hörn.length + 1];
		int		i = 0;
		for (i = 0; i < this.hörn.length; i++)
			h[i] = this.hörn[i];
		h[i] = new Punkt (hörn);

		this.hörn = h;
	}

	public void läggTillFramför (Punkt hörn, String hörnNamn) 
	{
		Punkt[] a = new Punkt[this.hörn.length +1];
		int p = 0;
		for (int i = 0; i < this.hörn.length; i++)
		{
			if (hörnNamn.equals(this.hörn[i].getNamn()))
			{
				p = i;
				break;
			}

		}
		for (int j = 0, s = 0; s < this.hörn.length; j++, s++)
		{
			if (j == p)
			{
				a[j] = hörn;
				j++;
			}
			a[j] = this.hörn[s];

		}
		this.hörn = a;	 	
	}

	public void taBort (String hörnNamn) 
	{

		int p = 0;
		for (int i = 0; i < this.hörn.length; i++)
		{
			if (hörnNamn.equals(this.hörn[i].getNamn()))
			{
				p = i;
				break;
			}

		}

		Punkt[] a = new Punkt[this.hörn.length -1];
		for (int j = 0, s = 0; s < this.hörn.length; j++, s++)
		{
			if (s == p)
			{
				a[j] = this.hörn[s+1];
				s++;
			}
			a[j] = this.hörn[s];
		}
		this.hörn = a;

	}

	public class PolylinjeIterator 
	{
		private int		aktuell = -1;

		public PolylinjeIterator ()
		{
			if (Polylinje.this.getHörn().length > 0)
				aktuell = 0;
		}

		public boolean finnsHörn ()
		{
			return aktuell != -1;
		}

		public Punkt hörn () throws NoSuchElementException
		{
			if (!this.finnsHörn ())
				throw new NoSuchElementException ("slut av iterationen");
			Punkt		hörn = Polylinje.this.hörn[aktuell];

			return hörn;
		}

		public void gåFram ()
		{
			if (aktuell >= 0 && aktuell < Polylinje.this.hörn.length -1)
				aktuell++;
			else
				aktuell = -1;
		}

	}



}
