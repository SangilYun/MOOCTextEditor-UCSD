package practice;

import java.util.Arrays;


public class RegularExpressions {

	public static int test(String word) {
		int count = 0;
	    boolean newSyllable = true;
	    String vowel = "aeiouy";
	    for(int i=0; i<word.length(); i++) {
	    	if(i == word.length()-1 && Character.toLowerCase(word.charAt(i)) == 'e') break;
	    	if(newSyllable && vowel.indexOf(Character.toLowerCase(word.charAt(i))) >=0) {
	    		count++; 
	    		newSyllable= false;
	    		}
	    	else if(vowel.indexOf(Character.toLowerCase(word.charAt(i))) < 0 )
	    		newSyllable = true;
	    }
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString("212345 2343332 6789".split("[1]+")));
		char c = "123".charAt(2);
		String sentence = "this is a sentence.";
		String[] words = sentence.split("[a-zA-Z]+");
		System.out.println(Arrays.toString(words));
		System.out.println(test("sentence"));
		System.out.println(test("seque"));
		System.out.println(test("sentences"));
		System.out.println(test("senteeeeeeeeences"));
		System.out.println(test("This is a test"));
		System.out.println(test("are"));
		System.out.println(test("be"));
		System.out.println(1/5.0);
		System.out.println(Arrays.toString("%one%%two%%%three%%%%".split("one|two|three")));
		String text = "My";
		text.concat("String");
		System.out.println(text);
		System.out.println(Arrays.toString("$123$$456$$$789".split("[123456789]+")));
	}

}
