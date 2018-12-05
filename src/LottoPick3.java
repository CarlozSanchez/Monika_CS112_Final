

public class LottoPick3 extends LotteryPick
{
	private final int  MAX_NUMBER = 3;
	private final double COST = 1.0;
	
	public LottoPick3()
	{
		super("---000---", 0, "Lottery Pick Three");
		getDate();
		getCost();
	}
	
	public double getCost()
	{
		return this.COST;
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
	// ---->		///return super.equals(otherLotto.super());
			return false;
		}
		
		
	}
}
