package mainPkg;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToe {
	private Board board;
	private Player player1;
	private Player player2;
	//private ComputerPlayer cPlayer;
	private Player[] players;
	
	public TicTacToe()
	{
		board = new Board(this);
		players = new Player[2];
	}
	public Board getBoard(){ return board; }
	public Player[] getPlayers(){ return players; }
	public boolean gameOver(){
		if(board.vertical() || board.horizontal() || board.diagonal())
			return true;
		if(board.boardFull())
			return true;
		return false;
	}
	public boolean keepPlaying(){
		//System.err.println(!gameOver() && !board.boardFull());
		return (!gameOver() && !board.boardFull());
	}
	public void setPlayers(String s){
		player1 = new Player(s, this);
		if(s.contains("X"))
			player2 = new Player("O", this);
		else
			player2 = new Player("X", this);
		
		players[0] = player1;
		players[1] = player2;

	}
	public void multiPlayerPlay() throws InterruptedException, IOException{
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String move = "";
			System.out.println("Welcome to TicTacToe!");

			board.showBoard();
			System.out.println("Please choose if you want to be X or O");
			String s = br.readLine();
			setPlayers(s);
			board.showBoard();
			while(keepPlaying()){
				System.out.println("Where do you want to put your " + player1.getSymbol() + "?");
				move = br.readLine();
				//System.in.read();
				//System.out.println(move);
				player1.makeMove(Integer.valueOf(move));
				System.out.println(player1.win());
				board.showBoard();
				if(keepPlaying()){
				
				
				System.out.println("Where do you want to put your " + player2.getSymbol() + "?");
				move = br.readLine();
				//System.out.println(move);
				player2.makeMove(Integer.valueOf(move));
				System.out.println(player1.win());
				}
				board.showBoard();

			}
			System.out.println();
			
		}catch(IOException e1){
			System.err.println(e1.getMessage());
			System.err.println(e1.getStackTrace());
		}

	}

}
