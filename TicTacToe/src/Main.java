import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args){
		TicTacToe game = new TicTacToe();
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String move = "";
			System.out.println("Welcome to TicTacToe!");

			game.showBoard();
			System.out.println("Please choose if you want to be X or O");
			
			game.setPlayer1(br.readLine());
			game.showBoard();
			while(/*game.keepPlaying()*/true){
				//System.out.println("Where do you want to put your " + "X" + "?");
				move = br.readLine();
				//System.in.read();
				//System.out.println(move);
				game.makeMove(Integer.valueOf(move), " X");
				game.showBoard();
				//System.out.println(game.win());
				//System.out.println("Where do you want to put your " + "O" + "?");
				move = br.readLine();
				//System.out.println(move);
				game.makeMove(Integer.valueOf(move), " O");
				game.showBoard();
				System.out.println(game.win());

			}


		}catch(IOException e1){
			System.err.println(e1.getMessage());
			System.err.println(e1.getStackTrace());
		}
	}
}
