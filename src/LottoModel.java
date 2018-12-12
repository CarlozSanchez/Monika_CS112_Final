
public class LottoModel
{
	private DataBase database;
	private LotteryPick currentPick;
	private LotteryPick[] winningPicks;
	private String currentMenu;
	
	public LottoModel()
	{
		this.database = new DataBase();
		this.currentPick = null;
		this.winningPicks = initializeWinningPicks();
		this.currentMenu = "MainMenu";
		
	}
	
	private LotteryPick[] initializeWinningPicks()
	{
		LotteryPick[] arr = new LotteryPick[3];
		
		return arr;
	}

	public String getWinningPicks()
	{
		String temp;
		
		temp = String.format("Pick 1 Winners: %s", winningPicks[0].getNumbers());
		temp = String.format("Pick 3 Winners: %s", winningPicks[1].getNumbers());
		temp = String.format("Pick 4 Winners: %s", winningPicks[2].getNumbers());
		
		return temp;
	}
	
	public String mainMenu()
	{
		String temp;
		
		temp = "";
		
		return temp;
	}
	
	public String proccess()
	{
		String result = "";
		
		return result;
	}
}
