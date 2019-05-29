package service;

import org.hibernate.Session;

import model.Type;

public class TypeService {
	private Session session;

	public TypeService(Session s) {
		this.session = s;
	}

	public Type getType(int id) {

		session.beginTransaction();

		// save the order object
		Type type = session.get(Type.class, id);

		session.getTransaction().commit();

		session.flush();

		session.close();

		return type;
	}
}
