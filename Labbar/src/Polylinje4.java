
 public interface Polylinje4 extends java.lang.Iterable<Punkt>
	{
		Punkt[] getH�rn ();
		
		String getF�rg ();
		
		int getBredd ();
		
		double l�ngd ();
		
		void setF�rg (String f�rg);
		
		void setBredd (int bredd);
		
		public void l�ggTill (Punkt h�rn);
		
		void l�ggTillFramf�r (Punkt h�rn, String h�rnNamn);
		
		void taBort (String h�rnNamn);
		
		java.util.Iterator<Punkt> iterator ();
	}


