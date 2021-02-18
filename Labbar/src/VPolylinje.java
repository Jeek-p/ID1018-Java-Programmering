import java.util.Iterator;

public class VPolylinje implements Polylinje4
{
	private Punkt[]		h�rn;
	private String		f�rg = "svart";
	private int			bredd = 1;
	
	
    public VPolylinje() 
    {
        this.h�rn = new Punkt[0];
    }



    public VPolylinje(Punkt[] h�rn) 
    {
        this.h�rn = new Punkt[h�rn.length];
        for (int i = 0; i < h�rn.length; i++)
            this.h�rn[i] = new Punkt(h�rn[i]);
        
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
		Punkt[]		p = new Punkt[this.h�rn.length];
		for (int i = 0; i < this.h�rn.length; i++)
			p[i] = new Punkt(this.h�rn[i]);

		return p;
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
		this.f�rg = f�rg;
	}

	public void setBredd (int bredd) 
	{
		this.bredd = bredd;
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
	
	public Iterator<Punkt> iterator() 
	{
        return this.new PolylinjeIterator();
    }

	public class PolylinjeIterator implements Iterator
	{
		private int		aktuell = -1;

		public PolylinjeIterator ()
		{
			if (VPolylinje.this.getH�rn().length > 0)
				aktuell = 0;
		}

		public boolean hasNext ()
		{
			return aktuell != -1;
		}

		 public Punkt next() throws java.util.NoSuchElementException 
		 {
	            if (!this.hasNext())
	                throw new java.util.NoSuchElementException( "slut av iterationen");
	            Punkt h�rn = VPolylinje.this.h�rn[aktuell];
	            if (aktuell >= 0 && aktuell < VPolylinje.this.h�rn.length - 1) 
	            {
	                aktuell++;
	            }
	            else 
	            {
	                aktuell = -1;
	            }
	            return h�rn;
	        }
	}
	
}
