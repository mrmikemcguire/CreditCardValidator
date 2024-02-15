
import java.util.Scanner;

public class CCFromInputNoGlobals {
    
    public static void main(String[] args) 
    	{
        long cardNumber = acceptCCNumber();
        long[] rawNumbers = loadArray(cardNumber);
        long[] numbersToAdd = modifyCCNumber(rawNumbers);
        boolean validity = validateCCNumber(numbersToAdd);
        displayResult(cardNumber, validity);
    	}
    
    public static long acceptCCNumber() 
    	{
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please input the credit card number without spaces.");
        return userInput.nextLong();
    	}
    
    public static long[] loadArray(long cardNumber) 
    	{
        long[] rawNumbers = new long[16];
        long tempCardNumber = cardNumber;
        for (int i = 0; i < 16; i++) 
        	{
            rawNumbers[i] = tempCardNumber % 10;
            tempCardNumber /= 10;
        	}
        return rawNumbers;
    	}
    
    public static long[] modifyCCNumber(long[] rawNumbers) 
    	{
        long[] numbersToAdd = new long[16];
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
                    numbersToAdd[i] = onesDigit + tensDigit;
                	}
            	}
        	}
        return numbersToAdd;
    	}
    
    public static boolean validateCCNumber(long[] numbersToAdd) 
    	{
        int total = 0;
        for (long num : numbersToAdd) 
        	{
            total += num;
        	}
        return total % 10 == 0;
    	}
    
    public static void displayResult(long cardNumber, boolean validity) 
    	{
        System.out.println("The credit card number " + cardNumber + " is ");
        if (validity) 
        	{
            System.out.print("potentially valid.");
        	} 
        else 
        	{
            System.out.print("invalid.");
        	}
    	}
	}

