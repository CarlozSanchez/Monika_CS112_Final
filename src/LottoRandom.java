

import java.util.Random;
import java.util.ArrayList;
//generates random numbers (integers)
public class LottoRandom
{
	
	//method that uses randomNumberSingleDigit method
	//and adds to an arrayList
	public static ArrayList<Integer> randomNumbers(int count)
	{
		ArrayList<Integer> arrNumbers = new ArrayList<Integer>(count);
		
		for (int i = 0; i < count; i++)
		{
			arrNumbers.add(randomNumberSingleDigit());
		}
		
		return arrNumbers;
	}
	
	//random number between 0-9
	public static int randomNumberSingleDigit()
	{
		Random r = new Random();
		int number = r.nextInt(10);
		return number;
	}
	
	//random numbers from 1-99
	public static int randomNumberOneThroughNinetyNine()
	{
		Random r = new Random();
		int number = 1+r.nextInt(99);
		return number;
	}
}
