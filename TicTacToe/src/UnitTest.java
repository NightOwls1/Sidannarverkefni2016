
public class UnitTest {
	public String testStr;
	public TicTacToe game;
	public void UnitTest()
	{
		testStr = "$"; 
		game = new TicTacToe();
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
	public boolean testTicTacToe(){
		game = new TicTacToe();
		return true;
	}
}
