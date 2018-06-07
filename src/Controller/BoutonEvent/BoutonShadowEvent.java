package Controller.BoutonEvent;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;

public class BoutonShadowEvent implements EventHandler<MouseEvent> {

    Button bouton;
    DropShadow dropShadow;
    boolean select;

    public BoutonShadowEvent(Button bouton, DropShadow dropShadow, boolean select){
    	this.bouton = bouton;
    	this.select = select;
        this.dropShadow = dropShadow;
    }
    
    public BoutonShadowEvent(Button bouton, boolean select){
    	this.bouton = bouton;
    	this.select = select;
    }

    @Override
    public void handle(MouseEvent event) {
        if (select){
            bouton.setEffect(dropShadow);
    		bouton.setScaleX(1.2);
    		bouton.setScaleY(1.2);
        } else {
            bouton.setEffect(null);
            bouton.setScaleX(1);
            bouton.setScaleY(1);
        }
    }
}
