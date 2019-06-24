import java.util.ArrayList;
import java.util.List;


public class Main {
	public static String replaceDuplicate(String str) {

		String[] strArr = str.trim().split(" ");
		List<String> word = new ArrayList<String>();
		String remove = null;
		for (int i = 0; i<strArr.length; i++) {
			if(word.isEmpty() || !word.get(word.size()-1).equalsIgnoreCase(strArr[i]) || word.get(word.size()-1).equals("REPEAT")) {
				if (remove!= null && word.get(word.size()-1).equals("REPEAT") && remove.equalsIgnoreCase(strArr[i])) continue;
				word.add(strArr[i]);
			}
			else {
				remove = word.remove(word.size()-1);
				word.add("REPEAT");
			}
		}
		StringBuilder outputStr = new StringBuilder();
		for (String words : word) {
			outputStr.append(words + " ");
		}
		return outputStr.toString();
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] test = {"I have a a pen and a pencil",
				"I want to tO go to The the zoo",
				"What a a wonderful day day day",
				"This is the final test case"};
		
		String[] expect = {"I have REPEAT pen and a pencil",
				"I want REPEAT go to REPEAT zoo",
				"What REPEAT wonderful REPEAT",
				"This is the final test case"};
		
		for (int i = 0; i<test.length; i++) {
			System.out.println("Case :" + (i+1));
			System.out.println("Input: " + test[i]);
			System.out.println("Expect output: " + expect[i]);
			System.out.println("Real output: " + replaceDuplicate(test[i]));
			System.out.println();
		}
	}

}
