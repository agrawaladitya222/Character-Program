package characterprogram;

public class Character {
	private String sentence = "";
	private String words[] = new String[50];
	private String wordswithoutpunk[] = new String[50];
	private boolean outputyet[] = new boolean[50];

	public Character() {
		for (int i = 0; i < words.length; i++) {
			words[i] = "";
		}
		for (int j = 0; j < wordswithoutpunk.length; j++) {
			wordswithoutpunk[j] = "";
		}
		for (int k = 0; k < outputyet.length; k++) {
			outputyet[k] = false;
		}

	}

	public void getInput(String a) {
		sentence = a.trim();
		boolean error = true;
		if (sentence.equals("")) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < sentence.length(); i++) {
			if (!isSpaceorTab(sentence.charAt(i)) && !isPunk(sentence.charAt(i))) {
				error = false;
			}
		}
		if (error == true) {
			throw new IllegalArgumentException();
		}
	}

	public int getCharacters() {
		int count = 0;
		for (int i = 0; i < sentence.length(); i++) {
			if (sentence.charAt(i) == '	' || sentence.charAt(i) == ' ') {
				continue;
			} else {
				count = count + 1;
			}
		}
		return count;
	}

	public void storeWords() {
		int wordindex = 0;
		for (int i = 0; i < sentence.length(); i++) {
			if (isSpaceorTab(sentence.charAt(i)) && isSpaceorTab(sentence.charAt(i - 1))) {
				continue;
			} else if (isSpaceorTab(sentence.charAt(i)) && !isSpaceorTab(sentence.charAt(i - 1))) {
				wordindex = wordindex + 1;
			} else if (!isSpaceorTab(sentence.charAt(i))) {
				words[wordindex] = words[wordindex] + String.valueOf(sentence.charAt(i));
			}
		}

	}

	public int getWords() {
		int count = 0;

		for (int i = 0; i < wordswithoutpunk.length; i++) {
			if (!wordswithoutpunk[i].equals("")) {
				count = count + 1;
			}
		}
		return count;
	}

	public boolean isSpaceorTab(char a) {
		if (a == ' ' || a == '\t' || a == '\n') {
			return true;
		}
		return false;
	}

	public boolean isPunk(char a) {
		if (a == '.' || a == '?' || a == '!') {
			return true;
		} else {
			return false;
		}
	}

	public String getRidofPunk(String a) {
		String result;

		for (int i = 0; i < a.length() - 1; i++) {
			if (isPunk(a.charAt(i)) && !isPunk(a.charAt(i + 1))) {
				a = a.substring(i + 1);
				break;
			}
		}
		for (int i = 0; i < a.length() - 1; i++) {
			if (!isPunk(a.charAt(i)) && isPunk(a.charAt(i + 1))) {
				a = a.substring(0, i + 1);
				break;
			}
		}
		result = a;

		return result;
	}

	public void storePunkFreeWords() {
		for (int i = 0; i < words.length; i++) {
			if (!words[i].equals("")) {
				wordswithoutpunk[i] = getRidofPunk(words[i]);
				if (isOnlyPunk(wordswithoutpunk[i])) {
					wordswithoutpunk[i] = "";
				}
			}
		}
	}

	public boolean isOnlyPunk(String a) {
		boolean error = true;
		for (int i = 0; i < a.length(); i++) {
			if (!isPunk(a.charAt(i))) {
				error = false;
			}
		}
		return error;
	}

	public int getAppearances(String a) {
		int appearances = 0;
		for (int i = 0; i < wordswithoutpunk.length; i++) {
			if (wordswithoutpunk[i].equalsIgnoreCase(a)) {
				appearances = appearances + 1;
			}
		}
		return appearances;
	}

	public String formOutput() {
		String output = "";
		for (int i = 0; i < wordswithoutpunk.length; i++) {
			if (outputyet[i] == false && !wordswithoutpunk[i].equals("")) {
				String firstletter = String.valueOf(wordswithoutpunk[i].charAt(0));
				String restofword = getRestofWord(wordswithoutpunk[i]);
				firstletter = firstletter.toUpperCase();
				output = output + firstletter + restofword + "	" + getAppearances(wordswithoutpunk[i]) + "\n";
				Outputted(wordswithoutpunk[i]);
			}
		}

		return output;
	}

	public String getRestofWord(String a) {
		String restofword = a.substring(1, a.length());
		return restofword;
	}

	public void Outputted(String a) {
		for (int i = 0; i < wordswithoutpunk.length; i++) {
			if (wordswithoutpunk[i].equalsIgnoreCase(a)) {
				outputyet[i] = true;
			}
		}
	}

	public void reset() {
		for (int i = 0; i < words.length; i++) {
			words[i] = "";
		}
		for (int j = 0; j < wordswithoutpunk.length; j++) {
			wordswithoutpunk[j] = "";
		}
		for (int k = 0; k < outputyet.length; k++) {
			outputyet[k] = false;
		}
		sentence = "";

	}
}
