package Core;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import Controller.JoueurController;
import Controller.MapController;
import Controller.Unites.SoldatController;
import View.TourView;
import javafx.stage.Stage;

public class Risk {
	
	private int nombre_player, nombre_IA;
	private JoueurController [] players;
	private ArrayList<JoueurController> players_vivant;
	private MapController map;
	private Stage stage;
	private TourView view;
	private JoueurController player_actuelle;

	public Risk(int nb_player, int nb_AI, int nb_terre, Stage stage) throws FileNotFoundException {
		
		this.stage = stage;
		// Affiche
		this.nombre_player = nb_player;
		this.nombre_IA = nb_AI;
		int nombre_de_territoire_initial = nb_terre;
		
		// combien de joueur et IA !! il faut demander user dans UI
		this.players = new JoueurController [this.nombre_player];
		this.players_vivant = new ArrayList<JoueurController>();
		
		// player initialiser;
		for (int i=0; i<nb_player; i++) {
			JoueurController player;
			if (i<(this.nombre_player - this.nombre_IA)) {
				player = new JoueurController("player" + i, false);
			} else {
				player = new JoueurController("player" + i, true);
			}
			this.players[i] = player;
			this.players_vivant.add(player);
		}
		
		// map initialiser
		this.map = new MapController();
		
		// Mission Atribue pour nombre_player avec tous les players
		new MissionAtribue(this.nombre_player, this.players);
		
		// territoiresdistribués
		new TerritoireDistribue(this.players, this.map, nombre_de_territoire_initial);
		
		// tous les joueurs recoit les armées 
		this.armee_distribue(nombre_de_territoire_initial);
		
		/* show image et UI */
		stage.close();
		
		// this.view.get_scene();
		
		/*
		 * JEU COMMENCE ICI
		 * */
		this.main_jeu();
	}
	
	private void armee_distribue(int nb_terre) {
		int renfort = 40 - (this.nombre_player - 2) * 5;
		for (int i=0; i<this.players.length; i++) {
			this.players[i].add_renfort(renfort-nb_terre);
			for (int ii=0; ii<nb_terre; ii++) {
				this.players[i].get_territoire().get(ii).add_armee(new SoldatController());
			}
		}
		
	}

	public void main_jeu() throws FileNotFoundException {
		this.player_actuelle = this.players_vivant.get(nombre_player - 1);
		this.un_tour();
		
		/*while (!fin) {
			/*
			 * MAIN BODY
			 
			// changer le valeur de player_acuttuel
			boolean fin = false;
			this.player_actuelle = this.tour_de_qui(this.player_actuelle);
			this.view.get_player_tour_info(this.player_actuelle).showAndWait();
			this.view.set_pop_joueur(player_actuelle);
			
			// player comsomer son renfort
			new ArmeeDistribue(this.player_actuelle);
			
			// player mouvement
			boolean tour_fin = false;
			while (!tour_fin) {
				this.player_mouvement(this.player_actuelle);
				// if (click tour fin by UI) tour_fin = true;
			}
			// tour fini
			
			// si il y a quelqu'un est mort
			this.quelqu_un_est_mort();
			
			// si il y a quelqu'un est win
			if  (this.quelqu_un_est_win() != null) {
				fin = true;
				System.out.println(this.quelqu_un_est_win());
			}
		}*/
	}

	private void quelqu_un_est_mort() {
		for (int i=0; i<this.players_vivant.size(); i++) {
			if (this.players_vivant.get(i).get_territoire().size() == 0) {
				this.players_vivant.get(i).mourir();
				this.players_vivant.remove(this.players_vivant.get(i));
			}
		}
	}
	
	public JoueurController tour_de_qui(JoueurController player_actuelle) {
		int index = 0;
		for (int i=0; i<this.players_vivant.size(); i++) {
			if (this.players_vivant.get(i).equals(player_actuelle)) {
				if (i == this.players_vivant.size()-1) {
					index = 0;
				} else {
					index = i + 1;
				}
			}
		}
		return this.players_vivant.get(index);
	}
	
	public void set_player_actuelle(JoueurController player) {
		this.player_actuelle = player;
	}

	private JoueurController quelqu_un_est_win() {
		for (int i=0; i<this.players_vivant.size(); i++) {
			if (this.players_vivant.get(i).get_mission().get_condition_de_complete()) {
				return this.players_vivant.get(i);
			}
		}
		return null;
	}
	
	public JoueurController get_player_actuelle() {
		return this.player_actuelle;
	}
	
	public JoueurController [] get_players() {
		return this.players;
	}
	
	public TourView get_view() {
		return this.view;
	}
	
	public void set_view(TourView view) {
		this.view = view;
	}
	
	public void un_tour() throws FileNotFoundException {
		this.player_actuelle = this.tour_de_qui(this.player_actuelle);
		this.view = new TourView(stage, this.player_actuelle, this);
		this.stage.setScene(this.view.get_scene());
		stage.show();
		this.view.get_player_tour_info(this.player_actuelle).showAndWait();
		this.view.get_player_mission_info(this.player_actuelle).showAndWait();
	}
	
	public MapController get_map() {
		return this.map;
	}
}
