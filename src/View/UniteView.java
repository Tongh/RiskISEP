package View;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import Core.View;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UniteView extends View{
	
	private String path = "./src/View/Images/";

	public UniteView() {
		super(300, 300);
	}

	public void print_details(String name, int score, boolean status) {
		System.out.println("Unite: ");
		System.out.println("Name: " + name);
		System.out.println("Score: " + score);
		String string = (status) ? "Vécu" : "Détruit!";
		System.out.println("Status: " + string);
		System.out.println();
	}
	
	public void show_unite_stage(String name, boolean status) throws FileNotFoundException {
		Stage stage = new Stage();
		stage.setWidth(500);
		stage.setHeight(500);
		GridPane root = new GridPane();
		root.setPadding(new Insets(5));
		root.setHgap(10);
		root.setVgap(10);
		
		Image img = new Image(new FileInputStream(this.path + name + ".png"));
		ImageView image = new ImageView(img);
		
		final VBox vbox = new VBox();
		vbox.getChildren().add(image);

		Label label = new Label("Status: Vécu");
		vbox.getChildren().add(label);
		root.add(vbox, 1, 1);
		Scene scene = new Scene(root, stage.getWidth(), stage.getHeight());
		stage.setScene(scene);
		stage.setTitle("Information sur " + name);
		stage.show();
	}
	
	public VBox get_unite_vbox(String name) throws FileNotFoundException {
		Image img = new Image(new FileInputStream(this.path + name + ".png"));
		ImageView image = new ImageView(img);
		
		final VBox vbox = new VBox();
		vbox.getChildren().add(image);

		Label label = new Label("Status: Vécu");
		vbox.getChildren().add(label);
		return vbox;
	}
}
