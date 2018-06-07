package Core;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class View extends Canvas {

	protected GraphicsContext gc;
	protected double width;
	protected double height;
	
	public View(double width, double height) {
		super(width, height);
		this.width = width;
		this.height = height;
		this.gc = this.getGraphicsContext2D();
	}
}
