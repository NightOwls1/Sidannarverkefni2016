
public class UnitTest {
	public String testStr;
	public TicTacToe game;
	public Board testBoard;
	
	public UnitTest()
	{
		testStr = "$"; 
		game = new TicTacToe();
		testBoard = game.getBoard();
		
		
	}
	public String testMain(){
		String result = "";
		if(testMakeBoard())
			result += "Make Board Successfull! :) \n";
		else 
			result += " :( Make Board Failed \n";
		
		if(testMakeMove())
			result += "Make Move On Board Successfull! :) \n";
		else 
			result += " :( Make Move On Board Failed \n";
		
		if(testBoardFull())
			result += "Board full Successfull! :) \n";
		else 
			result += " :( board full Failed \n";
		
		return result;
	}
	public String generateTestSet(String testCase)
	{
		testStr.concat(testCase);
		return testStr;
	}
	public String test()
	{
		//game.play();
		
		//game.makeMove(31);
		//game.showBoard();
		return "test successful";
	}
	public boolean testMakeBoard(){
		String[][] desiredBoard = new String[3][3];
		boolean flag = true;
		desiredBoard[0][0] = "10";
		desiredBoard[0][1] = "11";
		desiredBoard[0][2] = "12";
		desiredBoard[1][0] = "20";
		desiredBoard[1][1] = "21";
		desiredBoard[1][2] = "22";
		desiredBoard[2][0] = "30";
		desiredBoard[2][1] = "31";
		desiredBoard[2][2] = "32";
		for(int i =0; i<3; i++){
			for(int j=0; j<3; j++){
				//System.out.println(testBoard[i][j] + "test is desired "+ desiredBoard[i][j]);
				if(!testBoard.getArray()[i][j].equals(desiredBoard[i][j])){
					flag = false;
				}
			}
		}

		return flag;
				
	}
	public boolean testMakeMove(){
		boolean flag = true;
		Integer[] move = new Integer[9];
		
		move[0] = Integer.valueOf(10);
		move[1] = Integer.valueOf(11);
		move[2] = Integer.valueOf(12);
		move[3] = Integer.valueOf(20);
		move[4] = Integer.valueOf(21);
		move[5] = Integer.valueOf(22);
		move[6] = Integer.valueOf(30);
		move[7] = Integer.valueOf(31);
		move[8] = Integer.valueOf(32);

		game.getBoard().makeMove(move[0], "O");
		if(!game.getBoard().getArray()[0][0].contains("O"))
			flag = false;

		game.getBoard().makeMove(move[1], "X");
		if(!game.getBoard().getArray()[0][0].contains("O"))
			flag = false;

		game.getBoard().makeMove(move[2], "O");
		if(!game.getBoard().getArray()[0][0].contains("O"))
			flag = false;
		
		game.getBoard().makeMove(move[3], "X");
		if(!game.getBoard().getArray()[0][0].contains("O"))
			flag = false;
		
		game.getBoard().makeMove(move[4], "O");
		if(!game.getBoard().getArray()[0][0].contains("O"))
			flag = false;
		
		game.getBoard().makeMove(move[5], "X");
		if(!game.getBoard().getArray()[0][0].contains("O"))
			flag = false;
		
		game.getBoard().makeMove(move[6], "O");
		if(!game.getBoard().getArray()[0][0].contains("O"))
			flag = false;
		
		game.getBoard().makeMove(move[7], "X");
		if(!game.getBoard().getArray()[0][0].contains("O"))
			flag = false;
		
		game.getBoard().makeMove(move[8], "O");
		if(!game.getBoard().getArray()[0][0].contains("O"))
			flag = false;
		
				
		return flag;
	}
	public boolean testBoardFull(){
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		game.getBoard().showBoard();
		if(game.getBoard().boardFull())
			flag1 = true;
		game = new TicTacToe();
		if(!game.getBoard().boardFull())
			flag2 = true;
		
		Integer m = Integer.valueOf(21);
		game.getBoard().makeMove(m, "X");
		m = Integer.valueOf(22);
		game.getBoard().makeMove(m, "O");
		m = Integer.valueOf(10);
		game.getBoard().makeMove(m, "X");

		if(!game.getBoard().boardFull())
			flag3 = true;
		
		return flag1 && flag2 && flag3;
	}
}
