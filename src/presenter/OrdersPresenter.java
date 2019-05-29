package presenter;

import application.PizzaConfig;
import service.TableService;
import view.DetailsView;
import view.HomeView;
import view.OrdersView;

public class OrdersPresenter implements ViewListener {

	@SuppressWarnings("unused")
	private final OrdersView view;

	private int order_id;

	private final org.springframework.context.annotation.AnnotationConfigApplicationContext context = new org.springframework.context.annotation.AnnotationConfigApplicationContext(
			PizzaConfig.class);

	public OrdersPresenter(OrdersView view) {
		this.view = view;
		view.addListener(this);
	}

	@Override
	public void onButtonClicked(String button) {
		if (button.equals("Back")) {
			final HomeView view = new HomeView();
			new HomePresenter(view);
		} else if (button.equals("Details")) {
			final TableService tbService = context.getBean("tableService", TableService.class);
			final DetailsView view = new DetailsView(order_id, tbService);
			new DetailsPresenter(view);
			context.close();
		}
	}

	@Override
	public void getTextFieldValue(String text) {
		// TODO Auto-generated method stub

	}

	public void getRowId(String id) {
		this.order_id = Integer.parseInt(id);
	}

}
