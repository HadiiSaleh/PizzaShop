package service;

import org.hibernate.Session;

import model.Extra;

public class ExtraService {
	private Session session;

	public ExtraService(Session s) {
		this.session = s;
	}

	public Extra getExtra(int id) {

		session.beginTransaction();

		// save the order object
		Extra extra = session.get(Extra.class, id);

		session.getTransaction().commit();

		session.flush();

		session.close();

		return extra;
	}
}
