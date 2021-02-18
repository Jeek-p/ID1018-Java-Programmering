
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
	
	public Punkt hörn () throws java.util.NoSuchElementException
	{
		if (!this.finnsHörn ())
			throw new java.util.NoSuchElementException ("slut av iterationen");
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
