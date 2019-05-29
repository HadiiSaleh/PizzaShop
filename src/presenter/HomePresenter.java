package presenter;

import application.PizzaConfig;
import model.Order;
import view.DoughView;
import view.HomeView;
import view.OrdersView;

/**
 * Responsible to responding to user interaction and updating the view
 */
public class HomePresenter implements ViewListener {

	@SuppressWarnings("unused")
	private final HomeView view;

	private final org.springframework.context.annotation.AnnotationConfigApplicationContext context = new org.springframework.context.annotation.AnnotationConfigApplicationContext(
			PizzaConfig.class);

	public HomePresenter(final HomeView view) {
		this.view = view;
		view.addListener(this);
	}

	@Override
	public void onButtonClicked(String button) {

		if (button.equals("Show Orders")) {
			final OrdersView view = new OrdersView();
			new OrdersPresenter(view);
		} else if (button.equals("Order Pizza")) {

			Order order = context.getBean("order", Order.class);

			final DoughView view = new DoughView();
			new DoughPresenter(view, order);
		}
		context.close();
	}

	@Override
	public void getTextFieldValue(String text) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getRowId(String text) {
		// TODO Auto-generated method stub

	}
}