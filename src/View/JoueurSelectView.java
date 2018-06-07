package View;

import Controller.BoutonEvent.BoutonJeuCommenceEvent;
import Controller.BoutonEvent.BoutonShadowEvent;
import Controller.BoutonEvent.ToggleButtonJoueurSwitch;
import Core.View;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class JoueurSelectView extends View{

	public static int nb_player = 6;
	public static int nb_AI = 0;
	private HBox hbox_root;
	private Group root;
	private Scene scene;
	private ToggleGroup switch_player1, AI_player1;
	private ToggleGroup switch_player2, AI_player2;
	private ToggleGroup switch_player3, AI_player3;
	private ToggleGroup switch_player4, AI_player4;
	private ToggleGroup switch_player5, AI_player5;
	private ToggleGroup switch_player6, AI_player6;
	private TextField nombre_territoire;

	public JoueurSelectView(double width, double height, Stage stage) {
		super(width, height);
		this.root = new Group();
		this.hbox_root = new HBox();
		this.hbox_root.setPadding(new Insets(50, 50, 50, 50));
		this.hbox_root.setSpacing(100);

		VBox vbox_player1 = new VBox();
		vbox_player1.setSpacing(20);
		vbox_player1.getChildren().add(new Label("Joueur 1"));
		
		this.switch_player1 =  new ToggleGroup();
		HBox hbox1_player1 = new HBox();
		ToggleButtonJoueurSwitch btn1 = new ToggleButtonJoueurSwitch("Joueur On");
		ToggleButtonJoueurSwitch btn2 = new ToggleButtonJoueurSwitch("Joueur fermé");
		btn1.setToggleGroup(this.switch_player1);
		btn2.setToggleGroup(this.switch_player1);
		btn1.setSelected(true);
		hbox1_player1.getChildren().add(btn1);
		hbox1_player1.getChildren().add(btn2);

		this.AI_player1 = new ToggleGroup();
		HBox hbox2_player1 = new HBox();
		btn1 = new ToggleButtonJoueurSwitch("IA fermé");
		btn2 = new ToggleButtonJoueurSwitch("IA simple");
		ToggleButtonJoueurSwitch btn3 = new ToggleButtonJoueurSwitch("IA Avancé");
		btn1.setToggleGroup(AI_player1);
		btn2.setToggleGroup(AI_player1);
		btn3.setToggleGroup(AI_player1);
		btn1.setSelected(true);
		hbox2_player1.getChildren().addAll(btn1, btn2, btn3);
		
		vbox_player1.getChildren().add(hbox1_player1);
		vbox_player1.getChildren().add(hbox2_player1);
		
		hbox_root.getChildren().add(vbox_player1);
		
		VBox vbox_player2 = new VBox();
		vbox_player2.setSpacing(20);
		vbox_player2.getChildren().add(new Label("Joueur 2"));
		
		this.switch_player2 =  new ToggleGroup();
		HBox hbox1_player2 = new HBox();
		btn1 = new ToggleButtonJoueurSwitch("Joueur On");
		btn2 = new ToggleButtonJoueurSwitch("Joueur fermé");
		btn1.setToggleGroup(this.switch_player2);
		btn2.setToggleGroup(this.switch_player2);
		btn1.setSelected(true);
		hbox1_player2.getChildren().add(btn1);
		hbox1_player2.getChildren().add(btn2);

		this.AI_player2 = new ToggleGroup();
		HBox hbox2_player2 = new HBox();
		btn1 = new ToggleButtonJoueurSwitch("IA fermé");
		btn2 = new ToggleButtonJoueurSwitch("IA simple");
		btn3 = new ToggleButtonJoueurSwitch("IA Avancé");
		btn1.setToggleGroup(AI_player2);
		btn2.setToggleGroup(AI_player2);
		btn3.setToggleGroup(AI_player2);
		btn1.setSelected(true);
		hbox2_player2.getChildren().addAll(btn1, btn2, btn3);
		
		vbox_player2.getChildren().add(hbox1_player2);
		vbox_player2.getChildren().add(hbox2_player2);
		hbox_root.getChildren().add(vbox_player2);
		
		VBox vbox_player3 = new VBox();
		vbox_player3.setSpacing(20);
		vbox_player3.getChildren().add(new Label("Joueur 3"));
		
		this.switch_player3 =  new ToggleGroup();
		HBox hbox1_player3 = new HBox();
		btn1 = new ToggleButtonJoueurSwitch("Joueur On");
		btn2 = new ToggleButtonJoueurSwitch("Joueur fermé");
		btn1.setToggleGroup(this.switch_player3);
		btn2.setToggleGroup(this.switch_player3);
		btn1.setSelected(true);
		hbox1_player3.getChildren().add(btn1);
		hbox1_player3.getChildren().add(btn2);

		this.AI_player3 = new ToggleGroup();
		HBox hbox2_player3 = new HBox();
		btn1 = new ToggleButtonJoueurSwitch("IA fermé");
		btn2 = new ToggleButtonJoueurSwitch("IA simple");
		btn3 = new ToggleButtonJoueurSwitch("IA Avancé");
		btn1.setToggleGroup(AI_player3);
		btn2.setToggleGroup(AI_player3);
		btn3.setToggleGroup(AI_player3);
		btn1.setSelected(true);
		hbox2_player3.getChildren().addAll(btn1, btn2, btn3);
		
		vbox_player3.getChildren().add(hbox1_player3);
		vbox_player3.getChildren().add(hbox2_player3);
		
		hbox_root.getChildren().add(vbox_player3);
		
		VBox vbox_player4 = new VBox();
		vbox_player4.setSpacing(20);
		vbox_player4.getChildren().add(new Label("Joueur 4"));
		
		this.switch_player4 =  new ToggleGroup();
		HBox hbox1_player4 = new HBox();
		btn1 = new ToggleButtonJoueurSwitch("Joueur On");
		btn2 = new ToggleButtonJoueurSwitch("Joueur fermé");
		btn1.setToggleGroup(this.switch_player4);
		btn2.setToggleGroup(this.switch_player4);
		btn1.setSelected(true);
		hbox1_player4.getChildren().add(btn1);
		hbox1_player4.getChildren().add(btn2);

		this.AI_player4 = new ToggleGroup();
		HBox hbox2_player4 = new HBox();
		btn1 = new ToggleButtonJoueurSwitch("IA fermé");
		btn2 = new ToggleButtonJoueurSwitch("IA simple");
		btn3 = new ToggleButtonJoueurSwitch("IA Avancé");
		btn1.setToggleGroup(AI_player4);
		btn2.setToggleGroup(AI_player4);
		btn3.setToggleGroup(AI_player4);
		btn1.setSelected(true);
		hbox2_player4.getChildren().addAll(btn1, btn2, btn3);
		
		vbox_player4.getChildren().add(hbox1_player4);
		vbox_player4.getChildren().add(hbox2_player4);
		hbox_root.getChildren().add(vbox_player4);
		
		VBox vbox_player5 = new VBox();
		vbox_player5.setSpacing(20);
		vbox_player5.getChildren().add(new Label("Joueur 5"));
		
		this.switch_player5 =  new ToggleGroup();
		HBox hbox1_player5 = new HBox();
		btn1 = new ToggleButtonJoueurSwitch("Joueur On");
		btn2 = new ToggleButtonJoueurSwitch("Joueur fermé");
		btn1.setToggleGroup(this.switch_player5);
		btn2.setToggleGroup(this.switch_player5);
		btn1.setSelected(true);
		hbox1_player5.getChildren().add(btn1);
		hbox1_player5.getChildren().add(btn2);

		this.AI_player5 = new ToggleGroup();
		HBox hbox2_player5 = new HBox();
		btn1 = new ToggleButtonJoueurSwitch("IA fermé");
		btn2 = new ToggleButtonJoueurSwitch("IA simple");
		btn3 = new ToggleButtonJoueurSwitch("IA Avancé");
		btn1.setToggleGroup(AI_player5);
		btn2.setToggleGroup(AI_player5);
		btn3.setToggleGroup(AI_player5);
		btn1.setSelected(true);
		hbox2_player5.getChildren().addAll(btn1, btn2, btn3);
		
		vbox_player5.getChildren().add(hbox1_player5);
		vbox_player5.getChildren().add(hbox2_player5);
		hbox_root.getChildren().add(vbox_player5);
		
		VBox vbox_player6 = new VBox();
		vbox_player6.setSpacing(20);
		vbox_player6.getChildren().add(new Label("Joueur 6"));
		
		this.switch_player6 =  new ToggleGroup();
		HBox hbox1_player6 = new HBox();
		btn1 = new ToggleButtonJoueurSwitch("Joueur On");
		btn2 = new ToggleButtonJoueurSwitch("Joueur fermé");
		btn1.setToggleGroup(this.switch_player6);
		btn2.setToggleGroup(this.switch_player6);
		btn1.setSelected(true);
		hbox1_player6.getChildren().add(btn1);
		hbox1_player6.getChildren().add(btn2);

		this.AI_player6 = new ToggleGroup();
		HBox hbox2_player6 = new HBox();
		btn1 = new ToggleButtonJoueurSwitch("IA fermé");
		btn2 = new ToggleButtonJoueurSwitch("IA simple");
		btn3 = new ToggleButtonJoueurSwitch("IA Avancé");
		btn1.setToggleGroup(AI_player6);
		btn2.setToggleGroup(AI_player6);
		btn3.setToggleGroup(AI_player6);
		btn1.setSelected(true);
		hbox2_player6.getChildren().addAll(btn1, btn2, btn3);
		
		vbox_player6.getChildren().add(hbox1_player6);
		vbox_player6.getChildren().add(hbox2_player6);
		hbox_root.getChildren().add(vbox_player6);
		
		this.switch_player1.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			private String old;
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				if (newValue != null) {
					if (newValue.getUserData().equals("Joueur On") && !newValue.getUserData().equals(old)) {
						old = newValue.getUserData().toString();
						JoueurSelectView.nb_player++;
					} else if (newValue.getUserData().equals("Joueur fermé") && !newValue.getUserData().equals(old)){
						JoueurSelectView.nb_player--;
						old = newValue.getUserData().toString();
					}
				}
			}	
		});
		
		this.switch_player2.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			private String old;
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				if (newValue != null) {
					if (newValue.getUserData().equals("Joueur On") && !newValue.getUserData().equals(old)) {
						old = newValue.getUserData().toString();
						JoueurSelectView.nb_player++;
					} else if (newValue.getUserData().equals("Joueur fermé") && !newValue.getUserData().equals(old)){
						JoueurSelectView.nb_player--;
						old = newValue.getUserData().toString();
					}
				}
			}	
		});
		
		this.switch_player3.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			private String old;
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				if (newValue != null) {
					if (newValue.getUserData().equals("Joueur On") && !newValue.getUserData().equals(old)) {
						old = newValue.getUserData().toString();
						JoueurSelectView.nb_player++;
					} else if (newValue.getUserData().equals("Joueur fermé") && !newValue.getUserData().equals(old)){
						JoueurSelectView.nb_player--;
						old = newValue.getUserData().toString();
					}
				}
			}	
		});
		
		this.switch_player4.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			private String old;
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				if (newValue != null) {
					if (newValue.getUserData().equals("Joueur On") && !newValue.getUserData().equals(old)) {
						old = newValue.getUserData().toString();
						JoueurSelectView.nb_player++;
					} else if (newValue.getUserData().equals("Joueur fermé") && !newValue.getUserData().equals(old)){
						JoueurSelectView.nb_player--;
						old = newValue.getUserData().toString();
					}
				}
			}	
		});
		
		this.switch_player5.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			private String old;
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				if (newValue != null) {
					if (newValue.getUserData().equals("Joueur On") && !newValue.getUserData().equals(old)) {
						old = newValue.getUserData().toString();
						JoueurSelectView.nb_player++;
					} else if (newValue.getUserData().equals("Joueur fermé") && !newValue.getUserData().equals(old)){
						JoueurSelectView.nb_player--;
						old = newValue.getUserData().toString();
					}
				}
			}	
		});
		
		this.switch_player6.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			private String old;
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				if (newValue != null) {
					if (newValue.getUserData().equals("Joueur On") && !newValue.getUserData().equals(old)) {
						old = newValue.getUserData().toString();
						JoueurSelectView.nb_player++;
					} else if (newValue.getUserData().equals("Joueur fermé") && !newValue.getUserData().equals(old)){
						JoueurSelectView.nb_player--;
						old = newValue.getUserData().toString();
					}
				}
			}	
		});
		
		this.AI_player1.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			private String old = "IA fermé";
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				if (newValue != null) {
					if (!newValue.getUserData().equals("IA fermé") && old.equals("IA fermé")) {
						old = newValue.getUserData().toString();
						JoueurSelectView.nb_AI++;
					} else if (newValue.getUserData().equals("IA fermé") && !old.equals("IA fermé")){
						JoueurSelectView.nb_AI--;
						old = newValue.getUserData().toString();
					}
				}
			}	
		});
		
		this.AI_player2.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			private String old = "IA fermé";
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				if (newValue != null) {
					if (!newValue.getUserData().equals("IA fermé") && old.equals("IA fermé")) {
						old = newValue.getUserData().toString();
						JoueurSelectView.nb_AI++;
					} else if (newValue.getUserData().equals("IA fermé") && !old.equals("IA fermé")){
						JoueurSelectView.nb_AI--;
						old = newValue.getUserData().toString();
					}
				}
			}	
		});
		
		this.AI_player3.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			private String old = "IA fermé";
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				if (newValue != null) {
					if (!newValue.getUserData().equals("IA fermé") && old.equals("IA fermé")) {
						old = newValue.getUserData().toString();
						JoueurSelectView.nb_AI++;
					} else if (newValue.getUserData().equals("IA fermé") && !old.equals("IA fermé")){
						JoueurSelectView.nb_AI--;
						old = newValue.getUserData().toString();
					}
				}
			}	
		});
		
		this.AI_player4.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			private String old = "IA fermé";
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				if (newValue != null) {
					if (!newValue.getUserData().equals("IA fermé") && old.equals("IA fermé")) {
						old = newValue.getUserData().toString();
						JoueurSelectView.nb_AI++;
					} else if (newValue.getUserData().equals("IA fermé") && !old.equals("IA fermé")){
						JoueurSelectView.nb_AI--;
						old = newValue.getUserData().toString();
					}
				}
			}	
		});
		
		this.AI_player5.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			private String old = "IA fermé";
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				if (newValue != null) {
					if (!newValue.getUserData().equals("IA fermé") && old.equals("IA fermé")) {
						old = newValue.getUserData().toString();
						JoueurSelectView.nb_AI++;
					} else if (newValue.getUserData().equals("IA fermé") && !old.equals("IA fermé")){
						JoueurSelectView.nb_AI--;
						old = newValue.getUserData().toString();
					}
				}
			}	
		});
		
		this.AI_player6.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			private String old = "IA fermé";
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				if (newValue != null) {
					if (!newValue.getUserData().equals("IA fermé") && old.equals("IA fermé")) {
						old = newValue.getUserData().toString();
						JoueurSelectView.nb_AI++;
					} else if (newValue.getUserData().equals("IA fermé") && !old.equals("IA fermé")){
						JoueurSelectView.nb_AI--;
						old = newValue.getUserData().toString();
					}
				}
			}	
		});
		
		this.nombre_territoire = new TextField();
		this.nombre_territoire.setText("7");
		this.nombre_territoire.setPromptText("Nombre de territoires initiales");
		this.nombre_territoire.setTooltip(new Tooltip("Nombre de territoires initiales"));
		this.nombre_territoire.setPrefColumnCount(20);
		this.nombre_territoire.setMinWidth(50);
		
		Button bouton_nb_terre = new Button("Appliquer");
		bouton_nb_terre.addEventHandler(MouseEvent.MOUSE_ENTERED, new BoutonShadowEvent(bouton_nb_terre, new DropShadow(), true));
		bouton_nb_terre.addEventHandler(MouseEvent.MOUSE_EXITED, new BoutonShadowEvent(bouton_nb_terre, false));
		
		
		bouton_nb_terre.addEventHandler(MouseEvent.MOUSE_PRESSED, new BoutonJeuCommenceEvent(this, stage));
		
		HBox hbox_nb_terre = new HBox();
		hbox_nb_terre.getChildren().addAll(this.nombre_territoire, bouton_nb_terre);
		hbox_nb_terre.setPadding(new Insets(10, 10, 10, 10));
		hbox_nb_terre.setSpacing(30);
		
		VBox vbox_root = new VBox();
		vbox_root.getChildren().addAll(hbox_root, hbox_nb_terre);
		root.getChildren().add(vbox_root);
		this.scene = new Scene(root, width, height, Color.LIGHTGRAY);
	}

	public Scene get_scene() {
		return this.scene;
	}
	
	public int get_AI() {
		return JoueurSelectView.nb_AI;
	}
	
	public int get_player() {
		return JoueurSelectView.nb_player;
	}
	
	public TextField get_nombre_terre_field() {
		return this.nombre_territoire;
	}
}
