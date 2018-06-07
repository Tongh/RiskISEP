package Controller.BoutonEvent;

import View.JoueurSelectView;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BoutonGameBeginEvent extends BoutonEvent{
	
	private Stage stage;

	public BoutonGameBeginEvent(Button bouton, Stage stage) {
		super(bouton, true);
		this.set_stage(stage);
	}

	@Override
	public void handle(MouseEvent event) {
		stage.setScene(this.get_new_scene());
		stage.show();
	}

	public Stage get_stage() {
		return stage;
	}

	public void set_stage(Stage stage) {
		this.stage = stage;
	}
	
	public Scene get_new_scene() {
		stage.hide();
		JoueurSelectView joueur_select_view = new JoueurSelectView(stage.getWidth(), stage.getHeight(), stage);
		Scene scene = joueur_select_view.get_scene();
		
		return scene;
	}

}
