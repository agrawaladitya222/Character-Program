package characterprogram;


public class Character {
	private String sentence;
	private String words[]= new String [25];
	
	public Character() {
		for(int i=0; i<words.length;i++) {
			words[i]="";
		}
	
	
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
			if(isSpaceorTab(sentence.charAt(i)) && isSpaceorTab(sentence.charAt(i-1))) {
				continue;
			}else if(isSpaceorTab(sentence.charAt(i)) && !isSpaceorTab(sentence.charAt(i-1))) {
				words[wordindex]=words[wordindex] + String.valueOf(sentence.charAt(i));
				wordindex= wordindex + 1;
			}else if(!isSpaceorTab(sentence.charAt(i))) {
				words[wordindex]=words[wordindex] + String.valueOf(sentence.charAt(i));
			}
		}
		
	}
	
	public int getWords() {
		int count=0;
		
		for(int i=0; i<words.length; i++) {
			if(!words[i].equals("")) {
				count = count + 1;
			}
		}
		return count;
	}
	
	public boolean isSpaceorTab(char a) {
		if(a=='	' || a == ' ') {
			return true;
		}
		return false;
	}
	
	public String getRidofPunk(String a) {
		String result =a;
		if(!a.equals("") && (a.charAt(a.length()-1)=='.' || a.charAt(a.length()-1)=='!' || a.charAt(a.length()-1)=='?')) {
			result = a.substring(0, a.length()-2);
		}
		return result;
	}
	
	public void tester() {
		for(int i=0;i<words.length;i++) {
			if(!words[i].equals("")) {
			System.out.println(words[i]);
			}
		}
		System.out.println(getCharacters());
		System.out.println(getWords());
		for(int i=0;i<words.length;i++) {
			if(!words[i].equals("")) {
			System.out.println(getRidofPunk(words[i]));
			}
		}
		
		
	}
	
}
