package Controller.Unites;

import Controller.UniteController;
import Model.Unites.CanonModel;
import View.UniteView;

public class CanonController extends UniteController{

	public CanonController() {
		super(new CanonModel(), new UniteView());
	}

}
