import java.util.Scanner;

public class CreditCardValidator
	{
	static long cardNumber;
	static boolean validity;
	static int [ ] rawNumbers = new int [16];
	static int [ ] numbersToAdd = new int [16];
	
	public static void main(String[] args)
		{
		acceptCCNumber();
		loadArray();
		modifyCCNumber();
		validateCCNumber();
		displayResult();
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
					int doubledNumber = rawNumbers[i] * 2;
					int onesDigit = doubledNumber % 10;
					int tensDigit = doubledNumber / 10;
					numbersToAdd[i] = onesDigit + tensDigit;
					}
				}
			}
		}
	
	public static boolean validateCCNumber()
		{
		int total = 0;
		for (int wilma : numbersToAdd)
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
			System.out.print("potentially valid.");
			}
		else
			{
			System.out.print("invalid.");
			}
		}
	
	
	}
