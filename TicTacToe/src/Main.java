import java.io.IOException;


public class Main {
	public static void main(String[] args){
		TicTacToe game = new TicTacToe();
		try{
		try{
			game.play();	
		}catch(InterruptedException e){
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
		}}catch(IOException e1){
			System.err.println(e1.getMessage());
			System.err.println(e1.getStackTrace());
		}
	}
}
