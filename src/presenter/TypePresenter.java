package presenter;

import model.Order;
import view.DoughView;
import view.ExtraView;
import view.TypeView;

public class TypePresenter implements ViewListener {

	@SuppressWarnings("unused")
	private final TypeView view;

	private final Order order;

	public TypePresenter(TypeView view, Order order) {
		this.view = view;
		this.order = order;
		view.addListener(this);
	}

	@Override
	public void onButtonClicked(String button) {
		if (button.equals("Back")) {
			final DoughView view = new DoughView();
			order.getPizzas().remove(order.getPizzas().size() - 1);
			order.getDoughs().remove(order.getDoughs().size() - 1);
			new DoughPresenter(view, order);
		} else if (button.equals("<html>Vegetarian<p style=\"text-align:center;\">8$</p></html>")) {
			order.getDoughs().get(order.getDoughs().size() - 1).setVegetarianType();
			order.getPizzas().get(order.getPizzas().size() - 1).setType(1);
			final ExtraView view = new ExtraView();
			new ExtraPresenter(view, order);
		} else if (button.equals("<html>Pepperoni<p style=\"text-align:center;\">9$</p></html>")) {
			order.getDoughs().get(order.getDoughs().size() - 1).setPepperoniType();
			;
			order.getPizzas().get(order.getPizzas().size() - 1).setType(3);
			final ExtraView view = new ExtraView();
			new ExtraPresenter(view, order);
		} else if (button.equals("<html>Chicken<p style=\"text-align:center;\">10$</p></html>")) {
			order.getDoughs().get(order.getDoughs().size() - 1).setChickenType();
			order.getPizzas().get(order.getPizzas().size() - 1).setType(2);
			final ExtraView view = new ExtraView();
			new ExtraPresenter(view, order);
		}
	}

	@Override
	public void getTextFieldValue(String text) {
		// TODO Auto-generated method stub

	}

}
