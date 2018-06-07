package Core;

import Controller.JoueurController;
import Controller.Unites.SoldatController;

public class ArmeeDistribue {

	private JoueurController player;
	private int renfort;

	public ArmeeDistribue(JoueurController player) {
		this.player = player;
		this.renfort = this.player.get_renfort();
		this.gerer_armee();
	}

	private void gerer_armee() {
		// TODO Auto-generated method stub
		
	}

	private void initialiser_armee() {
		int i = 0; // get by UI
		while (this.renfort > 0) {
			int nmber = 10; // get by UI
			for (int ii=0; ii<nmber; ii++) {
				SoldatController armee = new SoldatController();
				this.player.add_armee(armee);
				this.player.get_territoire().get(i).add_armee(armee);
			}
			i++;
			this.renfort -= 10;
		}
	}
	
	

}
