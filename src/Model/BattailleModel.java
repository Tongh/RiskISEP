package Model;

import java.util.ArrayList;

import Controller.JoueurController;
import Controller.TerritoireController;
import Controller.UniteController;
import Core.Model;

public class BattailleModel extends Model{

	private ArrayList<UniteController> attack_unite, defence_unite;
	private JoueurController attack_player, defence_player, victoire_player;
	private TerritoireController lieu_battaille, lieu_preparer;
	private UniteController [][] combat_list;
	
	public BattailleModel(TerritoireController lieu_battaille, TerritoireController lieu_preparer, JoueurController attack_player, JoueurController defence_player, 
									ArrayList<UniteController> attack_unite, ArrayList<UniteController> defence_unite) {
		this.lieu_battaille = lieu_battaille;
		this.lieu_preparer = lieu_preparer;
		this.attack_player = attack_player;
		this.defence_player = defence_player;
		this.attack_unite = attack_unite;
		this.defence_unite = defence_unite;
		this.set_name("Battaille de " + lieu_battaille.get_name());
		this.lieu_preparer_remove_unite();
		this.combat_list = this.fight_global();
		this.who_is_win();
		this.marquer_captive_next_term();
	}

	public TerritoireController get_lieu_battaille() {
		return this.lieu_battaille;
	}
	
	public TerritoireController get_lieu_preparer() {
		return this.lieu_preparer;
	}
	
	public JoueurController get_attack_player() {
		return this.attack_player;
	}
	
	public JoueurController get_defence_player() {
		return this.defence_player;
	}
	
	public JoueurController get_victoire_player() {
		return this.victoire_player;
	}

	public UniteController[][] get_combat_list() {
		return this.combat_list;
	}
	
	public boolean have_captif() {
		boolean tous_kill = true;
		for (int i=0; i<this.lieu_battaille.get_armees().size(); i++) {
			if (this.lieu_battaille.get_armees().get(i).get_status()) {
				tous_kill = false;
			}
		}
		return (this.attaquant_win() && tous_kill);
	}
	
	public boolean attaquant_win() {
		return this.attack_player == this.victoire_player;
	}

	private void lieu_preparer_remove_unite() {
		for (int i=0; i<this.attack_unite.size(); i++) {
			this.lieu_preparer.remove_armee(this.attack_unite.get(i));
		}
	}
	
	private void marquer_captive_next_term() {
		if (this.have_captif()) {
			this.lieu_battaille.set_occupant(attack_player);
			this.attack_player.add_captif_marque();
		}
	}
	
	private UniteController [] selectionner_defence_unite() {
		UniteController [] res_defence_list = new UniteController [2];
		boolean condition = false;
		int priorite_def = 0, index = 0;
		while (condition == false) {
			priorite_def++;
			for (int i=0; i<this.defence_unite.size(); i++) {
				if (this.defence_unite.get(i).get_priorite_def() == priorite_def) {
					if (index < 2) {
						res_defence_list[index] = this.defence_unite.get(i);
						index++;
					}
				}
			}
			if (index == 2) {
				break;
			}
			condition = (index > 1) ? true : false;
			condition = (this.defence_unite.size() < 2) ? true : false;
		}
		return res_defence_list;
	}
	
	private UniteController [][] generer_combat_list() {
		UniteController [] attack_list = new UniteController [this.attack_unite.size()];
		UniteController [][] combat_list = new UniteController [2][];
		for (int i=0; i<this.attack_unite.size(); i++) {
			attack_list[i] = this.attack_unite.get(i);
		}
		combat_list[0] = attack_list;
		combat_list[1] = this.selectionner_defence_unite();
		return combat_list;
	}
	
	private UniteController [] permuter(UniteController [] tab, int i, int j) {
		UniteController tmp = tab[i];
		tab[i] = tab[j];
		tab[j] = tmp;
		return tab;
	}
	
	private int indiceMax(UniteController [] tab, int rang, boolean attaquant) {
		int indice = rang;
		for (int i=rang;i<tab.length;i++) {
			if (tab[i].get_score() > tab[indice].get_score()) {
				indice = i;
			} else if (tab[i].get_score() == tab[indice].get_score()) {
				if (attaquant) {
					if (tab[i].get_priorite_att() < tab[indice].get_priorite_att()) {
						indice = i;
					}
				} else {
					if (tab[i].get_priorite_def() < tab[indice].get_priorite_def()) {
						indice = i;
					}
				}
			}
		} return indice;
	}
	
	private UniteController[] triParSelection(UniteController [] tab, boolean attaquant) {
		for (int i=0; i<tab.length; i++) {
			int indice = indiceMax(tab, i, attaquant);
			if (i != indice) {
				tab = permuter(tab, i, indice);
			}
		} return tab;
	}
	
	private UniteController [][] re_ordre_list(UniteController [][] tmp_list) {
		UniteController [][] list = new UniteController [2][];
		list[0] = this.triParSelection(tmp_list[0], true);
		list[1] = this.triParSelection(tmp_list[1], false);
		return list;
	}
	
	private boolean fight(UniteController att, UniteController def) {
		return (att.get_score() > def.get_score()) ? true : false;
	}
	
	private UniteController [][] fight_global() {
		UniteController [][] combat_list = this.generer_combat_list();
		combat_list = this.re_ordre_list(combat_list);
		for (int i=0; i<2; i++) {
			if (fight(combat_list[0][i], combat_list[1][i])) {
				combat_list[1][i].detruit();
			} else {
				combat_list[0][i].detruit();
			}
		}
		return combat_list;
	}
	
	private void who_is_win() {
		this.victoire_player = this.attack_player;
		for (int i=0; i<this.combat_list[1].length; i++) {
			if (this.combat_list[1][i].get_status() == true) {
				this.victoire_player = this.defence_player;
			}
		}
	}
}
