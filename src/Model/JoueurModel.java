package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import Controller.MissionController;
import Controller.RegionController;
import Controller.TerritoireController;
import Controller.UniteController;
import Core.Model;

public class JoueurModel extends Model{

	private Random rand = new Random();
	private ArrayList<UniteController> armees;
	private ArrayList<RegionController> regions;
	private ArrayList<TerritoireController> territoires;
	private MissionController mission;
	private int captif_marque;
	private boolean vivant;
	private boolean IA;
	private int renfort;
	
	public JoueurModel(String name, boolean IA) {
		this.name = name;
		this.armees = new ArrayList<UniteController>();
		this.territoires = new ArrayList<TerritoireController>();
		this.regions = new ArrayList<RegionController>();
		this.captif_marque = 0;
		this.vivant = true;
		this.IA = IA;
		this.renfort = 0;
	}
	
	public boolean get_vivant() {
		return this.vivant;
	}
	
	public boolean il_est_IA() {
		return this.IA;
	}
	
	public MissionController get_mission() {
		return this.mission;
	}
	
	public ArrayList<UniteController> get_armee() {
		return this.armees;
	}
	
	public ArrayList<TerritoireController> get_territoires() {
		return this.territoires;
	}
	
	public ArrayList<RegionController> get_regions() {
		return this.regions;
	}
	
	public int get_captif_marque() {
		return this.captif_marque;
	}
	
	public HashMap<String, Integer> get_map_territoire() {
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		for (int i=0; i<this.get_territoires().size(); i++) {
			result.put(this.get_territoires().get(i).get_name(), this.get_territoires().get(i).get_armee_renfort());
		}
		return result;
	}
	
	public void cal_renfort() {
		this.add_renfort(this.territoires.size()/3 + 1);
		if (this.regions.size() != 0) {
			for (int i=0; i<this.regions.size(); i++) {
				this.add_renfort(this.regions.get(i).get_territoires().size()/2 + 1);
			}
		}
		this.add_renfort(this.get_nombre_captif());
	}
	
	private int get_nombre_captif() {
		int res = 0;
		for (int i=0; i<this.captif_marque; i++) {
			if (this.rand.nextInt(2) == 1) {
				res++;
			}
		}
		return res;
	}
	
	public void set_IA(boolean IA) {
		this.IA = IA;
	}
	
	public void mourir() {
		this.vivant = false;
	}
	
	public void set_mission(MissionController mission) {
		this.mission = mission;
	}
	
	public void add_armee(UniteController unite) {
		this.armees.add(unite);
	}

	public void remove_armee(UniteController unite) {
		this.armees.remove(unite);
	}
	
	public void add_territoire(TerritoireController controller) {
		this.territoires.add(controller);
	}
	
	public void remove_territoire(TerritoireController controller) {
		this.territoires.remove(controller);
	}
	
	public void add_region(RegionController controller) {
		this.regions.add(controller);
	}
	
	public void remove_region(RegionController controller) {
		this.regions.remove(controller);
	}

	public void add_captif_marque() {
		this.captif_marque++;
	}

	public int get_renfort() {
		return renfort;
	}

	public void add_renfort(int benefice) {
		this.renfort += benefice;
	}

	public void remove_renfort(int consome) {
		this.renfort -= consome;
	}
}
