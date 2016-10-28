package mainPkg;

import java.io.IOException;


public class Main {
	
	public static void main(String[] args){
		UnitTest ut = new UnitTest();
		System.out.println(ut.testMain());
		
		TicTacToe game = new TicTacToe();
		try {
			game.multiPlayerPlay();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
