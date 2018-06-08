package Controller;

import Core.Controller;
import Model.MissionModel;
import View.MissionView;

public abstract class MissionController extends Controller<MissionModel, MissionView>{

	public MissionController(MissionModel model, MissionView view) {
		super(model, view);
	}
	
	public String get_mission_short_name() {
		return this.model.get_mission_short_name();
	}
	
	public void set_mission_short_name(String name) {
		this.model.set_mission_short_name(name);
	}

	public abstract JoueurController get_player();
	
	public abstract String get_mission_contenu();

	public abstract boolean get_condition_de_complete();

	public abstract void set_mission_contenu(String mission_contenu);

}
