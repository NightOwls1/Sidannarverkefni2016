
public class ComputerPlayer {
	private boolean winner;
	private String symbol;
	private TicTacToe game;
	private Board board;
	private int[][] emptyTiles;
	public ComputerPlayer(TicTacToe g){
		game = g;
		symbol = "";
		if(game.getPlayers()[0].getSymbol().contains("X"))
			symbol = "O";
		else
			symbol = "X";
		winner = false;
		board = game.getBoard();
		emptyTiles = new int[3][3];
	}
	public String getSymbol() { return symbol; }
	public int[][] getEmptyTiles(){ return emptyTiles; }
	public void checkEmptyTiles(){
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				if(board.emptyTile(i, j))
					emptyTiles[i][j] = 1;
				else
					emptyTiles[i][j] = 0;
			}
		}
				
	}
	public int[][] oponentsTiles(){
		checkEmptyTiles();
		board = game.getBoard();
	//	board.showBoard();
		
		int[][] result = new int[3][3];
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				if(emptyTiles[i][j] == 0){
					if(board.getArray()[i][j].contains(game.getPlayers()[0].getSymbol()))
						result[i][j] = 1;
					else
						result[i][j] = 0;
				}
			}
		}
		return result;
	}
	public int[] isAboutToWin(){
		int [] result = new int[2];
		result[0] = 3;
		result[1] = 3;

		int[][] oponent = oponentsTiles();
		for(int i=0;i<3;i++){
			for(int j = 0; j<3; j++){
				if(emptyTiles[i][j] == 0){
					result[0] = i;
					result[1] = j;
					break;
				}
			}
		}

		int count = 0;
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				if(oponent[i][j] == 1){
					switch(i){
						case 0:
							if(oponent[i+1][j] == 1)
								result[0] = 2;
							break;
						case 1:
							if(oponent[i+1][j] == 1)
								result[0] = 0;
							break;
						case 2:
							if(oponent[i-1][j] == 1)
								result[0] = 0;
							break;
							
					}

					switch(j){
					case 0:
						if(oponent[i][j+1] == 1)
							result[1] = 2;
						break;
					case 1:
						if(oponent[i][j+1] == 1)
							result[1] = 0;
						break;
					case 2:
						if(oponent[i][j-1] == 1)
							result[1] = 0;
						break;
						
					}
				}
			}
			
		}
		return result;
	}
	public void makeMove(){
		int[] sq = isAboutToWin();
		Integer m = Integer.valueOf((sq[0]+1)*10 + sq[1]);
		game.getBoard().makeMove(m, symbol);
		
	}
}
