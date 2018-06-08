package Controller.BoutonEvent;

import java.io.FileNotFoundException;

import Core.Risk;
import View.TourView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class BoutonUpdateTerritoirePop implements EventHandler<MouseEvent> {
	
	private TourView tourView;
	private Risk risk;

	public BoutonUpdateTerritoirePop(TourView tourView, Risk risk) {
		this.tourView = tourView;
		this.risk = risk;
	}
	
	@Override
	public void handle(MouseEvent event) {
		
	}

}
