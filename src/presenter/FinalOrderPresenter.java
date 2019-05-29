package presenter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import extra.Extra;
import extra.ExtraCheese;
import extra.Mushrooms;
import extra.Pineapple;
import extra.Sausage;
import model.Dough;
import model.Order;
import model.Pizza;
import model.Type;
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
			SessionFactory factory = new Configuration().configure().addAnnotatedClass(model.Order.class)
					.addAnnotatedClass(model.Pizza.class).addAnnotatedClass(model.Extra.class)
					.addAnnotatedClass(model.Type.class).addAnnotatedClass(model.Dough.class).buildSessionFactory();

			try {
				Session session = factory.getCurrentSession();

				session.beginTransaction();

				List<Pizza> newPizzas = new ArrayList<Pizza>();

				for (int i = 0; i < order.getPizzas().size(); i++) {

					Pizza pizza = order.getPizzas().get(i);
					dough.Dough dough = order.getDoughs().get(i);
					pizza.setTypeti(session.get(Type.class, pizza.getType()));
					pizza.setDoughti(session.get(Dough.class, pizza.getDough()));

					// extras
					for (int j = 0; j < dough.getExtras().size(); j++) {
						Extra ex = dough.getExtras().get(j);

						if (ex instanceof Mushrooms)
							pizza.addExtra(session.get(model.Extra.class, 2));
						else if (ex instanceof ExtraCheese)
							pizza.addExtra(session.get(model.Extra.class, 1));
						else if (ex instanceof Sausage)
							pizza.addExtra(session.get(model.Extra.class, 3));
						else if (ex instanceof Pineapple)
							pizza.addExtra(session.get(model.Extra.class, 4));
					}

					session.save(pizza);

					newPizzas.add(pizza);

				}
				order.getPizzas().clear();

				for (int i = 0; i < newPizzas.size(); i++)
					order.AddPizza(newPizzas.get(i));

				session.save(order);

				session.getTransaction().commit();

			} finally {
				factory.close();
			}

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

	@Override
	public void getRowId(String text) {
		// TODO Auto-generated method stub

	}

}
