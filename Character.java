package characterprogram;


public class Character {
	private String sentence;
	private String words[]= new String [25];
	
	public Character() {
	
	
	}
	
	public void getInput(String a) {
		sentence = a.trim();
		
	}
	
	public int getCharacters() {
		int count=0;
		for(int i=0;i<sentence.length();i++) {
			if(sentence.charAt(i) == '	' || sentence.charAt(i) == ' ') {
				continue;
			}else {
				count = count + 1;
			}
		}
		return count;
	}
	
	public void storeWords() {
		int wordindex=0;
		for(int i=0;i<sentence.length();i++) {
			if(isSpaceorTab(sentence.charAt(i))) {
				continue;
			}else if(i==0) {
				words[wordindex]=words[wordindex] + String.valueOf(sentence.charAt(i));
			}else if(isSpaceorTab(sentence.charAt(i)) && !isSpaceorTab(sentence.charAt(i-1))) {
				words[wordindex]=words[wordindex] + String.valueOf(sentence.charAt(i));
				wordindex= wordindex + 1;
			}else if(!isSpaceorTab(sentence.charAt(i)) && !isSpaceorTab(sentence.charAt(i-1))) {
				words[wordindex]=words[wordindex] + String.valueOf(sentence.charAt(i));
			}
		}
		
	}
	
	public boolean isSpaceorTab(char a) {
		if(a=='	' || a == ' ') {
			return true;
		}
		return false;
	}
	public void tester() {
		System.out.println(sentence);
		System.out.println(getCharacters());
	}
	
}
