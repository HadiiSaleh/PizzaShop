package presenter;

import view.DetailsView;
import view.OrdersView;

public class DetailsPresenter implements ViewListener {

	@SuppressWarnings("unused")
	private final DetailsView view;

	public DetailsPresenter(DetailsView view) {
		this.view = view;
		view.addListener(this);
	}

	@Override
	public void onButtonClicked(String button) {
		if (button.equals("Back")) {
			final OrdersView view = new OrdersView();
			new OrdersPresenter(view);
		}

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
