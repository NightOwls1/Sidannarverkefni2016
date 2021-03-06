package tests;
import mainPkg.*;

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
/* ###################### BOARD INITIATION #################*/
		if(testMakeBoard())
			result += "Make Board Successfull! :) \n";
		else 
			result += " :( Make Board Failed \n";
/* ###################### MAKING MOVE #################*/		
		if(testMakeMove())
			result += "Make Move On Board Successfull! :) \n";
		else 
			result += " :( Make Move On Board Failed \n";
/* ###################### BOARD FULL #################*/		
		if(testBoardFull())
			result += "Board full Successfull! :) \n";
		else 
			result += " :( board full Failed \n";
/* ###################### HORIZONTAL CHECK #################*/		
		if(testHorizontalCheck())
			result += "Horizontal check Successfull! :) \n";
		else
			result += ":( horizontal check failed \n";
/* ###################### VERTIVAL CHECK #################*/
		if(testVerticalCheck())
			result += "Vertical check Successfull! :) \n";
		else
			result += ":( vertical check failed \n";
/* ###################### DIAGONAL CHECK #################*/
		if(testVerticalCheck())
			result += "Diagonal check Successfull! :) \n";
		else
			result += ":( diagonal check failed \n";
/* ###################### TILE CHECK #################*/
		if(testCheckTile())
			result += "Tile check Successfull! :) \n";
		else
			result += ":( tile check failed \n";
/* ###################### UPDATED MAKE MOVE #################*/
		if(testUpdatedMakeMove())
			result += "Make move Successfull! :) \n";
		else
			result += ":( make move failed \n";
/* ###################### UPDATED MAKE MOVE #################*/
		if(testPlayerMove())
			result += "Player move Successfull! \n";		
		else
			result += ":( player move failed \n";
		
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
		game  = new TicTacToe();
		
		
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
		game = new TicTacToe();
		testMakeMove();
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
	public boolean testHorizontalCheck(){
		game = new TicTacToe();
		game.setPlayers("X");
		boolean flag1 = true;
		boolean flag2 = true;
		game.getBoard().makeMove(Integer.valueOf(10), "X");
		game.getBoard().makeMove(Integer.valueOf(11), "O");
		game.getBoard().makeMove(Integer.valueOf(21), "X");
		game.getBoard().makeMove(Integer.valueOf(12), "O");
		if(game.getBoard().horizontal())
			flag1 = false;
		game.getBoard().makeMove(Integer.valueOf(31), "O");	
		game.getBoard().makeMove(Integer.valueOf(30), "O");
		game.getBoard().makeMove(Integer.valueOf(32), "O");
		if(!game.getBoard().horizontal())
			flag2 = false;

		return flag1 && flag2;
	}
	public boolean testVerticalCheck(){
		game = new TicTacToe();
		game.setPlayers("X");
		boolean flag1 = true;
		boolean flag2 = true;
		game.getBoard().makeMove(Integer.valueOf(10), "X");
		game.getBoard().makeMove(Integer.valueOf(11), "O");
		game.getBoard().makeMove(Integer.valueOf(21), "X");
		game.getBoard().makeMove(Integer.valueOf(12), "O");
		if(game.getBoard().vertical())
			flag1 = false;
		game.getBoard().makeMove(Integer.valueOf(31), "X");
		game.getBoard().makeMove(Integer.valueOf(22), "O");
		game.getBoard().makeMove(Integer.valueOf(30), "X");
		game.getBoard().makeMove(Integer.valueOf(32), "O");
		if(!game.getBoard().vertical())
			flag2 = false;

		return flag1 && flag2;
	}
	public boolean testDiagonalCheck(){
		game = new TicTacToe();
		game.setPlayers("X");
		boolean flag1 = true;
		boolean flag2 = true;
		game.getBoard().makeMove(Integer.valueOf(10), "X");
		game.getBoard().makeMove(Integer.valueOf(11), "O");
		game.getBoard().makeMove(Integer.valueOf(21), "X");
		game.getBoard().makeMove(Integer.valueOf(12), "O");
		if(game.getBoard().diagonal())
			flag1 = false;
		game.getBoard().makeMove(Integer.valueOf(32), "X");	
		if(!game.getBoard().diagonal())
			flag2 = false;

		return flag1 && flag2;

	}
	public boolean testCheckTile(){
		boolean flag1 = true;
		boolean flag2 = true;
		boolean flag3 = true;
		game = new TicTacToe();
		game.getBoard().makeMove(Integer.valueOf(10), "X");
		if(game.getBoard().emptyTile(0,0))
			flag1 = false;
		game.getBoard().makeMove(Integer.valueOf(11), "O");
		if(game.getBoard().emptyTile(0,1))
			flag2 = false;

		game.getBoard().makeMove(Integer.valueOf(12), "X");
		if(!game.getBoard().emptyTile(1,1))
			flag3 = false;
/*
*		System.err.println(flag1);
*		System.err.println(flag2);
*		System.err.println(flag3);
*/
		return flag1 && flag2 && flag3;
	}
	public boolean testUpdatedMakeMove(){
		game = new TicTacToe();

		String temp = "";
		boolean flag1 = true;
		boolean flag2 = true;
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

		temp += game.getBoard().makeMove(move[0], "O");

		temp += game.getBoard().makeMove(move[1], "X");

		if(temp.contains("Illegal move"))
			flag1 = false;
		
		temp += game.getBoard().makeMove(move[2], "O");
		
		temp += game.getBoard().makeMove(move[2], "X");
		
		temp += game.getBoard().makeMove(move[4], "O");
		
		if(!temp.contains("Illegal move"))
			flag2 = false;
		
		//System.out.println(temp);	
		return flag1 && flag2;
	
	}
	public boolean testPlayerMove(){
		boolean flag = true;
		game = new TicTacToe();
		String[][] desired = new String[3][3];
		game.setPlayers("X");
		game.getPlayers()[0].makeMove(Integer.valueOf(10));
		game.getPlayers()[1].makeMove(Integer.valueOf(10));
		game.getPlayers()[1].makeMove(Integer.valueOf(12));
		game.getPlayers()[0].makeMove(Integer.valueOf(21));
		game.getPlayers()[1].makeMove(Integer.valueOf(22));
		game.getPlayers()[0].makeMove(Integer.valueOf(31));
		
		desired[0][0] = "X";
		desired[0][1] = "11";
		desired[0][2] = "O";
		desired[1][0] = "20";
		desired[1][1] = "X";
		desired[1][2] = "O";
		desired[2][0] = "30";
		desired[2][1] = "X";
		desired[2][2] = "32";
		for(int i = 0; i<3; i++){
			for(int j=0; j<3; j++){
				if(!game.getBoard().getArray()[i][j].contains(desired[i][j]))
					flag = false;
				
			}
		}
				
				
		return flag;
	}
}
