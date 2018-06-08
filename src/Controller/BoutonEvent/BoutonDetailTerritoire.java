package Controller.BoutonEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Controller.RegionController;
import Controller.TerritoireController;
import Core.Risk;
import View.TourView;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.input.MouseEvent;

public class BoutonDetailTerritoire implements EventHandler<MouseEvent> {

	private TourView tourView;
	private Risk risk;
	
	public BoutonDetailTerritoire(TourView tourView, Risk risk) {
		this.tourView = tourView;
		this.risk = risk;
	}
	@Override
	public void handle(MouseEvent event) {
		get_choix_region();
	}

	private void get_choix_region() {
		RegionController [] regions = this.risk.get_map().get_regions();
		List<String> choices = new ArrayList<>();
		for (int i=0; i<regions.length; i++) {
			choices.add(regions[i].get_name());
		}

		ChoiceDialog<String> dialog = new ChoiceDialog<>(regions[0].get_name(), choices);
		dialog.setTitle("Choisir le région");
		dialog.setHeaderText("Vous voulez savoir les détails sur quel région?");
		dialog.setContentText("Faire votre choix:");

		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
			for (int i=0; i<regions.length; i++) {
				if (result.get() == regions[i].get_name()) {
					this.get_choix_territoire(regions[i]);
				}
			}
		}
	}
	private void get_choix_territoire(RegionController region) {
		ArrayList<TerritoireController> terres = region.get_territoires();
		List<String> choices = new ArrayList<>();
		for (int i=0; i<terres.size(); i++) {
			choices.add(terres.get(i).get_name());
		}

		ChoiceDialog<String> dialog = new ChoiceDialog<>(terres.get(0).get_name(), choices);
		dialog.setTitle("Choisir le territoire");
		dialog.setHeaderText("Vous voulez savoir les détails sur quel territoire?");
		dialog.setContentText("Faire votre choix:");

		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
			for (int i=0; i<terres.size(); i++) {
				if (result.get() == terres.get(i).get_name()) {
					this.show_territoire_detail(terres.get(i));
				}
			}
		}
	}
	private void show_territoire_detail(TerritoireController terre) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information sur " + terre.get_name());
		alert.setHeaderText("Occupant joueur: " + terre.get_occupant().get_name());
		if (terre.get_armees().size() != 0) {
			String soldat = "soldat : " + terre.get_map_armee().get("soldat") + "\n";
			String cavalier = "soldat : " + terre.get_map_armee().get("cavalier") + "\n";
			String canon = "soldat : " + terre.get_map_armee().get("canon") + "\n";
			alert.setContentText(soldat + cavalier + canon);
		} else {
			alert.setContentText("Ce territoire n'a pas d'armée!");
		}

		alert.showAndWait();
		
	}
}
