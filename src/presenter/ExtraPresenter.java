package presenter;

import application.PizzaConfig;
import model.Order;
import service.TableService;
import view.ExtraView;
import view.FinalOrder;
import view.TypeView;;

public class ExtraPresenter implements ViewListener {

	@SuppressWarnings("unused")
	private final ExtraView view;

	private final Order order;

	private final org.springframework.context.annotation.AnnotationConfigApplicationContext context = new org.springframework.context.annotation.AnnotationConfigApplicationContext(
			PizzaConfig.class);

	public ExtraPresenter(ExtraView view, Order order) {
		this.view = view;
		this.order = order;
		view.addListener(this);
	}

	@Override
	public void onButtonClicked(String button) {
		if (button.equals("Back")) {
			final TypeView view = new TypeView();
			order.getDoughs().get(order.getDoughs().size() - 1).ClearExtras();
			new TypePresenter(view, order);
		} else if (button.equals("<html>ExtraCheese<p style=\"text-align:center;\">2$</p></html>")) {
			order.getDoughs().get(order.getDoughs().size() - 1).addExtraCheese();
		} else if (button.equals("<html>Mushrooms<p style=\"text-align:center;\">1$</p></html>")) {
			order.getDoughs().get(order.getDoughs().size() - 1).addMushrooms();
		} else if (button.equals("<html>Sausage<p style=\"text-align:center;\">2$</p></html>")) {
			order.getDoughs().get(order.getDoughs().size() - 1).addSausage();
			;
		} else if (button.equals("<html>Pineapple<p style=\"text-align:center;\">2$</p></html>")) {
			order.getDoughs().get(order.getDoughs().size() - 1).addPineapple();
			;
		} else if (button.equals("View Order")) {
			order.getPizzas().get(order.getPizzas().size() - 1)
					.setPrice(order.getDoughs().get(order.getDoughs().size() - 1).CalculatePrice());
			order.getPizzas().get(order.getPizzas().size() - 1).calculateTotal();
			;
			order.setPrice(order.sum());
			final TableService tbService = context.getBean("tableService", TableService.class);
			final FinalOrder view = new FinalOrder(order, tbService);
			new FinalOrderPresenter(view, order);
			context.close();
		}
	}

	@Override
	public void getTextFieldValue(String text) {
		// TODO Auto-generated method stub

	}

}
