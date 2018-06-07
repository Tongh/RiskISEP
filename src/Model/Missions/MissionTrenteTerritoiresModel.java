package Model.Missions;

import Controller.JoueurController;
import Model.MissionModel;

public class MissionTrenteTerritoiresModel extends MissionModel{

	public MissionTrenteTerritoiresModel(JoueurController player) {
		super(player);
		this.set_mission_contenu("Contrôler 30 territoires");
	}

	@Override
	public String get_mission_contenu() {
		return this.mission_contenu;
	}

	@Override
	public boolean get_condition_de_complete() {
		if (this.player.get_territoire().size() < 30) {
			return false;
		}
		return true;
	}

}
