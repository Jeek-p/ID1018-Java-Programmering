
 public interface Polylinje4 extends java.lang.Iterable<Punkt>
	{
		Punkt[] getHörn ();
		
		String getFärg ();
		
		int getBredd ();
		
		double längd ();
		
		void setFärg (String färg);
		
		void setBredd (int bredd);
		
		public void läggTill (Punkt hörn);
		
		void läggTillFramför (Punkt hörn, String hörnNamn);
		
		void taBort (String hörnNamn);
		
		java.util.Iterator<Punkt> iterator ();
	}


