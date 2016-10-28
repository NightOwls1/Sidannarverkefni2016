package mainPkg;

public class Player {
	private boolean winner;
	private String symbol;
	TicTacToe game;
	public Player(String s, TicTacToe g){
		winner = false;
		symbol = s;
		game = g;
	}
	public String getSymbol(){
		return symbol;
	}
	public void setPlayer(String p1){ 
		symbol = p1;
	}
	public void makeMove(Integer dig1)
	{
		game.getBoard().makeMove(dig1, symbol);
	}
	public void asWinner(){
		winner = true;
	}
	public String win(){
		if(!game.gameOver())
			return "Keep playing";
		else if(game.getBoard().boardFull())
			return "No one won :( ";
		if(game.getBoard().vertical() || game.getBoard().horizontal()
				|| game.getBoard().diagonal())
			return "The winner is player " + symbol + "!";
		return "Something unexpected has happened :/ ";
	}


}
