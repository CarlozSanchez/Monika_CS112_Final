import java.util.ArrayList;
import java.util.Date;


public class LotteryPick implements Comparable, LottoInterface
{
	private String ticketNumber;
	private int retailerAccountNumber;
	private Date date;
	private ArrayList<Integer> numbers;
	private String nameOfGame;

	//default constructor
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
	
	//partial constructor....
	public LotteryPick(String ticketNum, int retailAcc, String name)
	{
		this.ticketNumber = ticketNum;
		this.retailerAccountNumber = retailAcc;
		date = new Date();
		numbers = new ArrayList<Integer>();
		this.nameOfGame = name;

	}
	
	//copy constructor
	public LotteryPick(LotteryPick originalObject)
	{
		if (originalObject == null)
		{
			System.out.println("Error: null object");
			System.exit(0);
		}
		this.ticketNumber = originalObject.getTicketNumber();
		this.retailerAccountNumber = originalObject.getRetailAccountNumber();
		this.nameOfGame = originalObject.getNameOfGame();
		date = new Date();
		numbers = new ArrayList<Integer>();
	}
	
	//----------------setters ------- mutators
	public void setTicketNumber(String number)
	{
		this.ticketNumber = number;
	}
	
	public void setRetailerNumber(int retailer)
	{
		this.retailerAccountNumber = retailer;
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
	
	public int getRetailAccountNumber()
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
	
	public int getSizeOfArray()
	{
		return numbers.size();
	}
	
	public ArrayList<Integer> getNumbers()
	{
		return numbers;
	}
	
	public int getNumbersLocation(int i) //get specific score in arrayList
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
					&& this.retailerAccountNumber == otherLottery.getRetailAccountNumber()
					&& this.numbers.equals(otherLottery.numbers)
					&& this.nameOfGame.equals(otherLottery.getNameOfGame());
		}
	}
	
	public String toString()
	{
		String temp = "";
		temp += getDate() + "\n";
		temp += String.format("%-20s%-20s\n", "Game Name:", getNameOfGame());
		temp += String.format("%-20s%-20d\n", "Retailer #:", getRetailAccountNumber());
		temp += String.format("%-20s%-20s\n", "Ticket Number:", getTicketNumber());
		temp += String.format("%s\n", numbers);
		temp += String.format("%-20s$%-20.2f\n", "Cost:", getCost());
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
