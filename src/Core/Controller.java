package Core;

public abstract class Controller<M, V> {
	protected M model;
	protected V view;
	
	public Controller(M model, V view) {
		this.model = model;
		this.view = view;
	}
	
	public  String get_name() {
		return ((Model) model).get_name();
	}
	
	public void set_name(String name) {
		((Model) model).set_name(name);
	}
	
	public abstract void updateView();
}
