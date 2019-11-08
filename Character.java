package characterprogram;


public class Character {
	private String ogsentence;
	//private String[] characters;
	
	public Character() {
		ogsentence="";
	//	wordswpunc= new String[];
	}
	
	public void setOG(String a) {
		ogsentence = a.trim();
	}
	
	public int getCharacters() {
		int count=0;
		char space = " ";
		for(int i=0; i<ogsentence.length(); i++) {
			
		}
		
		
		
		
		
		return count;
	}
	public void tester() {
		System.out.println(ogsentence);
	}
}
