import java.util.Scanner;

public class CreditCardValidatorFromInput
	{
	static long cardNumber, tempCardNumber;
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
		return cardNumber;
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
		System.out.println("The credit card number " + cardNumber + " is ");
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
