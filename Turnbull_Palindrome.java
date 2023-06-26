//Thessalonica Turnbull
//Spring 2023 Advanced Java
//HW - Palindrome
//Created February 22, 2023
//
//takes or prompts for a user input string
//checks if string is a strict palindrome, ordinary palindrome, or not a palindrome at all

import java.util.Scanner;

public class Turnbull_Palindrome {

	public static void main (String[] args) {
		String str = "";
		   
		System.out.print("Let's check for palindromes!\n\n");
	   
		//accepts string from command prompt
		if ( args.length >= 1 ){
		    str = args[0];
			for (int i = 1; i < args.length; i++) {
				str = str.concat(" " + args[i]);
			}
			System.out.println(str);
	    }
		//prompts for string
	    else{
	    	Scanner s = new Scanner(System.in);
	    	System.out.print("Please enter a string: ");
	    	str = s.nextLine();
	       
	    	s.close();
	    }
		
		//sends to function to strip string of extra junk
		str = stripString(str);
		
		//sends to recursive function to check if a palindrome
		if (checkPalindrome(str, 0 , str.length()-1) == true) {
			System.out.println("String IS a strict palindrome.");
		}else {
			//remove non alphanumeric characters, spaces removed
			str = str.replaceAll("[^a-zA-Z0-9]", "");
			//sends to checkPalindrome()
			if (checkPalindrome(str, 0, str.length()-1) == true) {
				System.out.println("String is not a strict palindrome.");
				System.out.println("But string IS an ordinary palindrome.");
			}else {
				System.out.println("String is neither a strict nor an ordinary palindrome.");
			}
		}
		
		//ends program
		return;
	}
	
	//strips str of anything but spaces, letters, and numbers
	private static String stripString(String str) {		
		//remove non alphanumeric characters, spaces kept
		str = str.replaceAll("[^a-zA-Z0-9 ]", "");
		
		//ignore letter case
		str = str.toUpperCase();
		
		return str;
	}
	
	//recursive function, checks string to see if it is a palindrome
	private static Boolean checkPalindrome(String str, int low, int high) {
		//if string is just one length
		if (low >= high) {
			return true;
		//if low and high are not the same -> it's not a strict palindrome
		}else if(str.charAt(low) != str.charAt(high)) {
			return false;
		//keeps comparing through recursion
		//once low meets high, then it is a palindrome
		}else {
			return checkPalindrome(str, low+1, high-1);
		}
	}
}
