package Controller.Unites;

import Controller.UniteController;
import Model.Unites.SoldatModel;
import View.UniteView;

public class SoldatController extends UniteController{

	public SoldatController() {
		super(new SoldatModel(), new UniteView());
	}

}
