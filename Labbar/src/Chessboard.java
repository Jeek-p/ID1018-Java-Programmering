
public class Chessboard
{
	public static class Field
	{   
		private char    row;
		private byte    column;
		private Chesspiece    piece = null;
		private boolean    marked = false;



		public Field (char row, byte column)
		{
			this.row = row;
			this.column = column;
		}

		public void put (Chesspiece piece)
		{
			this.piece = piece;
		}

		public Chesspiece take () 
		{
			Chesspiece borttagen = this.piece;
			this.piece = null;
			return borttagen;
		}

		public void mark ()
		{
			marked = true;
		}

		public void unmark ()  
		{
			marked = false;
		}

		public String toString ()
		{
			String    s = (marked)? "xx" : "--";
			return (piece == null)? s : piece.toString ();
		}

	}
	// Variabler för bestämning av brädet

	public static final int    NUMBER_OF_ROWS = 8;
	public static final int    NUMBER_OF_COLUMNS = 8;
	public static final int    FIRST_ROW = 'a';
	public static final int    FIRST_COLUMN = 1;

	private Field[][]    fields;

	// Deklarerar brädets rader/kolumner
	public Chessboard ()
	{
		fields = new Field[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
		char    row = 0;
		byte    column = 0;
		for (int r = 0; r < NUMBER_OF_ROWS; r++)
		{
			row = (char) (FIRST_ROW + r);
			column = FIRST_COLUMN;
			for (int c = 0; c < NUMBER_OF_COLUMNS; c++)
			{
				fields[r][c] = new Field (row, column);
				column++;
			}
		}
	}

	// printa ett synligt bräde
	public String toString ()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("    1  2  3  4  5  6  7  8\n");
		for(int i = 0; i < NUMBER_OF_ROWS; i++)
		{
			sb.append((char) (i + FIRST_ROW) + " ");
			for(int j = 0; j < NUMBER_OF_COLUMNS; j++)
			{
				sb.append(" " + fields[j][i]);
				if(j == 7)
				{
					sb.append("\n");
				}
			}
		}

		return sb.toString();
	}

	public boolean isValidField (char row, byte column)
	{
		try 
		{
			Field	test = fields[(int)(row) - 97][column - 1];
		} 
		catch (IndexOutOfBoundsException e) 
		{
			return false;
		}

		return true;
	}

	public abstract class Chesspiece
	{
		private char    color;
		// w -white, b -black
		private char    name;
		// K -King, Q -Queen, R -Rook, B -Bishop, N -Knight,
		// P –Pawn
		protected char    row = 0;
		protected byte    column = -1;

		protected Chesspiece (char color, char name)
		{
			this.color = color;
			this.name = name;
		}

		public String toString ()
		{
			return "" + color + name;
		}

		public boolean isOnBoard ()
		{
			return Chessboard.this.isValidField (row, column);
		}

		public void moveTo (char row, byte column) throws NotValidFieldException
		{
			if (!Chessboard.this.isValidField (row, column))
				throw new NotValidFieldException ("bad field: " + row + column );
			this.row = row;
			this.column = column;
			int    r = row -FIRST_ROW;
			int    c = column -FIRST_COLUMN;
			Chessboard.this.fields[r][c].put (this);
		}

		public void moveOut ()
		{
			if (this.isOnBoard()) 
			{
				Chessboard.this.fields[row - FIRST_ROW][column -1].take();
			}
		}

		public abstract void markReachableFields ();
		public abstract void unmarkReachableFields ();
	}

	//Bestämmer varje pjäs

	public class Pawn extends Chesspiece
	{
		public Pawn (char color, char name)
		{
			super (color, name);
		}

		public void markReachableFields ()
		{
			byte    col = (byte) (column + 1);
			if (Chessboard.this.isValidField (row, col))
			{
				int    r = row -FIRST_ROW;
				int    c = col -FIRST_COLUMN;
				Chessboard.this.fields[r][c].mark ();
			}
		}
		public void unmarkReachableFields ()
		{
			byte    col = (byte) (column + 1);
			if (Chessboard.this.isValidField (row, col))
			{
				int    r = row -FIRST_ROW;
				int    c = col -FIRST_COLUMN;
				Chessboard.this.fields[r][c].unmark ();
			}
		}
	}

	public class Rook extends Chesspiece
	{
		public Rook (char color, char name)
		{
			super (color, name);
		}

		public void markReachableFields ()
		{	
			for (int i = 0; i < NUMBER_OF_COLUMNS; i++)
			{
				if (Chessboard.this.isValidField (row, (byte)(i+1)))
				{
					Chessboard.this.fields[row - FIRST_ROW][i].mark();
				}	
			}
			for (int i = 0; i < NUMBER_OF_ROWS; i++)
			{
				if (Chessboard.this.isValidField ((char) (FIRST_ROW + i), (byte)(i+1)))
				{
					Chessboard.this.fields[i][this.column - FIRST_COLUMN].mark();
				}

			}

		}

		public void unmarkReachableFields ()
		{
			for (int i = 0; i < NUMBER_OF_COLUMNS; i++)
			{
				if (Chessboard.this.isValidField (row, (byte)(i+1)))
				{
					Chessboard.this.fields[row - FIRST_ROW][i].unmark();
				}	
			}
			for (int i = 0; i < NUMBER_OF_ROWS; i++)
			{
				if (Chessboard.this.isValidField ((char) (FIRST_ROW + i), this.column))
				{
					Chessboard.this.fields[i][this.column - FIRST_COLUMN].unmark();
				}	
			}
		}
	}

	public class Knight extends Chesspiece
	{
		public Knight (char color, char name)
		{
			super (color, name);
		}

		public void markReachableFields ()
		{
			byte col1 = (byte) (column + 2);
			char rad1 = (char) (row + 1);
			if (Chessboard.this.isValidField((rad1), (col1)))
			{
				Chessboard.this.fields[rad1 - FIRST_ROW][col1 - FIRST_COLUMN].mark();
			}

			byte col2 = (byte) (column + 2);
			char rad2 = (char) (row - 1);
			if (Chessboard.this.isValidField((rad2), (col2)))
			{
				Chessboard.this.fields[rad2 - FIRST_ROW][col2 - FIRST_COLUMN].mark();
			}

			byte col3 = (byte) (column + 1);
			char rad3 = (char) (row - 2);
			if (Chessboard.this.isValidField((rad3), (col3)))
			{
				Chessboard.this.fields[rad3 - FIRST_ROW][col3 - FIRST_COLUMN].mark();
			}

			byte col4 = (byte) (column - 1);
			char rad4 = (char) (row - 2);
			if (Chessboard.this.isValidField((rad4), (col4)))
			{
				Chessboard.this.fields[rad4 - FIRST_ROW][col4 - FIRST_COLUMN].mark();
			}

			byte col5 = (byte) (column - 2);
			char rad5 = (char) (row + 1);
			if (Chessboard.this.isValidField((rad5), (col5)))
			{
				Chessboard.this.fields[rad5 - FIRST_ROW][col5 - FIRST_COLUMN].mark();
			}

			byte col6 = (byte) (column - 2);
			char rad6 = (char) (row - 1);
			if (Chessboard.this.isValidField((rad6), (col6)))
			{
				Chessboard.this.fields[rad6 - FIRST_ROW][col6 - FIRST_COLUMN].mark();
			}

			byte col7 = (byte) (column + 1);
			char rad7 = (char) (row + 2);
			if (Chessboard.this.isValidField((rad7), col7))
			{
				Chessboard.this.fields[rad7 - FIRST_ROW][col7 - FIRST_COLUMN].mark();
			}

			byte col8 = (byte) (column - 1);
			char rad8 = (char) (row + 2);
			if (Chessboard.this.isValidField((rad8), col8))
			{
				Chessboard.this.fields[rad8 - FIRST_ROW][col8 - FIRST_COLUMN].mark();
			}
		}

		public void unmarkReachableFields ()
		{
			byte col1 = (byte) (column + 2);
			char rad1 = (char) (row + 1);
			if (Chessboard.this.isValidField((rad1), col1))
			{
				Chessboard.this.fields[rad1 - FIRST_ROW][col1 - FIRST_COLUMN].unmark();
			}

			byte col2 = (byte) (column + 2);
			char rad2 = (char) (row - 1);
			if (Chessboard.this.isValidField((rad2), col2))
			{
				Chessboard.this.fields[rad2 - FIRST_ROW][col2 - FIRST_COLUMN].unmark();
			}

			byte col3 = (byte) (column + 1);
			char rad3 = (char) (row - 2);
			if (Chessboard.this.isValidField((rad3), col3))
			{
				Chessboard.this.fields[rad3 - FIRST_ROW][col3 - FIRST_COLUMN].unmark();
			}

			byte col4 = (byte) (column - 1);
			char rad4 = (char) (row - 2);
			if (Chessboard.this.isValidField((rad4), col4))
			{
				Chessboard.this.fields[rad4 - FIRST_ROW][col4 - FIRST_COLUMN].unmark();
			}

			byte col5 = (byte) (column - 2);
			char rad5 = (char) (row + 1);
			if (Chessboard.this.isValidField((rad5), col5))
			{
				Chessboard.this.fields[rad5 - FIRST_ROW][col5 - FIRST_COLUMN].unmark();
			}

			byte col6 = (byte) (column - 2);
			char rad6 = (char) (row - 1);
			if (Chessboard.this.isValidField((rad6), col6))
			{
				Chessboard.this.fields[rad6 - FIRST_ROW][col6 - FIRST_COLUMN].unmark();
			}

			byte col7 = (byte) (column + 1);
			char rad7 = (char) (row + 2);
			if (Chessboard.this.isValidField((rad7), col7))
			{
				Chessboard.this.fields[rad7 - FIRST_ROW][col7 - FIRST_COLUMN].unmark();
			}

			byte col8 = (byte) (column - 1);
			char rad8 = (char) (row + 2);
			if (Chessboard.this.isValidField((rad8), col8))
			{
				Chessboard.this.fields[rad8 - FIRST_ROW][col8 - FIRST_COLUMN].unmark();
			}
		}
	}

	public class Bishop extends Chesspiece
	{
		public Bishop (char color, char name)
		{
			super (color, name);
		}

		public void markReachableFields ()
		{
			int colriktning;
			int radriktning;

			for (int i = 0; i < 2; i++)
			{
				colriktning = i % 2;
				if (colriktning == 0)
					colriktning = -1;
				else colriktning = 1;
				for (int j = 0; j < 2; j++)
				{
					radriktning = j % 2;
					if (radriktning == 0)
						radriktning = -1;
					else radriktning = 1;
					for (int r = 1; r < 8; r++)
					{
						int	col = column + colriktning * r;
						int rad = row + radriktning * r;
						if (Chessboard.this.isValidField((char)rad, (byte)col))
							Chessboard.this.fields[rad - FIRST_ROW][col - FIRST_COLUMN].mark();
					}
				}
			}
		}

		public void unmarkReachableFields ()
		{
			int colriktning;
			int radriktning;

			for (int i = 0; i < 2; i++)
			{
				colriktning = i % 2;
				if (colriktning == 0)
					colriktning = -1;
				else colriktning = 1;
				for (int j = 0; j < 2; j++)
				{
					radriktning = j % 2;
					if (radriktning == 0)
						radriktning = -1;
					else radriktning = 1;
					for (int r = 1; r < 8; r++)
					{
						int	col = column + colriktning * r;
						int rad = row + radriktning * r;
						if (Chessboard.this.isValidField((char)rad, (byte)col))
						{
							Chessboard.this.fields[rad - FIRST_ROW][col - FIRST_COLUMN].unmark();
						}
					}
				}
			}
		}
	}

	public class Queen extends Chesspiece
	{
		public Queen (char color, char name)
		{
			super (color, name);
		}

		public void markReachableFields ()
		{
			for (int i = 0; i < NUMBER_OF_COLUMNS; i++)
			{
				if (Chessboard.this.isValidField (row, (byte)(i+1)))
				{
					Chessboard.this.fields[row - FIRST_ROW][i].mark();
				}	
			}
			for (int i = 0; i < NUMBER_OF_ROWS; i++)
			{
				if (Chessboard.this.isValidField ((char) (FIRST_ROW + i), (byte)(i+1)))
				{
					Chessboard.this.fields[i][this.column - FIRST_COLUMN].mark();
				}

			}
			{
				int colriktning;
				int radriktning;

				for (int i = 0; i < 2; i++)
				{
					colriktning = i % 2;
					if (colriktning == 0)
						colriktning = -1;
					else colriktning = 1;
					for (int j = 0; j < 2; j++)
					{
						radriktning = j % 2;
						if (radriktning == 0)
							radriktning = -1;
						else radriktning = 1;
						for (int r = 1; r < 8; r++)
						{
							int	col = column + colriktning * r;
							int rad = row + radriktning * r;
							if (Chessboard.this.isValidField((char)rad, (byte)col))
							{
								Chessboard.this.fields[rad - FIRST_ROW][col - FIRST_COLUMN].mark();
							}
						}
					}
				}
			}

		}

		public void unmarkReachableFields ()
		{
			for (int i = 0; i < NUMBER_OF_COLUMNS; i++)
			{
				if (Chessboard.this.isValidField (row, (byte)(i+1)))
				{
					Chessboard.this.fields[row - FIRST_ROW][i].unmark();
				}	
			}
			for (int i = 0; i < NUMBER_OF_ROWS; i++)
			{
				if (Chessboard.this.isValidField ((char) (FIRST_ROW + i), (byte)(i+1)))
				{
					Chessboard.this.fields[i][this.column - FIRST_COLUMN].unmark();
				}

			}
			{
				int colriktning;
				int radriktning;

				for (int i = 0; i < 2; i++)
				{
					colriktning = i % 2;
					if (colriktning == 0)
						colriktning = -1;
					else colriktning = 1;
					for (int j = 0; j < 2; j++)
					{
						radriktning = j % 2;
						if (radriktning == 0)
							radriktning = -1;
						else radriktning = 1;
						for (int r = 1; r < 8; r++)
						{
							int	col = column + colriktning * r;
							int rad = row + radriktning * r;
							if (Chessboard.this.isValidField((char)rad, (byte)col))
							{
								Chessboard.this.fields[rad - FIRST_ROW][col - FIRST_COLUMN].unmark();
							}
						}
					}
				}
			}
		}
	}

	public class King extends Chesspiece
	{
		public King (char color, char name)
		{
			super (color, name);
		}

		public void markReachableFields ()
		{
			byte col1 = column;
			char rad1 = (char) (row - 1);
			if (Chessboard.this.isValidField((rad1), col1))
			{
				Chessboard.this.fields[rad1 - FIRST_ROW][col1 - FIRST_COLUMN].mark();
			}

			byte col2 = column;
			char rad2 = (char) (row + 1);
			if (Chessboard.this.isValidField((rad2), col2))
			{
				Chessboard.this.fields[rad2 - FIRST_ROW][col2 - FIRST_COLUMN].mark();
			}

			byte col3 = (byte) (column + 1);
			char rad3 = row;
			if (Chessboard.this.isValidField((rad3), col3))
			{
				Chessboard.this.fields[rad3 - FIRST_ROW][col3 - FIRST_COLUMN].mark();
			}

			byte col4 = (byte) (column - 1);
			char rad4 = row;
			if (Chessboard.this.isValidField((rad4), col4))
			{
				Chessboard.this.fields[rad4 - FIRST_ROW][col4 - FIRST_COLUMN].mark();
			}

			byte col5 = (byte) (column + 1);
			char rad5 = (char) (row - 1);
			if (Chessboard.this.isValidField((rad5), col5))
			{
				Chessboard.this.fields[rad5 - FIRST_ROW][col5 - FIRST_COLUMN].mark();
			}

			byte col6 = (byte) (column - 1);
			char rad6 = (char) (row - 1);
			if (Chessboard.this.isValidField((rad6), col6))
			{
				Chessboard.this.fields[rad6 - FIRST_ROW][col6 - FIRST_COLUMN].mark();
			}

			byte col7 = (byte) (column - 1);
			char rad7 = (char) (row + 1);
			if (Chessboard.this.isValidField((rad7), col7))
			{
				Chessboard.this.fields[rad7 - FIRST_ROW][col7 - FIRST_COLUMN].mark();
			}

			byte col8 = (byte) (column + 1);
			char rad8 = (char) (row + 1);
			if (Chessboard.this.isValidField((rad8), col8))
			{
				Chessboard.this.fields[rad8 - FIRST_ROW][col8 - FIRST_COLUMN].mark();
			}
		}

		public void unmarkReachableFields ()
		{
			byte col1 = column;
			char rad1 = (char) (row - 1);
			if (Chessboard.this.isValidField((rad1), col1))
			{
				Chessboard.this.fields[rad1 - FIRST_ROW][col1 - FIRST_COLUMN].unmark();
			}

			byte col2 = column;
			char rad2 = (char) (row + 1);
			if (Chessboard.this.isValidField((rad2), col2))
			{
				Chessboard.this.fields[rad2 - FIRST_ROW][col2 - FIRST_COLUMN].unmark();
			}

			byte col3 = (byte) (column + 1);
			char rad3 = row;
			if (Chessboard.this.isValidField((rad3), col3))
			{
				Chessboard.this.fields[rad3 - FIRST_ROW][col3 - FIRST_COLUMN].unmark();
			}

			byte col4 = (byte) (column - 1);
			char rad4 = row;
			if (Chessboard.this.isValidField((rad4), col4))
			{
				Chessboard.this.fields[rad4 - FIRST_ROW][col4 - FIRST_COLUMN].unmark();
			}

			byte col5 = (byte) (column + 1);
			char rad5 = (char) (row - 1);
			if (Chessboard.this.isValidField((rad5), col5))
			{
				Chessboard.this.fields[rad5 - FIRST_ROW][col5 - FIRST_COLUMN].unmark();
			}

			byte col6 = (byte) (column - 1);
			char rad6 = (char) (row - 1);
			if (Chessboard.this.isValidField((rad6), col6))
			{
				Chessboard.this.fields[rad6 - FIRST_ROW][col6 - FIRST_COLUMN].unmark();
			}

			byte col7 = (byte) (column - 1);
			char rad7 = (char) (row + 1);
			if (Chessboard.this.isValidField((rad7), col7))
			{
				Chessboard.this.fields[rad7 - FIRST_ROW][col7 - FIRST_COLUMN].unmark();
			}

			byte col8 = (byte) (column + 1);
			char rad8 = (char) (row + 1);
			if (Chessboard.this.isValidField((rad8), col8))
			{
				Chessboard.this.fields[rad8 - FIRST_ROW][col8 - FIRST_COLUMN].unmark();
			}
		}
	}


}
