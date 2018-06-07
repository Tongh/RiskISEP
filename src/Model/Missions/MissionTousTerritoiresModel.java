package Model.Missions;

import Controller.JoueurController;
import Model.MissionModel;

public class MissionTousTerritoiresModel extends MissionModel{

	public MissionTousTerritoiresModel(JoueurController player) {
		super(player);
		this.set_mission_contenu("Conquérir tous les territoires");
	}

	@Override
	public boolean get_condition_de_complete() {
		if (this.player.get_territoire().size() != 42) {
			return false;
		}
		return true;
	}

}
