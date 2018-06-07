package Controller.BoutonEvent;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public abstract class BoutonEvent implements EventHandler<MouseEvent> {
	
	private Button bouton;
	protected boolean select;
	
	public BoutonEvent(Button bouton, boolean select) {
		this.bouton = bouton;
		this.select = select;
	}

	@Override
	public abstract void handle(MouseEvent event);

	public boolean is_select() {
		return select;
	}

	public void set_select(boolean select) {
		this.select = select;
	}

	public Button get_bouton() {
		return bouton;
	}

	public void set_bouton(Button bouton) {
		this.bouton = bouton;
	}

}
