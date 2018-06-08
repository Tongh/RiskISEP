package View;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import Controller.JoueurController;
import Controller.BoutonEvent.BoutonChangePlayerName;
import Controller.BoutonEvent.BoutonDetailMission;
import Controller.BoutonEvent.BoutonDetailTerritoire;
import Controller.BoutonEvent.BoutonFinDeTour;
import Controller.BoutonEvent.BoutonGetRenfort;
import Controller.BoutonEvent.BoutonShadowEvent;
import Controller.BoutonEvent.BoutonUpdateTerritoirePop;
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
	private GridPane pop;
	private HBox bar;
	private String map_path = "./src/View/Images/map.png";
	private Button fin_tour = new Button("Fin");
	private Button renfort = new Button("Renfort"); 
	private Button detail = new Button("Détail"); 
	private Button mov = new Button("Mouvement");
	private Button change_name = new Button("Modifier");
	private Button process_mission = new Button("Mission");
	private Button update_terre_detail = new Button("Update");
	private JoueurController player;
	private Label label_player_name;
	private Risk risk;
	private Label renfort_label;
	private Label renfort_reste_label;
	private Label mission_label;
	private Label mission_contenu;
	private Label territoire_label; 

	public TourView(Stage stage, JoueurController player, Risk risk) throws FileNotFoundException {
		super(stage.getWidth(), stage.getHeight());
		this.stage = stage;
		this.risk = risk;
		this.risk.get_player_actuelle().cal_renfort();
		this.player = player;
		this.updateView();
	}
	
	public void updateView() throws FileNotFoundException {
		this.root = new GridPane();
		root.setPadding(new Insets(20, 20, 20, 20));
		root.setHgap(10);
		root.setVgap(10);
		
		this.set_map();
		this.set_bar();
		this.set_pop();
		
		
		this.setup_button();
		
		this.scene = new Scene(root, stage.getWidth(), stage.getHeight(), Color.LIGHTGRAY);
	}

	private void set_pop() {
		this.pop = this.get_pop_joueur();
		root.add(pop, 2, 1);
	}
	
	public void update_pop() {
		this.set_pop();
		this.scene = new Scene(root, stage.getWidth(), stage.getHeight(), Color.LIGHTGRAY);
	}

	private void set_bar() {
		this.bar = this.get_bar();
		root.add(bar, 1, 2);
	}

	private void set_map() throws FileNotFoundException {
		this.map = this.get_map();
		root.add(map, 1, 1);
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

		renfort.addEventHandler(MouseEvent.MOUSE_PRESSED, new BoutonGetRenfort(this, risk));
		renfort.addEventHandler(MouseEvent.MOUSE_ENTERED, new BoutonShadowEvent(renfort, new DropShadow(), true));
		renfort.addEventHandler(MouseEvent.MOUSE_EXITED, new BoutonShadowEvent(renfort, false));

		detail.addEventHandler(MouseEvent.MOUSE_PRESSED, new BoutonDetailTerritoire(risk));
		detail.addEventHandler(MouseEvent.MOUSE_ENTERED, new BoutonShadowEvent(detail, new DropShadow(), true));
		detail.addEventHandler(MouseEvent.MOUSE_EXITED, new BoutonShadowEvent(detail, false));

		process_mission.addEventHandler(MouseEvent.MOUSE_PRESSED, new BoutonDetailMission(risk));
		process_mission.addEventHandler(MouseEvent.MOUSE_ENTERED, new BoutonShadowEvent(process_mission, new DropShadow(), true));
		process_mission.addEventHandler(MouseEvent.MOUSE_EXITED, new BoutonShadowEvent(process_mission, false));
		
		update_terre_detail.addEventHandler(MouseEvent.MOUSE_PRESSED, new BoutonUpdateTerritoirePop(this, risk));
		update_terre_detail.addEventHandler(MouseEvent.MOUSE_ENTERED, new BoutonShadowEvent(update_terre_detail, new DropShadow(), true));
		update_terre_detail.addEventHandler(MouseEvent.MOUSE_EXITED, new BoutonShadowEvent(update_terre_detail, false));
		
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

	public GridPane get_pop_joueur() {
		GridPane pop_pane = new GridPane();
		pop_pane.setPadding(new Insets(10,10,10,10));
		pop_pane.setHgap(10);
		
		this.label_player_name = new Label(player.get_name());
		pop_pane.add(label_player_name, 1, 0);
		pop_pane.add(change_name, 3, 0);
		
		renfort_label= new Label("Renfort :");
		renfort_reste_label = new Label(player.get_renfort()+"");
		pop_pane.add(renfort_label, 0, 1);
		pop_pane.add(renfort_reste_label, 1, 1);
		
		mission_label = new Label("Mission :");
		mission_contenu = new Label(player.get_mission().get_mission_short_name());
		pop_pane.add(mission_label, 0, 2);
		pop_pane.add(mission_contenu, 1, 2, 2, 1);
		pop_pane.add(process_mission, 3, 2);
		
		territoire_label = new Label("Territoires");
		pop_pane.add(territoire_label, 0, 3, 3, 1);
		pop_pane.add(update_terre_detail, 3, 3);
		
		HashMap<String, Integer> terres_data = this.player.get_map_terrtoire();
		
		int i = 4;
		for (Map.Entry<String, Integer> entry: terres_data.entrySet()) {
			Label territoire_name = new Label(entry.getKey());
			Label renfort = new Label(entry.getValue()+"");
			pop_pane.add(territoire_name, 0, i, 2, 1);
			pop_pane.add(renfort, 3, i);
			i++;
		}
		
		return pop_pane;
	}
	
	public void update_player_name() {
		this.label_player_name.setText(player.get_name());
	}
	
	public Stage get_stage() {
		return this.stage;
	}

}
