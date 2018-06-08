package Controller;

import java.util.ArrayList;

import Core.Controller;
import Model.RegionModel;
import View.RegionView;

public class RegionController extends Controller<RegionModel, RegionView> {
	
	public RegionController(String name) {
		super(new RegionModel(name), new RegionView());
	}
	
	public String get_occupant_name() {
		if (this.model.get_player_occupant() != null) {
			return this.model.get_player_occupant().get_name();
		}
		return "Personne s'occupe cette région";
	}

	public TerritoireController get_territoire_by_name(String name) {
		return this.model.get_territoire_by_name(name);
	}
	
	public ArrayList<TerritoireController> get_territoires() {
		return this.model.get_territoires();
	}
	
	public void set_occupant(JoueurController player) {
		this.model.set_player_occupant(player);
	}
	
	public void add_territoire(TerritoireController controller) {
		this.model.add_territoire(controller);
		//this.view.print_add_terrtoire_status(status, this.model.get_name(), controller.get_name());
		controller.set_region(this);
	}

	public void updateView() {
		this.view.print_details(this.model.get_name(), this.get_occupant_name(), this.get_territoires());
	}
	
}
