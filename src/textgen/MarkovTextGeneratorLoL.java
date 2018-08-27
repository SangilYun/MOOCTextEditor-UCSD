package textgen;


import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/** 
 * An implementation of the MTG interface that uses a list of lists.
 * @author UC San Diego Intermediate Programming MOOC team 
 */
public class MarkovTextGeneratorLoL implements MarkovTextGenerator {

	// The list of words with their next words
	private List<ListNode> wordList; 
	
	// The starting "word"
	private String starter;
	
	// The random number generator
	private Random rnGenerator;
	
	public MarkovTextGeneratorLoL(Random generator)
	{
		wordList = new LinkedList<ListNode>();
		starter = "";
		rnGenerator = generator;
	}
	
	public ListNode findNode(String word) {
		for(ListNode ln : wordList) {
			if((ln.getWord()).equals(word)) {
				return ln;
			}
		}
		return null;
	}
	/** Retrain the generator from scratch on the source text */
	@Override
	public void retrain(String sourceText)
	{
		new MarkovTextGeneratorLoL(rnGenerator);
		wordList =new LinkedList<ListNode>();
		// The starting "word"
		starter ="";
		// TODO: Implement this method.
		train(sourceText);
	}
	
	/** Train the generator by adding the sourceText */
	@Override
	public void train(String sourceText)
	{
		// TODO: Implement this method
		String splitted[] = sourceText.split(" +");
		String prev=splitted[0];
		
		//debugging purpose 
//		System.out.println(Arrays.toString(splitted));
		
		for(int i=0; i<splitted.length; i++) {
			//set prev to the first element in the array
			try {
			starter = splitted[i+1];
//			System.out.println("prev , starter : " + prev +" " +starter); //debugging purpose
			}catch(ArrayIndexOutOfBoundsException e) {
				starter = splitted[0];
			}
			
			if(findNode(prev) !=null) {	//if prev is a node in the list
				ListNode prevNode = findNode(prev);
//				System.out.println("prevNode : "+ prevNode);	//debugging purpose
				prevNode.addNextWord(starter);	//add starter as a nextWord to the prev node
			}
			else {	// add a node to the list with "prevWord" as the node's word
				ListNode newNode = new ListNode(prev);
//				System.out.println("newNode : "+ newNode);	//debugging purpose
				wordList.add(newNode);
				newNode.addNextWord(starter);
			}
			prev = starter;
		}
		
	}
	
	/** 
	 * Generate the number of words requested.
	 */
	@Override
	public String generateText(int numWords) {
	    // TODO: Implement this method
		//initializing
		if(wordList.size() ==0) {
			return "";
		}
		String currWord = wordList.get(0).getWord();	//set "currWord" to be the starter word
		String output ="";	//set "output" to be ""
		String ranWord;
		ListNode currNode;
		
		output = output+currWord;  //add "currWord" to output
		for(int i=0;i<numWords-1;i++) {	//while you need more words //0부터 시작이라 -1해줌
			int j = i%wordList.size();
//			currWord =  wordList.get(j).getWord();
//			System.out.println("currWord : " + currWord);
			currNode = findNode(currWord);	// find the "node" corresponding to "currWord" in the list
			ranWord = currNode.getRandomNextWord(rnGenerator);	//select a random word "w" from the "wordList" for "node"

//			System.out.println("ranword : " + ranWord);

			output = output+" "+ranWord;	//   add a random word to the "output"
			currWord = ranWord; //   set "currWord" to be "w" 
		}
		return output;
	}
	
	
	// Can be helpful for debugging
	@Override
	public String toString()
	{
		String toReturn = "";
		for (ListNode n : wordList)
		{
			toReturn += n.toString();
		}
		return toReturn;
	}
	

	
	// TODO: Add any private helper methods you need here.
	
	
	/**
	 * This is a minimal set of tests.  Note that it can be difficult
	 * to test methods/classes with randomized behavior.   
	 * @param args
	 */
	public static void main(String[] args)
	{
		// feed the generator a fixed random value for repeatable behavior
		MarkovTextGeneratorLoL gen = new MarkovTextGeneratorLoL(new Random(42));
//		System.out.println("hi there hi Leo");
//		System.out.println(gen);
//		gen.train("hi there hi Leo");
//		System.out.println(gen);
//		System.out.println(gen.generateText(4));
//		
		String textString = "Hello.  Hello there.  This is a test.  Hello there.  Hello Bob.  Test again.";
		System.out.println(textString);	
		gen.train(textString);
//		System.out.println(gen);
		System.out.println(gen.generateText(20));
		
		String textString2 = "You say yes, I say no, "+
				"You say stop, and I say go, go, go, "+
				"Oh no. You say goodbye and I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"I say high, you say low, "+
				"You say why, and I say I don't know. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"Why, why, why, why, why, why, "+
				"Do you say goodbye. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"You say yes, I say no, "+
				"You say stop and I say go, go, go. "+
				"Oh, oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello,";
		System.out.println(textString2);
		gen.retrain(textString2);
//		System.out.println(gen);
		System.out.println(gen.generateText(20));
		
	}

}

/** Links a word to the next words in the list 
 * You should use this class in your implementation. */
class ListNode
{
    // The word that is linking to the next words
	private String word;
	
	// The next words that could follow it
	private List<String> nextWords;
	
	ListNode(String word)
	{
		this.word = word;
		nextWords = new LinkedList<String>();
	}
	
	public String getWord()
	{
		return word;
	}

	public void addNextWord(String nextWord)
	{
		nextWords.add(nextWord);
	}
	
	public String getRandomNextWord(Random generator)
	{
		// TODO: Implement this method
	    // The random number generator should be passed from 
	    // the MarkovTextGeneratorLoL class
		int ranNum=generator.nextInt(nextWords.size());
	    return nextWords.get(ranNum);
	}

	public String toString()
	{
		String toReturn = word + ": ";
		for (String s : nextWords) {
			toReturn += s + "->";
		}
		toReturn += "\n";
		return toReturn;
	}
	
}


