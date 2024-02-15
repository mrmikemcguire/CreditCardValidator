
public class GenerateNumbers
	{
	public static void main(String[] args)
		{
		System.out.println(generateRandomNumber());
		checkForValidity();		}
	
	public static long generateRandomNumber()
		{
		long number = (long)(Math.random() * 10000000000000000L);
		return number;			
		}
	
	public static boolean checkForValidity()
		{
		CreditCardValidatorFromInput
		CreditCardValidatorFromInput.loadArray();
		System.out.println(CreditCardValidatorFromInput.validateCCNumber());
		return CreditCardValidatorFromInput.validateCCNumber();
		}
	}
