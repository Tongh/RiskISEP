package Controller.Unites;

import Controller.UniteController;
import Model.Unites.CavalierModel;
import View.UniteView;

public class CavalierController extends UniteController{

	public CavalierController() {
		super(new CavalierModel(), new UniteView());
	}

}
