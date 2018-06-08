package Model;

import java.util.ArrayList;
import java.util.HashMap;

import Controller.JoueurController;
import Controller.RegionController;
import Controller.UniteController;
import Core.Model;

public class TerritoireModel extends Model{

	private int id;
	private JoueurController player_occupant;
	private ArrayList<UniteController> armees;
	private RegionController region;
	
	public TerritoireModel(int id) {
		this.name = "Territoire";
		this.id = id;
		this.player_occupant = null;
		this.armees = new ArrayList<UniteController>();
		this.region = null;
	}
	
	public TerritoireModel(String name, int id) {
		this.name = name;
		this.player_occupant = null;
		this.id= id;
		this.armees = new ArrayList<UniteController>();
	}
	
	public int get_id() {
		return this.id;
	}
	
	public JoueurController get_player_occupant() {
		return this.player_occupant;
	}
	
	public RegionController get_region() {
		return this.region;
	}
	
	public HashMap<String, Integer> get_map_armee() {
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		result.put("soldat", 0);
		result.put("cavalier", 0);
		result.put("canon", 0);
		for (int i=0; i<this.armees.size(); i++) {
			result.put(this.get_armee().get(i).get_name(), result.get(this.get_armee().get(i).get_name())+1);
		}
		return result;
	}
	
	public int get_armee_renfort() {
		int res = 0;
		for (int i=0; i<this.armees.size(); i++) {
			res += this.armees.get(i).get_cout();
		}
		return res;
	}
	
	public boolean have_occupant() {
		return (this.player_occupant == null) ? false : true;
	}
	
	public void set_player_occupant(JoueurController player) {
		this.player_occupant = player;
	}
	
	public void set_region(RegionController controller) {
		this.region = controller;
	}
	
	public ArrayList<UniteController> get_armee() {
		return this.armees;
	}
	
	public void add_armee(UniteController unite) {
		this.armees.add(unite);
	}
	
	public void remove_armee(UniteController unite) {
		this.armees.remove(unite);
	}
}
