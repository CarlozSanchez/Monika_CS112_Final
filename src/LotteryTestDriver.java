



public class LotteryTestDriver
{
	public static void main(String[] args)
	{
		//test1();
		//test2();
		test3();
	}
	
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
	
	private static void test2()
	{
		DataBase database = new DataBase();
		
		System.out.println("The DataBase: " + database);
		
		//LotteryCollection lt = new LottoTicket();
		LotteryCollection lc = new LotteryCollection();
		
		LottoTicket lottoTicket = database.add(lc);
		
		System.out.println(database);
	}
	
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

		
		System.out.println(database);;

	}
}
