package View;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import Controller.JoueurController;
import Controller.BoutonEvent.BoutonChangePlayerName;
import Controller.BoutonEvent.BoutonDetailTerritoire;
import Controller.BoutonEvent.BoutonFinDeTour;
import Controller.BoutonEvent.BoutonShadowEvent;
import Core.Risk;
import Core.View;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.DropShadow;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TourView extends View{

	private Stage stage;
	private GridPane root;
	private Scene scene;
	private ImageView map;
	private VBox pop;
	private HBox bar;
	private String map_path = "./src/View/Images/map.png";
	private Button fin_tour = new Button("Fin");
	private Button renfort = new Button("Renfort"); 
	private Button detail = new Button("Détail"); 
	private Button mov = new Button("Mouvement");
	private Button change_name = new Button("Modifier");
	private Button process_mission = new Button("Process");
	private JoueurController player;
	private Label label_player_name;
	private Risk risk; 

	public TourView(Stage stage, JoueurController player, Risk risk) throws FileNotFoundException {
		super(stage.getWidth(), stage.getHeight());
		this.stage = stage;
		this.risk = risk;
		this.player = player;
		this.updateView();
	}
	
	public void updateView() throws FileNotFoundException {
		this.root = new GridPane();
		root.setPadding(new Insets(50, 50, 50, 50));
		root.setHgap(10);
		root.setVgap(10);
		
		this.map = this.get_map();
		this.bar = this.get_bar();
		this.pop = this.get_pop_joueur();
		
		root.add(map, 1, 1);
		root.add(bar, 1, 2);
		root.add(pop, 2, 1);
		
		this.setup_button();
		
		this.scene = new Scene(root, stage.getWidth(), stage.getHeight(), Color.LIGHTGRAY);
	}

	private void setup_button() {
		change_name.addEventHandler(MouseEvent.MOUSE_PRESSED, new BoutonChangePlayerName(player, this, risk));
		change_name.addEventHandler(MouseEvent.MOUSE_ENTERED, new BoutonShadowEvent(change_name, new DropShadow(), true));
		change_name.addEventHandler(MouseEvent.MOUSE_EXITED, new BoutonShadowEvent(change_name, false));
		
		mov.addEventHandler(MouseEvent.MOUSE_ENTERED, new BoutonShadowEvent(mov, new DropShadow(), true));
		mov.addEventHandler(MouseEvent.MOUSE_EXITED, new BoutonShadowEvent(mov, false));
		
		fin_tour.addEventHandler(MouseEvent.MOUSE_PRESSED, new BoutonFinDeTour(this, risk));
		fin_tour.addEventHandler(MouseEvent.MOUSE_ENTERED, new BoutonShadowEvent(fin_tour, new DropShadow(), true));
		fin_tour.addEventHandler(MouseEvent.MOUSE_EXITED, new BoutonShadowEvent(fin_tour, false));
		
		renfort.addEventHandler(MouseEvent.MOUSE_ENTERED, new BoutonShadowEvent(renfort, new DropShadow(), true));
		renfort.addEventHandler(MouseEvent.MOUSE_EXITED, new BoutonShadowEvent(renfort, false));

		detail.addEventHandler(MouseEvent.MOUSE_PRESSED, new BoutonDetailTerritoire(this, risk));
		detail.addEventHandler(MouseEvent.MOUSE_ENTERED, new BoutonShadowEvent(detail, new DropShadow(), true));
		detail.addEventHandler(MouseEvent.MOUSE_EXITED, new BoutonShadowEvent(detail, false));

		process_mission.addEventHandler(MouseEvent.MOUSE_ENTERED, new BoutonShadowEvent(process_mission, new DropShadow(), true));
		process_mission.addEventHandler(MouseEvent.MOUSE_EXITED, new BoutonShadowEvent(process_mission, false));
		
	}

	public ImageView get_map() throws FileNotFoundException {
		ImageView image = new ImageView(this.get_map_image());
		image.setPreserveRatio(true);
		image.setFitHeight(stage.getHeight()-300);
		return image;
	}
	
	public HBox get_bar() {
		HBox hbox = new HBox();
		hbox.setSpacing(stage.getWidth()/6);
		hbox.getChildren().addAll(fin_tour, renfort, mov, detail);
		return hbox;
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

	public Alert get_player_mission_info(JoueurController player) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Votre mission"); 
		alert.setHeaderText(null);
		alert.setContentText("Votre mission est " + player.get_mission().get_mission_contenu() + "!");
		return alert;
	}

	public VBox get_pop_joueur() {
		VBox vbox = new VBox();
		Label vide = new Label();
		vbox.setSpacing(10);
		vbox.setPadding(new Insets(10,10,10,10));
		HBox hbox = new HBox();
		hbox.setSpacing(10);
		hbox.setPadding(new Insets(5, 5, 5, 5));
		Label name = new Label("PLAYER NAME :");
		this.label_player_name = new Label(player.get_name());
		hbox.getChildren().addAll(name, label_player_name, change_name);
		vbox.getChildren().add(hbox);
		hbox = new HBox();
		hbox.setSpacing(10);
		hbox.setPadding(new Insets(5, 5, 5, 5));
		name = new Label("Mission :");
		Label mission = new Label(player.get_mission().get_mission_contenu());
		hbox.getChildren().addAll(name, mission, process_mission);
		vbox.getChildren().add(hbox);
		name = new Label("Territoires");
		vbox.getChildren().add(name);
		VBox vbox_territoire = new VBox();
		vbox_territoire.setSpacing(5);
		vbox_territoire.setPadding(new Insets(5,5,5,5));
		for (int i=0; i<player.get_territoire().size(); i++) {
			hbox = new HBox();
			name = new Label(player.get_territoire().get(i).get_name());
			Label renfort = new Label(player.get_territoire().get(i).get_armee_renfort()+"");
			hbox.getChildren().addAll(name, renfort, vide);
			vbox.getChildren().add(hbox);
		}
		return vbox;
	}
	
	public void update_player_name() {
		this.label_player_name.setText(player.get_name());
	}

}
