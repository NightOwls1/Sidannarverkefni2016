
public class Board {
	private String[][] board;
	private TicTacToe game;
	private boolean[][] seen;
	
	public Board(TicTacToe g)
	{		
		game = g;
		board = new String[3][3];
		int sq = 48;
		seen = new boolean[3][3];

		for(int i=0;i<3;i++){

			for(int j=0;j<3;j++){
				sq = (i+1)*10 + j;
				board[i][j] = String.valueOf(sq);
				seen[i][j] = false;
			}
		}
	}
	public String[][] getArray() { return board; }
	public void showBoard()
	{
		System.out.println("--------");
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++)
				System.out.print(board[i][j] + " ");
			System.out.println();
		}
		
	}
	public void makeMove(Integer dig1, String pl)
	{
		int dig = dig1.intValue();
		//System.out.println("digit = " + dig);
		int i = dig/10 -1;
		int j = dig%10;
		//System.out.println("i = " + i);
		//System.out.println("j = " + j);
		board[i][j] = pl;
		seen[i][j] = true;
				
	}
	public boolean boardFull(){
		for(int i=0;i<3;i++){
			for(int j=0; j<3; j++){
				if(!seen[i][j])
					return false;
			}
		}
		return true;
	}
	public boolean horizontal(){
		for(int i=0;i<3;i++){
			if(board[i][0]==board[i][1]
					&& board[i][1]==board[i][2]){
				if(game.getPlayers()[0].getSymbol() == board[i][1])
					game.getPlayers()[0].asWinner();
				else if(game.getPlayers()[1].getSymbol() == board[i][1])
					game.getPlayers()[1].asWinner();

				return true;
				}
		}
		return false;
	}
	public boolean vertical(){
		for(int j=0;j<3;j++){
			if(board[0][j]==board[1][j]
				&& board[1][j]==board[2][j]){
				if(game.getPlayers()[0].getSymbol() == board[2][j])
					game.getPlayers()[0].asWinner();
				else if(game.getPlayers()[1].getSymbol() == board[2][j])
					game.getPlayers()[1].asWinner();
				
				return true;
				}
		}
		return false;
	}
	public boolean diagonal(){
		if(
				(board[1][1] == board[0][0] && board[0][0] == board[2][2]) ||
				(board[1][1] == board[0][2] && board[0][2] == board[2][2])){
			
			if(board[1][1] == game.getPlayers()[0].getSymbol())
				game.getPlayers()[0].asWinner();
			else
				game.getPlayers()[1].asWinner();
				
			return true;
		}
		return false;
	}
	
	public boolean emptyTile(int i, int j){
		if(board[i][j].contains("X") || board[i][j].contains("O"))
			return false;
		return true;
	}



}
