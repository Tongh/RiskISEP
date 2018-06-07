package Core;

import java.util.Random;

import Controller.JoueurController;
import Controller.MapController;
import Controller.TerritoireController;

public class TerritoireDistribue {
	
	private Random rand = new Random();
	private JoueurController[] players; 
	private MapController map;
	private int nombre_de_territoire_initial;

	public TerritoireDistribue(JoueurController[] players, MapController map, int nombre_de_territoire_initial) {
		this.players = players;
		this.map = map;
		this.nombre_de_territoire_initial = nombre_de_territoire_initial;
		
		for (int i=0; i<players.length; i++) {
			for (int ii=0; ii<this.nombre_de_territoire_initial; ii++) {
				this.get_territoire_sans_occupant().set_occupant(this.players[i]);
			}
		}
	}

	private TerritoireController get_territoire_sans_occupant() {
		boolean have_occupant = true;
		int index = 0;
		while (have_occupant) {
			index = this.rand.nextInt(42);
			if (this.map.get_territoires()[index].get_occupant() == null) {
				have_occupant = false;
			} 
		}
		return this.map.get_territoires()[index];
	}

}
