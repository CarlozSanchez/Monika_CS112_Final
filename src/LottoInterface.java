import java.util.Date;

interface LottoInterface
{
	public Date getDate();
	public String getTicketNumber();
	public int getRetailAccountNumber();
	
	public void setTicketNumber(String number);
	public void setRetailerNumber(int retailer);
}
