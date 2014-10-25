import java.util.Scanner;

public class CreditCardValidator
	{
	static int cardNumber;
	
	public static void main(String[] args)
		{
		acceptCCNumber();
		validateCCNumber();
		}
	
	public static int acceptCCNumber()
		{
		Scanner userInput = new Scanner(System.in);
		System.out.println("Please input the credit card number without spaces.");
		cardNumber = userInput.nextInt();
		return cardNumber;
		}
	
	public static void validateCCNumber()
		{
		
		}

	}
