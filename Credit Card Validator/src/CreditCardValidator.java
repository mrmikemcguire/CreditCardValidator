import java.util.Scanner;
import java.util.ArrayList;

public class CreditCardValidator
	{
	static String cardNumber;
	static ArrayList <String> numberArray = new ArrayList <String>();
	
	public static void main(String[] args)
		{
		acceptCCNumber();
		loadArray();
		//validateCCNumber();
		}
	
	public static String acceptCCNumber()
		{
		Scanner userInput = new Scanner(System.in);
		System.out.println("Please input the credit card number without spaces.");
		cardNumber = userInput.nextLine();
		return cardNumber;
		}
	
	public static void loadArray()
		{
		for (int i = 0; i < cardNumber.length(); i++)
			{
			numberArray.add(cardNumber.substring(i, i + 1));
			}
		
		
		for(String fred : numberArray)
			{
			System.out.println(fred);
			}
		}
	
	public static void validateCCNumber()
		{
		
		}

	}
