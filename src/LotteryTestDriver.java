////////////////////////////////////////////////////////////////////////////
//	Course: 			CS112	Tues/Thurs 1:30pm-3:20pm
//	Chapter:			Final Project
//	HomeWork:			Final Project - Simple Lottery System
//	Programmer:			Monika Shin
//	Date Modified:		12-13-18	
////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////
//	Program Title:		 LotteryTestDriver
//	Program Description: main driver to test classes and run program
//						 
////////////////////////////////////////////////////////////////////////////

/////////////////////////
//	Actual Program	   //
/////////////////////////

public class LotteryTestDriver
{
	public static void main(String[] args)
	{
		//test1();
		//test2();
		//test3();	//lotto pick 3 adding to database
		//test4();	//lotto pick 4 adding to database and Printing txt file
		//checkWinnerTester();
		
		//Testing LottoGUI
		LottoGUI gui = new LottoGUI();
		gui.setVisible(true);
		
		
	}
	
	//testing LottoRandom methods and adding to collection
	private static void test1()
	{
		//LotteryPick a = new LotteryPick();
		//System.out.println(a);
			
		LottoPick3 b = new LottoPick3();
		LottoPick3 c = new LottoPick3();
		System.out.println(b.equals(c));
		b.addNumber(1);
		b.addNumber(2);
		b.addNumber(1);
		b.addNumber(9);	//should give message "Cannot add another number"
		
		c.generateNumbers();
		System.out.println("Printing b------");
		
		System.out.println(b);
		System.out.println("Printing c------");
		System.out.println(c);
		
		System.out.println("Random Number tester");
		LottoRandom r = new LottoRandom();
		System.out.println(r.randomNumberSingleDigit());
		System.out.println(r.randomNumberSingleDigit());
		
		System.out.println("Testing arrayList RandomNumbers....");
		System.out.println(r.randomNumbers(3));	//for 3 sets of numbers
		
		System.out.println("Testing double Digit random Number");
		System.out.println(r.randomNumberOneThroughNinetyNine());
		
		System.out.println("Testing LotteryCollection class");
		LotteryCollection col01 = new LotteryCollection();
		col01.addToCollection(b);
		col01.addToCollection(c);
		System.out.println(col01);	
	}
	
	//creating database and testing to see if lottery collection gets added
	//properly
	private static void test2()
	{
		DataBase database = new DataBase();
		
		System.out.println("The DataBase: " + database);
		
		//LotteryCollection lt = new LottoTicket();
		LotteryCollection lc = new LotteryCollection();
		
		LottoTicket lottoTicket = database.add(lc);
		
		System.out.println(database);
	}
	
	//creating lotto pick 3 random numbers and adding to database
	private static void test3()
	{
		DataBase database = new DataBase();
		
		LottoPick3 a3 = new LottoPick3();
		LottoPick3 b3 = new LottoPick3();
		
		try
		{
			a3.addSetOfNumbers(LottoRandom.randomNumbers(3));
			b3.addSetOfNumbers(LottoRandom.randomNumbers(3));

		}
		catch(Exception e)
		{
			System.out.println("Unable to add numbers");;
		}
		
		LotteryCollection lc = new LotteryCollection();
		lc.addToCollection(a3);
		lc.addToCollection(b3);
		
		LottoTicket lt = database.add(lc);
		//Printer.print(lt); //lottoticket_id.txt 
		//test winning ticket
		System.out.println(database);
	}
	
	//lotto pick 4 adding to database and Printing txt file
	private static void test4()
	{
		DataBase database = new DataBase();
		
		LottoPick4 a4 = new LottoPick4();
		LottoPick4 b4 = new LottoPick4();
		
		try
		{
			a4.addSetOfNumbers(LottoRandom.randomNumbers(4));
			b4.addSetOfNumbers(LottoRandom.randomNumbers(4));
		}
		catch(Exception e)
		{
			System.out.println("Unable to add numbers");
		}
		
		LotteryCollection lc = new LotteryCollection();
		lc.addToCollection(a4);
		lc.addToCollection(b4);
		
		LottoTicket lt = database.add(lc);
		
		//LottoTicket ticket = database.getLastEntry();
		Printer.printTicket(lt);
		System.out.println(database);
	}
	
	//testing database check winner method
	private static void checkWinnerTester()
	{
		DataBase database = new DataBase();
		LottoPick4 winningTester = new LottoPick4();
		winningTester.addNumber(7);
		winningTester.addNumber(6);
		winningTester.addNumber(6);
		winningTester.addNumber(1);
		System.out.println("Winning Numbers are: " + winningTester.getNumbers());
		System.out.println("Winning Ticket: \n" + database.checkWinner(winningTester));
		
		LottoPick3 nonWinnerTester = new LottoPick3();
		nonWinnerTester.addNumber(0);
		nonWinnerTester.addNumber(0);
		nonWinnerTester.addNumber(0);
		System.out.println("Winning Numbers are : " + nonWinnerTester.getNumbers());
		System.out.println("Winning Ticket: \n" + database.checkWinner(nonWinnerTester));
		
	}
}
