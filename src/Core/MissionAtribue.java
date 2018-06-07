package Core;

import java.util.Random;

import Controller.JoueurController;
import Controller.Missions.MissionDetruireXController;
import Controller.Missions.MissionDixHuitTerritoiresController;
import Controller.Missions.MissionPlusGrandeRegionController;
import Controller.Missions.MissionTousTerritoiresController;
import Controller.Missions.MissionTrenteTerritoiresController;
import Controller.Missions.MissionTroisRegionController;
import Controller.Missions.MissionVingtEtUnTerritoiresController;
import Controller.Missions.MissionVingtQuatreTerritoiresController;

public class MissionAtribue{

	private Random rand = new Random();
	private int nombre_player;
	private JoueurController [] players;

	public MissionAtribue(int nombre_player, JoueurController [] players) {
		this.players = players;
		this.nombre_player = nombre_player;
		
		// en fonction de nombre_player, quels sont les mission peut choisir
		int [] list_id_permission = this.get_list_id_permission(this.nombre_player);
		
		// for () pour chancun une mission
		for (int i=0; i<this.nombre_player; i++) {
			// this.attribue_mission_à();
			this.attribue_mission_à(this.players[i], list_id_permission, this.players);
		}
	}
	
	private int[] get_list_id_permission(int nombre_player) {
		int [] result = null;
		switch (nombre_player) {
		case (2): {
			result = new int [] {1, 2, 4, 7};
			break;
		}
		case (3): {
			result = new int [] {0, 1, 2, 3, 4, 7};
			break;
		}
		case (4): {
			result = new int [] {0, 2, 3, 5, 7};
			break;
		}
		case (5): {
			result = new int [] {0, 2, 3, 5, 7};
			break;
		}
		case (6): {
			result = new int [] {0, 2, 3, 6, 7};
			break;
		}
		}
		return result;
	}

	public void attribue_mission_à(JoueurController player, int [] list_id_permission, JoueurController [] players) {
		// aleatoire dans list
		int id = list_id_permission[rand.nextInt(list_id_permission.length)];
		
		// this.get_mission_by_id
		this.get_mission_by_id(player, id, players);
	}

	private void get_mission_by_id(JoueurController player, int id, JoueurController [] players) {
		switch (id) {
		case (0): {
			MissionDetruireXController mission = new MissionDetruireXController(player, players);
			player.set_mission(mission);
			break;
		}
		case (1): {
			MissionTousTerritoiresController mission = new MissionTousTerritoiresController(player);
			player.set_mission(mission);
			break;
		}
		case (2): {
			MissionTroisRegionController mission = new MissionTroisRegionController(player);
			player.set_mission(mission);
			break;
		}
		case (3): {
			MissionDixHuitTerritoiresController mission = new MissionDixHuitTerritoiresController(player);
			player.set_mission(mission);
			break;
		}
		case (4): {
			MissionTrenteTerritoiresController mission = new MissionTrenteTerritoiresController(player);
			player.set_mission(mission);
			break;
		}
		case (5): {
			MissionVingtQuatreTerritoiresController mission = new MissionVingtQuatreTerritoiresController(player);
			player.set_mission(mission);
			break;
		}
		case (6): {
			MissionVingtEtUnTerritoiresController mission = new MissionVingtEtUnTerritoiresController(player);
			player.set_mission(mission);
			break;
		}
		case (7): {
			MissionPlusGrandeRegionController mission = new MissionPlusGrandeRegionController(player);
			player.set_mission(mission);
			break;
		}
		}
	}
}
