import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CreditCardValidatorFromFile
	{
	static long cardNumber, tempCardNumber;
	static boolean validity;
	static long [ ] rawNumbers = new long [16];
	static long [ ] numbersToAdd = new long [16];
	static int validCCCounter = 0;
	
	public static void main(String[] args) throws IOException
		{
		Scanner file = new Scanner (new File ("CreditCardNumbers.txt"));	
		while(file.hasNext())
			{
			cardNumber = file.nextLong();
			loadArray();
			modifyCCNumber();
			validateCCNumber();
			displayResult();
			}
		
		System.out.println("\nThis list contains " + validCCCounter
				+ " potentially valid credit card numbers.");
		}
	
	public static void loadArray()
		{
		tempCardNumber = cardNumber;
		for (int i = 0; i < 16; i++)
			{
			rawNumbers[i] = tempCardNumber % 10;
			tempCardNumber = tempCardNumber / 10;
			}
		}
	
	public static void modifyCCNumber()
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
					long doubledNumber = rawNumbers[i] * 2;
					long onesDigit = doubledNumber % 10;
					long tensDigit = doubledNumber / 10;
					numbersToAdd[i] = (onesDigit + tensDigit);
					}
				}
			}
		}
	
	public static boolean validateCCNumber()
		{
		int total = 0;
		for (long wilma : numbersToAdd)
			{
			total += wilma;
			}
		
		if (total % 10 == 0)
			{
			validity = true;
			}
		return validity;
		}
	
	public static void displayResult()
		{
		System.out.print("The credit card number " + cardNumber + " is ");
		if (validity == true)
			{
			System.out.println("potentially valid.");
			validCCCounter++;
			}
		else
			{
			System.out.println("invalid.");
			}
		}		
	}
