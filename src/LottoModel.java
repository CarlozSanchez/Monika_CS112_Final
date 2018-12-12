
// This class will be used for LottoGUI

public class LottoModel
{
	private DataBase database;
	private LotteryCollection tempLottoCollection;	
	private LotteryPick[] winningPicks;
	private String currentMenu;	//String of which menu you are at
	private int number;
	
	public LottoModel()
	{
		this.database = new DataBase();
		this.tempLottoCollection = new LotteryCollection();
		this.winningPicks = initializeWinningPicks();
		this.currentMenu = "MainMenu"; 
		number = 0;
	}
	
	// Purpose: used for displaying in GUI 
	// Pre-setting winning numbers for demo
	private LotteryPick[] initializeWinningPicks()
	{
		LotteryPick[] arr = new LotteryPick[3];
		//lotteryPick[0] = pick1 winning numbers
		LottoPick1 pick1Winner = new LottoPick1();
		pick1Winner.addNumber(50);
		arr[0] = pick1Winner;	//setting to index 0
		
		//lotteryPick[1] = pick3 winning numbers
		LottoPick3 pick3Winner = new LottoPick3();
		pick3Winner.addNumber(3);
		pick3Winner.addNumber(3);
		pick3Winner.addNumber(3);
		arr[1] = pick3Winner;
		
		//lotteryPick[2] = pick4 winning numbers	
		LottoPick4 pick4Winner = new LottoPick4();
		pick4Winner.addNumber(7);
		pick4Winner.addNumber(6);
		pick4Winner.addNumber(6);
		pick4Winner.addNumber(1);
		arr[2] = pick4Winner;
		
		return arr;
		
	}

	public String getWinningPicks()
	{
		String temp;
		
		temp = String.format("Pick 1 Winners: %s\n", winningPicks[0].getNumbers());
		temp = String.format("Pick 3 Winners: %s\n", winningPicks[1].getNumbers());
		temp = String.format("Pick 4 Winners: %s\n", winningPicks[2].getNumbers());
		
		return temp;
	}
	
	public String mainMenu()
	{
		String temp = "";		
		temp += "---MAIN MENU---\n";
		temp += "\n";
		temp += "A) Quick Pick\n\n";
		temp += "B) Check Winners\n\n";
		temp += "C) Database\n";
				
		return temp;
	}
	
	
	//-------------Main menu options--------------------------
	public String quickPickSelectionMenu()
	{	//fill later------
		String temp = "";
		temp = "quickpickmenuoption";
		return temp;
	}
	
	public String checkWinnersSelectionMenu()
	{	//fill later------
		String temp = "";
		temp = "checkwinnersleectionmenu";
		return temp;
	}
	
	public String databaseSelectionMenu()
	{	//stub
		String temp = "";
		temp = "databaseSelectionmenu";
		return temp;
	}
	
	
	//----QuickPickGameSelectionMenu----------------------
	public String lottoPickSelectionMenu(int num)
	{	//stub
		String temp = "";
		temp = "pick" + num + "game";
		
		return temp;
	}
	
	public String pickMenu(int num)
	{
		//stub
		String temp = "";
		return temp;
	}
	
	
	//------
	
	public String setUp()
	{
		return mainMenu();
	}
	
	public String process(String selection)
	{
		String result = "";
		String temp = "";
		//int num = 0;	//used for Pick_#_Menu
		
		if (selection.equals("Go Back"))
		{
			currentMenu = "MainMenu";
			number = 0;
			mainMenu();
			tempLottoCollection = new LotteryCollection();
		}
		
		switch(currentMenu)
		{
		case "MainMenu":
			if (selection.equals("A"))
			{			
				temp = quickPickSelectionMenu();
				currentMenu = "QuickPickGameSelectionMenu";				
				return temp;
			}
			else if (selection.equals("B"))
			{
				return checkWinnersSelectionMenu();
			}
			else if (selection.equals("C"))
			{
				return databaseSelectionMenu();
			}
			break;
			
		case "QuickPickGameSelectionMenu":
						
			if (selection.equals("A"))
			{
				number = 1;
				temp = lottoPickSelectionMenu(number);
				currentMenu = "Pick" + number + "Game";
				return temp;
			}
			else if (selection.equals("B"))
			{
				number = 3;
				temp = lottoPickSelectionMenu(number);
				currentMenu = "Pick" + number + "Game";
				return temp;
			}
			else if (selection.equals("C"))
			{
				number = 4;
				temp = lottoPickSelectionMenu(number);
				currentMenu = "Pick" + number + "Game";
				return temp;
			}
			break;
		
		
		}
		
		
		return result;
	}
	
	
	
}
