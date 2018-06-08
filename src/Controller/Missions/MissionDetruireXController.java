package Controller.Missions;

import Controller.JoueurController;
import Controller.MissionController;
import Model.Missions.MissionDetruireXModel;
import View.MissionView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MissionDetruireXController extends MissionController{

	public MissionDetruireXController(JoueurController player, JoueurController[] players) {
		super(new MissionDetruireXModel(player, players), new MissionView());
		this.set_mission_short_name("Mission détuire");
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
	
	public Alert get_process_alert() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Process de votre mission");
		alert.setHeaderText("Votre mission est: " + this.get_mission_contenu());
		alert.setContentText("");
		return alert;
	}

}
