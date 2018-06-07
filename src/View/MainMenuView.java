package View;

import Controller.BoutonEvent.BoutonCreditEvent;
import Controller.BoutonEvent.BoutonExitGameEvent;
import Controller.BoutonEvent.BoutonShadowEvent;
import Core.View;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class MainMenuView extends View{
	private Group root;
	private Scene scene;
	private Button bouton_commencer, bouton_quitter, bouton_credit;
	
	public MainMenuView(double width, double height) {
		super(width, height);
		this.root = new Group();
		this.scene = new Scene(root, width, height, Color.LIGHTGRAY);
		this.initialser_image_bg();
		this.initialiser_bouton();
	}

	private void initialser_image_bg() {
		// TODO Auto-generated method stub
		
	}

	private void initialiser_bouton() {
		root.getChildren().add(this.set_bouton_commencer(this.configurer_bouton("Commencer", width/4, height*4/5)));
		root.getChildren().add(this.bouton_credit = this.configurer_bouton("Credit", width*2/4, height*4/5));
		root.getChildren().add(this.bouton_quitter = this.configurer_bouton("Quitter", width*3/4, height*4/5));
		this.add_event_pour_bouttons();
	}

	private void add_event_pour_bouttons() {
		this.bouton_quitter.addEventHandler(MouseEvent.MOUSE_PRESSED, new BoutonExitGameEvent(this.bouton_quitter));
		this.bouton_credit.addEventHandler(MouseEvent.MOUSE_PRESSED, new BoutonCreditEvent(this.bouton_credit));
	}

	private Button configurer_bouton(String name, double x, double y) {
		Button bouton = new Button(name);
		bouton.setLayoutX(x);
		bouton.setLayoutY(y);
		bouton.addEventHandler(MouseEvent.MOUSE_ENTERED, new BoutonShadowEvent(bouton, new DropShadow(), true));
		bouton.addEventHandler(MouseEvent.MOUSE_EXITED, new BoutonShadowEvent(bouton, false));
		return bouton;
	}

	public Scene get_scene() {
		return scene;
	}

	public Button get_bouton_commencer() {
		return bouton_commencer;
	}

	public Button set_bouton_commencer(Button bouton_commencer) {
		this.bouton_commencer = bouton_commencer;
		return bouton_commencer;
	}

}
