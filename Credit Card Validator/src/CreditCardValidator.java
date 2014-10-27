import java.util.Scanner;

public class CreditCardValidator
	{
	static long cardNumber;
	static boolean validity;
	static long [ ] rawNumbers = new long [16];
	static long [ ] numbersToAdd = new long [16];
	
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
		System.out.println("The 1st loaded array:");
		for(long fred : rawNumbers)
			{
			System.out.print(fred);
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
					System.out.println("Raw number is " + rawNumbers[i]);
					long doubledNumber = rawNumbers[i] * 2;
					System.out.println("Doubled number is " + doubledNumber);
					long onesDigit = doubledNumber % 10;
					System.out.println("One's digit is " + onesDigit);
					long tensDigit = doubledNumber / 10;
					System.out.println("Ten's digit is " + tensDigit);
					System.out.println("Replaced number is " + (onesDigit + tensDigit));
					numbersToAdd[i] = (onesDigit + tensDigit);
					}
				}
			}
		for(long bambam : numbersToAdd)
			{
			System.out.println(bambam);
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
			System.out.print("potentially valid.");
			}
		else
			{
			System.out.print("invalid.");
			}
		}
	
	
	}
