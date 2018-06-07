package Model.Missions;

import Controller.JoueurController;
import Model.MissionModel;

public class MissionPlusGrandeRegionModel extends MissionModel{

	public MissionPlusGrandeRegionModel(JoueurController player) {
		super(player);
		this.set_mission_contenu("Contrôler la plus grosse région + 1 autre région");
	}

	@Override
	public String get_mission_contenu() {
		return this.mission_contenu;
	}

	@Override
	public boolean get_condition_de_complete() {
		if (this.player.get_regions().size() < 2) {
			return false;
		}
		for (int i=0; i<this.player.get_regions().size(); i++) {
			if (this.player.get_regions().get(i).get_name().equals("Asie")) {
				return true;
			}
		}
		return false;
	}

}
