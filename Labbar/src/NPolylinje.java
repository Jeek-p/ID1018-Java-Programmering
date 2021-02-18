import java.util.Iterator;

public class NPolylinje implements Polylinje4
{
	private static class Nod
	{
		public Punkt    h�rn;
		public Nod      n�staNod;
		public Nod (Punkt h�rn)
		{
			this.h�rn = h�rn;
			n�staNod = null;
		}
	}
	private Nod    h�rn;
	private String     f�rg = "svart";
	private int        bredd
	= 1;  // pixlar

	public NPolylinje ()
	{
		this.h�rn = null;
	}

	public NPolylinje (Punkt[] h�rn)
	{
		if (h�rn.length > 0)
		{
			Nod   nod = new Nod (new Punkt (h�rn[0]));
			this.h�rn = nod;
			int    pos = 1;
			while (pos < h�rn.length)
			{
				nod.n�staNod = new Nod (new Punkt (h�rn[pos++]));
				nod = nod.n�staNod;
			}
		}
	}



	public int nodl�ngd ()
	{
		int i = 0;
		Nod nod = this.h�rn;
		while (nod != null) 
		{
			nod = nod.n�staNod;
			i++;
		}
		return i;
	}

	// Skriver ut polylinjen p� korrekt format

	@Override

	public String toString() 
	{
		String h�rnText = "{[";
		Nod nod = this.h�rn;
		while (nod != null) 
		{
			h�rnText += nod.h�rn.toString();
			nod = nod.n�staNod;
			if (nod != null) h�rnText += " ";
		}
		h�rnText += "], " + this.f�rg + ", " + this.bredd + "}";
		return h�rnText;
	}

	// Retunerar punkterna i noderna som en punkt vektor

	public Punkt[] getH�rn() 
	{
		Punkt[] n = new Punkt[nodl�ngd()];
		Nod nod = h�rn;
		for (int i = 0; i < nodl�ngd(); i++) 
		{
			n[i] = nod.h�rn;
			nod = nod.n�staNod;

		}
		return n;
	}

	// retunerar farg

	public String getF�rg() 
	{
		return this.f�rg;
	}


	// retunerar bredd

	public int getBredd() 
	{
		return this.bredd;
	}

	// s�tter farg till ett nytt v�rde

	public void setF�rg(String f�rg) 
	{
		this.f�rg = f�rg;
	}

	// s�tter bredd till ett nytt v�rde

	public void setBredd(int bredd) 
	{
		this.bredd = bredd;
	}



	// retunerar polylinjens l�ngd

	// ber�knar l�ngden mellan nodernas punkter i tur och ordning

	public double l�ngd() 
	{
		double l�ngd = 0;
		Nod nod = h�rn;
		for (int i = 0; i < nodl�ngd() - 1; i++) 
		{
			l�ngd += nod.h�rn.avst�nd(nod.n�staNod.h�rn);
			nod = nod.n�staNod;
		}
		return l�ngd;
	}



	// l�gger till en ny punkt
	// om det inte finns n�gon nod skapar den

	public void l�ggTill(Punkt h�rn) 
	{
		if (this.h�rn == null)
			this.h�rn = new Nod(h�rn);
		else 
		{
			Nod nod = this.h�rn;
			while (nod.n�staNod != null) 
			{
				nod = nod.n�staNod;
			}
			nod.n�staNod = new Nod(h�rn);
		}
	}



	// l�gger till en ny punkt framf�r den med namn hornNamn

	// fungerar p� liknande s�tt som taBort

	public void l�ggTillFramf�r(Punkt h�rn, String h�rnNamn) 
	{
		{

			if (this.h�rn == null) return;
			if (this.h�rn.h�rn.getNamn().equals(h�rnNamn)) 
			{
				Nod temp = this.h�rn;
				this.h�rn = new Nod(h�rn);
				this.h�rn.n�staNod = temp;
			} 
			else if (this.h�rn.n�staNod != null) 
			{
				Nod nodStart = this.h�rn;
				while (!nodStart.n�staNod.h�rn.getNamn().equals(h�rnNamn)) 
				{
					if (nodStart.n�staNod.n�staNod == null) return;
					nodStart = nodStart.n�staNod;
				}
				Nod temp = nodStart.n�staNod;
				nodStart.n�staNod = new Nod(h�rn);
				nodStart.n�staNod.n�staNod = temp;
			}

		}
	}



	// Tar bort punkten vid namn horn namn

	// om den �r den enda punkten s�tt horn till null

	// ta delen till och med punkten och s�tt ihop med delen efter punkten

	public void taBort(String h�rnNamn)
	{
		if (this.h�rn.h�rn.getNamn().equals(h�rnNamn)) 
		{
			if (this.h�rn.n�staNod != null)
				this.h�rn = this.h�rn.n�staNod;
			else
				this.h�rn = null;
		} 
		else if (this.h�rn.n�staNod != null)
		{
			Nod nodB�rjan = this.h�rn;
			while (!nodB�rjan.n�staNod.h�rn.getNamn().equals(h�rnNamn)) 
			{
				if (nodB�rjan.n�staNod.n�staNod == null) return;
				nodB�rjan = nodB�rjan.n�staNod;
			}
			Nod nodSlut = nodB�rjan.n�staNod.n�staNod;
			nodB�rjan.n�staNod = nodSlut;
		}

	}


	public Iterator<Punkt> iterator() 
	{
		return this.new PolylinjeIterator();
	}

	public class PolylinjeIterator implements Iterator 
	{
		private int aktuell = -1;




		public PolylinjeIterator() 
		{
			if (NPolylinje.this.h�rn.n�staNod != null) 
			{
				aktuell = 0;
			}
		}



		// d� aktuell inte = -1 s� finns det en till punkt

		public boolean hasNext()
		{
			return aktuell != -1;
		}
		// gets the next Punkt from the nodes

		public Punkt next() throws java.util.NoSuchElementException
		{
			if (!this.hasNext())
				throw new java.util.NoSuchElementException (  "slut av iterationen");
			Nod node = h�rn;
			if (aktuell != 0) 
			{
				for (int i = 0; i < aktuell; i++) 
				{
					node = node.n�staNod;
				}
			}

			if (aktuell >= 0 && aktuell < nodl�ngd() - 1) 
			{
				aktuell++;
			} 
			else 
			{
				aktuell = -1;
			}
			return node.h�rn;

		}

	}
}


