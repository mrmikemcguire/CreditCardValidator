import java.util.ArrayList;

public class GenerateCreditCards
	{
	static long cardNumber, tempCardNumber, possibleNum;
	static boolean validity;
	static boolean stillGenerating = true;
	static long [ ] rawNumbers = new long [16];
	static long [ ] numbersToAdd = new long [16];
	static ArrayList<Long> validCards = new ArrayList<Long>();
	
	public static void main(String[] args)
		{
		while(stillGenerating)
			{
			generateCC();
			loadArray();
			modifyCCNumber();
			validateCCNumber();
			loadValidCards();
			}
		}
	
	public static long generateCC()
		{
		possibleNum = (long)(Math.random()*((long)(Math.pow(10,15)*9))+(long)(Math.pow(10,15)));
		return possibleNum;
		}
	
	public static void loadArray()
		{
		tempCardNumber = generateCC();
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
	
	public static void loadValidCards()
		{
		if(validateCCNumber())
			{
			validCards.add(possibleNum);
			}
		if(validCards.size() == 100)
			{
			stillGenerating = false;
			displayValidCards();
			}
		}
	
	public static void displayValidCards()
		{
		System.out.println("Here are one hundred potentially valid credit card numbers:\n");
		for(Long l : validCards)
			{
			System.out.println(l);
			}
		}
	}
