

import java.util.ArrayList;

abstract public class LotteryPick implements Comparable
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
	
	
	@Override
	//comparable interface
	public int compareTo(Object arg0)
	{
		// TODO Auto-generated method stub
		return 0;
	}
}
