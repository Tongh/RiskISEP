package Controller;

import Controller.JoueurController;

public interface OccupantChangement{

	public void old_occupant_traitement(JoueurController old_occupant);
	
	public void new_occupant_traitement(JoueurController new_occupant);

	public boolean new_player_s_occupe_toute_la_region(JoueurController new_occupant);

	public void traitement_de_changement_occupant(JoueurController old_occupant, JoueurController new_occupant);

}
