package service;

import org.hibernate.Session;

import model.Dough;

public class DoughService {

	private Session session;

	public DoughService(Session s) {
		this.session = s;
	}

	public Dough getDough(int id) {

		session.beginTransaction();

		// save the order object
		Dough dough = session.get(Dough.class, id);

		session.getTransaction().commit();

		session.flush();

		session.close();

		return dough;
	}

}
