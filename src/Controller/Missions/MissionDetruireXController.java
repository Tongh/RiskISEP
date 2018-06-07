package Controller.Missions;

import Controller.JoueurController;
import Controller.MissionController;
import Model.Missions.MissionDetruireXModel;
import View.MissionView;

public class MissionDetruireXController extends MissionController{

	public MissionDetruireXController(JoueurController player, JoueurController[] players) {
		super(new MissionDetruireXModel(player, players), new MissionView());
	}

	public JoueurController get_target_player() {
		return ((MissionDetruireXModel) this.model).get_target_player();
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