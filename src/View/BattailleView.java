package View;

import java.io.FileNotFoundException;

import Controller.JoueurController;
import Controller.UniteController;
import Core.View;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BattailleView extends View{

	public BattailleView(double width, double height) {
		super(width, height);
	}

	public void print_details(String name, UniteController [][] combat_list, JoueurController attack_player, JoueurController defence_player, JoueurController victoire_player) {
		System.out.println(name);
		System.out.println(attack_player.get_name() + "\tVS\t" + defence_player.get_name());
		for (int i=0; i<2; i++) {
			String status_att = (combat_list[0][i].get_status()) ? "V" : "X" ;
			String status_def = (combat_list[1][i].get_status()) ? "V" : "X" ;
			System.out.print(combat_list[0][i].get_name() + "\t" + combat_list[0][i].get_score() + "\t[" + status_att + "]\tVS\t");
			System.out.print(combat_list[1][i].get_name() + "\t" + combat_list[1][i].get_score() + "\t[" + status_def + "]" + "\n");
		}
		if (combat_list[0].length == 3) {
			System.out.print(combat_list[0][2].get_name() + "\t" + combat_list[0][2].get_score() + "\t[" + "V" + "]" + "\n");
		}
		System.out.println("Victoire : " + victoire_player.get_name());
		System.out.println();
	}
	
	public void show_stage_battaille(String name, UniteController [][] combat_list, JoueurController attack_player, JoueurController defence_player, JoueurController victoire_player) throws FileNotFoundException {
		Stage stage = new Stage();
		stage.setWidth(900);
		stage.setHeight(600);
		GridPane root = new GridPane();
		root.setVgap(10);
		root.setHgap(10);
		HBox hbox = new HBox();
		Label status = null;
		Label vs = new Label("VS");
		hbox.getChildren().add(new Label(attack_player.get_name()));
		hbox.getChildren().add(vs);
		hbox.getChildren().add(new Label(defence_player.get_name()));
		root.add(hbox, 1, 1);
		for (int i=0; i<2; i++) {
			status = (combat_list[0][i].get_status()) ? new Label("V") : new Label("X");
			VBox vbox = combat_list[0][i].get_unite_vbox();
			Label score = new Label(combat_list[0][i].get_score()+"");
			vbox.getChildren().addAll(status, score);
			hbox = new HBox();
			hbox.getChildren().add(vbox);
			status = (combat_list[1][i].get_status()) ? new Label("V") : new Label("X");
			vbox = combat_list[1][i].get_unite_vbox();
			score = new Label(combat_list[1][i].get_score()+"");
			vbox.getChildren().addAll(status, score);
			hbox.getChildren().add(vs);
			hbox.getChildren().add(vbox);
			root.add(hbox, i+2, 1);
		}
		if (combat_list[0].length == 3) {
			hbox = new HBox();
			VBox vbox = combat_list[0][2].get_unite_vbox();
			status = (combat_list[0][3].get_status()) ? new Label("V") : new Label("X");
			Label score = new Label(combat_list[1][3].get_score() + "");
			vbox.getChildren().addAll(status, score);
			hbox.getChildren().addAll(vbox, new Label(), new Label());
			root.add(hbox, 4, 1);
		}
		hbox = new HBox();
		hbox.getChildren().add(new Label());
		Label victoire = new Label("Victoire: "+victoire_player.get_name());
		hbox.getChildren().add(victoire);
		hbox.getChildren().add(new Label());
		root.add(hbox, 5, 1);
		
		Scene scene = new Scene(root, stage.getWidth(), stage.getHeight());
		stage.setTitle(name);
		stage.show();
	}
}
