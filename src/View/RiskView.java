package View;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import Controller.JoueurController;
import Core.Risk;
import Core.View;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class RiskView extends View{

	private Stage stage;
	private BorderPane root;
	private Scene scene;
	private Canvas map;
	private VBox pop;
	private HBox bar;
	private String map_path = "./src/View/Images/map.png";

	public RiskView(Stage stage) throws FileNotFoundException {
		super(stage.getWidth(), stage.getHeight());
		this.stage = stage;
		this.root = new BorderPane();
		
		this.map = this.get_map();
		this.bar = this.get_bar();
		
		root.setTop(map);
		root.setBottom(bar);
		
		this.scene = new Scene(root, stage.getWidth(), stage.getHeight(), Color.LIGHTGRAY);
	}
	
	public Canvas get_map() throws FileNotFoundException {
		Canvas canvas = new Canvas();
		canvas.getGraphicsContext2D().drawImage(this.get_map_image(), stage.getWidth()/2, stage.getHeight()/2);
		return canvas;
	}
	
	public HBox get_bar() {
		HBox hbox = new HBox();
		return hbox;
	}
	
	public void set_pop_joueur(JoueurController player) {
		VBox vbox = new VBox();
		Label player_name = new Label(player.get_name());
		
		vbox.getChildren().add(player_name);
		root.setRight(pop);
	}
	
	public Alert get_player_tour_info(JoueurController player) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("C'est le tour de " + player.get_name()); 
		alert.setHeaderText(null);
		alert.setContentText("C'est le tour de " + player.get_name() + "! Merci de ne pas regarder l'écran pour les autres joueur.");
		return alert;
	}
	
	public Scene get_scene() {
		return scene;
	}
	
	public Image get_map_image() throws FileNotFoundException {
		Image image = new Image(new FileInputStream(this.map_path));
		return image;
	}

}
