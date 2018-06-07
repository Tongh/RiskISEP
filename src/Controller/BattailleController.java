package Controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import Core.Controller;
import Model.BattailleModel;
import View.BattailleView;

public class BattailleController extends Controller<BattailleModel, BattailleView>{

	public BattailleController(TerritoireController lieu_battaille, TerritoireController lieu_preparer, JoueurController attack_player, JoueurController defence_player, 
										ArrayList<UniteController> attack_unite, ArrayList<UniteController> defence_unite) {
		super(new BattailleModel(lieu_battaille, lieu_preparer, attack_player, defence_player, attack_unite, defence_unite), new BattailleView(900, 600));
	}
	
	public JoueurController get_attack_player() {
		return this.model.get_attack_player();
	}
	
	public JoueurController get_defence_player() {
		return this.model.get_defence_player();
	}
	
	public JoueurController get_victoire_player() {
		return this.model.get_victoire_player();
	}
	
	public UniteController [][] get_combat_list() {
		return this.model.get_combat_list();
	}
	
	public TerritoireController get_lieu_preparer() {
		return this.model.get_lieu_preparer();
	}
	
	public TerritoireController get_lieu_battaille() {
		return this.model.get_lieu_battaille();
	}
	
	public boolean have_captif() {
		return this.model.have_captif();
	}
	
	public boolean attaquant_win() {
		return this.model.attaquant_win();
	}
	
	public void end_battaille() {
		UniteController [][] combat_list = this.get_combat_list();
		for (int i=0; i<combat_list.length; i++) {
			for (int ii=0; ii<combat_list[i].length; ii++) {
				UniteController unite = combat_list[i][ii];
				if (unite.get_status() == true) {
					unite.close_block();
				}
			}
		} 
		this.traitement_unite(combat_list);
	}

	private void traitement_unite(UniteController[][] combat_list) {
		for (int i=0; i<this.get_combat_list().length; i++) {
			JoueurController player = (i == 0) ? this.get_attack_player() : this.get_defence_player();
			TerritoireController territoire = (i == 0) ? this.get_lieu_preparer() : this.get_lieu_battaille();
			for (int ii=0; ii<this.get_combat_list()[i].length; ii++) {
				if (!this.get_combat_list()[i][ii].get_status()) {
					// joueur.remove_unite
					player.remove_armee(this.get_combat_list()[i][ii]);
					// territoire_battaille.remove_unite
					territoire.remove_armee(this.get_combat_list()[i][ii]);
				}
			}
		}
		
		// territoire_battaille.add_unite if attaquant win && territoire_battaille.unite_list vide
		TerritoireController territoire = ((this.have_captif())) ? this.get_lieu_battaille() : this.get_lieu_preparer();
		for (int i=0; i<this.get_combat_list()[0].length; i++) {
			System.out.println(i+"");
			if (this.get_combat_list()[0][i].get_status()) {
				territoire.add_armee(this.get_combat_list()[0][i]);
			}
		}
	}

	@Override
	public void updateView() {
		this.view.print_details(this.get_name(), this.get_combat_list(), this.get_attack_player(), this.get_defence_player(), this.get_victoire_player());
		this.end_battaille();
	}
	
	public void show_stage_bataille() throws FileNotFoundException {
		this.view.show_stage_battaille(this.get_name(), this.get_combat_list(), this.get_attack_player(), this.get_defence_player(), this.get_victoire_player());
	}
}
