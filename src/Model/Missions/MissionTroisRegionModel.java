package Model.Missions;

import Controller.JoueurController;
import Model.MissionModel;

public class MissionTroisRegionModel extends MissionModel{

	public MissionTroisRegionModel(JoueurController player) {
		super(player);
		this.set_mission_contenu("Contrôler 3 régions et au moins 18 territoires");
	}

	@Override
	public String get_mission_contenu() {
		return this.mission_contenu;
	}

	@Override
	public boolean get_condition_de_complete() {
		if (this.player.get_regions().size() < 3 || this.player.get_territoire().size() < 18) {
			return false;
		} 
		return true;
	}

}
