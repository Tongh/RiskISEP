package Controller.BoutonEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Controller.TerritoireController;
import Controller.UniteController;
import Controller.Unites.CanonController;
import Controller.Unites.CavalierController;
import Controller.Unites.SoldatController;
import Core.Risk;
import Model.Unites.SoldatModel;
import View.TourView;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;

public class BoutonGetRenfort implements EventHandler<MouseEvent> {

	
	private TourView tourView;
	private Risk risk;

	public BoutonGetRenfort(TourView tourView, Risk risk) {
		this.tourView = tourView;
		this.risk = risk;
	}
	
	@Override
	public void handle(MouseEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Choix de renfort");
		alert.setHeaderText("Vous voulez quel type de renfort?\nVous restez encore " + get_renfort() + " points des renforts");
		alert.setContentText("Faire votre choix:");

		ButtonType buttonTypeOne = new ButtonType("Soldat");
		ButtonType buttonTypeTwo = new ButtonType("Cavalier");
		ButtonType buttonTypeThree = new ButtonType("Canon");
		ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

		alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree, buttonTypeCancel);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeOne){
			if (get_renfort() < new SoldatController().get_cout()) {
				this.show_warning();
			} else {
				this.choix_nb(new SoldatController().get_cout());
			}
		} else if (result.get() == buttonTypeTwo) {
			if (get_renfort() < new CavalierController().get_cout()) {
				this.show_warning();
			} else {
				this.choix_nb(new CavalierController().get_cout());
			}
		} else if (result.get() == buttonTypeThree) {
			if (get_renfort() < new CanonController().get_cout()) {
				this.show_warning();
			} else {
				this.choix_nb(new CanonController().get_cout());
			}
		} else {
		    alert.close();
		}
	}

	private void choix_nb(int cout) {
		TextInputDialog dialog = new TextInputDialog("1");
		dialog.setTitle("Choix des renforts");
		dialog.setHeaderText(null);
		dialog.setContentText("Insérez combien vous voulez");

		// Traditional way to get the response value.
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
			int taper = Integer.parseInt(result.get().trim());
			int consomme = taper * cout;
			if (consomme > get_renfort()) {
				show_warning();
			} else {
				risk.get_player_actuelle().remove_renfort(consomme);
				for (int i=0; i<taper; i++) {
					UniteController unite;
					if (cout == new SoldatController().get_cout()) {
						unite = new SoldatController();
					} else if (cout == new CavalierController().get_cout()) {
						unite = new CavalierController();
					} else {
						unite = new CanonController();
					}
					risk.get_player_actuelle().add_armee(unite);
					this.placer_ou(unite);
				}
			}
		}

		
	}

	private void placer_ou(UniteController unite) {
		ArrayList<TerritoireController> terres = risk.get_player_actuelle().get_territoire();
		List<String> choices = new ArrayList<>();
		for (int i=0; i<terres.size(); i++) {
			choices.add(terres.get(i).get_name());
		}

		ChoiceDialog<String> dialog = new ChoiceDialog<>(terres.get(0).get_name(), choices);
		dialog.setTitle("Choisir le territoire");
		dialog.setHeaderText("Vous voulez placer ce nouveau " + unite.get_name() + " dans votre quel territoire?");
		dialog.setContentText("Faire votre choix:");

		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
			for (int i=0; i<terres.size(); i++) {
				if (result.get() == terres.get(i).get_name()) {
					this.set_unite_territoire(terres.get(i), unite);
				}
			}
		}
	}

	private void set_unite_territoire(TerritoireController terre, UniteController unite) {
		terre.add_armee(unite);
	}

	private void show_warning() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Warning!");
		alert.setHeaderText("Votre points des renforts restés ne sont pas suffisant!");
		alert.setContentText("Merci de vérifier votre choix");

		alert.showAndWait();
	}

	private int get_renfort() {
		return risk.get_player_actuelle().get_renfort();
	}
}
