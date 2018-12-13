////////////////////////////////////////////////////////////////////////////
//	Course: 			CS112	Tues/Thurs 1:30pm-3:20pm
//	Chapter:			Final Project
//	HomeWork:			Final Project - Simple Lottery System
//	Programmer:			Monika Shin
//	Date Modified:		12-13-18	
////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////
//	Program Title:		 DataBase
//	Program Description: store LottoTicket into LinkedList...create/open/load
//						 binary file...LotteryCollection -> LottoTicket -> LinkedList
//						 and append LottoTicket to binary file
////////////////////////////////////////////////////////////////////////////


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

	// Default Constructor
	public DataBase()
	{
		database = new LinkedList<LottoTicket>();

		openFile();
		loadDataBase();
	}

	// Opens the data base file to read in data
	private void openFile()
	{
		try // to read in data base to linkedList
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

	// Read the data from data file and loads it into linkedList
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
		
		if (lc.getCollection().size() != 0)
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
			entry.setNameOfGame(determineName(lc));
			database.add(entry);
			writeToDatabase(entry);	//append to binary file
			return entry;
		}

		return null;
	}
	
	private String determineName(LotteryCollection lt)
	{
		//LotteryPick pick = lt.getCollection().get(0);
/*		if (pick.getClass().getName().equals("LottoPick1"))
		{
			return "Lotto Pick 1";
		}
		else if (pick.getClass().getName().equals("LottoPick3"))
		{
			return "Lotto Pick 3";
		}*/
	
		return lt.getCollection().get(0).getClass().getName();
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
		winners = new ArrayList<LottoTicket>();
		for (LottoTicket lt : database)
		{
			// <LotteryPick> lpArrayList = lt.getCollection();
			for (LotteryPick lp : lt.getCollection())
			{
				if (lp.equals(winningNumbers))
				{
					winners.add(lt);
				}
			}
		}

		return winners;
	}

	public String toString()
	{
		//return database.toString();
		String temp = "";
		for(LottoTicket lt : database)
		{
			temp += String.format("ID: %-3d %-20s Date: %s\n", lt.getID(), lt.getNameOfGame(), lt.getDate());
			for(LotteryPick lp : lt.getCollection())
			{
				temp += "\t" + lp.getNumbers() + "\n";
			}
			temp += "\n";
		}
		
		return temp;
	}

}
