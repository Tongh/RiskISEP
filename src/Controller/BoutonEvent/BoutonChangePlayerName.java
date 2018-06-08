package Controller.BoutonEvent;

import java.util.Optional;

import Controller.JoueurController;
import View.TourView;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;

public class BoutonChangePlayerName implements EventHandler<MouseEvent>{
	
	private JoueurController player;
	private TourView view;

	public BoutonChangePlayerName(JoueurController player, TourView tourView) {
		this.player = player;
		this.view = tourView;
	}

	@Override
	public void handle(MouseEvent event) {
		TextInputDialog dialog = new TextInputDialog("");
		dialog.setTitle("Changer le nom de joueur");
		dialog.setHeaderText(null);
		dialog.setContentText("Insérez votre nom du joueur: ");

		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
		    System.out.println("Your name: " + result.get());
		    System.out.println(player.get_name());
		}

		result.ifPresent(name -> player.set_name(name));
		System.out.println(player.get_name());
		this.view.update_player_name();
		dialog.close();
	}

}
