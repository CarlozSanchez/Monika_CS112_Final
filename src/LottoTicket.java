
import java.util.Date;

public class LottoTicket extends LotteryCollection
{
	private int uniqueID;
	private Date date;
	
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
	public void setUniqueID(int num)
	{
		this.uniqueID = num;
	}
	
	public void setDate(Date date)
	{
		this.date = date;
	}
	
	//accessors
	public int getUniqueID()
	{
		return uniqueID;
	}
	
	public Date getDate()
	{
		return date;
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
			return (uniqueID == otherObject.getUniqueID());
		}
	}
	
	public String toString()
	{
		String temp = "";
		temp += String.format("%-20s%d", "ID:", getUniqueID());
		temp += date;
		return temp;
	}
	
}
