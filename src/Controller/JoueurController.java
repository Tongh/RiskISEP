package Controller;

import java.util.ArrayList;

import Core.Controller;
import Model.JoueurModel;
import View.JoueurView;

public class JoueurController extends Controller<JoueurModel, JoueurView>{

	public JoueurController(String name, boolean IA) {
		super(new JoueurModel(name, IA), new JoueurView());
	}
	
	public boolean get_vivant() {
		return this.model.get_vivant();
	}
	
	public MissionController get_mission() {
		return this.model.get_mission();
	}
	
	public ArrayList<UniteController> get_armees() {
		return this.model.get_armee();
	}
	
	public ArrayList<RegionController> get_regions() {
		return this.model.get_regions();
	}
	
	public ArrayList<TerritoireController> get_territoire() {
		return this.model.get_territoires();
	}
	
	public int get_captif_marque() {
		return this.model.get_captif_marque();
	}
	
	public int get_renfort() {
		return this.model.get_renfort();
	}
	
	public void add_renfort(int benefice) {
		this.model.add_renfort(benefice);
	}
	
	public void remove_renfort(int consome) {
		this.model.remove_renfort(consome);
	}
	
	public void cal_renfort() {
		this.model.cal_renfort();
	}
	
	public void mourir() {
		this.model.mourir();
	}
	
	public void set_mission(MissionController mission) {
		this.model.set_mission(mission);
	}
	
	public void add_armee(UniteController unite) {
		this.model.add_armee(unite);
	}
	
	public void remove_armee(UniteController unite) {
		this.model.remove_armee(unite);
	}
	
	public void add_territoire(TerritoireController controller) {
		this.model.add_territoire(controller);
	}
	
	public void remove_territoire(TerritoireController controller) {
		this.model.remove_territoire(controller);
	}
	
	public void add_region(RegionController controller) {
		this.model.add_region(controller);
	}
	
	public void remove_region(RegionController controller) {
		this.model.remove_region(controller);
	}

	public void add_captif_marque() {
		this.model.add_captif_marque();
	}
	
	public void updateView() {
		view.print_details(model.get_name(), this.get_armees().size(), this.get_captif_marque());
	}
	
}
