package Model;

import Controller.JoueurController;
import Core.Model;

public abstract class MissionModel extends Model {

	protected boolean condition_de_complete;
	protected String mission_contenu, mission_simple_name;
	protected JoueurController player;
	
	public MissionModel(JoueurController player) {
		this.player = player;
	}
	
	public void set_mission_short_name(String name) {
		this.mission_simple_name = name;
	}
	
	public JoueurController get_player() {
		return this.player;
	}
	
	public void set_player(JoueurController controller){
		this.player = controller;
	}
	
	public void set_mission_contenu(String mission_contenu) {
		this.mission_contenu = mission_contenu;
	}
	
	public String get_mission_contenu() {
		return this.mission_contenu;
	}
	
	public String get_mission_short_name() {
		return this.mission_simple_name;
	}

	public abstract boolean get_condition_de_complete();
	
}
