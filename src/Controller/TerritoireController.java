package Controller;

import java.util.ArrayList;
import java.util.HashMap;

import Core.Controller;
import Model.TerritoireModel;
import View.TerritoireView;

public class TerritoireController extends Controller<TerritoireModel, TerritoireView> implements OccupantChangement{
	
	private boolean region_occupant_status;

	public TerritoireController(int id) {
		super(new TerritoireModel(id), new TerritoireView());
		this.region_occupant_status = false;
	}
	
	public TerritoireController(String name, int id) {
		super(new TerritoireModel(name, id), new TerritoireView());
		this.region_occupant_status = false;
	}
	
	public JoueurController get_occupant() {
		return this.model.get_player_occupant();
	}
	
	public int get_id() {
		return this.model.get_id();
	}

	public ArrayList<UniteController> get_armees() {
		return this.model.get_armee();
	}
	
	public RegionController get_region() {
		return this.model.get_region();
	}
	
	public boolean occupant_region_have_change() {
		return this.region_occupant_status;
	}
	
	public HashMap<String, Integer> get_map_armee() {
		return this.model.get_map_armee();
	}
	
	public int get_armee_renfort() {
		return this.model.get_armee_renfort();
	}
	
	public boolean have_occupant() {
		return this.model.have_occupant();
	}
	
	public void set_occupant(JoueurController occupant) {
		String old_name;
		if (this.get_occupant() == null) {
			old_name = "Personne";
		} else {
			old_name = this.get_occupant().get_name();
		}
		this.view.territoire_occupant_changer(old_name, occupant.get_name(), this.get_name());
		this.traitement_de_changement_occupant(this.get_occupant(), occupant);
		if (this.occupant_region_have_change()) {
			this.view.region_occupant_changer(this.model.get_region().get_name(), this.model.get_region().get_occupant_name());
		}
		this.region_occupant_status = false;
	}
	
	public void set_region(RegionController controller) {
		this.model.set_region(controller);
	}
	
	public void add_armee(UniteController unite) {
		this.model.add_armee(unite);
	}
	
	public void remove_armee(UniteController unite) {
		this.model.remove_armee(unite);
	}

	@Override
	public void updateView() {
		this.view.print_details(this.model.get_name(),this.get_occupant(), this.get_armees());
		
	}

	@Override
	public void old_occupant_traitement(JoueurController old_occupant) {
		// old_player.remove();
		old_occupant.remove_territoire(this);
		this.model.set_player_occupant(null);
		
		// old_player.region_changer?
		// old_player.regions have this.lieu.get_region?
		if (old_occupant.get_regions().contains(this.model.get_region())) {
			// old_player.remove_region
			old_occupant.remove_region(this.model.get_region());
			this.model.get_region().set_occupant(null);
			this.region_occupant_status = true;
		} else {
			// rien changer
		}
	}

	@Override
	public void new_occupant_traitement(JoueurController new_occupant) {
		// new_player.add();
		new_occupant.add_territoire(this);
		this.model.set_player_occupant(new_occupant);
		
		// new_player.region_changer?
		// this.lieu.get_region.get_territoires, tous s'occuper par new_player?
		if (this.new_player_s_occupe_toute_la_region(new_occupant)) {
			// new_player.add_region
			new_occupant.add_region(this.model.get_region());
			this.model.get_region().set_occupant(new_occupant);
			this.region_occupant_status = true;
		} else {
			// rien changer
		}
	}

	@Override
	public boolean new_player_s_occupe_toute_la_region(JoueurController new_occupant) {
		ArrayList<TerritoireController> toute_la_region = this.model.get_region().get_territoires();
		for (int i=0; i<toute_la_region.size(); i++) {
			if (toute_la_region.get(i).get_occupant() == null || !toute_la_region.get(i).get_occupant().equals(new_occupant)) {
				return false;
			}
		} return true;
	}

	@Override
	public void traitement_de_changement_occupant(JoueurController old_occupant, JoueurController new_occupant) {
		if (old_occupant != null) {
			this.old_occupant_traitement(old_occupant);
		}
		this.new_occupant_traitement(new_occupant);
	}
}
