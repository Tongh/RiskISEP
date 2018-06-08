package Core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

import Controller.BattailleController;
import Controller.JoueurController;
import Controller.MapController;
import Controller.RegionController;
import Controller.TerritoireController;
import Controller.BoutonEvent.BoutonGameBeginEvent;
import Controller.Unites.CanonController;
import Controller.Unites.CavalierController;
import Controller.Unites.SoldatController;
import View.LoadingView;
import View.MainMenuView;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class InitCore extends Application{

	private Random rand = new Random();
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		this.main_jeu(stage);
		
		// this.test_bataille();
	}

	private void main_jeu(Stage stage) throws FileNotFoundException {
		this.set_stage(stage);
		this.set_load_view(stage);
	}

	private void set_stage(Stage stage) throws FileNotFoundException {
		/* configurer l'icon en bar menu */
		this.set_icon(stage);
		
		/* configurer la fenetre toujours plus grand en fonction de la taille du screen de l'ordinateur */
		Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
		stage.setX(bounds.getMinX());
		stage.setY(bounds.getMinY());
		stage.setWidth(bounds.getWidth());
		stage.setHeight(bounds.getHeight());
		
		/* interdir reformer la fenetre */
		stage.setResizable(false);
	}

	private void set_load_view(Stage stage) throws FileNotFoundException {
		Scene scene = new LoadingView(stage.getWidth(), stage.getHeight()).get_scene();
		
		/* Press any key to continue */
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() { /* Press any key */
			@Override
			public void handle(KeyEvent event) {
				set_main_menu(stage);
			}
		});
		scene.setOnMousePressed(new EventHandler<MouseEvent>() { /* if press mouse */
			@Override
			public void handle(MouseEvent event) {
				set_main_menu(stage);
			}
		});
		stage.setTitle("RiskISEP");
		stage.setScene(scene);
		stage.show();
	}
	
	public void set_icon(Stage stage) throws FileNotFoundException {
		stage.getIcons().add(new Image(new FileInputStream("./src/View/Images/icon.png")));
	}
	
	public void set_main_menu(Stage stage) {
		MainMenuView main_view = new MainMenuView(stage.getWidth(), stage.getHeight());
		Scene scene = main_view.get_scene();
		main_view.get_bouton_commencer().addEventHandler(MouseEvent.MOUSE_PRESSED, new BoutonGameBeginEvent(main_view.get_bouton_commencer(), stage));
		stage.setScene(scene);
		stage.show();
	}
	
	public void test_bataille() throws FileNotFoundException {
		JoueurController player1 = new JoueurController("Wenxiao", false);
		JoueurController player2 = new JoueurController("Tianyang", false);
		
		MapController map = new MapController();
		for (int i=0; i<map.get_territoires().length; i++) {
			if (rand.nextInt(2) == 0) {
				map.get_territoires()[i].set_occupant(player1);
			} else {
				map.get_territoires()[i].set_occupant(player2);
			}
		}
		
		TerritoireController territoire = map.get_territoire_by_name("la France");
		TerritoireController territoire_venir = map.get_territoire_by_name("l'Italie");
		
		SoldatController soldat = new SoldatController();
		CavalierController cavalier = new CavalierController();
		CanonController canon = new CanonController();
		player1.add_armee(canon);
		player1.add_armee(cavalier);
		player1.add_armee(soldat);
		soldat = new SoldatController();
		cavalier = new CavalierController();
		canon = new CanonController();
		player2.add_armee(canon);
		player2.add_armee(cavalier);
		
		BattailleController battle = new BattailleController(player1.get_territoire().get(0), player2.get_territoire().get(0), player1, player2, player1.get_armees(), player2.get_armees());
		battle.updateView();
		battle.show_stage_bataille();
	}
	
	
}
