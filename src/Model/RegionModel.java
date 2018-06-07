package Model;

import java.util.ArrayList;

import Controller.JoueurController;
import Controller.TerritoireController;
import Core.Model;

public class RegionModel extends Model{
	
	private JoueurController player_occupant;
	private ArrayList<TerritoireController> territoires;
	
	public RegionModel() {
		this.name = "Region";
		this.player_occupant = null;
		this.territoires = new ArrayList<TerritoireController>();
	}
	
	public RegionModel(String name) {
		this.name = name;
		this.player_occupant = null;
		this.territoires = new ArrayList<TerritoireController>();
	}
	
	public JoueurController get_player_occupant() {
		return this.player_occupant;
	}
	
	public ArrayList<TerritoireController> get_territoires() {
		return this.territoires;
	}
	
	public TerritoireController get_territoire_by_name(String name) {
		for (int i=0; i<this.territoires.size(); i++) {
			if (this.territoires.get(i).get_name() == name) {
				return this.territoires.get(i);
			}
		} return null;
	}
	
	public boolean get_tous_occupant_status() {
		for (int i=0; i<this.territoires.size()-1; i++) {
			if (this.territoires.get(i) == null) {
				return false;
			} else if (!this.territoires.get(i).equals(this.territoires.get(i+1))) {
				return false;
			}
		} return true;
	}
	
	public void set_player_occupant(JoueurController player) {
		this.player_occupant = player;
	}
	
	public int add_territoire(TerritoireController controller) {
		if (this.territoires.contains(controller)){
			return -1;
		}
		this.territoires.add(controller);
		return 1;
	}

}
