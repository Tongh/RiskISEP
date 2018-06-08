package Controller.BoutonEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Controller.RegionController;
import Controller.TerritoireController;
import Core.Risk;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.input.MouseEvent;

public class BoutonDetailTerritoire implements EventHandler<MouseEvent> {

	private Risk risk;
	
	public BoutonDetailTerritoire(Risk risk) {
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
					if (this.can_we_show_info(terres.get(i))) {
						this.show_territoire_detail(terres.get(i));
					} else {
						this.champs_visuel_warning(terres.get(i));
					}
				}
			}
		}
	}

	private void champs_visuel_warning(TerritoireController terre) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Warning!");
		alert.setHeaderText("Ce territoire [" + terre.get_name() + "] n'est pas dans votre champs visuel!");
		alert.setContentText("Si vous voulez savoir les détail sur ce territoire, vous dévez s'occuper un des territoires à proximité de [" + terre.get_name() + "]!");

		alert.showAndWait();
	}
	
	private boolean can_we_show_info(TerritoireController terre) {
		for (int i=0; i<risk.get_player_actuelle().get_territoire().size(); i++) {
			if (risk.get_map().deux_territoires_adj(risk.get_player_actuelle().get_territoire().get(i), terre)) {
				return true;
			}
		} return false;
	}
	
	private void show_territoire_detail(TerritoireController terre) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information sur " + terre.get_name());
		alert.setHeaderText("Occupant joueur: " + terre.get_occupant().get_name());
		if (terre.get_armees().size() != 0) {
			String soldat = "soldat : " + terre.get_map_armee().get("soldat") + "\n";
			String cavalier = "cavalier : " + terre.get_map_armee().get("cavalier") + "\n";
			String canon = "canon : " + terre.get_map_armee().get("canon") + "\n";
			alert.setContentText(soldat + cavalier + canon);
		} else {
			alert.setContentText("Ce territoire n'a pas d'armée!");
		}

		alert.showAndWait();
		
	}
}
