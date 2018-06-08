package Model.Missions;

import java.util.Random;

import Controller.JoueurController;
import Model.MissionModel;

public class MissionDetruireXModel extends MissionModel{
	
	private JoueurController target_player;
	private Random rand = new Random();
	
	public MissionDetruireXModel(JoueurController player, JoueurController[] players) {
		super(player);
		this.target_player = this.target_aleatoire(players);
		this.set_mission_contenu("Détruire le joueur [" + this.target_player.get_name() + "]");
	}
	
	private JoueurController target_aleatoire(JoueurController[] players) {
		JoueurController [] list_target = new JoueurController [players.length-1];
		int index = 0;
		for (int i=0; i<players.length; i++) {
			if (!players[i].get_name().equals(this.player.get_name())) {
				list_target[index] = players[i];
				index++;
			}
		}
		JoueurController target = list_target[rand.nextInt(list_target.length)];
		return target;
	}

	public JoueurController get_target_player() {
		return this.target_player;
	}

	@Override
	public boolean get_condition_de_complete() {
		if (this.target_player.get_vivant() == false) {
			return true;
		}
		return false;
	}

	@Override
	public String get_mission_contenu() {
		this.set_mission_contenu("Détruire le joueur [" + this.target_player.get_name() + "]");
		return this.mission_contenu;
	}
	
	
}
