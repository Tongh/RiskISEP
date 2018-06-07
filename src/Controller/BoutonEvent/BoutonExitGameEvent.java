package Controller.BoutonEvent;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class BoutonExitGameEvent extends BoutonEvent {
	
	public BoutonExitGameEvent(Button bouton) {
		super(bouton, true);
	}

	@Override
	public void handle(MouseEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Comfirmation");
		alert.setHeaderText("Vous êtes sûr?");
		alert.setContentText("Vous allez quitter tous le jeu.");
		
		Optional<ButtonType> result_alert = alert.showAndWait();
		if (result_alert.get() == ButtonType.OK) {
			System.exit(0);
		} else {
			alert.close();
		}
	}

}
