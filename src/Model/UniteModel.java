package Model;

import java.util.Random;

import Core.Model;

public class UniteModel extends Model {

	private Random rand = new Random();
	protected static int cout;
	protected int priorite_att, priorite_def;
	protected int mouvement;
	protected int puissance_min, puissance_max;
	protected int score;
	protected boolean block;
	protected boolean status;
	
	public UniteModel(int cout, int priorite_att, int priorite_def, int mouvement, int puissance_min, int puissance_max) {
		this.cout = cout;
		this.priorite_att = priorite_att;
		this.priorite_def = priorite_def;
		this.mouvement = mouvement;
		this.puissance_min = puissance_min;
		this.puissance_max = puissance_max;
		this.block = false;
		this.status = true;
		this.name = "unité";
	}
	
	public int get_cout() {
		return this.cout;
	}
	
	public int get_priorite_att() {
		return this.priorite_att;
	}
	
	public int get_priorite_def() {
		return this.priorite_def;
	}
	
	public int get_mouvement() {
		return this.mouvement;
	}
	
	public int get_puissance_min() {
		return this.puissance_min;
	}
	
	public int get_puissance_max() {
		return this.puissance_max;
	}
	
	public int get_score() {
		if (!this.block) {
			this.score = rand.nextInt(this.puissance_max + 1 - this.puissance_min) + this.puissance_min;
			this.close_block();
		} 
		return this.score;
	}
	
	public boolean get_block() {
		return this.block;
	}
	
	public boolean get_status() {
		return this.status;
	}
	
	public void close_block() {
		this.block = true;
	}
	
	public void open_block() {
		this.block = false;
	}
	
	public void detruit() {
		this.status =false;
	}
}
