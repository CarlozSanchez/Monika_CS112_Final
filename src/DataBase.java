
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;

public class DataBase
{
	private final String DATA_FILE = "database.dat";
	ObjectInputStream inputStream = null;
	private LinkedList<LottoTicket> database;

	// Constructor
	public DataBase()
	{
		database = new LinkedList<LottoTicket>();

		openFile();
		loadDataBase();
	}

	// Opens the data base file to read in data
	private void openFile()
	{
		try // to read in data base to Linked List
		{
			inputStream = new ObjectInputStream(new FileInputStream(DATA_FILE));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Unable to find database, Creating new database");
			try
			{
				ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(DATA_FILE));
				outStream.close();
				openFile();
			}
			catch (IOException d)
			{
				System.out.println("Unable to create file" + DATA_FILE);
			}

		}
		catch (IOException e)
		{
			System.out.println("IO Error while opening file " + DATA_FILE);
		}
	}

	// Read the data from data file and loads it into Linked List
	private void loadDataBase()
	{
		boolean endOfFile = false;

		try
		{
			while (!endOfFile)
			{
				try
				{
					LottoTicket lottoTicket = (LottoTicket) inputStream.readObject();
					database.add(lottoTicket);
				}
				catch (EOFException e)
				{
					endOfFile = true;
				}
			}

			inputStream.close();

		}
		catch (ClassNotFoundException e)
		{
			System.out.println("Unable to cast LottoTicket");

		}
		catch (IOException e)
		{
			System.out.println("IO error while loading " + DATA_FILE);
		}
	}

	// Adds a LotteryCollection to this database
	public LottoTicket add(LotteryCollection lc)
	{
		LottoTicket entry = new LottoTicket(lc);

		if (database.size() == 0)
		{
			entry.setID(0);
		}
		else
		{
			int uniqueID = database.getLast().getID() + 1;

			entry.setID(uniqueID);
		}

		database.add(entry);
		writeToDatabase(entry);

		return entry;
	}

	private void writeToDatabase(LottoTicket lt)
	{
		AppendObjectOutputStream outStream;

		try
		{
			outStream = new AppendObjectOutputStream(new FileOutputStream(DATA_FILE, true));
			outStream.writeObject(lt);
			outStream.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Unable to locate file " + DATA_FILE);
		}
		catch (IOException e)
		{
			System.out.println("IO error while writting to " + DATA_FILE);
		}

	}

	public LottoTicket getLastEntry()
	{
		return this.database.getLast();
	}

	// Checks if winning numbers match any lotto tickets in database
	// Return null if no winners are found
	// Otherwise the array list will contain the winning lotto ticket
	public ArrayList<LottoTicket> checkWinner(LotteryPick winningNumbers)
	{
		ArrayList<LottoTicket> winners = null;

		for (LotteryCollection lc : database)
		{
			// <LotteryPick> lpArrayList = lt.getCollection();
			for (LotteryPick lp : lc.getCollection())
			{
				if (lp.equals(winningNumbers))
				{
					winners.add((LottoTicket) lc);
				}
			}
		}

		return winners;
	}

	public String toString()
	{
		return database.toString();
	}

}
