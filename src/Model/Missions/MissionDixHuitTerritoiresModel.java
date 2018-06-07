package Model.Missions;

import java.util.ArrayList;

import Controller.JoueurController;
import Controller.TerritoireController;
import Model.MissionModel;

public class MissionDixHuitTerritoiresModel extends MissionModel{

	public MissionDixHuitTerritoiresModel(JoueurController player) {
		super(player);
		this.set_mission_contenu("Contrôler 18 Territoires avec au moins 2 armées");
	}

	@Override
	public String get_mission_contenu() {
		return this.mission_contenu;
	}

	@Override
	public boolean get_condition_de_complete() {
		ArrayList<TerritoireController> territoires = this.player.get_territoire();
		if (territoires.size() < 18) {
			return false;
		} 
		for (int i=0; i<territoires.size(); i++) {
			if (territoires.get(i).get_armees().size() < 2) {
				return false;
			}
		}
		return true;
	}

}
