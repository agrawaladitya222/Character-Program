package characterprogram;

import javax.swing.*;
import BreezySwing.*;

public class CharacterGUI extends GBFrame{
	private JButton calculate;
	private JLabel inputlabel;
	private JTextArea area;
	private Character character = new Character();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame gui = new CharacterGUI();
		gui.setTitle("Word Counter");
		gui.setVisible(true);
		gui.setSize(800,400);
	}
	
	public CharacterGUI() {
		calculate = addButton("Calculate",3,1,1,1);
		inputlabel = addLabel("Input a sentence:",1,1,1,1);
		area = addTextArea("",2,1,1,1);
		
	}
	
	public void buttonClicked(JButton button) {
		if(button == calculate) {
			character.getInput(area.getText());
			character.tester();
			
			
			
		}
		
		
		
		
	}

}
