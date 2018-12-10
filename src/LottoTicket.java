
import java.util.Date;



public class LottoTicket extends LotteryCollection
{
	private int uniqueID;
	private Date date;
	private String nameOfGame;
	
	public LottoTicket()
	{
		super();
		uniqueID = 0;
		date = new Date();
	}
	
	public LottoTicket(LotteryCollection col)
	{
		super(col);
		uniqueID = 0;
		date = new Date();
	}
	
	public LottoTicket(LotteryCollection col, int id)
	{
		super(col);
		uniqueID = id;
		date = new Date();
	}
	
	//mutators - setters
	public void setID(int num)
	{
		this.uniqueID = num;
	}
	
	public void setDate(Date date)
	{
		this.date = date;
	} 
	
	public void setNameOfGame(String name)
	{
		this.nameOfGame = name;
	}
	
	//accessors
	public int getID()
	{
		return uniqueID;
	}
	
	public Date getDate()
	{
		return date;
	}
	
	public String getNameOfGame()
	{
		return this.nameOfGame;
	}
	
	//comparing unique ID
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
			LottoTicket otherObject = (LottoTicket) other;
			return (uniqueID == otherObject.getID());
		}
	}
	
	public String toString()
	{

		String temp = "";
		temp += String.format("%-5s%-5d%-20s", "ID:", getID(), getNameOfGame());
		temp += date + "\n";
		temp += super.toString();
		return temp;
	}
	
}
