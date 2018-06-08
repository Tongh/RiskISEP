package Controller.Missions;

import Controller.JoueurController;
import Controller.MissionController;
import Model.Missions.MissionTrenteTerritoiresModel;
import View.MissionView;

public class MissionTrenteTerritoiresController extends MissionController{

	public MissionTrenteTerritoiresController(JoueurController player) {
		super(new MissionTrenteTerritoiresModel(player), new MissionView());
		this.set_mission_short_name("Mission contrôler");
	}

	@Override
	public JoueurController get_player() {
		return this.model.get_player();
	}

	@Override
	public String get_mission_contenu() {
		return this.model.get_mission_contenu();
	}

	@Override
	public boolean get_condition_de_complete() {
		return this.model.get_condition_de_complete();
	}

	@Override
	public void set_mission_contenu(String mission_contenu) {
		this.model.set_mission_contenu(mission_contenu);
	}

	@Override
	public void updateView() {
		// TODO Auto-generated method stub
		
	}

}
