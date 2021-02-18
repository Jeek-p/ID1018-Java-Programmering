import java.util.Iterator;

public class NPolylinje implements Polylinje4
{
	private static class Nod
	{
		public Punkt    hörn;
		public Nod      nästaNod;
		public Nod (Punkt hörn)
		{
			this.hörn = hörn;
			nästaNod = null;
		}
	}
	private Nod    hörn;
	private String     färg = "svart";
	private int        bredd
	= 1;  // pixlar

	public NPolylinje ()
	{
		this.hörn = null;
	}

	public NPolylinje (Punkt[] hörn)
	{
		if (hörn.length > 0)
		{
			Nod   nod = new Nod (new Punkt (hörn[0]));
			this.hörn = nod;
			int    pos = 1;
			while (pos < hörn.length)
			{
				nod.nästaNod = new Nod (new Punkt (hörn[pos++]));
				nod = nod.nästaNod;
			}
		}
	}



	public int nodlängd ()
	{
		int i = 0;
		Nod nod = this.hörn;
		while (nod != null) 
		{
			nod = nod.nästaNod;
			i++;
		}
		return i;
	}

	// Skriver ut polylinjen på korrekt format

	@Override

	public String toString() 
	{
		String hörnText = "{[";
		Nod nod = this.hörn;
		while (nod != null) 
		{
			hörnText += nod.hörn.toString();
			nod = nod.nästaNod;
			if (nod != null) hörnText += " ";
		}
		hörnText += "], " + this.färg + ", " + this.bredd + "}";
		return hörnText;
	}

	// Retunerar punkterna i noderna som en punkt vektor

	public Punkt[] getHörn() 
	{
		Punkt[] n = new Punkt[nodlängd()];
		Nod nod = hörn;
		for (int i = 0; i < nodlängd(); i++) 
		{
			n[i] = nod.hörn;
			nod = nod.nästaNod;

		}
		return n;
	}

	// retunerar farg

	public String getFärg() 
	{
		return this.färg;
	}


	// retunerar bredd

	public int getBredd() 
	{
		return this.bredd;
	}

	// sätter farg till ett nytt värde

	public void setFärg(String färg) 
	{
		this.färg = färg;
	}

	// sätter bredd till ett nytt värde

	public void setBredd(int bredd) 
	{
		this.bredd = bredd;
	}



	// retunerar polylinjens längd

	// beräknar längden mellan nodernas punkter i tur och ordning

	public double längd() 
	{
		double längd = 0;
		Nod nod = hörn;
		for (int i = 0; i < nodlängd() - 1; i++) 
		{
			längd += nod.hörn.avstånd(nod.nästaNod.hörn);
			nod = nod.nästaNod;
		}
		return längd;
	}



	// lägger till en ny punkt
	// om det inte finns någon nod skapar den

	public void läggTill(Punkt hörn) 
	{
		if (this.hörn == null)
			this.hörn = new Nod(hörn);
		else 
		{
			Nod nod = this.hörn;
			while (nod.nästaNod != null) 
			{
				nod = nod.nästaNod;
			}
			nod.nästaNod = new Nod(hörn);
		}
	}



	// lägger till en ny punkt framför den med namn hornNamn

	// fungerar på liknande sätt som taBort

	public void läggTillFramför(Punkt hörn, String hörnNamn) 
	{
		{

			if (this.hörn == null) return;
			if (this.hörn.hörn.getNamn().equals(hörnNamn)) 
			{
				Nod temp = this.hörn;
				this.hörn = new Nod(hörn);
				this.hörn.nästaNod = temp;
			} 
			else if (this.hörn.nästaNod != null) 
			{
				Nod nodStart = this.hörn;
				while (!nodStart.nästaNod.hörn.getNamn().equals(hörnNamn)) 
				{
					if (nodStart.nästaNod.nästaNod == null) return;
					nodStart = nodStart.nästaNod;
				}
				Nod temp = nodStart.nästaNod;
				nodStart.nästaNod = new Nod(hörn);
				nodStart.nästaNod.nästaNod = temp;
			}

		}
	}



	// Tar bort punkten vid namn horn namn

	// om den är den enda punkten sätt horn till null

	// ta delen till och med punkten och sätt ihop med delen efter punkten

	public void taBort(String hörnNamn)
	{
		if (this.hörn.hörn.getNamn().equals(hörnNamn)) 
		{
			if (this.hörn.nästaNod != null)
				this.hörn = this.hörn.nästaNod;
			else
				this.hörn = null;
		} 
		else if (this.hörn.nästaNod != null)
		{
			Nod nodBörjan = this.hörn;
			while (!nodBörjan.nästaNod.hörn.getNamn().equals(hörnNamn)) 
			{
				if (nodBörjan.nästaNod.nästaNod == null) return;
				nodBörjan = nodBörjan.nästaNod;
			}
			Nod nodSlut = nodBörjan.nästaNod.nästaNod;
			nodBörjan.nästaNod = nodSlut;
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
			if (NPolylinje.this.hörn.nästaNod != null) 
			{
				aktuell = 0;
			}
		}



		// då aktuell inte = -1 så finns det en till punkt

		public boolean hasNext()
		{
			return aktuell != -1;
		}
		// gets the next Punkt from the nodes

		public Punkt next() throws java.util.NoSuchElementException
		{
			if (!this.hasNext())
				throw new java.util.NoSuchElementException (  "slut av iterationen");
			Nod node = hörn;
			if (aktuell != 0) 
			{
				for (int i = 0; i < aktuell; i++) 
				{
					node = node.nästaNod;
				}
			}

			if (aktuell >= 0 && aktuell < nodlängd() - 1) 
			{
				aktuell++;
			} 
			else 
			{
				aktuell = -1;
			}
			return node.hörn;

		}

	}
}


