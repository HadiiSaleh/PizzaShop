package presenter;

import application.PizzaConfig;
import dough.Dough;
import dough.FlatBread;
import dough.ThinCrust;
import model.Order;
import model.Pizza;
import view.DoughView;
import view.HomeView;
import view.TypeView;

public class DoughPresenter implements ViewListener {

	@SuppressWarnings("unused")
	private final DoughView view;

	private int quantity;

	private final Order order;

	private final org.springframework.context.annotation.AnnotationConfigApplicationContext context = new org.springframework.context.annotation.AnnotationConfigApplicationContext(
			PizzaConfig.class);

	public DoughPresenter(DoughView view, Order order) {
		this.view = view;
		this.order = order;
		view.addListener(this);
	}

	@Override
	public void onButtonClicked(String button) {
		if (button.equals("Back")) {
			final HomeView view = new HomeView();
			new HomePresenter(view);
		} else if (button.equals("FlatBread")) {
			final TypeView view = new TypeView();
			Pizza pizza = context.getBean("pizza", Pizza.class);
			pizza.setQuantity(this.quantity);
			pizza.setDough(1);
			Dough dough = context.getBean("flatBread", FlatBread.class);
			order.AddPizza(pizza);
			order.AddDough(dough);
			new TypePresenter(view, order);
		} else if (button.equals("Thin Crust")) {
			Pizza pizza = context.getBean("pizza", Pizza.class);
			pizza.setQuantity(this.quantity);
			pizza.setDough(2);
			Dough dough = context.getBean("thinCrust", ThinCrust.class);
			order.AddPizza(pizza);
			order.AddDough(dough);
			final TypeView view = new TypeView();
			new TypePresenter(view, order);
		}
	}

	@Override
	public void getTextFieldValue(String text) {
		if (text.equals(""))
			this.quantity = 1;
		else
			this.quantity = Integer.parseInt(text);

	}

}
