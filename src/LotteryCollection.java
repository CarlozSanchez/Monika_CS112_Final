
import java.io.Serializable;
import java.util.ArrayList;

// each game type will be seperated into different tickets
// 
public class LotteryCollection implements Serializable
{
	private ArrayList <LotteryPick> collectionOfPick;
	//private ArrayList <T> collectionOfPick;
	private double totalCost;
	
	// Default constructor
	public LotteryCollection()
	{
		collectionOfPick = new ArrayList<LotteryPick>();
		//collectionOfPick = new ArrayList<T>();
		totalCost = 0.00;
	}
	
	public LotteryCollection(LotteryCollection col)
	{
		this.collectionOfPick = new ArrayList<LotteryPick>(col.getCollection());
		
	}
	
	// Accessors - getters	
	
	public ArrayList<LotteryPick> getCollection()
	{
		return collectionOfPick;
	}
	
	public String getTotalCost()
	{
		calculateCost();
		return String.format("Cost: $ %.2f", this.totalCost);
	}
	
	// mistake...don't use this
	/*
	public void addToCollection(ArrayList<LotteryPick> a)
	{
		collectionOfPick.addAll(a);
	}
	*/
	
	public double calculateCost()
	{
		for (int i = 0; i < collectionOfPick.size(); i++)
		{
			totalCost += collectionOfPick.get(i).getCost();
		}
		return totalCost;
	}
	
	// Do later - validate to make sure a collection is of type pick 1 only,
	//	pick 3 only, or pick 4 only... not mix and match...
	public void addToCollection(LotteryPick a)
	{
		collectionOfPick.add(a);
	}

	public boolean equals(Object other)
	{
		if (other == null)
		{
			return false;
		}
		else if (this.getClass() != other.getClass())
		{
			return false;
		}
		else
		{
			LotteryCollection otherObject = (LotteryCollection) other;
			return this.collectionOfPick.equals(otherObject.collectionOfPick);
		}
	}
	
	public String toString()
	{
		String temp = "";
		// Getting just the numbers of the lottery pick without the cost
		for(int i = 0; i < collectionOfPick.size(); i++)
		{
			temp += String.format("%s\n", getCollection().get(i).getNumbers());
		}
		
		temp += String.format("%-20s$%-20.2f\n", "Total Cost: ", calculateCost());
		return temp;
	}
}
