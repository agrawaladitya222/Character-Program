package characterprogram;

import javax.swing.*;
import BreezySwing.*;

public class CharacterGUI extends GBFrame {
	private JButton calculate;
	private JLabel inputlabel;
	private JTextArea area;
	private JButton reset;
	private Character character = new Character();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame gui = new CharacterGUI();
		gui.setTitle("Word Counter");
		gui.setVisible(true);
		gui.setSize(800, 400);
	}

	public CharacterGUI() {
		calculate = addButton("Calculate", 3, 1, 1, 1);
		inputlabel = addLabel("Input a sentence:", 1, 1, 1, 1);
		area = addTextArea("", 2, 1, 1, 1);
		reset = addButton("Reset", 4, 1, 1, 1);
		area.requestFocus();
		reset.setEnabled(false);

	}

	public void buttonClicked(JButton button) {
		if (button == calculate) {
			try {
				character.getInput(area.getText());
				character.storeWords();
				character.storePunkFreeWords();
				area.setText(area.getText() + "\nCharacters: " + character.getCharacters() + "\nWords: "
						+ character.getWords() + "\n" + character.formOutput());
				calculate.setEnabled(false);
				reset.setEnabled(true);
			} catch (IllegalArgumentException e) {
				messageBox(
						"Error.The input needs to contain at least one character other than punctuation, spaces/tabs, or nothing.");
				character.reset();
				area.setText("");
				area.requestFocus();
				reset.setEnabled(false);
				calculate.setEnabled(true);
			}
		} else if (button == reset) {
			character.reset();
			area.setText("");
			area.requestFocus();
			calculate.setEnabled(true);
			reset.setEnabled(false);
		}

	}

}
