package presenter;

import java.time.LocalDate;

import model.Order;
import view.DoughView;
import view.ExtraView;
import view.FinalOrder;
import view.HomeView;

public class FinalOrderPresenter implements ViewListener {

	@SuppressWarnings("unused")
	private final FinalOrder view;

	private final Order order;

	public FinalOrderPresenter(FinalOrder view, Order order) {
		this.view = view;
		this.order = order;
		view.addListener(this);
	}

	@Override
	public void onButtonClicked(String button) {
		if (button.equals("Back")) {
			final ExtraView view = new ExtraView();
			order.getDoughs().get(order.getDoughs().size() - 1).ClearExtras();
			new ExtraPresenter(view, order);
		} else if (button.equals("Finish")) {
			order.setDate(LocalDate.now());

			// save order to database

			final HomeView view = new HomeView();
			new HomePresenter(view);
		} else if (button.equals("Add More Pizzas")) {
			final DoughView view = new DoughView();
			new DoughPresenter(view, order);
		}
	}

	@Override
	public void getTextFieldValue(String text) {
		// TODO Auto-generated method stub

	}

}
