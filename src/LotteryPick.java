import java.util.ArrayList;
import java.util.Date;


public class LotteryPick
{
	private String ticketNumber;
	private int retailerAccountNumber;
	private Date date;
	private ArrayList<Integer> numbers;
	private String nameOfGame;

	
	public LotteryPick()
	{
		this.ticketNumber = "---000---";
		this.retailerAccountNumber = 0;
		date = new Date();
		//date.getDate();
		numbers = new ArrayList<Integer>();
		this.nameOfGame = "None";

		//System.out.println(date);
	}
	
	public LotteryPick(String ticketNum, int retailAcc, String name)
	{
		this.ticketNumber = ticketNum;
		this.retailerAccountNumber = retailAcc;
		date = new Date();
		numbers = new ArrayList<Integer>();
		this.nameOfGame = name;

	}
	
	//----------------setters ------- mutators
	public void setTicketNumber(String ticketNum)
	{
		this.ticketNumber = ticketNum;
	}
	
	public void setRetailerNumber(int retailerN)
	{
		this.retailerAccountNumber = retailerN;
	}
	
	public void setNameOfGame(String name)
	{
		this.nameOfGame = name;
	}
	
	//--------------getters -------- accessors
	public String getTicketNumber()
	{
		return this.ticketNumber;
	}
	
	public int getRetailerAccountNumber()
	{
		return this.retailerAccountNumber;
	}
	
	public String getNameOfGame()
	{
		return this.nameOfGame;
	}
	
	public double getCost()
	{
		return 0.0; //stub....maybe change to abstract later
	}
	
	public int getNumbers(int i) //get specific score in arrayList
	{
		if (i >=this.numbers.size()) 
		{
			System.out.println("out of bounds");
			return 0;
		}
		else
		{
			return this.numbers.get(i);
		}
	}
	
	public Date getDate()
	{
		return date;
	}
	
	//------ Methods ----------------------
	public void addNumber(int num)
	{
		numbers.add(num);
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
			LotteryPick otherLottery = (LotteryPick) other;
			return this.ticketNumber.equals(otherLottery.getTicketNumber())
					&& this.retailerAccountNumber == otherLottery.getRetailerAccountNumber()
					&& this.numbers.equals(otherLottery.numbers)
					&& this.nameOfGame.equals(otherLottery.getNameOfGame());
		}
	}
	
	public String toString()
	{
		String temp = "";
		temp += getDate() + "\n";
		temp += String.format("%-20s%-20s\n", "Game Name:", getNameOfGame());
		temp += String.format("%-20s%-20d\n", "Retailer #:", getRetailerAccountNumber());
		temp += String.format("%-20s%-20s\n", "Ticket Number:", getTicketNumber());
		temp += String.format("%s\n", numbers);
		temp += String.format("%-20s$%-20.2f\n", "Cost:", getCost());
		return temp;
	}
}
