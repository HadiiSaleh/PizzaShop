package service;

import org.hibernate.Session;

import model.Order;

public class OrderService {

	private Session session;

	public OrderService(Session s) {
		this.session = s;
	}

	public void createOrder(Order order) {

		session.beginTransaction();

		// save the order object
		session.save(order);

		session.getTransaction().commit();

		session.flush();

		session.close();

	}

	public Order getOrder(int id) {

		session.beginTransaction();

		// save the order object
		Order order = session.get(Order.class, id);

		session.getTransaction().commit();

		session.flush();

		session.close();

		return order;
	}
}
