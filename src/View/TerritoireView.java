package View;

import java.util.ArrayList;

import Controller.JoueurController;
import Controller.UniteController;

public class TerritoireView {

	public void print_details(String name, JoueurController player, ArrayList<UniteController> armees) {
		System.out.println("Territoire: " + name);
		String player_name = (player == null) ? "" : player.get_name();
		System.out.println("Occupant: " + player_name);
		System.out.println("Armée: " + armees.size());
		for (int i=0; i<armees.size(); i++) {
			armees.get(i).updateView();
		}
		System.out.println();
	}

	public void territoire_occupant_changer(String old_name, String new_name, String territoire) {
		System.out.println("Terrtoire Change: " + "[" + territoire + "]");
		System.out.println("Old occupant: " + "[" + old_name + "]");
		System.out.println("New occupant: " + "[" + new_name + "]");
		System.out.println();
	}

	public void region_occupant_changer(String name, String info) {
		System.out.println("Région [" + name + "]");
		System.out.println("Occupant : [" + info + "]");
		System.out.println();
	}
	
}
