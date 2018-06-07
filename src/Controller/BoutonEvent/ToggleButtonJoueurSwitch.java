package Controller.BoutonEvent;

import javafx.scene.control.ToggleButton;

public class ToggleButtonJoueurSwitch extends ToggleButton {
	public ToggleButtonJoueurSwitch(String name) {
		super(name);
		this.setUserData(name);
	}
}
