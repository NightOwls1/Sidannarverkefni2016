import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToe {
	private String[][] board;
	public TicTacToe()
	{
		board = new String[3][3];
		
		int sq = 48;
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++){
				sq = (i+1)*10 + j;
				board[i][j] = String.valueOf(sq); 
						
			}
	}
	private String player;
	private String winner;
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
		System.out.println("digit = " + dig);
		int i = dig/10 -1;
		int j = dig%10;
		System.out.println("i = " + i);
		System.out.println("j = " + j);
		board[i][j] = pl;

				
	}
	public boolean boardFull(){
		for(int i=0;i<3;i++){
			for(int j=0; j<3; j++){
				if(!board[i][j].equals("X")
						|| !board[i][j].equals("O"))
					return false;
			}
		}
		return true;
	}
	public boolean horizontal(){
		for(int i=0;i<3;i++){
			if(board[i][0]==board[i][1]
					&& board[i][1]==board[i][2]){
				winner = board[i][1];
				return true;
				}
		}
		return false;
	}
	public boolean vertical(){
		for(int j=0;j<3;j++){
			if(board[0][j]==board[1][j]
				&& board[1][j]==board[2][j]){
				winner = board[2][j];
				return true;
				}
		}
		return false;
	}
	public boolean gameOver(){
		if(vertical() || horizontal())
			return true;
		if((board[1][1] == board[0][0] && board[0][0] == board[2][2])
				|| (board[1][1] == board[0][2] && board[0][2]==board[2][0]))
			return true;
			
		return false;
	}
	public String win(){
		if(!gameOver())
			return "Keep playing";
		else if(boardFull())
			return "No one won :( ";
		if(vertical() || horizontal())
			return "The winner is player " + winner + "!";
		if(board[1][1].contains("X"))
			return "The winner is player X!";
		if(board[1][1].contains("O"))
			return "The winner is player O!";
		return "Something unexpected has happened :/ ";
	}
	public void play() throws InterruptedException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String move = "";
		System.out.println("Welcome to TicTacToe!");
		showBoard();
		System.out.println("Please choose if you want to be X or O");
		
		player = br.readLine();
		System.out.println("You are player " + player);
		showBoard();
		while(!gameOver() && !boardFull()){
			System.out.println("Where do you want to put your " + "X" + "?");
			//br.wait();
			move = br.readLine();
			//System.in.read();
			System.out.println(move);
			makeMove(Integer.valueOf(move), " X");
			showBoard();
			System.out.println(win());
			System.out.println("Where do you want to put your " + "O" + "?");
			//br.wait();
			move = br.readLine();
			//System.in.read();
			System.out.println(move);
			makeMove(Integer.valueOf(move), " O");
			showBoard();
			System.out.println(win());

		}
	}

}
