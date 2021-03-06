package Model.Missions;

import Controller.JoueurController;
import Model.MissionModel;

public class MissionVingtQuatreTerritoiresModel extends MissionModel{

	public MissionVingtQuatreTerritoiresModel(JoueurController player) {
		super(player);
		this.set_mission_contenu("Contrôler 24 territoires");
	}

	@Override
	public String get_mission_contenu() {
		return this.mission_contenu;
	}

	@Override
	public boolean get_condition_de_complete() {
		if (this.player.get_territoire().size() < 24) {
			return false;
		}
		return true;
	}

}
