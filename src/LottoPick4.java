////////////////////////////////////////////////////////////////////////////
//	Course: 			CS112	Tues/Thurs 1:30pm-3:20pm
//	Chapter:			Final Project
//	HomeWork:			Final Project - Simple Lottery System
//	Programmer:			Monika Shin
//	Date Modified:		12-13-18	
////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////
//	Program Title:		 LottoPick4
//	Program Description: Holds max of 4 numbers in arrayList... numbers stored
//						 are single digits
////////////////////////////////////////////////////////////////////////////


import java.util.ArrayList;

// Numbers 0-9 can be duplicated
// in array list... it can be 0000-9999
// each in array list is single digit... so 1, 1, 1, 1 is allowed
public class LottoPick4 extends LotteryPick
{
	private final int  MAX_NUMBER = 4;
	private final double COST = 1.0;
	private final String NAME_OF_GAME = "LottoPick4";
	
	public LottoPick4()
	{
		super();
		getNameOfGame();
		getCost();
	}

	// Accessors
	public double getCost()
	{
		return this.COST;
	}
	
	public String getNameOfGame()
	{
		return this.NAME_OF_GAME;
	}
	
	// Methods
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
	
	// Copying arraylist to another arrayList
	// example: using an arrayList of random Numbers and passing it here
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
	
	// Method to remove (all) number(s) in arrayList
	// Array List will be empty again
	public void clearSet()
	{
		numbers.clear();
	}
	
	// Using the class LottoRandom, use method random numbers method
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
			LottoPick4 otherLotto = (LottoPick4) other;
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
