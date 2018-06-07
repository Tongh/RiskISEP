package View;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import Core.View;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class LoadingView extends View{

	private double width;
	private double height;
	private String image_path = "./src/View/Images/load.png";
	private Group root;
	private Scene scene;

	public LoadingView(double width, double height) {
		super(width, height);
		this.width = width;
		this.height = height;
		this.root = new Group();
		scene = new Scene(root, width, height, Color.LIGHTGRAY);
	}
	
	public Scene get_scene() throws FileNotFoundException {
		
		this.set_image();
		this.set_text();
		
		root.getChildren().add(this);
		
		return scene;
	}

	private void set_text() {
		Text text = new Text("PRESS ANY KEY TO CONTINUE");
		text.setFont(new Font("Verdana", 20));
		text.setX(width/2 - 140);
		text.setY(height - 100);
		
		root.getChildren().add(text);
		
	}

	private void set_image() throws FileNotFoundException {
		Image image = new Image(new FileInputStream(this.image_path));
		this.gc.drawImage(image, (width - image.getWidth())/2, (height - image.getHeight())/2);
	}
}
