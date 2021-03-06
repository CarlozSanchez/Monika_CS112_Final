////////////////////////////////////////////////////////////////////////////
//	Course: 			CS112	Tues/Thurs 1:30pm-3:20pm
//	Chapter:			Final Project
//	HomeWork:			Final Project - Simple Lottery System
//	Programmer:			Monika Shin
//	Date Modified:		12-13-18	
////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////
//	Program Title:		 LotteryPick
//	Program Description: abstract class with methods that will be overriden
//						 with child classes
////////////////////////////////////////////////////////////////////////////


import java.io.Serializable;
import java.util.ArrayList;

abstract public class LotteryPick implements Serializable
{
	protected ArrayList<Integer> numbers;	//changed from private to protected

	//default constructor
	public LotteryPick()
	{
		numbers = new ArrayList<Integer>();
	}
		
	//copy constructor
	public LotteryPick(LotteryPick originalObject)
	{
		if (originalObject == null)
		{
			System.out.println("Error: null object");
			System.exit(0);
		}
		this.numbers = new ArrayList<Integer>(originalObject.getNumbers());
	}
	
	//----------------setters ------- mutators
	//no need for setters here
	//will be using add method to add numbers
	
	//--------------getters -------- accessors
	
	abstract public double getCost();
	
	public int getSizeOfArray()
	{
		return numbers.size();
	}
	
	public ArrayList<Integer> getNumbers()
	{
		return new ArrayList<Integer> (numbers);
	}
	
	public int getNumber(int index) //get specific score in arrayList
	{
		if (index >=this.numbers.size()) 
		{
			System.out.println("out of bounds");
			return 0;
		}
		else
		{
			return this.numbers.get(index);
		}
	}

	//------ Methods ----------------------
	abstract public void addNumber(int num);
	
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
			LotteryPick otherLottery = (LotteryPick) other;
			return this.numbers.equals(otherLottery.numbers);
		}
	}
	
	public String toString()
	{
		String temp = "";
		temp += String.format("%s\n", numbers);
		//temp += String.format("%-20s$%-20.2f\n", "Cost:", getCost());
		return temp;
	}
}
