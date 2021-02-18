
public class PolylinjeIterator 
{
	private int		aktuell = -1;
	
	public PolylinjeIterator ()
	{
		if (Polylinje.this.getH�rn().length > 0)
			aktuell = 0;
	}
	
	public boolean finnsH�rn ()
	{
		return aktuell != -1;
	}
	
	public Punkt h�rn () throws java.util.NoSuchElementException
	{
		if (!this.finnsH�rn ())
			throw new java.util.NoSuchElementException ("slut av iterationen");
		Punkt		h�rn = Polylinje.this.h�rn[aktuell];
		 
		return h�rn;
	}
	
	public void g�Fram ()
	{
		if (aktuell >= 0 && aktuell < Polylinje.this.h�rn.length -1)
			aktuell++;
		else
			aktuell = -1;
	}

}
