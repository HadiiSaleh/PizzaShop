package service;

import org.hibernate.Session;

import model.Pizza;

public class PizzaService {

	private Session session;

	public PizzaService(Session s) {
		this.session = s;
	}

	public void createPizza(Pizza pizza) {

		session.beginTransaction();
		// save the order object
		session.save(pizza);

		session.getTransaction().commit();

		session.flush();

		session.close();

	}

	public Pizza getPizza(int id) {

		session.beginTransaction();

		// save the order object
		Pizza pizza = session.get(Pizza.class, id);

		session.getTransaction().commit();

		session.flush();

		session.close();

		return pizza;
	}
}
