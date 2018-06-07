package Controller.BoutonEvent;

import java.io.FileNotFoundException;

import Core.Risk;
import View.JoueurSelectView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BoutonJeuCommenceEvent implements EventHandler<MouseEvent>{

	private int nb_player, nb_AI, nb_terre;
	private JoueurSelectView scene_precedent;
	private Stage stage;

	public BoutonJeuCommenceEvent(JoueurSelectView scene_precedent, Stage stage) {
		this.scene_precedent = scene_precedent;
		this.stage = stage;
	}

	@Override
	public void handle(MouseEvent event) {
		this.set_nb_AI(scene_precedent.get_AI());
		this.set_nb_player(scene_precedent.get_player());
		this.set_nb_terre(Integer.parseInt(scene_precedent.get_nombre_terre_field().getText().trim()));
		
		try {
			new Risk(this.nb_player, this.nb_AI, this.nb_terre, this.stage);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public int get_nb_player() {
		return nb_player;
	}

	public void set_nb_player(int nb_player) {
		this.nb_player = nb_player;
	}

	public int get_nb_AI() {
		return nb_AI;
	}

	public void set_nb_AI(int nb_AI) {
		this.nb_AI = nb_AI;
	}

	public int get_nb_terre() {
		return nb_terre;
	}

	public void set_nb_terre(int nb_terre) {
		this.nb_terre = nb_terre;
	}

}
