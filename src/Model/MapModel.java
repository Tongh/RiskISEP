package Model;

import Controller.RegionController;
import Controller.TerritoireController;
import Core.Model;

public class MapModel extends Model {
	
	private RegionController EURUPE, ASIE, AMQN, AMQS, OCEAN, AFRIC;
	private RegionController [] regions;
	private TerritoireController [] territoires;
	private int [][] adj_territoires_matrix;

	public MapModel() {
		this.initialiser_map();
	}
	
	public RegionController [] get_regions() {
		return this.regions;
	}
	
	public TerritoireController [] get_territoires() {
		return this.territoires;
	}
	
	public TerritoireController get_terrioitre_by_id(int id) {
		for (int i=0; i<this.territoires.length; i++) {
			if (this.territoires[i].get_id() == id) {
				return this.territoires[i];
			}
		} return null;
	}
	
	public TerritoireController get_territoire_by_name(String name) {
		for (int i=0; i<this.territoires.length; i++) {
			if (this.territoires[i].get_name().equals(name)) {
				return this.territoires[i];
			}
		} return null;
	}
	
	public boolean deux_territoires_adj_by_id(int id1, int id2) {
		if (this.adj_territoires_matrix[id1][id2] == 1) {
			return true;
		} return false;
	}
	
	public boolean deux_territoires_adj_by_name(String name1, String name2) {
		return (this.deux_territoires_adj_by_id(this.get_territoire_by_name(name1).get_id(), this.get_territoire_by_name(name2).get_id()));
	}
	
	public boolean deux_territoires_adj(TerritoireController terre1, TerritoireController terre2) {
		return (this.deux_territoires_adj_by_id(terre1.get_id(), terre2.get_id()));
	}
	
	public int [][] get_adj_territoires_matrix() {
		return this.adj_territoires_matrix;
	}
	
	private void initialiser_map() {
		// initialiser regions
		this.regions_initialiser();
		// initialiser territoires
		this.territoire_initialiser();
		// lien entre territoires
		this.set_adj_territoires_matrix();
	}

	private void set_adj_territoires_matrix() {
		this.adj_territoires_matrix = new int [42][42];
		// Europe
		this.set_arete(1, new int [] {0, 2, 4, 41});
		this.set_arete(41, new int [] {1, 4, 21, 5});
		this.set_arete(2, new int [] {1, 4, 5, 3, 0});
		this.set_arete(4, new int [] {1, 41, 2,});
		this.set_arete(0, new int [] {1, 11, 2, 3});
		this.set_arete(3, new int [] {10, 0, 2, 5, 39});
		this.set_arete(5, new int [] {4, 2, 3, 39, 29, 35});
		// Afrique
		this.set_arete(11, new int [] {0, 12, 10, 6, 9});
		this.set_arete(10, new int [] {3, 39, 11, 9});
		this.set_arete(9, new int [] {10, 11, 6, 7, 8, 39});
		this.set_arete(6, new int [] {11, 9, 7});
		this.set_arete(8, new int [] {9, 7});
		this.set_arete(7, new int [] {6, 9, 8});
		// Amérique du sud
		this.set_arete(15, new int [] {14, 12});
		this.set_arete(12, new int [] {13, 14, 15, 11});
		this.set_arete(14, new int [] {12, 13, 15});
		this.set_arete(13, new int [] {12, 14, 22});
		// Amérique du nord
		this.set_arete(16, new int [] {37, 17, 18});
		this.set_arete(18, new int [] {16, 17, 19, 23});
		this.set_arete(22, new int [] {13, 23, 24});
		this.set_arete(24, new int [] {22, 23, 19, 20});
		this.set_arete(21, new int [] {17, 19, 20, 41});
		this.set_arete(17, new int [] {16, 18, 19, 21});
		this.set_arete(19, new int [] {17, 18, 20, 41, 23, 24});
		this.set_arete(20, new int [] {41, 19, 24});
		this.set_arete(23, new int [] {18, 19, 24, 22});
		// Oceanie
		this.set_arete(28, new int [] {26, 27});
		this.set_arete(25, new int [] {26, 27, 40});
		this.set_arete(26, new int [] {25, 28, 27});
		this.set_arete(27, new int [] {25, 26, 28});
		// Asie
		this.set_arete(29, new int [] {5, 39, 32, 30, 35});
		this.set_arete(30, new int [] {29, 31, 32, 34, 35, 40});
		this.set_arete(32, new int [] {29, 39, 30, 40});
		this.set_arete(36, new int [] {31, 34, 33, 37});
		this.set_arete(38, new int [] {31, 37});
		this.set_arete(37, new int [] {38, 31, 36, 33, 16});
		this.set_arete(39, new int [] {5, 29, 32, 9, 10, 3});
		this.set_arete(31, new int [] {30, 34, 36, 37});
		this.set_arete(40, new int [] {25, 32, 30});
		this.set_arete(34, new int [] {35, 30, 31, 36, 33});
		this.set_arete(35, new int [] {5, 29, 30, 34});
		this.set_arete(33, new int [] {34, 36, 37});
	}

	private void set_arete(int x, int [] y) {
		for (int i=0; i<y.length; i++) {
			this.adj_territoires_matrix[x][y[i]] = 1;
		}
	}

	private void create_new_territoire(String territoire_name, RegionController region, int id) {
	    TerritoireController territoireController = new TerritoireController(territoire_name, id);
	    this.territoires[id] = territoireController;
	    region.add_territoire(territoireController);
	}
	
	private void new_territoire_in_the(RegionController region) {
		if (this.EURUPE.equals(region)) {
			this.create_new_territoire("la France", region, 0);
			this.create_new_territoire("le Royaume-Uni", region, 1);
			this.create_new_territoire("l'Allemagne", region, 2);
			this.create_new_territoire("l'Italie", region, 3);
			this.create_new_territoire("la Suède", region, 4);
			this.create_new_territoire("la Russie de l'ouest", region, 5);
			this.create_new_territoire("l'Islande", region, 41);
		} else if (this.AFRIC.equals(region)) {
			this.create_new_territoire("le Congo", region, 6);
			this.create_new_territoire("l'Afrique du sud", region, 7);
			this.create_new_territoire("Madagascar", region, 8);
			this.create_new_territoire("l'Ethiopie", region, 9);
			this.create_new_territoire("l'Egypte", region, 10);
			this.create_new_territoire("l'Algérie", region, 11);
		} else if (this.AMQS.equals(region)) {
			this.create_new_territoire("le Brésil", region, 12);
			this.create_new_territoire("La Guyane", region, 13);
			this.create_new_territoire("le Pérou", region, 14);
			this.create_new_territoire("l'Argentine", region, 15);
		} else if (this.AMQN.equals(region)) {
			this.create_new_territoire("l'Alaska", region, 16);
			this.create_new_territoire("le Canada du nord", region, 17);
			this.create_new_territoire("le Canada du sud", region, 18);
			this.create_new_territoire("le Canada du Centre", region, 19);
			this.create_new_territoire("le Canada de l'est", region, 20);
			this.create_new_territoire("le Groenland", region, 21);
			this.create_new_territoire("le Mexique", region, 22);
			this.create_new_territoire("les Etats-Unis de l'ouest", region, 23);
			this.create_new_territoire("les Etats-Unis de l'est", region, 24);
		} else if (this.OCEAN.equals(region)) {
			this.create_new_territoire("l'Indonésie", region, 25);
			this.create_new_territoire("la Nouvelle-Guinée", region, 26);
			this.create_new_territoire("l'Australie de l'ouest", region, 27);
			this.create_new_territoire("l'Australie de l'est", region, 28);
		} else {
			this.create_new_territoire("le Kazakhstan", region, 29);
			this.create_new_territoire("la Chine", region, 30);
			this.create_new_territoire("la Mongolie", region, 31);
			this.create_new_territoire("l'Inde", region, 32);
			this.create_new_territoire("le Plateau de Sibérie centrale", region, 33);
			this.create_new_territoire("la Plaine de Sibérie occidentale", region, 34);
			this.create_new_territoire("la Plaine d'Europe orientale", region, 35);
			this.create_new_territoire("la Russie du sud", region, 36);
			this.create_new_territoire("la Russie de l'est", region, 37);
			this.create_new_territoire("le Japon", region, 38);
			this.create_new_territoire("le Moyen-Orient", region, 39);
			this.create_new_territoire("le Vietnam", region, 40);
		}
	}
	
	private void territoire_initialiser() {
		this.territoires = new TerritoireController [42];
		this.new_territoire_in_the(this.EURUPE);
		this.new_territoire_in_the(this.AFRIC);
		this.new_territoire_in_the(this.AMQN);
		this.new_territoire_in_the(this.AMQS);
		this.new_territoire_in_the(this.OCEAN);
		this.new_territoire_in_the(this.ASIE);
	}

	private RegionController create_new_region(String region_name) {
		RegionController regionController = new RegionController(region_name);
		return regionController;
	}

	private void regions_initialiser() {
		this.regions = new RegionController [6];
		this.regions[0] = this.EURUPE = this.create_new_region("Europe");
		this.regions[1] = this.ASIE = this.create_new_region("Asie");
		this.regions[2] = this.AMQN = this.create_new_region("Amérique du Nord");
		this.regions[3] = this.AMQS = this.create_new_region("Amérique du Sud");
		this.regions[4] = this.OCEAN = this.create_new_region("Océanie");
		this.regions[5] = this.AFRIC = this.create_new_region("Afrique");
	}
}
