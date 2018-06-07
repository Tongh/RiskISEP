package Controller;

import Core.Controller;
import Model.MapModel;
import View.MapView;

public class MapController extends Controller<MapModel, MapView> {

	
	public MapController() {
		super(new MapModel(), new MapView());
	}
	
	public RegionController [] get_regions() {
		return this.model.get_regions();
	}
	
	public TerritoireController [] get_territoires() {
		return this.model.get_territoires();
	}
	
	public TerritoireController get_territoire_by_name(String name) {
		return this.model.get_territoire_by_name(name);
	}
	
	public int [][] get_adj_territoires_matrix() {
		return this.model.get_adj_territoires_matrix();
	}
	
	public boolean deux_territoires_adj_by_name(String name1, String name2) {
		return this.model.deux_territoires_adj_by_name(name1, name2);
	}
	
	public boolean deux_territoires_adj_by_id(int id1, int id2) {
		return this.model.deux_territoires_adj_by_id(id1, id2);
	}

	@Override
	public void updateView() {
		
	}

	
}
