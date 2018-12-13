////////////////////////////////////////////////////////////////////////////
//	Course: 			CS112	Tues/Thurs 1:30pm-3:20pm
//	Chapter:			Final Project
//	HomeWork:			Final Project - Simple Lottery System
//	Programmer:			Monika Shin
//	Date Modified:		12-13-18	
////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////
//	Program Title:		 Printer
//	Program Description: Print LottoTicket for user (.txt file)
//						 
////////////////////////////////////////////////////////////////////////////

// Print Ticket for user

import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class Printer
{
	private static final String USER_TICKET = "lottoTicket_";
	//private PrintWriter outStream = null;
	
	public static void printTicket(LottoTicket lt)
	{
		PrintWriter outStream = null;
		System.out.println("Writing to file...");
		
		String temp = USER_TICKET + lt.getID() + ".txt";
		
		try
		{
			outStream = new PrintWriter(new FileOutputStream(temp));
			outStream.println("ID: " + lt.getID() + "  " + lt.getNameOfGame() + "  "+ lt.getDate());
			
			
			for (LotteryPick pick : lt.getCollection())
			{
				outStream.println(pick.getNumbers().toString());
			}
			outStream.println("Total Cost: " + lt.getTotalCost());
			outStream.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Unable to locate file " + temp);
		}
	}	
}
