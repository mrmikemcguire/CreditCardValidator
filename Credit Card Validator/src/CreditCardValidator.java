import java.util.Scanner;
import java.util.ArrayList;

public class CreditCardValidator
	{
	static long cardNumber;
	static long [ ] rawNumbers = new long [16];
	static long [ ] numbersToAdd = new long [16];

	
	public static void main(String[] args)
		{
		acceptCCNumber();
		loadArray();
		//validateCCNumber();
		}
	
	public static long acceptCCNumber()
		{
		Scanner userInput = new Scanner(System.in);
		System.out.println("Please input the credit card number without spaces.");
		cardNumber = userInput.nextLong();
		System.out.println("Your credit card # is " + cardNumber);
		return cardNumber;
		}
	
	public static void loadArray()
		{
		for (int i = 0; i < 16; i++)
			{
			rawNumbers[i] = cardNumber % 10;
			cardNumber = cardNumber / 10;
			}
			
		for(long fred : rawNumbers)
			{
			System.out.println(fred);
			}
		}
	
	public static void validateCCNumber()
		{
		for (int i = 0; i < 16; i++)
			{
			if (i % 2 == 0)
				{
				numbersToAdd[i] = rawNumbers[i];
				}
			else
				{
				if (rawNumbers[i] * 2 < 10)
					{
					numbersToAdd[i] = rawNumbers[i] * 2;
					}
				else
					{
					addDigitsOfDoubledNumber();
					}
				}
			}
		}
	
	public static int addDigitsOfDoubledNumber()
		{
		
		return adjustedDoubledNumber;
		}
	
	}
