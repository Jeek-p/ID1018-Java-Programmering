import java.util.Random;
public class ReachableFieldsOnChessboard 
{
	public static void main(String[] args) {

		Chessboard chessBoard = new Chessboard();

		System.out.println(chessBoard + "\n");

		Chessboard.Chesspiece[] pieces = new Chessboard.Chesspiece[6];

		pieces[0] = chessBoard.new Pawn('w', 'P');
		pieces[1] = chessBoard.new Rook('b', 'R');
		pieces[2] = chessBoard.new Knight('w', 'N');
		pieces[3] = chessBoard.new Bishop('w', 'B');
		pieces[4] = chessBoard.new Queen('w', 'Q');
		pieces[5] = chessBoard.new King('b', 'K');


		Random slumpa = new Random();
		for (int i = 0; i < 6; i++) {
			try 
			{
				for (int j = 0; j < 4; j++) 
				{
					if (j == 0) 
					{
						pieces[i].moveTo((char) (slumpa.nextInt(7) + 97), (byte) (slumpa.nextInt(7) + 1));
						System.out.println("Placerar ut " + pieces[i].toString() + " på schackbrädet ");
					}
					if (j == 1)
					{
						pieces[i].markReachableFields();
						System.out.println("Visar möjliga drag " + pieces[i].toString() + ".");
					} 
					if (j == 2)
					{
						pieces[i].unmarkReachableFields();
						System.out.println("Rensar " + pieces[i].toString() + ".");
					}
					if (j == 3)
					{
						pieces[i].moveOut();
						System.out.println("Tar bort " + pieces[i].toString() + " från schackbrädet.");
					}

					System.out.println(chessBoard);

					try
					{
						Thread.sleep(1500);
					}
					catch (InterruptedException paus)
					{
						Thread.currentThread().interrupt();
					}
				}
			}

			catch (NotValidFieldException fel) 
			{
				System.out.println(fel.getMessage());
			}

		}

	}
}
