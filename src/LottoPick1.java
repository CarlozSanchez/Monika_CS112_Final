import java.util.ArrayList;
//singular pick number
// 1-99
public class LottoPick1 extends LotteryPick
{
	private final int  MAX_NUMBER = 1;
	private final double COST = 1.0;
	private final String NAME_OF_GAME = "LottoPick1";
	
	public LottoPick1()
	{
		super();
		getNameOfGame();
		getCost();
	}
	
	//accessors
	public double getCost()
	{
		return this.COST;
	}
	
	public String getNameOfGame()
	{
		return this.NAME_OF_GAME;
	}
	
	//methods
	@Override
	public void addNumber(int num)
	{
		if (getSizeOfArray() == MAX_NUMBER)
		{
			System.out.println("Cannot add another Number here");
		}
		else
		{
			numbers.add(num);
		}	
	}
	
	//copying arraylist to another arrayList
	//example: using an arrayList of random Numbers and passing it here
	public boolean addSetOfNumbers(ArrayList<Integer> arr) throws Exception
	{
		if(arr.size() == MAX_NUMBER)
		{
			numbers = new ArrayList(arr);
			return true;
		}
		else
		{
			System.out.println("incorrect size of array");
			throw new Exception();			
		}
	}
	
	//using the class LottoRandom, use method random numbers method
	// to generate single digit random (0-9)
	public void generateNumbers()
	{	
		numbers = LottoRandom.randomNumbers(MAX_NUMBER);
	}

	public boolean equals(Object other)
	{
		if (other == null)
		{
			return false;
		}
		else if (getClass() != other.getClass())
		{
			return false;
		}
		else
		{
			LottoPick3 otherLotto = (LottoPick3) other;
			return super.equals(otherLotto);			
		}
	}
	
	public String toString()
	{
		String temp = "";
		temp += String.format("%-20s\n", getNameOfGame());  //name of the game
		temp += String.format("%s\n", numbers);
		temp += String.format("%-20s$%-20.2f\n", "Cost: ", getCost());
		
		return temp;
	}

}
