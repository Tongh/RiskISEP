package Model;

import java.util.ArrayList;

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
