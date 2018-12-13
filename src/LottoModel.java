
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
		number = -1;
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
		temp = "---QuickPickMenuOption---\n\n";
		temp += "A) Pick 1\n\n";
		temp += "B) Pick 3\n\n";
		temp += "C) Pick 4\n\n";
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
	// Pick 1, Pick 3, Pick 4 options
	public String lottoPickSelectionMenu()
	{
		String temp = "";
		temp += "pick" + number + "game";
		
		return temp;
	}
	
	//-----Pick_#_Menu-----------------------------
	public String pickNumberMenu()
	{
		String temp = "";
		temp += "---Pick"+number+"Menu---\n\n";
		temp += "A) Add Random Pick\n\n";
		temp += "B) Remove All added picks\n\n";
		temp += "C) Submit QuickPick\n\n";
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
		String message = "";
		//int num = 0;	//used for Pick_#_Menu
		
		if (selection.equals("Go Back"))
		{
			currentMenu = "MainMenu";
			number = 0;
			temp = mainMenu();
			tempLottoCollection = new LotteryCollection();
			return temp;
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
			}
			else if (selection.equals("B"))
			{
				number = 3;
			}
			else if (selection.equals("C"))
			{
				number = 4;		
			}

			temp = pickNumberMenu();
			currentMenu = "PickNumberMenu";
			return temp;	
		
		case "PickNumberMenu":
			//-----Pick 1 -> add random pick------random 1-99--------------
			if (number == 1 && selection.equals("A"))
			{	//add random pick option
				LottoPick1 pick = new LottoPick1();
				
				try
				{
					pick.addSetOfNumbers(LottoRandom.randomNumberPickOneAndNinetyNine(1));
					tempLottoCollection.addToCollection(pick);
					//message = "Adding Quick Pick";
					message = tempLottoCollection.toString();
				}
				catch (Exception e)
				{
					System.out.println("Unable to add Numbers");
				}
				
			}			
			
			//------Pick 3 -> Add random pick-----single digit random-----------------
			else if (number == 3 && selection.equals("A"))
			{	//add random pick option
				LottoPick3 pick = new LottoPick3();
				
				try
				{
					pick.addSetOfNumbers(LottoRandom.randomNumbers(3));
					tempLottoCollection.addToCollection(pick);
					//message = "Adding Quick Pick";
					message = tempLottoCollection.toString();
				}
				catch (Exception e)
				{
					System.out.println("Unable to add Numbers");
				}
				
			}
			
			//-------Pick 4 -> Add random pick--------single digit random--------------
			else if (number == 4 && selection.equals("A"))
			{	//add random pick option
				LottoPick4 pick = new LottoPick4();
				
				try
				{
					pick.addSetOfNumbers(LottoRandom.randomNumbers(4));
					tempLottoCollection.addToCollection(pick);
					//message = "Adding Quick Pick";
					message = tempLottoCollection.toString();
				}
				catch (Exception e)
				{
					System.out.println("Unable to add Numbers");
				}				
			}
			
			//-------Clear ALL selection----------------------------
			else if (selection.equals("B"))
			{
				//remove all added pick option
				tempLottoCollection = new LotteryCollection();
				message = "Clearing all added Picks";
			}
			//--------Submit Quick Pick and Print----------------------
			else if (selection.equals("C"))	//submit quick pick
			{
				
				LottoTicket lt = database.add(tempLottoCollection);
				Printer.printTicket(lt);
				//String message = "";
				message += "Printing ticket ID# " + lt.getID() + "\n";
				message += lt.toString();
				message += "\n\n\n \"Press GO BACK Button\"";
				message += "\n  to go to MainMenu"; 
				System.out.println("Debugger tester" + lt);
				System.out.println("Price of LT: " + lt.getTotalCost());
				return message;
			}
			temp = pickNumberMenu();
			return temp + "\n" + message;
			
		}
			
		return result;
	}
	
	
	
}
