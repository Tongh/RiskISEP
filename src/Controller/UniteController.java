package Controller;

import java.io.FileNotFoundException;

import Core.Controller;
import Model.UniteModel;
import View.UniteView;
import javafx.scene.layout.VBox;

public class UniteController extends Controller<UniteModel, UniteView>{

	public UniteController(UniteModel model, UniteView view) {
		super(model, view);
	}
	
	public int get_cout() {
		return this.model.get_cout();
	}
	
	public int get_priorite_att() {
		return this.model.get_priorite_att();
	}
	
	public int get_priorite_def() {
		return this.model.get_priorite_def();
	}
	
	public int get_mouvement() {
		return this.model.get_mouvement();
	}
	
	public int get_puissance_min() {
		return this.model.get_puissance_min();
	}
	
	public int get_puissance_max() {
		return this.model.get_puissance_max();
	}
	
	public int get_score() {
		return this.model.get_score();
	}
	
	public boolean get_block() {
		return this.model.get_block();
	}
	
	public boolean get_status() {
		return  this.model.get_status();
	}
	
	public VBox get_unite_vbox() throws FileNotFoundException {
		return this.view.get_unite_vbox(this.get_name());
	}
	
	public void open_block() {
		this.model.open_block();
	}
	
	public void close_block() {
		this.model.close_block();
	}
	
	public void detruit() {
		this.model.detruit();
	}
	
	public void updateView() {
		this.view.print_details(this.get_name(), this.get_score(), this.get_status());
	}
	
	public void show_info_stage() throws FileNotFoundException {
		this.view.show_unite_stage(this.get_name(), this.get_status());
	}
}
