package Controller.BoutonEvent;

import Core.Risk;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class BoutonDetailMission implements EventHandler<MouseEvent> {

	private Risk risk;

	public BoutonDetailMission(Risk risk) {
		this.risk = risk;
	}
	
	@Override
	public void handle(MouseEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information sur Votre " + risk.get_player_actuelle().get_mission().get_mission_short_name());
		alert.setHeaderText(null);
		alert.setContentText(risk.get_player_actuelle().get_mission().get_mission_contenu());

		alert.showAndWait();
	}

}
