package Controller.BoutonEvent;

import java.io.FileNotFoundException;
import java.util.Optional;

import Core.Risk;
import View.TourView;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;

public class BoutonFinDeTour implements EventHandler<MouseEvent>{
	
	private TourView tourView;
	private Risk risk;

	public BoutonFinDeTour(TourView tourView, Risk risk) {
		this.tourView = tourView;
		this.risk = risk;
	}

	@Override
	public void handle(MouseEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Vous êtes sûr?"); 
		alert.setHeaderText("Vous allez fini votre tour, et merci de ne pas regarder le tour de les autres joueurs");
		alert.setContentText("Merci de vérifié si vous voulez encore les chose à faire.");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
		    try {
				this.passer_next_tour();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
		    alert.close();
		}
	}

	private void passer_next_tour() throws FileNotFoundException {
		risk.un_tour();
	}

}
