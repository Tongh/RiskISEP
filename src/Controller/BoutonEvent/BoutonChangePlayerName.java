package Controller.BoutonEvent;

import java.util.Optional;

import Controller.JoueurController;
import Core.Risk;
import View.TourView;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;

public class BoutonChangePlayerName implements EventHandler<MouseEvent>{
	
	private JoueurController player;
	private TourView view;
	private Risk risk;

	public BoutonChangePlayerName(JoueurController player, TourView tourView, Risk risk) {
		this.player = player;
		this.view = tourView;
		this.risk = risk;
	}

	@Override
	public void handle(MouseEvent event) {
		TextInputDialog dialog = new TextInputDialog("");
		dialog.setTitle("Changer le nom de joueur");
		dialog.setHeaderText(null);
		dialog.setContentText("Insérez votre nom du joueur: ");

		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
			if (this.new_name_ok(result.get())) {
				player.set_name(result.get());
				this.view.update_player_name();
				dialog.close();
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setHeaderText("Ce nom est déjà utilisé!");
				alert.setContentText("Merci de changer votre nom!");

				alert.showAndWait();
			}
		}

	}

	public boolean new_name_ok(String name) {
		for (int i=0; i<risk.get_players().length; i++) {
			if (risk.get_players()[i].get_name().equals(name) && !risk.get_players()[i].get_name().equals(risk.get_player_actuelle().get_name())) {
				return false;
			}
		} return true;
	}

}
