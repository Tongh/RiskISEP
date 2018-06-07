package View;

import java.util.ArrayList;

import Controller.TerritoireController;

public class RegionView {

	public void print_details(String name, String player_name, ArrayList<TerritoireController> territoires) {
		System.out.println("Région: " + name);
		System.out.println("Occupant: " + player_name);
		System.out.print("[");
		for (int i=0; i<territoires.size(); i++) {
			System.out.print(territoires.get(i).get_name() + ", ");
		}
		System.out.print("]\n");
		System.out.println();
	}
	
	public void print_add_terrtoire_status(int status, String region_name, String territoire_name) {
		if (status == 1) {
			System.out.println("[" + territoire_name + "] -> [" + region_name + "]!");
		} else {
			System.out.println("[" + territoire_name + "] a déjà existé dans la région [" + region_name + "]!");
		}
		System.out.println();
	}
}
